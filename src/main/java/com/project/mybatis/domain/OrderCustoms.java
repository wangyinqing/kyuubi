package com.project.mybatis.domain;

import java.sql.Timestamp;

/**
 * @Author: jiazhuang
 * @Date: 23:17 2018/7/24
 */
public class OrderCustoms {
    private Long orderCustomsId;
    private String orderId;
    private Integer customsType;
    private String invoicePackingUrl;
    private String packingListUrl;
    private String customsDeclarationUrl;
    private Timestamp updateTime;
    private Timestamp createTime;

    public Long getOrderCustomsId() {
        return orderCustomsId;
    }

    public void setOrderCustomsId(Long orderCustomsId) {
        this.orderCustomsId = orderCustomsId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Integer getCustomsType() {
        return customsType;
    }

    public void setCustomsType(Integer customsType) {
        this.customsType = customsType;
    }

    public String getInvoicePackingUrl() {
        return invoicePackingUrl;
    }

    public void setInvoicePackingUrl(String invoicePackingUrl) {
        this.invoicePackingUrl = invoicePackingUrl;
    }

    public String getPackingListUrl() {
        return packingListUrl;
    }

    public void setPackingListUrl(String packingListUrl) {
        this.packingListUrl = packingListUrl;
    }

    public String getCustomsDeclarationUrl() {
        return customsDeclarationUrl;
    }

    public void setCustomsDeclarationUrl(String customsDeclarationUrl) {
        this.customsDeclarationUrl = customsDeclarationUrl;
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
