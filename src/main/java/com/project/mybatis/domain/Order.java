package com.project.mybatis.domain;

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * @Author: jiazhuang
 * @Date: 22:37 2018/7/23
 */
public class Order {
    private Long id;
    private String orderId;
    private Long logisticsFreightId;
    private Integer oderStatus;
    private Integer collectType;
    private BigDecimal totalCharge;
    private String remark;
    private Timestamp updateTime;
    private Timestamp createTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Long getLogisticsFreightId() {
        return logisticsFreightId;
    }

    public void setLogisticsFreightId(Long logisticsFreightId) {
        this.logisticsFreightId = logisticsFreightId;
    }

    public Integer getOderStatus() {
        return oderStatus;
    }

    public void setOderStatus(Integer oderStatus) {
        this.oderStatus = oderStatus;
    }

    public Integer getCollectType() {
        return collectType;
    }

    public void setCollectType(Integer collectType) {
        this.collectType = collectType;
    }

    public BigDecimal getTotalCharge() {
        return totalCharge;
    }

    public void setTotalCharge(BigDecimal totalCharge) {
        this.totalCharge = totalCharge;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
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
