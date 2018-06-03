package com.project.manager;

import com.project.mybatis.domain.PoiOverseas;
import com.project.mybatis.mapper.PoiOverseasMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PoiOverseasManagerImpl implements PoiOverseasManager {
    @Autowired
    private PoiOverseasMapper poiOverseasMapper;

    @Override
    public List<PoiOverseas> findAllPoiOverseasByType(Integer businessType) {
        return poiOverseasMapper.findAllPoiOverseasByType(businessType);
    }
}
