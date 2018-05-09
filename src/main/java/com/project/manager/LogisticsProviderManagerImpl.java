package com.project.manager;

import com.project.mybatis.domain.LogisticsProvider;
import com.project.mybatis.mapper.LogisticsProviderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author: jiazhuang
 * @Date: 16:44 2018/5/9
 */
@Component
public class LogisticsProviderManagerImpl implements LogisticsProviderManager {
    @Autowired
    private LogisticsProviderMapper logisticsProviderMapper;
    /**
     * 新增物流商
     *
     * @param logisticsProvider
     * @return
     */
    @Override
    public int addLogisticsProvider(LogisticsProvider logisticsProvider) {
        return logisticsProviderMapper.addLogisticsProvider(logisticsProvider);
    }
}
