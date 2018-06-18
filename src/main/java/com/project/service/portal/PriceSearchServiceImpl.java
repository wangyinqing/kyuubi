package com.project.service.portal;

import com.project.manager.SearchPriceManager;
import com.project.model.dto.PriceSearchParam;
import com.project.model.enums.BizTypeEnum;
import com.project.mybatis.domain.Airline;
import com.project.mybatis.domain.FreightType;
import com.project.mybatis.domain.LogisticsProvider;
import com.project.mybatis.domain.PoiDomestic;
import com.project.mybatis.domain.PoiOverseas;
import com.project.mybatis.domain.PriceSolution;
import com.project.mybatis.domain.SearchPriceCondition;
import com.project.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class PriceSearchServiceImpl implements PriceSearchService {
    @Autowired
    private SearchPriceManager searchPriceManager;

    @Autowired
    private ResourceService resourceService;

    /**
     * 根据入参查询货运方案
     *
     * @param priceSearchParam
     * @return
     */
    @Override
    public List<PriceSolution> searchPriceSolution(PriceSearchParam priceSearchParam) {
        SearchPriceCondition condition = buildSearchCondition(priceSearchParam);
        Integer totalWeight = priceSearchParam.getWeight() * priceSearchParam.getAmount();
        condition.setTotalWeight(totalWeight);
        List<PriceSolution> result = searchPriceManager.findPriceSolutionByCondition(condition);
        if (CollectionUtils.isEmpty(result)) {
            return Collections.emptyList();
        }
        result.stream()
                .forEach(item -> {
                    //provider name
                    item.setProviderName(Optional.ofNullable(resourceService.buildProviderById(item.getProviderId()))
                            .map(LogisticsProvider::getEptname)
                            .orElse(""));
                    //poi domestic
                    item.setOriginName(Optional.ofNullable(resourceService.buildPoiDomesticById(item.getOrigin()))
                            .map(PoiDomestic::getPoiName)
                            .orElse(""));
                    //poi overseas
                    item.setDestinationName(Optional.ofNullable(resourceService.buildPoiOverseasById(item.getDestination()))
                            .map(PoiOverseas::getPoiName)
                            .orElse(""));
                    //freight type
                    item.setFreightTypeName(Optional.ofNullable(resourceService.buildFreightTypeById(item.getFreightType()))
                            .map(FreightType::getName)
                            .orElse(""));
                    //airline
                    item.setAirlineName(Optional.ofNullable(resourceService.buildAirlineById(item.getAirlines()))
                            .map(Airline::getAirlineName)
                            .orElse(""));
                    //biz type
                    item.setBizTypeName(BizTypeEnum.getNameByValue(item.getBizType()));
                });
        return result;
    }

    private SearchPriceCondition buildSearchCondition(PriceSearchParam param) {
        SearchPriceCondition condition = new SearchPriceCondition();
        condition.setOrigin(param.getPackageLocation());
        condition.setDestination(param.getDestination());
        condition.setBizType(param.getBizType());
        condition.setFreightType(param.getFreightType());
        condition.setIndex(param.getIndex());
        condition.setSize(param.getSize());
        return condition;
    }
}
