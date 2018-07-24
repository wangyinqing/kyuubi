package com.project.mybatis.domain;

import java.sql.Timestamp;

/**
 * @Author: jiazhuang
 * @Date: 23:25 2018/7/24
 */
public class OrderSender {
    private Long orderSenderId;
    private String orderId;
    private Integer bizType;
    private String senderCompany;
    private String senderName;
    private String senderMobile;
    private String senderContact;
    private Long senderProvinceId;
    private Long senderCityId;
    private Long senderRegionId;
    private String senderAddress;
    private Timestamp updateTime;
    private Timestamp createTime;

    public Long getOrderSenderId() {
        return orderSenderId;
    }

    public void setOrderSenderId(Long orderSenderId) {
        this.orderSenderId = orderSenderId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Integer getBizType() {
        return bizType;
    }

    public void setBizType(Integer bizType) {
        this.bizType = bizType;
    }

    public String getSenderCompany() {
        return senderCompany;
    }

    public void setSenderCompany(String senderCompany) {
        this.senderCompany = senderCompany;
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public String getSenderMobile() {
        return senderMobile;
    }

    public void setSenderMobile(String senderMobile) {
        this.senderMobile = senderMobile;
    }

    public String getSenderContact() {
        return senderContact;
    }

    public void setSenderContact(String senderContact) {
        this.senderContact = senderContact;
    }

    public Long getSenderProvinceId() {
        return senderProvinceId;
    }

    public void setSenderProvinceId(Long senderProvinceId) {
        this.senderProvinceId = senderProvinceId;
    }

    public Long getSenderCityId() {
        return senderCityId;
    }

    public void setSenderCityId(Long senderCityId) {
        this.senderCityId = senderCityId;
    }

    public Long getSenderRegionId() {
        return senderRegionId;
    }

    public void setSenderRegionId(Long senderRegionId) {
        this.senderRegionId = senderRegionId;
    }

    public String getSenderAddress() {
        return senderAddress;
    }

    public void setSenderAddress(String senderAddress) {
        this.senderAddress = senderAddress;
    }

    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }
}
