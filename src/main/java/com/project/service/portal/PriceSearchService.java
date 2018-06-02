package com.project.service.portal;

import com.project.model.dto.PriceSearchParam;
import com.project.mybatis.domain.PriceSolution;

import java.util.List;

/**
 * @Author: jiazhuang
 * @Date: 17:27 2018/6/1
 */
public interface PriceSearchService {
    /**
     * 根据入参查询货运方案
     * @param priceSearchParam
     * @return
     */
    List<PriceSolution> searchPriceSolution(PriceSearchParam priceSearchParam);
}
