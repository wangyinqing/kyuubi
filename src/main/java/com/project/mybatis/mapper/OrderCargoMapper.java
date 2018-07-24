package com.project.mybatis.mapper;

import com.project.mybatis.domain.OrderCargo;
import org.springframework.stereotype.Component;

/**
 * @Author: jiazhuang
 * @Date: 23:28 2018/7/23
 */
@Component
public interface OrderCargoMapper {
    int insertOrderCargo(OrderCargo orderCargo);

    OrderCargo findOrderCargoByOrderId(String orderId);
}
