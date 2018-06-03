package com.project.mybatis.mapper;

import com.project.mybatis.domain.SearchPriceCondition;
import com.project.mybatis.domain.FreightMain;
import com.project.mybatis.domain.PriceSolution;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FreightMainMapper {

    long create(FreightMain freight);

    List<FreightMain> findByProvider(Long providerId);

    List<PriceSolution> searchPriceSolutionByCondition(SearchPriceCondition searchPriceCondition);

    long update(FreightMain freight);

    int delete(long id);

}
