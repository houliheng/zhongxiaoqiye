package com.gqcc.meim.common.exception.security;

/**
 * 授权错误时抛出该异常
 * 
 */
public class AuthorizationException extends com.gqcc.meim.common.exception.security.SecurityException {

private static final long serialVersionUID = 1L;
  
  public AuthorizationException(String msg, Throwable t) {
      super(msg, t);
  }

  public AuthorizationException(String msg) {
      super(msg);
  }
  
  public AuthorizationException() {
    super();
  }

  public AuthorizationException(Throwable cause) {
      super(cause);
  }

  protected AuthorizationException(String message, Throwable cause,
                             boolean enableSuppression,
                             boolean writableStackTrace) {
      super(message, cause, enableSuppression, writableStackTrace);
  }

}
