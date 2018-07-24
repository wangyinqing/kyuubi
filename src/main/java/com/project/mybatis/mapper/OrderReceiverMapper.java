package com.project.mybatis.mapper;

import com.project.mybatis.domain.OrderReceiver;
import org.springframework.stereotype.Component;

/**
 * @Author: jiazhuang
 * @Date: 23:40 2018/7/24
 */
@Component
public interface OrderReceiverMapper {
    int insertOrderReceiverMapper(OrderReceiver orderReceiver);

    OrderReceiver findOrderReceiverByOrderId(String orderId);
}
