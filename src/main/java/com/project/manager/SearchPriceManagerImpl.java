package com.project.manager;

import com.project.mybatis.domain.SearchPriceCondition;
import com.project.mybatis.domain.PriceSolution;
import com.project.mybatis.mapper.FreightMainMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: jiazhuang
 * @Date: 22:49 2018/6/3
 */
@Repository
public class SearchPriceManagerImpl implements SearchPriceManager{
    @Autowired
    private FreightMainMapper freightMainMapper;

    @Override
    public List<PriceSolution> findPriceSolutionByCondition(SearchPriceCondition searchPriceCondition) {
        return freightMainMapper.searchPriceSolutionByCondition(searchPriceCondition);
    }
}
