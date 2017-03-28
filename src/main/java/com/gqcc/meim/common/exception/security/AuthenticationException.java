package com.gqcc.meim.common.exception.security;

/**
 * 身份验证错误时抛出该异常
 * 
 */
public class AuthenticationException extends com.gqcc.meim.common.exception.security.SecurityException {

private static final long serialVersionUID = 1L;
  
  public AuthenticationException(String msg, Throwable t) {
      super(msg, t);
  }

  public AuthenticationException(String msg) {
      super(msg);
  }
  
  public AuthenticationException() {
    super();
  }

  public AuthenticationException(Throwable cause) {
      super(cause);
  }

  protected AuthenticationException(String message, Throwable cause,
                             boolean enableSuppression,
                             boolean writableStackTrace) {
      super(message, cause, enableSuppression, writableStackTrace);
  }

}
