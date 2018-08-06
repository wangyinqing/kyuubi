package com.project.service;

import com.project.model.vo.OrderVO;

/**
 * @author YangJun
 * @createTime 2018年-08月-05日 22:18
 * @description 订单服务，负责创建订单，修改，查询订单.
 */
public interface OrderService {

    /**
     * 创建订单
     *
     * @param orderVO
     * @return 订单编号
     */
    String createOrder(OrderVO orderVO);
}
