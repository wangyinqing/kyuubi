package com.project.manager;

import com.project.mybatis.domain.FreightType;

import java.util.List;

/**
 * @Author: jiazhuang
 * @Date: 15:55 2018/6/9
 */
public interface FreightTypeManager {
    long create(FreightType freightType);

    FreightType findFreightTypeById(Long id);

    List<FreightType> findAllFreightType();

    List<FreightType> findFreightTypeByType(Integer type);
}
