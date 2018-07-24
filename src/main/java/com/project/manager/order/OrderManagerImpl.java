package com.project.manager.order;

import com.project.mybatis.domain.Order;
import com.project.mybatis.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @Author: jiazhuang
 * @Date: 22:53 2018/7/23
 */
@Repository
public class OrderManagerImpl implements OrderManager {
    @Autowired
    private OrderMapper orderMapper;

    @Override
    public int insertOrder(Order order) {
        return orderMapper.insertOrder(order);
    }
}
