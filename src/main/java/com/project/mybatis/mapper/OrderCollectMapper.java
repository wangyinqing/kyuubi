package com.project.mybatis.mapper;

import com.project.mybatis.domain.OrderCollect;
import org.springframework.stereotype.Component;

/**
 * @Author: jiazhuang
 * @Date: 23:16 2018/7/23
 */
@Component
public interface OrderCollectMapper {
    int insertOrderCollect(OrderCollect orderCollect);

    OrderCollect findOrderCollectByOrderId(String orderId);
}
