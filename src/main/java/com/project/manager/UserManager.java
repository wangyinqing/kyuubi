package com.project.manager;

import com.project.mybatis.domain.User;

import java.util.List;

/**
 * @Author: jiazhuang
 * @Date: 22:03 2018/5/8
 */
public interface UserManager {
    /**
     * 新增用户
     * @param user
     * @return
     */
    int addUser(User user);
    /**
     * 根据id查询user
     * @param userId
     * @return
     */
    User findUserById(Long userId);

    /**
     * 根据用户名查询user
     * @param account
     * @return
     */
    User findUserByAccount(String account);

    /**
     * 根据电话查询user
     * @param mobile
     * @return
     */
    List<User> findUserByMobile(String mobile);
}
