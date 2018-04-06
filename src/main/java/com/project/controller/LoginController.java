package com.project.controller;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.dto.RegUser;
import com.project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author wangyinqing
 */
@Controller
public class LoginController {

    UserService userService;

    @ResponseBody
    @RequestMapping("/login")
    public String login(@RequestParam() String account, @RequestParam() String password) throws Exception{
        RegUser regUser = userService.findUserByAccountAndPass(account, password);
        if(regUser == null)
            regUser = userService.findUserByMobileAndPass(account,password);
        Map map = new HashMap();
        if(regUser == null){
            map.put("code",0);
            map.put("message","账号或者密码不正确");
        }else{
            map.put("code",1);
            map.put("data",regUser);
        }
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(map);
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

}
