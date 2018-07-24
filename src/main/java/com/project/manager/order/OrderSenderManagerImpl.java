package com.project.manager.order;

import com.project.mybatis.domain.OrderSender;
import com.project.mybatis.mapper.OrderSenderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @Author: jiazhuang
 * @Date: 23:49 2018/7/24
 */
@Repository
public class OrderSenderManagerImpl implements OrderSenderManager {
    @Autowired
    private OrderSenderMapper orderSenderMapper;

    @Override
    public int insertOrderSender(OrderSender orderSender) {
        return orderSenderMapper.insertOrderSender(orderSender);
    }

    @Override
    public OrderSender findOrderSenderByOrderId(String orderId) {
        return orderSenderMapper.findOrderSenderByOrderId(orderId);
    }
}
