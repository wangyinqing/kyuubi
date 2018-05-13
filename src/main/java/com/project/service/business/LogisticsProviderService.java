package com.project.service.business;

import com.project.model.dto.BizUser;

import java.util.List;
import java.util.Map;

/**
 * @Author: jiazhuang
 * @Date: 16:46 2018/5/9
 */
public interface LogisticsProviderService {
    /**
     * 新增物流商
     * @param bizUser
     * @return
     */
    int createLogisticsProvider(BizUser bizUser);

    /**
     * 根据账号密码查询用户
     * @param account
     * @param password
     * @return
     */
    BizUser findLogisticsProviderByAccountAndPass(String account, String password);


    /**
     * 返回所有物流商
     *
     * @return
     */
    List<BizUser> findLogistcits(Map<String,Object> params);

    /**
     * @param params
     * @return
     */
    long updateLogistics(Map<String,Object> params);

}
