package com.project.mybatis.domain;

import java.math.BigDecimal;

/**
 * @Author: jiazhuang
 * @Date: 22:40 2018/6/3
 */
public class PriceSolution {
    private Long providerId;
    private String providerName;
    private Long origin;
    private String originName;
    private Long destination;
    private String destinationName;
    private Long freightType;
    private String freightTypeName;
    private Long airlines;
    private String airlineName;
    private Integer bizType;
    private String bizTypeName;
    private Integer from;
    private Integer to;
    private BigDecimal price;

    public Long getProviderId() {
        return providerId;
    }

    public void setProviderId(Long providerId) {
        this.providerId = providerId;
    }

    public Long getOrigin() {
        return origin;
    }

    public void setOrigin(Long origin) {
        this.origin = origin;
    }

    public Long getDestination() {
        return destination;
    }

    public void setDestination(Long destination) {
        this.destination = destination;
    }

    public Long getFreightType() {
        return freightType;
    }

    public void setFreightType(Long freightType) {
        this.freightType = freightType;
    }

    public Long getAirlines() {
        return airlines;
    }

    public void setAirlines(Long airlines) {
        this.airlines = airlines;
    }

    public Integer getBizType() {
        return bizType;
    }

    public void setBizType(Integer bizType) {
        this.bizType = bizType;
    }

    public Integer getFrom() {
        return from;
    }

    public void setFrom(Integer from) {
        this.from = from;
    }

    public Integer getTo() {
        return to;
    }

    public void setTo(Integer to) {
        this.to = to;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getProviderName() {
        return providerName;
    }

    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }

    public String getOriginName() {
        return originName;
    }

    public void setOriginName(String originName) {
        this.originName = originName;
    }

    public String getDestinationName() {
        return destinationName;
    }

    public void setDestinationName(String destinationName) {
        this.destinationName = destinationName;
    }

    public String getFreightTypeName() {
        return freightTypeName;
    }

    public void setFreightTypeName(String freightTypeName) {
        this.freightTypeName = freightTypeName;
    }

    public String getAirlineName() {
        return airlineName;
    }

    public void setAirlineName(String airlineName) {
        this.airlineName = airlineName;
    }

    public String getBizTypeName() {
        return bizTypeName;
    }

    public void setBizTypeName(String bizTypeName) {
        this.bizTypeName = bizTypeName;
    }
}
