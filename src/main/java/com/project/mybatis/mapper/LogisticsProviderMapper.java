package com.project.mybatis.mapper;

import com.project.mybatis.domain.LogisticsProvider;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author: jiazhuang
 * @Date: 16:41 2018/5/9
 */
@Component
public interface LogisticsProviderMapper {
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
     * @return
     */
    List<LogisticsProvider> findLogistics();
}
