package com.project.mybatis.domain;

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * @Author: jiazhuang
 * @Description: 订单货物信息
 * @Date: 23:24 2018/7/23
 */
public class OrderCargo {
    private Long orderCargoId;
    private String orderId;
    private String cargoName;
    private String cargoEnName;
    private String hsCode;
    private BigDecimal customsUnitCharge;
    private Double cargoLength;
    private Double cargoWidth;
    private Double cargoHeight;
    private Double cargoWeight;
    private Integer numPerPack;
    private Integer packageNum;
    private BigDecimal customsTotalCharge;
    private Timestamp updateTime;
    private Timestamp createTime;

    public Long getOrderCargoId() {
        return orderCargoId;
    }

    public void setOrderCargoId(Long orderCargoId) {
        this.orderCargoId = orderCargoId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getCargoName() {
        return cargoName;
    }

    public void setCargoName(String cargoName) {
        this.cargoName = cargoName;
    }

    public String getCargoEnName() {
        return cargoEnName;
    }

    public void setCargoEnName(String cargoEnName) {
        this.cargoEnName = cargoEnName;
    }

    public String getHsCode() {
        return hsCode;
    }

    public void setHsCode(String hsCode) {
        this.hsCode = hsCode;
    }

    public BigDecimal getCustomsUnitCharge() {
        return customsUnitCharge;
    }

    public void setCustomsUnitCharge(BigDecimal customsUnitCharge) {
        this.customsUnitCharge = customsUnitCharge;
    }

    public Double getCargoLength() {
        return cargoLength;
    }

    public void setCargoLength(Double cargoLength) {
        this.cargoLength = cargoLength;
    }

    public Double getCargoWidth() {
        return cargoWidth;
    }

    public void setCargoWidth(Double cargoWidth) {
        this.cargoWidth = cargoWidth;
    }

    public Double getCargoHeight() {
        return cargoHeight;
    }

    public void setCargoHeight(Double cargoHeight) {
        this.cargoHeight = cargoHeight;
    }

    public Double getCargoWeight() {
        return cargoWeight;
    }

    public void setCargoWeight(Double cargoWeight) {
        this.cargoWeight = cargoWeight;
    }

    public Integer getNumPerPack() {
        return numPerPack;
    }

    public void setNumPerPack(Integer numPerPack) {
        this.numPerPack = numPerPack;
    }

    public Integer getPackageNum() {
        return packageNum;
    }

    public void setPackageNum(Integer packageNum) {
        this.packageNum = packageNum;
    }

    public BigDecimal getCustomsTotalCharge() {
        return customsTotalCharge;
    }

    public void setCustomsTotalCharge(BigDecimal customsTotalCharge) {
        this.customsTotalCharge = customsTotalCharge;
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
