package com.gqcc.meim.common.interceptor.wrapper;

import com.gqcc.meim.common.Constant;
import com.gqcc.meim.common.exception.Errors;
import com.gqcc.meim.common.exception.business.BusinessException;
import com.gqcc.meim.common.interceptor.core.CheckResult;
import com.gqcc.meim.common.utils.cookie.CookieUtils;
import com.gqcc.meim.member.controller.res.MemberResForm;
import com.gqcc.meim.redis.service.RedisService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * @ClassName: CoreNxinInterceptorLoginLogWrapper
 * @Description: 修饰器
 * @author wangyongqing
 * @date 2016-9-18 下午3:37:01
 * 
 */
@Component("coreUserAuthWrapper")
public class CoreNxinInterceptorUserAuthWrapper extends CoreNxinCheckInterceptorWrapper {
  static Logger logger = LoggerFactory.getLogger(CoreNxinInterceptorUserAuthWrapper.class);
  @Resource
  RedisService redisService;

  @Override
  public CheckResult doWork(HttpServletRequest rq, HttpServletResponse rs, Object handler) {
    CheckResult checkResult = super.doWork(rq, rs, handler);
    if (checkResult.getResult() == CheckResult.Result.SUCCESS) {
      return checkResult;
    }
    // 1、获取token
    String tokenId = CookieUtils.getCookieTokenId(rq);
    logger.info("tokenId===" + tokenId);
    Long boId = (Long) redisService.getRBucket(Constant.CURR_USER_INFO_TOKEN + ":" + tokenId).get();
    if (boId == null) {
      logger.info("获取用户信息失败!");
      throw new BusinessException(Errors.SYSTEM_NOT_LOGIN);
    }
    MemberResForm member = (MemberResForm) redisService
        .getRBucket(Constant.CURR_USER_TICKET + String.valueOf(boId)).get();
    if (member == null) {
      logger.info("获取用户信息失败!");
      throw new BusinessException(Errors.SYSTEM_NOT_LOGIN);
    }
    logger.info("用户校验结束");
    checkResult.setResult(CheckResult.Result.SUCCESS);
    return checkResult;
  }

}
