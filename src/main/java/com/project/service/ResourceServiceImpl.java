package com.project.service;

import com.google.common.base.Function;
import com.google.common.collect.Lists;
import com.project.manager.AirlineManager;
import com.project.manager.FreightTypeManager;
import com.project.manager.PoiDomesticManager;
import com.project.manager.PoiOverseasManager;
import com.project.model.BizTypeEnum;
import com.project.model.dto.AirlineVO;
import com.project.model.dto.BizTypeVO;
import com.project.model.dto.PoiDomesticVO;
import com.project.model.dto.PoiOverseasVO;
import com.project.model.dto.freight.FreightTypeVO;
import com.project.mybatis.domain.Airline;
import com.project.mybatis.domain.FreightType;
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

    @Autowired
    private FreightTypeManager freightTypeManager;

    @Autowired
    private AirlineManager airlineManager;

    @Override
    public List<PoiDomesticVO> buildDomesticPoiVo() {
        List<PoiDomestic> poiList = poiDomesticManager.findAllPoiDomestic();
        if (CollectionUtils.isEmpty(poiList)) {
            return Collections.emptyList();
        }
        //省
        List<PoiDomesticVO> poiProvinceList = poiList.stream()
                .filter(a -> a.getType() == 0)
                .map(a -> new PoiDomesticVO(a.getId(), a.getPoiName(), a.getParentId()))
                .collect(Collectors.toList());
        //市
        List<PoiDomesticVO> poiCityList = poiList.stream()
                .filter(a -> a.getType() == 1)
                .map(a -> new PoiDomesticVO(a.getId(), a.getPoiName(), a.getParentId()))
                .collect(Collectors.toList());
        //区
        List<PoiDomesticVO> poiCountyList = poiList.stream()
                .filter(a -> a.getType() == 2)
                .map(a -> new PoiDomesticVO(a.getId(), a.getPoiName(), a.getParentId()))
                .collect(Collectors.toList());
        Map<Long, List<PoiDomesticVO>> cityMap = buildMap(poiCityList);
        Map<Long, List<PoiDomesticVO>> countyMap = buildMap(poiCountyList);
        for (PoiDomesticVO prov : poiProvinceList) {
            List<PoiDomesticVO> cityList = cityMap.get(prov.getId());
            if (CollectionUtils.isEmpty(cityList)) {
                continue;
            }
            for (PoiDomesticVO city : cityList) {
                city.setChildren(countyMap.get(city.getId()));
            }
            prov.setChildren(cityList);
        }
        return poiProvinceList;
    }

    @Override
    public List<PoiOverseasVO> buildOverseasPoiVoByType(Integer businessType) {
        List<PoiOverseas> overseasPoiList = poiOverseasManager.findAllPoiOverseasByType(businessType);
        return overseasPoiList.stream()
                .map(a -> new PoiOverseasVO(a.getId(), a.getPoiName(), a.getShortName(), a.getBusinessType()))
                .collect(Collectors.toList());
    }

    @Override
    public List<PoiOverseasVO> buildAllOverseasPoi() {
        List<PoiOverseas> overseasList = poiOverseasManager.findAllPoiOverseas();
        return overseasList.stream()
                .map(a -> new PoiOverseasVO(a.getId(), a.getPoiName(), a.getShortName(), a.getBusinessType()))
                .collect(Collectors.toList());
    }

    //key:上级poiId
    private Map buildMap(List<PoiDomesticVO> poiList) {
        Map<Long, List<PoiDomesticVO>> map = new HashMap<>();
        for (PoiDomesticVO entity : poiList) {
            if (CollectionUtils.isEmpty(map.get(entity.getParentId()))) {
                List<PoiDomesticVO> list = new ArrayList<>();
                list.add(entity);
                map.put(entity.getParentId(), list);
            } else {
                map.get(entity.getParentId()).add(entity);
            }
        }
        return map;
    }

    @Override
    public List<FreightTypeVO> queryAllFreightType() {
        List<FreightType> freightTypeList = freightTypeManager.findAllFreightType();
        if (CollectionUtils.isEmpty(freightTypeList)) {
            return Collections.emptyList();
        }
        return Lists.transform(freightTypeList, new Function<FreightType, FreightTypeVO>() {
            @Override
            public FreightTypeVO apply(FreightType freightType) {
                FreightTypeVO vo = new FreightTypeVO();
                BeanUtils.copyProperties(freightType, vo);
                return vo;
            }
        });
    }

    @Override
    public List<FreightTypeVO> queryFreightTypeByType(Integer type) {
        List<FreightType> freightTypeList = freightTypeManager.findFreightTypeByType(type);
        if (CollectionUtils.isEmpty(freightTypeList)) {
            return Collections.emptyList();
        }
        return freightTypeList.stream()
                .map(a -> new FreightTypeVO(a.getId(), a.getName(), a.getType()))
                .collect(Collectors.toList());
    }

    @Override
    public List<AirlineVO> findAllAirlines() {
        List<Airline> airlineList = airlineManager.findAllAirlines();
        if (CollectionUtils.isEmpty(airlineList)) {
            return Collections.emptyList();
        }
        return Lists.transform(airlineList, new Function<Airline, AirlineVO>() {
            @Override
            public AirlineVO apply(Airline airline) {
                AirlineVO vo = new AirlineVO();
                BeanUtils.copyProperties(airline, vo);
                return vo;
            }
        });
    }

    @Override
    public List<BizTypeVO> findAllBizType() {
        List<BizTypeVO> list = new ArrayList<>();
        for (BizTypeEnum item : BizTypeEnum.values()) {
            BizTypeVO vo = new BizTypeVO(item.getValue(), item.getName());
            list.add(vo);
        }
        return list;
    }
}
