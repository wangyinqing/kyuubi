package com.project.service;

import com.project.manager.PoiDomesticManager;
import com.project.manager.PoiOverseasManager;
import com.project.model.dto.PoiDomesticEntity;
import com.project.model.dto.PoiOverseasEntity;
import com.project.mybatis.domain.PoiDomestic;
import com.project.mybatis.domain.PoiOverseas;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class ResourceServiceImpl implements ResourceService {
    @Autowired
    private PoiDomesticManager poiDomesticManager;

    @Autowired
    private PoiOverseasManager poiOverseasManager;

    @Override
    public List<PoiDomesticEntity> buildDomesticPoiEntity() {
        List<PoiDomestic> poiList = poiDomesticManager.findAllPoiDomestic();
        if (CollectionUtils.isEmpty(poiList)) {
            return Collections.emptyList();
        }
        //省
        List<PoiDomesticEntity> poiProvinceList = poiList.stream()
                .filter(a -> a.getType() == 0)
                .map(a -> new PoiDomesticEntity(a.getId(), a.getPoiName(), a.getParentId()))
                .collect(Collectors.toList());
        //市
        List<PoiDomesticEntity> poiCityList = poiList.stream()
                .filter(a -> a.getType() == 1)
                .map(a -> new PoiDomesticEntity(a.getId(), a.getPoiName(), a.getParentId()))
                .collect(Collectors.toList());
        //区
        List<PoiDomesticEntity> poiCountyList = poiList.stream()
                .filter(a -> a.getType() == 2)
                .map(a -> new PoiDomesticEntity(a.getId(), a.getPoiName(), a.getParentId()))
                .collect(Collectors.toList());
        Map<Long, List<PoiDomesticEntity>> cityMap = buildMap(poiCityList);
        Map<Long, List<PoiDomesticEntity>> countyMap = buildMap(poiCountyList);
        for (PoiDomesticEntity prov : poiProvinceList) {
            List<PoiDomesticEntity> cityList = cityMap.get(prov.getId());
            if (CollectionUtils.isEmpty(cityList)) {
                continue;
            }
            for (PoiDomesticEntity city : cityList) {
                city.setChildren(countyMap.get(city.getId()));
            }
            prov.setChildren(cityList);
        }
        return poiProvinceList;
    }

    @Override
    public List<PoiOverseasEntity> buildOverseasPoiEntityByType(Integer businessType) {
        List<PoiOverseas> overseasPoiList = poiOverseasManager.findAllPoiOverseasByType(businessType);
        return overseasPoiList.stream()
                .map(a -> new PoiOverseasEntity(a.getId(), a.getPoiName(), a.getShortName()))
                .collect(Collectors.toList());
    }

    //key:上级poiId
    private Map buildMap(List<PoiDomesticEntity> poiList) {
        Map<Long, List<PoiDomesticEntity>> map = new HashMap<>();
        for (PoiDomesticEntity entity : poiList) {
            if (CollectionUtils.isEmpty(map.get(entity.getParentId()))) {
                List<PoiDomesticEntity> list = new ArrayList<>();
                list.add(entity);
                map.put(entity.getParentId(), list);
            } else {
                map.get(entity.getParentId()).add(entity);
            }
        }
        return map;
    }
}
