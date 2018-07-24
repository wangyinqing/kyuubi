package com.project.manager.order;

import com.project.mybatis.domain.OrderCustoms;

/**
 * @Author: jiazhuang
 * @Date: 23:46 2018/7/24
 */
public interface OrderCustomsManager {
    int insertOrderCustoms(OrderCustoms orderCustoms);

    OrderCustoms findOrderCustomsByOrderId(String orderId);
}
