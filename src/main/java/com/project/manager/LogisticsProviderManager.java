package com.project.manager;

import com.project.mybatis.domain.LogisticsProvider;

import java.util.List;
import java.util.Map;

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

    /**
     * @param params
     * @return
     */
    List<LogisticsProvider> findLogistics(Map<String,Object> params);

    LogisticsProvider findLogisticProviderById(Long id);


    long updateLogistics(Map<String,Object> params);
}
