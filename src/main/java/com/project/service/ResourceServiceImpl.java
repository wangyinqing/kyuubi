package com.project.service;

import com.google.common.base.Function;
import com.google.common.collect.Lists;
import com.project.manager.AirlineManager;
import com.project.manager.FreightRangeManager;
import com.project.manager.FreightTypeManager;
import com.project.manager.LogisticsProviderManager;
import com.project.manager.PoiDomesticManager;
import com.project.manager.PoiOverseasManager;
import com.project.model.dto.freight.FreightRange;
import com.project.model.enums.BizTypeEnum;
import com.project.model.vo.AirlineVO;
import com.project.model.vo.BizTypeVO;
import com.project.model.vo.FreightTypeVO;
import com.project.model.vo.PoiDomesticVO;
import com.project.model.vo.PoiOverseasVO;
import com.project.mybatis.domain.Airline;
import com.project.mybatis.domain.FreightType;
import com.project.mybatis.domain.LogisticsProvider;
import com.project.mybatis.domain.PoiDomestic;
import com.project.mybatis.domain.PoiOverseas;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
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

    @Autowired
    private FreightRangeManager freightRangeManager;

    @Autowired
    private LogisticsProviderManager logisticsProviderManager;

    private Map<Long, LogisticsProvider> providerMap = new ConcurrentHashMap<>();
    private Map<Long, Airline> airlineMap = new ConcurrentHashMap<>();
    private Map<Long, FreightType> freightTypeMap = new ConcurrentHashMap<>();
    private Map<Long, PoiDomestic> poiDomesticMap = new ConcurrentHashMap<>();
    private Map<Long, PoiOverseas> poiOverseasMap = new ConcurrentHashMap<>();

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

    @Override
    public LogisticsProvider buildProviderById(Long providerId) {
        LogisticsProvider provider = providerMap.get(providerId);
        if (provider == null) {
            provider = logisticsProviderManager.findLogisticProviderById(providerId);
            if (provider == null) {
                return null;
            }
            providerMap.put(providerId, provider);
        }
        return provider;
    }

    @Override
    public PoiDomestic buildPoiDomesticById(Long poiDomesticId) {
        PoiDomestic origin = poiDomesticMap.get(poiDomesticId);
        if (origin == null) {
            origin = poiDomesticManager.findPoiDomesticById(poiDomesticId);
            if (origin == null) {
                return null;
            }
            poiDomesticMap.put(poiDomesticId, origin);
        }
        return origin;
    }

    @Override
    public PoiOverseas buildPoiOverseasById(Long poiOverseasId) {
        PoiOverseas overseas = poiOverseasMap.get(poiOverseasId);
        if (overseas == null) {
            overseas = poiOverseasManager.findPoiOverseasById(poiOverseasId);
            if (overseas == null) {
                return null;
            }
            poiOverseasMap.put(poiOverseasId, overseas);
        }
        return overseas;
    }

    @Override
    public FreightType buildFreightTypeById(Long freightTypeId) {
        FreightType freightType = freightTypeMap.get(freightTypeId);
        if (freightType == null) {
            freightType = freightTypeManager.findFreightTypeById(freightTypeId);
            if (freightType == null) {
                return null;
            }
            freightTypeMap.put(freightTypeId, freightType);
        }
        return freightType;
    }

    @Override
    public Airline buildAirlineById(Long airlineId) {
        Airline airline = airlineMap.get(airlineId);
        if (airline == null) {
            airline = airlineManager.findAirlineById(airlineId);
            if (airline == null) {
                return null;
            }
            airlineMap.put(airlineId, airline);
        }
        return airline;
    }

    @Override
    public List<FreightRange> buildFreightRangeById(Long freightId) {
        return freightRangeManager.findFreightRangeByFreightId(freightId);
    }
}
