package com.project.manager;

import com.project.mybatis.domain.LogisticsProvider;
import com.project.mybatis.mapper.LogisticsProviderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

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

    /**
     * 根据用户名查询物流商
     *
     * @param account
     * @return
     */
    @Override
    public LogisticsProvider findLogisticsProviderByAccount(String account) {
        return logisticsProviderMapper.findLogisticsProviderByAccount(account);
    }


    @Override
    public List<LogisticsProvider> findLogistics(Map<String, Object> params) {
        return logisticsProviderMapper.findLogistics();
    }

    @Override
    public LogisticsProvider findLogisticProviderById(Long id) {
        return logisticsProviderMapper.findLogisticProviderById(id);
    }

    @Override
    public long updateLogistics(Map<String, Object> params) {
        return logisticsProviderMapper.updateLogistics(params);
    }
}
