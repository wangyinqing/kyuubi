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
    private Integer bizType;
    private Integer freightType;
    private Integer deliverApproach;
    private Integer index = 0;
    private Integer size = 10;

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

    public Integer getBizType() {
        return bizType;
    }

    public void setBizType(Integer bizType) {
        this.bizType = bizType;
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

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }
}
