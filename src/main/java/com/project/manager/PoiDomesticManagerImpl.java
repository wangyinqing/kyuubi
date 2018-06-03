package com.project.manager;

import com.project.mybatis.domain.PoiDomestic;
import com.project.mybatis.mapper.PoiDomesticMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PoiDomesticManagerImpl implements PoiDomesticManager {
    @Autowired
    private PoiDomesticMapper poiDomesticMapper;

    @Override
    public List<PoiDomestic> findAllPoiDomestic() {
        return poiDomesticMapper.findAllPoiDomestic();
    }
}
