package com.project.service;

import java.util.Iterator;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import com.project.dto.RegUser;
import org.springframework.stereotype.Service;

/**
 * @author wangyinqing
 */
@Service
public class UserServiceImpl implements UserService {

    private ConcurrentMap<String,RegUser> map = new ConcurrentHashMap<>();

    @Override
    public int addUser(RegUser user) {
        RegUser prev = map.putIfAbsent(user.getAccount(),user);
        return prev== null?1:0;
    }

    @Override
    public RegUser findUserById(Long userId) {
        return null;
    }

    @Override
    public RegUser findUserByAccountAndPass(String account, String password) {
       RegUser user =  map.get(account);
       if(user != null && user.getPassword().equals(password)){
           return user;
       }
        return null;
    }

    @Override
    public RegUser findUserByMobileAndPass(String mobile, String password) {
        RegUser user = null;
        Iterator<Map.Entry<String, RegUser>> iterator = map.entrySet().iterator();
        while(iterator.hasNext()){
            Map.Entry<String, RegUser> next = iterator.next();
            if(next.getValue().getMobile().equals(mobile)){
                if(next.getValue().getPassword().equals(password))
                    user = next.getValue();
                break;
            }
        }
        return user;
    }


    private ConcurrentMap<String,RegUser> tokenMap = new ConcurrentHashMap<>();

    @Override
    public String generateSut(RegUser user) {
        String token  =  UUID.randomUUID().toString().replaceAll("-","");
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

}
