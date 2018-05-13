package com.project.service.business;

import com.google.common.base.Function;
import com.google.common.collect.Lists;
import com.project.manager.LogisticsProviderManager;
import com.project.model.UserStatusEnum;
import com.project.model.dto.BizUser;
import com.project.mybatis.domain.LogisticsProvider;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

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
        //创建账号时设置用户为待审核状态status=0
        logisticsProvider.setStatus(UserStatusEnum.PENDING.getValue());
        return logisticsProviderManager.addLogisticsProvider(logisticsProvider);
    }

    /**
     * 根据账号密码查询用户
     *
     * @param account
     * @param password
     * @return
     */
    @Override
    public BizUser findLogisticsProviderByAccountAndPass(String account, String password) {
        LogisticsProvider logisticsProvider = logisticsProviderManager.findLogisticsProviderByAccount(account);
        if (logisticsProvider != null && password.equals(logisticsProvider.getPassword())) {
            return convertLogisticsProviderToBizUser(logisticsProvider);
        }
        return null;
    }

    private LogisticsProvider convertBizUserToLogisticsProvider(BizUser bizUser) {
        LogisticsProvider logisticsProvider = new LogisticsProvider();
        BeanUtils.copyProperties(bizUser, logisticsProvider);
        return logisticsProvider;
    }

    private BizUser convertLogisticsProviderToBizUser(LogisticsProvider logisticsProvider) {
        BizUser bizUser = new BizUser();
        BeanUtils.copyProperties(logisticsProvider, bizUser);
        return bizUser;
    }

    private boolean isProviderPresent(LogisticsProvider logisticsProvider) {
        LogisticsProvider lp = logisticsProviderManager.findLogisticsProviderByAccount(logisticsProvider.getAccount());
        return lp != null;
    }


    @Override
    public List<BizUser> findLogistcits(Map<String,Object> params) {
        List<LogisticsProvider> providerList = logisticsProviderManager.findLogistics(null);
        List<BizUser> bizUsers = Lists.transform(providerList, new Function<LogisticsProvider, BizUser>() {
            @Override
            public BizUser apply(LogisticsProvider logisticsProvider) {
                BizUser bizUser = new BizUser();
                BeanUtils.copyProperties(logisticsProvider, bizUser);
                return bizUser;
            }
        });
        return bizUsers;
    }

    @Override
    public long updateLogistics(Map<String, Object> params) {
        return logisticsProviderManager.updateLogistics(params);
    }
}
