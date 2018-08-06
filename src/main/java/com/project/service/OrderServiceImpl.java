package com.project.service;

import com.project.manager.order.OrderCargoManager;
import com.project.model.vo.OrderVO;
import com.project.mybatis.domain.OrderCargo;
import com.project.util.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.support.incrementer.MySQLMaxValueIncrementer;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;

/**
 * @author YangJun
 * @createTime 2018年-08月-05日 22:21
 * @description
 */
public class OrderServiceImpl implements OrderService {

    @Autowired
    private MySQLMaxValueIncrementer mySQLMaxValueIncrementer;

    @Autowired
    private OrderCargoManager orderCargoManager;


    @Transactional
    @Override
    public String createOrder(OrderVO orderVO) {
        List<OrderCargo> orderCargoList = orderVO.getDetails();
        if (CollectionUtils.isEmpty(orderCargoList)) {
            throw new IllegalArgumentException();
        }

        long id = mySQLMaxValueIncrementer.nextLongValue();
        String orderId = DateUtils.formatDate(new Date(System.currentTimeMillis()), "yyyyMMddHHmmss") + id;
        for (OrderCargo cargo : orderCargoList) {
            cargo.setOrderId(orderId);
            orderCargoManager.insertOrderCargo(cargo);
        }

        return orderId;

    }

}
