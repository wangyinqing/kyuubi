package com.project.model.dto.freight;

import java.util.List;

/**
 * @Author: jiazhuang
 * @Date: 16:34 2018/6/9
 */
public class FreightVO {
    private Long freightId;
    private Long providerId;
    private String providerName;
    private Long originId;
    private String originName;
    private Long destinationId;
    private String destinationName;
    private Integer bizType;
    private String bizTypeName;
    private Long airLineId;
    private String airLineName;
    private Long freightTypeId;
    private String freightTypeName;
    List<FreightRangeVO> freightRangeList;

    public Long getFreightId() {
        return freightId;
    }

    public void setFreightId(Long freightId) {
        this.freightId = freightId;
    }

    public Long getProviderId() {
        return providerId;
    }

    public void setProviderId(Long providerId) {
        this.providerId = providerId;
    }

    public String getProviderName() {
        return providerName;
    }

    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }

    public Long getOriginId() {
        return originId;
    }

    public void setOriginId(Long originId) {
        this.originId = originId;
    }

    public String getOriginName() {
        return originName;
    }

    public void setOriginName(String originName) {
        this.originName = originName;
    }

    public Long getDestinationId() {
        return destinationId;
    }

    public void setDestinationId(Long destinationId) {
        this.destinationId = destinationId;
    }

    public String getDestinationName() {
        return destinationName;
    }

    public void setDestinationName(String destinationName) {
        this.destinationName = destinationName;
    }

    public Integer getBizType() {
        return bizType;
    }

    public void setBizType(Integer bizType) {
        this.bizType = bizType;
    }

    public String getBizTypeName() {
        return bizTypeName;
    }

    public void setBizTypeName(String bizTypeName) {
        this.bizTypeName = bizTypeName;
    }

    public Long getAirLineId() {
        return airLineId;
    }

    public void setAirLineId(Long airLineId) {
        this.airLineId = airLineId;
    }

    public String getAirLineName() {
        return airLineName;
    }

    public void setAirLineName(String airLineName) {
        this.airLineName = airLineName;
    }

    public Long getFreightTypeId() {
        return freightTypeId;
    }

    public void setFreightTypeId(Long freightTypeId) {
        this.freightTypeId = freightTypeId;
    }

    public String getFreightTypeName() {
        return freightTypeName;
    }

    public void setFreightTypeName(String freightTypeName) {
        this.freightTypeName = freightTypeName;
    }

    public List<FreightRangeVO> getFreightRangeList() {
        return freightRangeList;
    }

    public void setFreightRangeList(List<FreightRangeVO> freightRangeList) {
        this.freightRangeList = freightRangeList;
    }

    @Override
    public String toString() {
        return "FreightVO{" +
                "freightId=" + freightId +
                ", providerId=" + providerId +
                ", providerName='" + providerName + '\'' +
                ", originId=" + originId +
                ", originName='" + originName + '\'' +
                ", destinationId=" + destinationId +
                ", destinationName='" + destinationName + '\'' +
                ", bizType=" + bizType +
                ", bizTypeName='" + bizTypeName + '\'' +
                ", airLineId=" + airLineId +
                ", airLineName='" + airLineName + '\'' +
                ", freightTypeId=" + freightTypeId +
                ", freightTypeName='" + freightTypeName + '\'' +
                ", freightRangeList=" + freightRangeList +
                '}';
    }
}
