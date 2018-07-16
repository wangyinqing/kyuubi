package com.project.model.dto.freight;

import java.math.BigDecimal;

public class FreightRange {

    private Integer from;

    private Integer to;

    private BigDecimal price;

    private Long freightId;

    // from view only
    private boolean is_from_edit = false;
    private boolean is_to_edit = false;
    private boolean is_price_edit = false;


    public FreightRange() {
    }

    public FreightRange(Integer from, Integer to, BigDecimal price, Long freightId) {
        this.from = from;
        this.to = to;
        this.price = price;
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

    public Long getFreightId() {
        return freightId;
    }

    public void setFreightId(Long freightId) {
        this.freightId = freightId;
    }

    public boolean isIs_from_edit() {
        return is_from_edit;
    }

    public boolean isIs_to_edit() {
        return is_to_edit;
    }

    public boolean isIs_price_edit() {
        return is_price_edit;
    }

    @Override
    public String toString() {
        return "FreightRange{" +
                "from=" + from +
                ", to=" + to +
                ", price=" + price +
                ", freightId=" + freightId +
                '}';
    }
}
