package com.project.manager.order;

import com.project.mybatis.domain.OrderCargo;
import com.project.mybatis.mapper.OrderCargoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class OrderCargoManagerImpl implements OrderCargoManager {
    @Autowired
    private OrderCargoMapper orderCargoMapper;

    @Override
    public int insertOrderCargo(OrderCargo orderCargo) {
        return orderCargoMapper.insertOrderCargo(orderCargo);
    }
}
