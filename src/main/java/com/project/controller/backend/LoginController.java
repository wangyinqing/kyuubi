package com.project.controller.backend;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.dto.RegUser;
import com.project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * @author wangyinqing
 */
@Controller("backendLoginController")
@RequestMapping("backend")
public class LoginController {


    @ResponseBody
    @RequestMapping("/login")
    public String login(@RequestParam() String account, @RequestParam() String password, HttpServletResponse response) throws Exception{
        Map map = new HashMap();
        if(!"admin".equalsIgnoreCase(account)
                || !"admin".equalsIgnoreCase(password)){
            map.put("code",0);
            map.put("message","账号或者密码不正确");
        }else{
            map.put("code",1);
        }
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(map);
    }

}
