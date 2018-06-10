package com.project.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.model.dto.AirlineVO;
import com.project.model.dto.BizTypeVO;
import com.project.model.dto.PoiDomesticVO;
import com.project.model.dto.PoiOverseasVO;
import com.project.model.dto.freight.FreightTypeVO;
import com.project.service.ResourceService;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/get")
public class ResourceController {

    @Autowired
    private ResourceService resourceService;

    @RequestMapping("/img/**")
    public void geImage(HttpServletRequest request, HttpServletResponse response) throws Exception{
        //FIXME 代码需要优化
        String path = request.getServletPath().substring("/get/img".length());
        File file = new File(path);
        byte[] bytes = new byte[(int)file.length()];
        IOUtils.read(new FileInputStream(file),bytes, 0, (int)file.length());
        OutputStream os = response.getOutputStream();
        os.write(bytes);
        os.flush();
        os.close();
    }

    @RequestMapping("/originsAndDests")
    @ResponseBody
    public String getOriginsAndDests() throws Exception{
        Map map = new HashMap();
        map.put("code",1);
        List<PoiDomesticVO> poiDomestic = resourceService.buildDomesticPoiVo();
        map.put("origins", poiDomestic);

        //FBA目的地
        List<PoiOverseasVO> poiOverseas = resourceService.buildOverseasPoiVoByType(1);
        map.put("destinations", poiOverseas);
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(map);
    }

    @RequestMapping("/allResourcesByBizType")
    @ResponseBody
    public String getAllResourcesByBizType(@RequestParam Integer bizType) throws Exception {
        Map map = new HashMap();
        map.put("code", 1);
        //始发地
        List<PoiDomesticVO> poiDomestic = resourceService.buildDomesticPoiVo();
        map.put("origins", poiDomestic);
        //目的地
        List<PoiOverseasVO> poiOverseas = resourceService.buildOverseasPoiVoByType(bizType);
        map.put("destinations", poiOverseas);
        //airlines
        List<AirlineVO> airlines = resourceService.findAllAirlines();
        map.put("airlines", airlines);
        //freight type
        List<FreightTypeVO> freightTypes = resourceService.queryFreightTypeByType(bizType);
        map.put("freightTypes", freightTypes);
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(map);
    }

    @RequestMapping("/allResources")
    @ResponseBody
    public String getAllResources() throws Exception {
        Map map = new HashMap();
        map.put("code", 1);
        //biz type
        List<BizTypeVO> bizTypes = resourceService.findAllBizType();
        map.put("bizTypes", bizTypes);
        //始发地
        List<PoiDomesticVO> poiDomestic = resourceService.buildDomesticPoiVo();
        map.put("origins", poiDomestic);
        //目的地
        List<PoiOverseasVO> poiOverseas = resourceService.buildAllOverseasPoi();
        map.put("destinations", poiOverseas);
        //airlines
        List<AirlineVO> airlines = resourceService.findAllAirlines();
        map.put("airlines", airlines);
        //freight type
        List<FreightTypeVO> freightTypes = resourceService.queryAllFreightType();
        map.put("freightTypes", freightTypes);
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(map);
    }
}
