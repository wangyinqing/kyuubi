package com.project.controller;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;

@Controller
@RequestMapping("/get")
public class ResourceController {

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
}
