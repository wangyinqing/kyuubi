package com.project.manager;

import com.project.mybatis.domain.LogisticsProvider;

/**
 * @Author: jiazhuang
 * @Date: 16:44 2018/5/9
 */
public interface LogisticsProviderManager {
    /**
     * 新增物流商
     * @param logisticsProvider
     * @return
     */
    int addLogisticsProvider(LogisticsProvider logisticsProvider);

    /**
     * 根据用户名查询物流商
     * @param account
     * @return
     */
    LogisticsProvider findLogisticsProviderByAccount(String account);
}
