package com.project.controller.business;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.model.dto.BizUser;
import com.project.service.business.LogisticsProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Controller("bizRegistController")
@RequestMapping("/business/regist")
public class RegistController {

    @Autowired
    private LogisticsProviderService logisticsProviderService;

    @RequestMapping("/create")
    @ResponseBody
    public String createUser(@RequestBody BizUser user){
        int addNum = logisticsProviderService.createLogisticsProvider(user);
        return String.valueOf(addNum);
    }

    @RequestMapping("/upload")
    @ResponseBody
    public String uploadFile(@RequestParam("id") String id, @RequestParam("field") String field,
                             @RequestParam("file") MultipartFile multipartFile) throws Exception{
        Map map = new HashMap();
        try {
            File desDir = new File("/tmp/" +id + "/" + field);
            if(!desDir.exists())
                desDir.mkdirs();
            String filename = multipartFile.getOriginalFilename();
            FileCopyUtils.copy(multipartFile.getInputStream(),
                    new FileOutputStream(desDir.getAbsoluteFile() + "/" + filename));
            map.put("code", 1);
            map.put("type", field);
            map.put("name", filename);
            map.put("path", desDir.getPath());
            map.put("url", "/get/img" + desDir.getPath() + "/" + filename);
        } catch (IOException e) {
            map.put("code", 0);
            map.put("message",e.getMessage());
            e.printStackTrace();
        }
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(map);
    }



}
