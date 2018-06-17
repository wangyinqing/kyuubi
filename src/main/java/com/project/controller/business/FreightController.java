package com.project.controller.business;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.model.dto.BizUser;
import com.project.model.dto.freight.Freight;
import com.project.model.vo.FreightVO;
import com.project.service.business.FreightService;
import com.project.service.business.LogisticsProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller("freightController")
@RequestMapping("/business/freight")
public class FreightController {

    @Autowired
    private LogisticsProviderService logisticsProviderService;

    @Autowired
    private FreightService freightService;

    @RequestMapping("/saveOrUpdate")
    @ResponseBody
    public String saveOrUpdate(@RequestBody Freight freight, @CookieValue(value = "sut", required = false) String sut) throws Exception{
        Map map = new HashMap();
        ObjectMapper mapper = new ObjectMapper();
        if(sut == null){
            map.put("code", 0);
            map.put("message", "请先登录");
        }else {
            System.out.println(freight);
            BizUser bizUser = logisticsProviderService.getBizUserByToken(sut);
            freight.setProviderId(bizUser.getId());
            if(freight.getId() == null) {
                long id = freightService.create(freight);
            }else{
                int updated = freightService.update(freight);
            }
            map.put("code", 1);
        }
        return mapper.writeValueAsString(map);
    }

    @RequestMapping(value = "/list", produces = {"application/json; charset=UTF-8"})
    @ResponseBody
    public String findByProvider(@CookieValue(value = "sut", required = false) String sut) throws Exception {
        Map map = new HashMap();
        ObjectMapper mapper = new ObjectMapper();
        if(sut == null){
            map.put("code", 0);
            map.put("message", "请先登录");
        }else {
            BizUser bizUser = logisticsProviderService.getBizUserByToken(sut);
            List<FreightVO> freights = freightService.findFreightByProviderId(bizUser.getId());
            freights.stream()
                    .forEach(a -> {
                        a.setProviderId(bizUser.getId());
                        a.setProviderName(bizUser.getEptname());
                    });
            map.put("code", 1);
            map.put("data", freights);
        }
        return mapper.writeValueAsString(map);
    }


    @RequestMapping(value = "/delete/{id}", produces = {"application/json; charset=UTF-8"})
    @ResponseBody
    public String delete(@PathVariable("id") String id) throws Exception{
        Map map = new HashMap();
        ObjectMapper mapper = new ObjectMapper();
        freightService.delete(Long.parseLong(id));
        map.put("code", 1);
        return mapper.writeValueAsString(map);
    }


}
