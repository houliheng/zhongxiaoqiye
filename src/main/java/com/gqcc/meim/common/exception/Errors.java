package com.gqcc.meim.common.exception;

/**
 * 错误码
 *
 */
public enum Errors {
  // 0-200 系统级
  SUCCESS(0, "系统错误", "操作成功"),
  //
  SYSTEM_ERROR(1, "系统错误", "系统错误"),
  // 自定义错误，可以修改label
  SYSTEM_CUSTOM_ERROR(2, "系统错误", "自定义错误"),
  //
  SYSTEM_DATA_ERROR(3, "系统错误", "数据异常"),
  //
  SYSTEM_DATA_NOT_FOUND(4, "系统错误", "数据不存在"),
  //
  SYSTEM_NOT_LOGIN(5, "系统错误", "请登录"),
  //
  SYSTEM_UPDATE_ERROR(6, "系统错误", "数据更新失败"),
  //
  SYSTEM_NO_ACCESS(7, "系统错误", "无权限访问"),
  //
  SYSTEM_REQUEST_PARAM_ERROR(8, "系统错误", "请求参数错误"),
  //
  SYSTEM_BUSINESS_ERROR(9, "系统错误", "系统繁忙,请您稍后再试"),

  FORM_TOKEN_INVALID_ERROR(302, "业务错误", "token invalid be form submit"),

  //
  SYSTEM_DATE_TRANS_ERROR(101, "业务错误", "日期转换错误"),
  //
  BUSI_PASSWORD_WRONG_ERROR(208, "业务错误", "密码输入错误，请重新填写！"),
  //
  BUSI_USER_IS_NOT_HAVE_ERROR(206, "业务错误", "账号输入错误，请重新填写!"),
  //
  BUSI_MEMBER_STATUS_DISABLED(213, "业务错误", "由于您的账号存在异常情况，已被官方工作人员禁用"),
  FORM_TOKEN_DIFFERENCE_ERROR(303, "业务错误", "token值不同");






  public int code;
  public String categoryLable;
  public String label;

  private Errors(int code, String categoryLable, String label) {
    this.code = code;
    this.categoryLable = categoryLable;
    this.label = label;
  }

  /**
   * 
   * @param code
   * @return
   */
  public static String getLabel(int code) {
    String result = "";
    for (Errors status : Errors.values()) {
      if (status.code == code) {
        result = status.label;
      }
    }
    return result;
  }

}
