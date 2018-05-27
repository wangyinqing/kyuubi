package com.project.model.dto.freight;

import java.util.List;

public class Freight {

    private Long id;

    private String origin;

    private String destination;

    private String bizType;

    private String airlines;

    private String cargoType;

    private Long providerId;

    private List<FreightRange> freights;

    public Freight() {
    }


    public Freight(Long id, String origin, String destination, String bizType, String airlines, String cargoType, Long providerId, List<FreightRange> freights) {
        this.id = id;
        this.origin = origin;
        this.destination = destination;
        this.bizType = bizType;
        this.airlines = airlines;
        this.cargoType = cargoType;
        this.providerId = providerId;
        this.freights = freights;
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

    public String getCargoType() {
        return cargoType;
    }

    public void setCargoType(String cargoType) {
        this.cargoType = cargoType;
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


    @Override
    public String toString() {
        return "Freight{" +
                "id=" + id +
                ", origin='" + origin + '\'' +
                ", destination='" + destination + '\'' +
                ", bizType='" + bizType + '\'' +
                ", airlines='" + airlines + '\'' +
                ", cargoType='" + cargoType + '\'' +
                ", providerId=" + providerId +
                ", freights=" + freights +
                '}';
    }

}