package com.project.controller.business;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.model.dto.BizUser;
import com.project.service.business.LogisticsProviderService;
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
@Controller("bizLoginController")
@RequestMapping("business")
public class LoginController {

    @Autowired
    private LogisticsProviderService logisticsProviderService;

    @ResponseBody
    @RequestMapping("/login")
    public String login(@RequestParam() String account, @RequestParam() String password, HttpServletResponse response) throws Exception {
        BizUser bizUser = logisticsProviderService.findLogisticsProviderByAccountAndPass(account, password);

        Map map = new HashMap();
        map.put("code", 0);
        if (bizUser == null) {
            map.put("message", "账号或者密码不正确");
        }else if(bizUser.getStatus() == 0){
            map.put("message", "您的账号还未审核通过，请先联系运营审核");
        }else if(bizUser.getStatus() == 2){
            map.put("message", "您的账号审核未通过，请先联系运营核实");
        }else if(bizUser.getStatus() == 3){
            map.put("message", "您的账号已被删除，请联系运营核实并重新注册");
        }else {
            String token = logisticsProviderService.generateSut(bizUser);
            Cookie cookie = new Cookie("sut", token);
            cookie.setHttpOnly(true);
            response.addCookie(cookie);
            map.put("bizUser", bizUser);
            map.put("code", 1);
        }
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(map);
    }

    @RequestMapping("validateUser")
    @ResponseBody
    public String vaildate(@CookieValue(value = "sut", required = false, defaultValue = "") String token) throws Exception {
        BizUser user = logisticsProviderService.getBizUserByToken(token);
        Map map = new HashMap();
        if (user == null) {
            map.put("code", 0);
        } else {
            map.put("code", 1);
            map.put("user", user);
        }
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(map);
    }

    @RequestMapping("invalidateUser")
    @ResponseBody
    public String invaildate(@CookieValue("sut") String token, HttpServletResponse response) throws Exception {
        BizUser user = logisticsProviderService.removeBizUserByToken(token);
        Map map = new HashMap();
        if (user == null) {
            map.put("code", 0);
        } else {
            map.put("code", 1);
            map.put("user", user);
            Cookie cookie = new Cookie("sut", null);
            cookie.setMaxAge(0);
            response.addCookie(cookie);
        }
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(map);
    }


}
