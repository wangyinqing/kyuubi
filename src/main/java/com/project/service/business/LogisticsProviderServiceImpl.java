package com.project.service.business;

import com.project.dto.BizUser;
import com.project.manager.LogisticsProviderManager;
import com.project.mybatis.domain.LogisticsProvider;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: jiazhuang
 * @Date: 16:46 2018/5/9
 */
@Service
public class LogisticsProviderServiceImpl implements LogisticsProviderService {
    @Autowired
    private LogisticsProviderManager logisticsProviderManager;

    /**
     * 新增物流商
     *
     * @param bizUser
     * @return
     */
    @Override
    public int createLogisticsProvider(BizUser bizUser) {
        LogisticsProvider logisticsProvider = convertBizUserToLogisticsProvider(bizUser);
        if (isProviderPresent(logisticsProvider)) {
            return 0;
        }
        return logisticsProviderManager.addLogisticsProvider(logisticsProvider);
    }

    private LogisticsProvider convertBizUserToLogisticsProvider(BizUser bizUser) {
        LogisticsProvider logisticsProvider = new LogisticsProvider();
        BeanUtils.copyProperties(bizUser, logisticsProvider);
        return logisticsProvider;
    }

    private boolean isProviderPresent(LogisticsProvider logisticsProvider) {
        return false;
    }
}
