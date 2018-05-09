package com.project.controller.portal;

import com.project.dto.RegUser;
import com.project.service.portal.UserService;
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
        int addNum = userService.addUser(user);
        return String.valueOf(addNum);
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

}
