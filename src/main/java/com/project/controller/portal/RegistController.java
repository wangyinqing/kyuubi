package com.project.controller.portal;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Strings;
import com.project.model.dto.RegUser;
import com.project.service.portal.UserService;
import com.project.util.CacheUtil;
import com.project.util.SmsSenderUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author wangyinqing
 */
@Controller
@RequestMapping("/regist")
public class RegistController {

    UserService userService;


    @ResponseBody
    @RequestMapping("/create")
    public String create(@RequestBody RegUser user,
                         @CookieValue(value = "guid", required = false, defaultValue = "") String guid) throws Exception {
        Map map = new HashMap();
        map.put("code", 0);
        if(Strings.isNullOrEmpty(guid)){
        }else{
            String code = CacheUtil.get(guid);
            if(!user.getValidationCode().equalsIgnoreCase(code)){
                map.put("message", "验证码验证失败，请重新注册");
            }else{
                int addNum = userService.addUser(user);
                map.put("code", 1);
                map.put("id", addNum);
            }
        }
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(map);
    }

    @RequestMapping("/sendCode")
    @ResponseBody
    public String sendValidationCode(@RequestParam String mobile, HttpServletResponse response) throws Exception {
        Map map = new HashMap();
        if (Strings.isNullOrEmpty(mobile)) {
            map.put("code", 0);
            map.put("message", "请先输入一个合法的手机号");
        } else {
            String code = SmsSenderUtil.generateCode(4);
            String uuid = UUID.randomUUID().toString();
            System.out.println("generated " + code + " for " + uuid);
            CacheUtil.put(uuid, code);
            Cookie cookie = new Cookie("guid", uuid);
            cookie.setHttpOnly(true);
            response.addCookie(cookie);
            if(SmsSenderUtil.sendVerifyCode(mobile, code)) {
                map.put("code", 1);
            }else{
                map.put("code", 0);
                map.put("message", "发送验证码失败");
            }
        }
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(map);
    }

    @RequestMapping("/validCode")
    @ResponseBody
    public String checkdValidationCode(@CookieValue(value = "guid", required = false, defaultValue = "") String guid,
                                       @RequestParam String validationCode) throws Exception {
        Map map = new HashMap();
        if (guid == null || guid.trim().length() == 0 || validationCode == null) {
            map.put("code", 0);
        } else {
            String code = CacheUtil.get(guid);
            if(validationCode.equalsIgnoreCase(code)){
                map.put("code", 1);
            }else{
                map.put("code", 0);
            }
        }
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(map);

    }


    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

}
