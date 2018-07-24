package com.project.mybatis.mapper;

import com.project.mybatis.domain.OrderCustoms;
import org.springframework.stereotype.Component;

/**
 * @Author: jiazhuang
 * @Date: 23:20 2018/7/24
 */
@Component
public interface OrderCustomsMapper {
    int insertOrderCustoms(OrderCustoms orderCustoms);

    OrderCustoms findOrderCustomsByOrderId(String orderId);
}
