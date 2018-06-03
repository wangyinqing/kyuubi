package com.project.manager;

import com.project.mybatis.domain.SearchPriceCondition;
import com.project.mybatis.domain.PriceSolution;

import java.util.List;

/**
 * @Author: jiazhuang
 * @Date: 17:37 2018/6/3
 */
public interface SearchPriceManager {
    /**
     * 根据条件查询价格方案
     * @param searchPriceCondition
     * @return
     */
    List<PriceSolution> findPriceSolutionByCondition(SearchPriceCondition searchPriceCondition);
}
