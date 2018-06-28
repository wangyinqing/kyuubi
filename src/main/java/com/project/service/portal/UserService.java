package com.project.service.portal;

import com.project.model.dto.RegUser;
import com.project.model.vo.UserVO;

/**
 * @author wangyinqing
 */
public interface UserService {

    int addUser(RegUser user);

    RegUser findUserById(Long userId);

    RegUser findUserByAccountAndPass(String account, String password);

    RegUser findUserByMobileAndPass(String mobile, String password);

    String generateSut(RegUser user);

    RegUser getUserByToken(String token);

    RegUser removeUserByToken(String token);

    UserVO queryUserInfoByAccount(String account);

}
