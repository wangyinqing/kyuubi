package com.project.mybatis.mapper;

import com.project.mybatis.domain.LogisticsProvider;
import org.springframework.stereotype.Component;

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
}
