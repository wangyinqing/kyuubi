package com.project.controller;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author wangyinqing
 */
@Controller
public class LoginController {

    @ResponseBody
    @RequestMapping("/login")
    public String login(@RequestParam() String account, @RequestParam() String password) throws Exception{
        Map map = new HashMap();
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(map);
    }


}
