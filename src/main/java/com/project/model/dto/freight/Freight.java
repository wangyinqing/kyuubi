package com.project.model.dto.freight;

import java.util.List;

public class Freight {

    private Long id;

    private String origin;

    private String destination;

    private String bizType;

    private String airlines;

    private String freightType;

    private Long providerId;

    private Integer taxInclude;

    private Integer timeMin;

    private Integer timeMax;

    private List<FreightRange> freights;

    public Freight() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getBizType() {
        return bizType;
    }

    public void setBizType(String bizType) {
        this.bizType = bizType;
    }

    public String getAirlines() {
        return airlines;
    }

    public void setAirlines(String airlines) {
        this.airlines = airlines;
    }

    public String getFreightType() {
        return freightType;
    }

    public void setFreightType(String freightType) {
        this.freightType = freightType;
    }

    public List<FreightRange> getFreights() {
        return freights;
    }

    public void setFreights(List<FreightRange> freights) {
        this.freights = freights;
    }


    public Long getProviderId() {
        return providerId;
    }

    public void setProviderId(Long providerId) {
        this.providerId = providerId;
    }

    public Integer getTaxInclude() {
        return taxInclude;
    }

    public void setTaxInclude(Integer taxInclude) {
        this.taxInclude = taxInclude;
    }

    public Integer getTimeMin() {
        return timeMin;
    }

    public void setTimeMin(Integer timeMin) {
        this.timeMin = timeMin;
    }

    public Integer getTimeMax() {
        return timeMax;
    }

    public void setTimeMax(Integer timeMax) {
        this.timeMax = timeMax;
    }

    @Override
    public String toString() {
        return "Freight{" +
                "id=" + id +
                ", origin='" + origin + '\'' +
                ", destination='" + destination + '\'' +
                ", bizType='" + bizType + '\'' +
                ", airlines='" + airlines + '\'' +
                ", freightType='" + freightType + '\'' +
                ", providerId=" + providerId +
                ", taxInclude=" + taxInclude +
                ", timeMin=" + timeMin +
                ", timeMax=" + timeMax +
                ", freights=" + freights +
                '}';
    }
}