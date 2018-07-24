package com.project.manager.order;

import com.project.mybatis.domain.OrderCollect;
import com.project.mybatis.mapper.OrderCollectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class OrderCollectManagerImpl implements OrderCollectManager {
    @Autowired
    private OrderCollectMapper orderCollectMapper;

    @Override
    public int insertOrderCollect(OrderCollect orderCollect) {
        return orderCollectMapper.insertOrderCollect(orderCollect);
    }
}
