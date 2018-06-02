package com.project.model.dto;

/**
 * @Author: jiazhuang
 * @Date: 16:53 2018/6/1
 */
public class PriceSearchParam {
    private Integer packageLocation;
    private Integer destination;
    private Integer length;
    private Integer width;
    private Integer height;
    private Integer weight;
    private Integer amount;
    private Integer freightType;
    private Integer deliverApproach;

    public Integer getPackageLocation() {
        return packageLocation;
    }

    public void setPackageLocation(Integer packageLocation) {
        this.packageLocation = packageLocation;
    }

    public Integer getDestination() {
        return destination;
    }

    public void setDestination(Integer destination) {
        this.destination = destination;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Integer getFreightType() {
        return freightType;
    }

    public void setFreightType(Integer freightType) {
        this.freightType = freightType;
    }

    public Integer getDeliverApproach() {
        return deliverApproach;
    }

    public void setDeliverApproach(Integer deliverApproach) {
        this.deliverApproach = deliverApproach;
    }
}
