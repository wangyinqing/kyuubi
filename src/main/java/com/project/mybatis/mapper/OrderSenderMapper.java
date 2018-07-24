package com.project.mybatis.mapper;

import com.project.mybatis.domain.OrderSender;
import org.springframework.stereotype.Component;

/**
 * @Author: jiazhuang
 * @Date: 23:29 2018/7/24
 */
@Component
public interface OrderSenderMapper {
    int insertOrderSender(OrderSender orderSender);

    OrderSender findOrderSenderByOrderId(String orderId);
}
