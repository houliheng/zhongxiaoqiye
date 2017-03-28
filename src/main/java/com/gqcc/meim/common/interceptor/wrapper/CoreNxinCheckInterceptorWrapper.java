package com.gqcc.meim.common.interceptor.wrapper;

import com.gqcc.meim.common.interceptor.core.CheckResult;
import com.gqcc.meim.common.interceptor.core.ICoreNxinCheckInterceptor;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * @ClassName: CoreNxinInterceptorWrapper
 * @Description: 装饰器类-用来装饰核心类
 * @author wangyongqing
 * @date 2016-9-18 下午3:26:14
 * 
 */
@Component("coreCheckWrapper")
public class CoreNxinCheckInterceptorWrapper implements ICoreNxinCheckInterceptor {

  ICoreNxinCheckInterceptor iCoreNxinCheckInterceptor;

  @Override
  public CheckResult doWork(HttpServletRequest rq, HttpServletResponse rs, Object handler) {
    return iCoreNxinCheckInterceptor.doWork(rq, rs, handler);
  }

  public ICoreNxinCheckInterceptor getiCoreNxinCheckInterceptor() {
    return iCoreNxinCheckInterceptor;
  }

  public void setiCoreNxinCheckInterceptor(ICoreNxinCheckInterceptor iCoreNxinCheckInterceptor) {
    this.iCoreNxinCheckInterceptor = iCoreNxinCheckInterceptor;
  }
}
