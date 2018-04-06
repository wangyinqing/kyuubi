package com.project.controller;

import com.project.dto.RegUser;
import com.project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
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

    UserService userService;


    @ResponseBody
    @RequestMapping("/create")
    public String create(@RequestBody RegUser user) {
        System.out.println(user);
        userService.addUser(user);
        return "";
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

}
