package com.project.controller.portal;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.project.manager.FreightTypeManager;
import com.project.manager.PoiDomesticManager;
import com.project.manager.PoiOverseasManager;
import com.project.model.dto.PriceSearchParam;

import com.project.model.vo.OrderVO;
import com.project.mybatis.domain.PoiDomestic;
import com.project.mybatis.domain.PoiOverseas;
import com.project.service.ResourceService;
import jdk.nashorn.internal.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


/**
 * Created by Yangjun on 2018/7/19.
 */

@Controller
@RequestMapping("/order/")
public class OrderController {

    @Autowired
    private ResourceService resourceService;


    @PostMapping("collectOrderInfo")
    public String collectOrderInfo(Model model, PriceSearchParam priceSearchParam) throws Exception {
        model.addAttribute("priceSearchParam", priceSearchParam);

        //
        PoiDomestic location = resourceService.buildPoiDomesticById(Long.valueOf(priceSearchParam.getPackageLocation()));
        PoiOverseas overseas = resourceService.buildPoiOverseasById(Long.valueOf(priceSearchParam.getDestination()));
        //取件地
        model.addAttribute("locationName", location.getPoiName());
        //取件地ID
        model.addAttribute("location", location.getId());
        //取件城市名
        model.addAttribute("locationCityName", resourceService.buildPoiDomesticById(Long.valueOf(location.getParentId())).getPoiName());
        //取件城市ID
        model.addAttribute("locationCity", resourceService.buildPoiDomesticById(Long.valueOf(location.getParentId())).getId());
        //取件省份名
        model.addAttribute("locationProvinceName", resourceService.buildPoiDomesticById(resourceService.buildPoiDomesticById(Long.valueOf(location.getParentId())).getParentId()).getPoiName());
        //取件省份ID
        model.addAttribute("locationProvince", resourceService.buildPoiDomesticById(resourceService.buildPoiDomesticById(Long.valueOf(location.getParentId())).getParentId()).getId());
        //收件地
        model.addAttribute("destName", overseas.getPoiName());
        //收件地ID
        model.addAttribute("dest", overseas.getId());

        //货物种类
        model.addAttribute("freightTypeName", resourceService.buildFreightTypeById(Long.valueOf(priceSearchParam.getFreightType())).getName());


        return "order/placeOrder";
    }

    @PostMapping("createOrder")
    public String createOrder(Model model, OrderVO orderVO) {
        return "order/success.jsp";
    }

}
