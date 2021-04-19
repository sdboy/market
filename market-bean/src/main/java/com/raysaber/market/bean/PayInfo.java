package com.raysaber.market.bean;

import java.util.Date;

/**
 * Database Table Remarks:
 *   支付信息
 *
 * This class was generated by MyBatis Generator.
 * This class corresponds to the database table MARKET_PAY_INFO
 */
public class PayInfo {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column MARKET_PAY_INFO.ID
     *
     * @mbg.generated Tue Apr 20 04:08:53 CST 2021
     */
    private Integer id;

    /**
     * Database Column Remarks:
     *   用户id
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column MARKET_PAY_INFO.USER_ID
     *
     * @mbg.generated Tue Apr 20 04:08:53 CST 2021
     */
    private Integer userId;

    /**
     * Database Column Remarks:
     *   订单号
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column MARKET_PAY_INFO.ORDER_NO
     *
     * @mbg.generated Tue Apr 20 04:08:53 CST 2021
     */
    private Long orderNo;

    /**
     * Database Column Remarks:
     *   支付平台:1-支付宝,2-微信
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column MARKET_PAY_INFO.PAY_PLATFORM
     *
     * @mbg.generated Tue Apr 20 04:08:53 CST 2021
     */
    private Integer payPlatform;

    /**
     * Database Column Remarks:
     *   支付宝支付流水号
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column MARKET_PAY_INFO.PLATFORM_NUMBER
     *
     * @mbg.generated Tue Apr 20 04:08:53 CST 2021
     */
    private String platformNumber;

    /**
     * Database Column Remarks:
     *   支付宝支付状态
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column MARKET_PAY_INFO.PLATFORM_STATUS
     *
     * @mbg.generated Tue Apr 20 04:08:53 CST 2021
     */
    private String platformStatus;

    /**
     * Database Column Remarks:
     *   创建时间
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column MARKET_PAY_INFO.CREATE_TIME
     *
     * @mbg.generated Tue Apr 20 04:08:53 CST 2021
     */
    private Date createTime;

    /**
     * Database Column Remarks:
     *   更新时间
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column MARKET_PAY_INFO.UPDATE_TIME
     *
     * @mbg.generated Tue Apr 20 04:08:53 CST 2021
     */
    private Date updateTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table MARKET_PAY_INFO
     *
     * @mbg.generated Tue Apr 20 04:08:53 CST 2021
     */
    public PayInfo(Integer id, Integer userId, Long orderNo, Integer payPlatform, String platformNumber, String platformStatus, Date createTime, Date updateTime) {
        this.id = id;
        this.userId = userId;
        this.orderNo = orderNo;
        this.payPlatform = payPlatform;
        this.platformNumber = platformNumber;
        this.platformStatus = platformStatus;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table MARKET_PAY_INFO
     *
     * @mbg.generated Tue Apr 20 04:08:53 CST 2021
     */
    public PayInfo() {
        super();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column MARKET_PAY_INFO.ID
     *
     * @return the value of MARKET_PAY_INFO.ID
     *
     * @mbg.generated Tue Apr 20 04:08:53 CST 2021
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column MARKET_PAY_INFO.ID
     *
     * @param id the value for MARKET_PAY_INFO.ID
     *
     * @mbg.generated Tue Apr 20 04:08:53 CST 2021
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column MARKET_PAY_INFO.USER_ID
     *
     * @return the value of MARKET_PAY_INFO.USER_ID
     *
     * @mbg.generated Tue Apr 20 04:08:53 CST 2021
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column MARKET_PAY_INFO.USER_ID
     *
     * @param userId the value for MARKET_PAY_INFO.USER_ID
     *
     * @mbg.generated Tue Apr 20 04:08:53 CST 2021
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column MARKET_PAY_INFO.ORDER_NO
     *
     * @return the value of MARKET_PAY_INFO.ORDER_NO
     *
     * @mbg.generated Tue Apr 20 04:08:53 CST 2021
     */
    public Long getOrderNo() {
        return orderNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column MARKET_PAY_INFO.ORDER_NO
     *
     * @param orderNo the value for MARKET_PAY_INFO.ORDER_NO
     *
     * @mbg.generated Tue Apr 20 04:08:53 CST 2021
     */
    public void setOrderNo(Long orderNo) {
        this.orderNo = orderNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column MARKET_PAY_INFO.PAY_PLATFORM
     *
     * @return the value of MARKET_PAY_INFO.PAY_PLATFORM
     *
     * @mbg.generated Tue Apr 20 04:08:53 CST 2021
     */
    public Integer getPayPlatform() {
        return payPlatform;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column MARKET_PAY_INFO.PAY_PLATFORM
     *
     * @param payPlatform the value for MARKET_PAY_INFO.PAY_PLATFORM
     *
     * @mbg.generated Tue Apr 20 04:08:53 CST 2021
     */
    public void setPayPlatform(Integer payPlatform) {
        this.payPlatform = payPlatform;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column MARKET_PAY_INFO.PLATFORM_NUMBER
     *
     * @return the value of MARKET_PAY_INFO.PLATFORM_NUMBER
     *
     * @mbg.generated Tue Apr 20 04:08:53 CST 2021
     */
    public String getPlatformNumber() {
        return platformNumber;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column MARKET_PAY_INFO.PLATFORM_NUMBER
     *
     * @param platformNumber the value for MARKET_PAY_INFO.PLATFORM_NUMBER
     *
     * @mbg.generated Tue Apr 20 04:08:53 CST 2021
     */
    public void setPlatformNumber(String platformNumber) {
        this.platformNumber = platformNumber == null ? null : platformNumber.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column MARKET_PAY_INFO.PLATFORM_STATUS
     *
     * @return the value of MARKET_PAY_INFO.PLATFORM_STATUS
     *
     * @mbg.generated Tue Apr 20 04:08:53 CST 2021
     */
    public String getPlatformStatus() {
        return platformStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column MARKET_PAY_INFO.PLATFORM_STATUS
     *
     * @param platformStatus the value for MARKET_PAY_INFO.PLATFORM_STATUS
     *
     * @mbg.generated Tue Apr 20 04:08:53 CST 2021
     */
    public void setPlatformStatus(String platformStatus) {
        this.platformStatus = platformStatus == null ? null : platformStatus.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column MARKET_PAY_INFO.CREATE_TIME
     *
     * @return the value of MARKET_PAY_INFO.CREATE_TIME
     *
     * @mbg.generated Tue Apr 20 04:08:53 CST 2021
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column MARKET_PAY_INFO.CREATE_TIME
     *
     * @param createTime the value for MARKET_PAY_INFO.CREATE_TIME
     *
     * @mbg.generated Tue Apr 20 04:08:53 CST 2021
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column MARKET_PAY_INFO.UPDATE_TIME
     *
     * @return the value of MARKET_PAY_INFO.UPDATE_TIME
     *
     * @mbg.generated Tue Apr 20 04:08:53 CST 2021
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column MARKET_PAY_INFO.UPDATE_TIME
     *
     * @param updateTime the value for MARKET_PAY_INFO.UPDATE_TIME
     *
     * @mbg.generated Tue Apr 20 04:08:53 CST 2021
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}