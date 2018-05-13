package com.project.controller.backend;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Maps;
import com.project.service.business.LogisticsProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller("backendController")
@RequestMapping("/backend")
public class BackendController {


    @Autowired
    private LogisticsProviderService logisticsProviderService;

    @ResponseBody @RequestMapping("/logistics/find")
    public String findLogisticsProviders() throws Exception{
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(logisticsProviderService.findLogistcits(Maps.newHashMap()));
    }

}
