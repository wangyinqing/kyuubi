package com.project.manager.order;

import com.project.mybatis.domain.Order;

/**
 * @Author: jiazhuang
 * @Date: 22:53 2018/7/23
 */
public interface OrderManager {
    /**
     * 创建新订单
     * @param order
     * @return
     */
    int insertOrder(Order order);
}
