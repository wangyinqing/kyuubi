package com.project.controller.business;

import com.project.dto.BizUser;
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

@Controller("bizRegistController")
@RequestMapping("/business/regist")
public class RegistController {

    @RequestMapping("/create")
    @ResponseBody
    public String createUser(@RequestBody BizUser user){
        System.out.println(user);
        return "";
    }

    @RequestMapping("/upload")
    @ResponseBody
    public String uploadFile(@RequestParam("id") String id,
                             @RequestParam("file") MultipartFile multipartFile){
        try {
            File desDir = new File("/tmp/" +id);
            if(!desDir.exists())
                desDir.mkdirs();
            FileCopyUtils.copy(multipartFile.getInputStream(),
                    new FileOutputStream(desDir.getAbsoluteFile() + "/" + multipartFile.getOriginalFilename()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "OK";
    }



}
