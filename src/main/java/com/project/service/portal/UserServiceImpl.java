package com.project.service.portal;

import com.project.manager.UserManager;
import com.project.model.dto.RegUser;
import com.project.mybatis.domain.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * @author wangyinqing
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserManager userManager;

    @Override
    public int addUser(RegUser user) {
        User userEntity = convertRegUserToUser(user);
        if (isUserPresent(userEntity)) {
            return 0;
        }
        return userManager.addUser(userEntity);
    }

    @Override
    public RegUser findUserById(Long userId) {
        User user = userManager.findUserById(userId);
        RegUser regUser = convertUserToRegUser(user);
        return regUser;
    }

    @Override
    public RegUser findUserByAccountAndPass(String account, String password) {
        User user = userManager.findUserByAccount(account);
        RegUser regUser = convertUserToRegUser(user);
        if (regUser != null && regUser.getPassword().equals(password)) {
            return regUser;
        }
        return null;
    }

    @Override
    public RegUser findUserByMobileAndPass(String mobile, String password) {
        return null;
    }


    private ConcurrentMap<String, RegUser> tokenMap = new ConcurrentHashMap<>();

    @Override
    public String generateSut(RegUser user) {
        String token = UUID.randomUUID().toString().replaceAll("-", "");
        tokenMap.put(token, user);
        return token;
    }

    @Override
    public RegUser getUserByToken(String token) {
        return tokenMap.get(token);
    }

    @Override
    public RegUser removeUserByToken(String token) {
        return tokenMap.remove(token);
    }

    private RegUser convertUserToRegUser(User user) {
        RegUser regUser = new RegUser();
        BeanUtils.copyProperties(user, regUser);
        return regUser;
    }

    private User convertRegUserToUser(RegUser regUser) {
        User user = new User();
        BeanUtils.copyProperties(regUser, user);
        return user;
    }

    /**
     * 检查user是否已存在
     * @param user
     * @return
     */
    private boolean isUserPresent(User user) {
        User currentUser = userManager.findUserByAccount(user.getAccount());
        return currentUser != null;
    }

}
