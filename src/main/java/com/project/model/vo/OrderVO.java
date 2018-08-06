package com.project.model.vo;


import com.project.mybatis.domain.OrderCargo;

import java.util.List;

/**
 * @Author YangJun
 * @Description:订单信息,包含货物，收货人，发货人，仓库等.
 */
public class OrderVO {

    /**
     * 货物信息
     */
    private List<OrderCargo> details;

    /**
     * 获取货物信息
     *
     * @return List<OrderCargo>
     */
    public List<OrderCargo> getDetails() {
        return details;
    }

    public void setDetails(List<OrderCargo> details) {
        this.details = details;
    }
}
