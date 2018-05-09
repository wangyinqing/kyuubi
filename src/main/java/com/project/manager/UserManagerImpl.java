package com.project.manager;

import com.project.mybatis.domain.User;
import com.project.mybatis.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author: jiazhuang
 * @Date: 22:02 2018/5/8
 */
@Component
public class UserManagerImpl implements UserManager{

    @Autowired
    private UserMapper userMapper;

    /**
     * 新增用户
     *
     * @param user
     * @return
     */
    @Override
    public int addUser(User user) {
        return userMapper.addUser(user);
    }

    /**
     * @param userId
     * @return
     */
    @Override
    public User findUserById(Long userId) {
        return userMapper.findUserById(userId);
    }

    /**
     * 根据用户名查询user
     *
     * @param account
     * @return
     */
    @Override
    public User findUserByAccount(String account) {
        return userMapper.findUserByAccount(account);
    }

    /**
     * 根据电话查询user
     *
     * @param mobile
     * @return
     */
    @Override
    public List<User> findUserByMobile(String mobile) {
        return userMapper.findUserByMobile(mobile);
    }
}
