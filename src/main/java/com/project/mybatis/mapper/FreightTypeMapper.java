package com.project.mybatis.mapper;

import com.project.mybatis.domain.FreightType;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: jiazhuang
 * @Date: 13:08 2018/6/2
 */
@Repository
public interface FreightTypeMapper {
    long create(FreightType freightType);

    FreightType findFreightTypeById(Long id);

    List<FreightType> findAllFreightType();

    List<FreightType> findFreightTypeByType(Integer type);
}
