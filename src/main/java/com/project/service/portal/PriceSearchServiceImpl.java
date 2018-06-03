package com.project.service.portal;

import com.project.manager.SearchPriceManager;
import com.project.model.dto.PriceSearchParam;
import com.project.mybatis.domain.SearchPriceCondition;
import com.project.mybatis.domain.PriceSolution;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PriceSearchServiceImpl implements PriceSearchService {
    @Autowired
    private SearchPriceManager searchPriceManager;

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
        return searchPriceManager.findPriceSolutionByCondition(condition);
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
