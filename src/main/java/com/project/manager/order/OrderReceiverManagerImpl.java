package com.project.manager.order;

import com.project.mybatis.domain.OrderReceiver;
import com.project.mybatis.mapper.OrderReceiverMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @Author: jiazhuang
 * @Date: 23:50 2018/7/24
 */
@Repository
public class OrderReceiverManagerImpl implements OrderReceiverManager {
    @Autowired
    private OrderReceiverMapper orderReceiverMapper;

    @Override
    public int insertOrderReceiverMapper(OrderReceiver orderReceiver) {
        return orderReceiverMapper.insertOrderReceiverMapper(orderReceiver);
    }

    @Override
    public OrderReceiver findOrderReceiverByOrderId(String orderId) {
        return orderReceiverMapper.findOrderReceiverByOrderId(orderId);
    }
}
