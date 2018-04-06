package com.project.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author wangyinqing
 */
@Controller
@RequestMapping("/regist")
public class RegistController {

    @ResponseBody
    @RequestMapping("/create")
    public String create(@RequestBody Map data) {
        System.out.println(data);
        return "";
    }
}
