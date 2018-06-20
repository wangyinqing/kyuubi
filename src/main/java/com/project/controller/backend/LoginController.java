package com.project.controller.backend;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * @author wangyinqing
 */
@Controller("backendLoginController")
@RequestMapping("backend")
public class LoginController {

    private ConcurrentMap<String,String> localSut = new ConcurrentHashMap<>();


    @ResponseBody
    @RequestMapping("/login")
    public String login(@RequestParam() String account, @RequestParam() String password, HttpServletResponse response) throws Exception{
        Map map = new HashMap();
        if(!"admin".equalsIgnoreCase(account)
                || !"admin".equalsIgnoreCase(password)){
            map.put("code",0);
            map.put("message","账号或者密码不正确");
        }else{
            String token = UUID.randomUUID().toString().replaceAll("-", "");
            localSut.put(token, account);
            Cookie cookie = new Cookie("sut", token);
            cookie.setHttpOnly(true);
            response.addCookie(cookie);
            map.put("code",1);
        }
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(map);
    }


    @RequestMapping("validateUser")
    @ResponseBody
    public String vaildate(@CookieValue(value = "sut", required = false, defaultValue = "") String token) throws Exception {
        String account = localSut.get(token);
        Map map = new HashMap();
        if (account == null) {
            map.put("code", 0);
        } else {
            map.put("code", 1);
            map.put("user", account);
        }
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(map);
    }

    @RequestMapping("invalidateUser")
    @ResponseBody
    public String invaildate(@CookieValue("sut") String token, HttpServletResponse response) throws Exception {
        Map map = new HashMap();
        String account = localSut.remove(token);
        if (account == null) {
            map.put("code", 0);
        } else {
            map.put("code", 1);
            Cookie cookie = new Cookie("sut", null);
            cookie.setMaxAge(0);
            response.addCookie(cookie);
        }
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(map);
    }


}
