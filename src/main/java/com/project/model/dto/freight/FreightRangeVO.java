package com.project.model.dto.freight;

import java.math.BigDecimal;

/**
 * @Author: jiazhuang
 * @Date: 16:40 2018/6/9
 */
public class FreightRangeVO {
    private Long freightId;
    private Integer from;
    private Integer to;
    private BigDecimal price;

    public Long getFreightId() {
        return freightId;
    }

    public void setFreightId(Long freightId) {
        this.freightId = freightId;
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
        return "FreightRangeVO{" +
                "freightId=" + freightId +
                ", from=" + from +
                ", to=" + to +
                ", price=" + price +
                '}';
    }
}
