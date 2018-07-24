package com.project.manager.order;

import com.project.mybatis.domain.OrderSender;

/**
 * @Author: jiazhuang
 * @Date: 23:48 2018/7/24
 */
public interface OrderSenderManager {
    int insertOrderSender(OrderSender orderSender);

    OrderSender findOrderSenderByOrderId(String orderId);
}
