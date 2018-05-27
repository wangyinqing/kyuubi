package com.project.controller.business;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.model.dto.BizUser;
import com.project.model.dto.freight.Freight;
import com.project.service.business.FreightService;
import com.project.service.business.LogisticsProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller("freightController")
@RequestMapping("/business/freight")
public class FreightController {

    @Autowired
    private LogisticsProviderService logisticsProviderService;

    @Autowired
    private FreightService freightService;

    @RequestMapping("/create")
    @ResponseBody
    public String create(@RequestBody Freight freight, @CookieValue(value = "sut", required = false) String sut) throws Exception{
        Map map = new HashMap();
        ObjectMapper mapper = new ObjectMapper();
        if(sut == null){
            map.put("code", 0);
            map.put("message", "请先登录");
        }else {
            System.out.println(freight);
            BizUser bizUser = logisticsProviderService.getBizUserByToken(sut);
            freight.setProviderId(bizUser.getId());
            long id = freightService.create(freight);
            map.put("code", 1);
        }
        return mapper.writeValueAsString(map);
    }




}
