package com.project.mybatis.mapper;

import com.project.mybatis.domain.Order;
import org.springframework.stereotype.Component;

@Component
public interface OrderMapper {
    int insertOrder(Order order);

    Order findOrderByOrderId(String orderId);

    /**
     * 根据物流方案id查询订单
     * @param logisticsFreightId
     * @return
     */
    Order findOrderByLogisticsFreightId(Long logisticsFreightId);
}
