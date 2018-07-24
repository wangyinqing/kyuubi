package com.project.manager.order;

import com.project.mybatis.domain.OrderReceiver;

/**
 * @Author: jiazhuang
 * @Date: 23:50 2018/7/24
 */
public interface OrderReceiverManager {
    int insertOrderReceiverMapper(OrderReceiver orderReceiver);

    OrderReceiver findOrderReceiverByOrderId(String orderId);
}
