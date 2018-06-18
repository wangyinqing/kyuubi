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
import com.project.service.ResourceService;
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
    private ResourceService resourceService;

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
            PoiDomestic poiDomestic = resourceService.buildPoiDomesticById(Long.valueOf(freight.getOrigin()));
            freightVO.setOriginId(poiDomestic.getId());
            freightVO.setOriginName(poiDomestic.getPoiName());
            //overseas poi
            PoiOverseas poiOverseas = resourceService.buildPoiOverseasById(Long.valueOf(freight.getDestination()));
            freightVO.setDestinationId(poiOverseas.getId());
            freightVO.setDestinationName(poiOverseas.getPoiName());
            //freight type
            FreightType freightType = resourceService.buildFreightTypeById(Long.valueOf(freight.getFreightType()));
            freightVO.setFreightTypeId(freightType.getId());
            freightVO.setFreightTypeName(freightType.getName());
            //airline
            Airline airline = resourceService.buildAirlineById(Long.valueOf(freight.getAirlines()));
            freightVO.setAirLineId(airline.getId());
            freightVO.setAirLineName(airline.getAirlineName());
            //freight range
            List<FreightRange> freightRanges = resourceService.buildFreightRangeById(Long.valueOf(freight.getId()));
            List<FreightRangeVO> freightRangeVOList = Lists.transform(freightRanges, new Function<FreightRange, FreightRangeVO>() {
                @Override
                public FreightRangeVO apply(FreightRange freightRange) {
                    FreightRangeVO range = new FreightRangeVO();
                    BeanUtils.copyProperties(freightRange, range);
                    return range;
                }
            });
            freightVO.setFreightRangeList(freightRangeVOList);
            result.add(freightVO);
        }
        return result;
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
