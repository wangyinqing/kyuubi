package com.project.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Lists;
import com.project.model.BizTypeEnum;
import com.project.model.dto.PoiDomesticVO;
import com.project.model.dto.PoiOverseasVO;
import com.project.service.ResourceService;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
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

        //FIXME 可以合成一个请求
        //FBA目的地
        List<PoiOverseasVO> poiOverseasFBA = resourceService.buildOverseasPoiVoByType(BizTypeEnum.FBA.getValue());
        List<PoiOverseasVO> poiOverseasNormal = resourceService.buildOverseasPoiVoByType(BizTypeEnum.NORMAL.getValue());

        List<PoiOverseasVO> poiOverseas = Lists.newArrayList();
        poiOverseas.addAll(poiOverseasFBA);
        poiOverseas.addAll(poiOverseasNormal);
        map.put("destinations", poiOverseas);
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(map);
    }

}
