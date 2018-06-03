package com.project.controller.portal;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.model.dto.PriceSearchParam;
import com.project.mybatis.domain.PriceSolution;
import com.project.service.portal.PriceSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: jiazhuang
 * @Date: 17:29 2018/6/3
 */
@Controller
@RequestMapping("/search")
public class SearchController {
    @Autowired
    private PriceSearchService priceSearchService;

    @RequestMapping("searchPriceSolution")
    @ResponseBody
    public String searchPriceSolution(@RequestBody PriceSearchParam priceSearchParam) throws Exception {
        List<PriceSolution> priceSolutionList = priceSearchService.searchPriceSolution(priceSearchParam);
        Map map = new HashMap();
        map.put("priceSolutionList", priceSolutionList);
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(map);
    }
}
