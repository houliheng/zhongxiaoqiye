package com.gqcc.meim.common.security;

import com.gqcc.meim.common.Constant;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.math.BigInteger;
import java.util.Random;

public class TokenHelper {

  public static void setCookieToken(String token, HttpServletResponse response) {
    Cookie cookie = new Cookie(Constant.COOKIE_FORM_TOKEN_KEY, token);
    cookie.setPath("/");
    response.addCookie(cookie);
  }

  public static void delCookieToken(HttpServletResponse response) {
    Cookie cookie = new Cookie(Constant.COOKIE_FORM_TOKEN_KEY, null);
    cookie.setMaxAge(-1);
    cookie.setPath("/");
    response.addCookie(cookie);
  }

  /**
   * 生产token值
   * 
   * @return
   * @author lishen
   * @date 2015-5-20
   */
  public static String generateGUID() {
    return new BigInteger(165, new Random()).toString(36).toUpperCase();
  }

  public static String getCookie(Cookie[] cookies, String key) {
    String cookieVal = "";
    if (cookies != null) {
      for (Cookie cookie : cookies) {
        if (cookie.getName().equals(key)) {
          cookieVal = cookie.getValue();
        }
      }
    }
    return cookieVal;
  }
}
