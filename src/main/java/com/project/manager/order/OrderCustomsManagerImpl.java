package com.project.manager.order;

import com.project.mybatis.domain.OrderCustoms;
import com.project.mybatis.mapper.OrderCustomsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @Author: jiazhuang
 * @Date: 23:46 2018/7/24
 */
@Repository
public class OrderCustomsManagerImpl implements OrderCustomsManager {
    @Autowired
    private OrderCustomsMapper orderCustomsMapper;

    @Override
    public int insertOrderCustoms(OrderCustoms orderCustoms) {
        return orderCustomsMapper.insertOrderCustoms(orderCustoms);
    }

    @Override
    public OrderCustoms findOrderCustomsByOrderId(String orderId) {
        return orderCustomsMapper.findOrderCustomsByOrderId(orderId);
    }
}
