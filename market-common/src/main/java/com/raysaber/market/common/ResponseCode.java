package com.raysaber.market.common;

/**
 * @author jiaoguang
 * @version V1.0.0
 * @class ResponseCode
 * @date 2021/4/16 3:06
 * @Copyright
 */
public enum ResponseCode {
  SUCCESS(200, "SUCCESS"),
  ERROR(1, "ERROR");
  private final int code;
  private final String desc;

  /**
   * 初始哈状态码
   * @param code 状态码
   * @param desc 描述信息
   */
  ResponseCode(int code, String desc) {
    this.code = code;
    this.desc = desc;
  }

  public int getCode() {
    return code;
  }

  public String getDesc() {
    return desc;
  }
}
