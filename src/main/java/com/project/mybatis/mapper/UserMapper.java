package com.project.mybatis.mapper;

import com.project.mybatis.domain.User;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author: jiazhuang
 * @Date: 19:17 2018/5/8
 */
@Component
public interface UserMapper {
    /**
     * 新增用户
     * @param user
     * @return
     */
    int addUser(User user);

    /**
     * 根据用户id查询
     * @param id
     * @return
     */
    User findUserById(Long id);

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
