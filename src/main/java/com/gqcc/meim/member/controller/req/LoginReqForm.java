package com.gqcc.meim.member.controller.req;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 注册、登录请求
 *
 * @author YS yanshuang@nxin.com
 * @ClassName: LoginReqForm
 * @Description: 注册、登录请求
 * @createTime 2016/12/1 20:22
 */
public class LoginReqForm {

  @NotBlank(message = "电话不能为空")
  private String mobilePhone;

  @NotBlank(message = "密码不能为空")
  private String password;

  private Long operatorId;

  private String identifyingCode;

  public Long getOperatorId() {
    return operatorId;
  }

  public void setOperatorId(Long operatorId) {
    this.operatorId = operatorId;
  }

  public String getMobilePhone() {
    return mobilePhone;
  }

  public void setMobilePhone(String mobilePhone) {
    this.mobilePhone = mobilePhone;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getIdentifyingCode() {
    return identifyingCode;
  }

  public void setIdentifyingCode(String identifyingCode) {
    this.identifyingCode = identifyingCode;
  }
}
