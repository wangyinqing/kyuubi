package com.project.model.dto.freight;

import java.math.BigDecimal;

public class SingleFreight {

    private Integer from;

    private Integer to;

    private BigDecimal price;

    public SingleFreight() {
    }

    public SingleFreight(Integer from, Integer to, BigDecimal price) {
        this.from = from;
        this.to = to;
        this.price = price;
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

    @Override
    public String toString() {
        return "SingleFreight{" +
                "from=" + from +
                ", to=" + to +
                ", price=" + price +
                '}';
    }
}
