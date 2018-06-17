package com.project.service.business;

import com.google.common.base.Function;
import com.google.common.collect.Lists;
import com.project.manager.AirlineManager;
import com.project.manager.FreightMainManager;
import com.project.manager.FreightRangeManager;
import com.project.manager.FreightTypeManager;
import com.project.manager.PoiDomesticManager;
import com.project.manager.PoiOverseasManager;
import com.project.model.enums.BizTypeEnum;
import com.project.model.dto.freight.Freight;
import com.project.model.dto.freight.FreightRange;
import com.project.model.vo.FreightRangeVO;
import com.project.model.vo.FreightVO;
import com.project.mybatis.domain.Airline;
import com.project.mybatis.domain.FreightMain;
import com.project.mybatis.domain.FreightType;
import com.project.mybatis.domain.PoiDomestic;
import com.project.mybatis.domain.PoiOverseas;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class FreightServiceImpl implements FreightService {

    @Autowired
    private FreightMainManager freightMainManager;
    @Autowired
    private FreightRangeManager freightRangeManager;
    @Autowired
    private PoiDomesticManager poiDomesticManager;
    @Autowired
    private PoiOverseasManager poiOverseasManager;
    @Autowired
    private FreightTypeManager freightTypeManager;
    @Autowired
    private AirlineManager airlineManager;

    private Map<String, Airline> airlineMap = new ConcurrentHashMap<>();
    private Map<String, FreightType> freightTypeMap = new ConcurrentHashMap<>();
    private Map<String, PoiDomestic> poiDomesticMap = new ConcurrentHashMap<>();
    private Map<String, PoiOverseas> poiOverseasMap = new ConcurrentHashMap<>();

    @Override
    public long create(Freight freight) {
        long id = freightMainManager.create(freight);
        for(FreightRange freightRange: freight.getFreights()){
            freightRange.setFreightId(id);
        }
        freightRangeManager.create(freight.getFreights());
        return id;
    }

    @Override
    public List<FreightVO> findFreightByProviderId(Long providerId) {
        List<FreightVO> result = new ArrayList<>();
        List<Freight> freights = freightMainManager.findFreightMainByProviderId(providerId);
        for(Freight freight:freights){
            FreightVO freightVO = new FreightVO();
            //id
            freightVO.setFreightId(freight.getId());
            //biz type
            freightVO.setBizType(Integer.valueOf(freight.getBizType()));
            freightVO.setBizTypeName(BizTypeEnum.getNameByValue(Integer.valueOf(freight.getBizType())));
            //domestic poi
            buildPoiDomestic(freightVO, freight);
            //overseas poi
            buildPoiOverseas(freightVO, freight);
            //freight type
            buildFreightType(freightVO, freight);
            //airline
            buildAirline(freightVO, freight);
            //freight range
            buildFreightRange(freightVO, freight);
            result.add(freightVO);
        }
        return result;
    }

    private void buildPoiDomestic(FreightVO freightVO, Freight freight) {
        PoiDomestic origin = poiDomesticMap.get(freight.getOrigin());
        if (origin == null) {
            origin = poiDomesticManager.findPoiDomesticById(Long.valueOf(freight.getOrigin()));
            if (origin == null) {
                return;
            }
            poiDomesticMap.put(freight.getOrigin(), origin);
        }
        freightVO.setOriginId(origin.getId());
        freightVO.setOriginName(origin.getPoiName());
    }

    private void buildPoiOverseas(FreightVO freightVO, Freight freight) {
        PoiOverseas overseas = poiOverseasMap.get(freight.getDestination());
        if (overseas == null) {
            overseas = poiOverseasManager.findPoiOverseasById(Long.valueOf(freight.getDestination()));
            if (overseas == null) {
                return;
            }
            poiOverseasMap.put(freight.getDestination(), overseas);
        }
        freightVO.setDestinationId(overseas.getId());
        freightVO.setDestinationName(overseas.getPoiName());
    }

    private void buildFreightType(FreightVO freightVO, Freight freight) {
        FreightType freightType = freightTypeMap.get(freight.getFreightType());
        if (freightType == null) {
            freightType = freightTypeManager.findFreightTypeById(Long.valueOf(freight.getFreightType()));
            if (freightType == null) {
                return;
            }
            freightTypeMap.put(freight.getFreightType(), freightType);
        }
        freightVO.setFreightTypeId(freightType.getId());
        freightVO.setFreightTypeName(freightType.getName());
    }

    private void buildAirline(FreightVO freightVO, Freight freight) {
        Airline airline = airlineMap.get(freight.getAirlines());
        if (airline == null) {
            airline = airlineManager.findAirlineById(Long.valueOf(freight.getAirlines()));
            if (airline == null) {
                return;
            }
            airlineMap.put(freight.getAirlines(), airline);
        }
        freightVO.setAirLineId(airline.getId());
        freightVO.setAirLineName(airline.getAirlineName());
    }

    private void buildFreightRange(FreightVO freightVO, Freight freight) {
        List<FreightRange> freightRanges = freightRangeManager.findFreightRangeByFreightId(freight.getId());
        if (CollectionUtils.isEmpty(freightRanges)) {
            return;
        }
        List<FreightRangeVO> freightRangeVOList = Lists.transform(freightRanges, new Function<FreightRange, FreightRangeVO>() {
            @Override
            public FreightRangeVO apply(FreightRange freightRange) {
                FreightRangeVO range = new FreightRangeVO();
                BeanUtils.copyProperties(freightRange, range);
                return range;
            }
        });
        freightVO.setFreightRangeList(freightRangeVOList);
    }

    @Override
    public int update(Freight freight) {
        FreightMain freightMain = new FreightMain();
        BeanUtils.copyProperties(freight, freightMain);
        long count = freightMainManager.update(freightMain);
        freightRangeManager.deleteByFreightId(freight.getId());
        for(FreightRange freightRange: freight.getFreights()){
            freightRange.setFreightId(freight.getId());
        }
        freightRangeManager.create(freight.getFreights());
        return Long.valueOf(count).intValue();
    }

    @Override
    public int delete(long id) {
        freightRangeManager.deleteByFreightId(id);
        return freightMainManager.delete(id);
    }
}
