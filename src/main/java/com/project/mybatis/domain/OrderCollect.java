package com.project.mybatis.domain;

import java.sql.Timestamp;

public class OrderCollect {
    private Long orderCollectId;
    private String orderId;
    private String collectName;
    private String collectMobile;
    private Long collectProvinceId;
    private Long collectCityId;
    private Long collectRegionId;
    private String collectAddress;
    private Timestamp updateTime;
    private Timestamp createTime;

    public Long getOrderCollectId() {
        return orderCollectId;
    }

    public void setOrderCollectId(Long orderCollectId) {
        this.orderCollectId = orderCollectId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getCollectName() {
        return collectName;
    }

    public void setCollectName(String collectName) {
        this.collectName = collectName;
    }

    public String getCollectMobile() {
        return collectMobile;
    }

    public void setCollectMobile(String collectMobile) {
        this.collectMobile = collectMobile;
    }

    public Long getCollectProvinceId() {
        return collectProvinceId;
    }

    public void setCollectProvinceId(Long collectProvinceId) {
        this.collectProvinceId = collectProvinceId;
    }

    public Long getCollectCityId() {
        return collectCityId;
    }

    public void setCollectCityId(Long collectCityId) {
        this.collectCityId = collectCityId;
    }

    public Long getCollectRegionId() {
        return collectRegionId;
    }

    public void setCollectRegionId(Long collectRegionId) {
        this.collectRegionId = collectRegionId;
    }

    public String getCollectAddress() {
        return collectAddress;
    }

    public void setCollectAddress(String collectAddress) {
        this.collectAddress = collectAddress;
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
