package com.project.mybatis.domain;

import java.math.BigDecimal;

/**
 * @Author: jiazhuang
 * @Date: 22:40 2018/6/3
 */
public class PriceSolution {
    private Long providerId;
    private Long origin;
    private Long destination;
    private Integer freightType;
    private Long airlines;
    private Integer bizType;
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

    public Integer getFreightType() {
        return freightType;
    }

    public void setFreightType(Integer freightType) {
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
}
