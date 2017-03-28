package com.gqcc.meim.common.interceptor.wrapper;

import com.gqcc.meim.common.Constant;
import com.gqcc.meim.common.exception.Errors;
import com.gqcc.meim.common.exception.business.BusinessException;
import com.gqcc.meim.common.interceptor.core.CheckResult;
import com.gqcc.meim.common.interceptor.core.CheckResult.Result;
import com.gqcc.meim.common.security.TokenHelper;
import com.gqcc.meim.redis.service.RedisService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author wangyongqing
 * @ClassName: CoreNxinInterceptorLoginLogWrapper
 * @Description: 修饰器
 * @date 2016-9-18 下午3:37:01
 */
@Component("coreCheckTokenWrapper")
public class CoreNxinInterceptorCheckTokenWrapper extends CoreNxinCheckInterceptorWrapper {
    static Logger logger = LoggerFactory.getLogger(CoreNxinInterceptorCheckTokenWrapper.class);
    @Resource
    RedisService redisService;

    @Override
    public CheckResult doWork(HttpServletRequest rq, HttpServletResponse rs, Object handler) {
        CheckResult checkResult = super.doWork(rq, rs, handler);
        if(checkResult.getResult() == Result.SUCCESS){
            return checkResult;
        }
        // 1、从表单中读取token
        String token = rq.getParameter(Constant.RES_FORM_TOKEN_KEY);
       /* ObjectMapper mapper = new ObjectMapper();
        TokenModel tokenModel = null;
        try {
            mapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            tokenModel = mapper.readValue(rq.getInputStream(), TokenModel.class);
            if (StringUtils.isBlank(token)) {
                token = tokenModel.getFormToken();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }*/

        if (token != null) {
            // 1、从redis中获取token
            Object tokenKey = redisService.getRBucket(Constant.REDIS_FORM_TOKEN_KEY + token).get();
            if (tokenKey == null) {
                throw new BusinessException(Errors.FORM_TOKEN_INVALID_ERROR);
            }
            if (!token.equals(tokenKey)) {
                throw new BusinessException(Errors.FORM_TOKEN_DIFFERENCE_ERROR);
            }

            redisService.getRBucket(Constant.REDIS_FORM_TOKEN_KEY + token).delete();
            //删除cookie
            TokenHelper.delCookieToken(rs);

        }
        return checkResult;
    }
}
