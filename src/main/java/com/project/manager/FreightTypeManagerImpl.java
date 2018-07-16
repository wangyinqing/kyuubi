package com.project.manager;

import com.project.mybatis.domain.FreightType;
import com.project.mybatis.mapper.FreightTypeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: jiazhuang
 * @Date: 15:56 2018/6/9
 */
@Repository
public class FreightTypeManagerImpl implements FreightTypeManager {
    @Autowired
    private FreightTypeMapper freightTypeMapper;

    @Override
    public long create(FreightType freightType) {
        return freightTypeMapper.create(freightType);
    }

    @Override
    public FreightType findFreightTypeById(Long id) {
        return freightTypeMapper.findFreightTypeById(id);
    }

    @Override
    public List<FreightType> findAllFreightType() {
        return freightTypeMapper.findAllFreightType();
    }

    @Override
    public List<FreightType> findFreightTypeByType(Integer type) {
        return freightTypeMapper.findFreightTypeByType(type);
    }

}
