package com.project.controller.portal;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.model.dto.RegUser;
import com.project.model.vo.UserVO;
import com.project.service.portal.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
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
@Controller
public class LoginController {

    UserService userService;

    @ResponseBody
    @RequestMapping("/login")
    public String login(@RequestParam() String account, @RequestParam() String password, HttpServletResponse response) throws Exception {
        RegUser regUser = userService.findUserByAccountAndPass(account, password);
        if (regUser == null) {
            regUser = userService.findUserByMobileAndPass(account, password);
        }
        Map map = new HashMap();
        if (regUser == null) {
            map.put("code", 0);
            map.put("message", "账号或者密码不正确");
        } else {
            String token = userService.generateSut(regUser);
            Cookie cookie = new Cookie("sut", token);
            cookie.setHttpOnly(true);
            response.addCookie(cookie);
            map.put("code", 1);
            map.put("user", regUser);
        }
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(map);
    }

    @RequestMapping("validateUser")
    @ResponseBody
    public String vaildate(@CookieValue(value = "sut", required = false, defaultValue = "") String token) throws Exception {
        RegUser user = userService.getUserByToken(token);
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
        RegUser user = userService.removeUserByToken(token);
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

    @RequestMapping("queryUserInfo")
    @ResponseBody
    public String queryUserInfo(@CookieValue(value = "sut", required = false, defaultValue = "") String token) throws Exception {
        RegUser user = userService.getUserByToken(token);
        String account = user.getAccount();
        Map map = new HashMap();
        if (StringUtils.isEmpty(account)) {
            map.put("code", 0);
        }
        UserVO userInfo = userService.queryUserInfoByAccount(account);
        userInfo.setMobile(hideSomeInfo(userInfo.getMobile(), false));
        userInfo.setEmail(hideSomeInfo(userInfo.getEmail(), true));
        map.put("code", 1);
        map.put("userInfo", userInfo);
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(map);
    }


    private String hideSomeInfo(String origin, boolean isMail){
        int start = origin.length() >= 3 ? 3: origin.length() -1;
        int end = origin.length() >= 3 ? origin.length() - 3 : origin.length() -1;
        char[] c = origin.toCharArray();
        char[] cc = new char[origin.length()];
        boolean isMailSuffix = false;
        for(int i =0 ;i < origin.length(); i++){
            if(isMail && c[i] == '@')
                isMailSuffix = true;
            if(!isMailSuffix && (i >= start && i < end)){
                cc[i] = '*';
            }else{
                cc[i] = c[i];
            }
        }
        return new String(cc);
    }


    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
