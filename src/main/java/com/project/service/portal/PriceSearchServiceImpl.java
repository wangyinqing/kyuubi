package com.project.service.portal;

import com.project.model.dto.PriceSearchParam;
import com.project.mybatis.domain.PriceSolution;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PriceSearchServiceImpl implements PriceSearchService {
    /**
     * 根据入参查询货运方案
     *
     * @param priceSearchParam
     * @return
     */
    @Override
    public List<PriceSolution> searchPriceSolution(PriceSearchParam priceSearchParam) {
        return null;
    }
}
