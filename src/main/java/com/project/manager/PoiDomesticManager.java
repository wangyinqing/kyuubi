package com.project.manager;

import com.project.mybatis.domain.PoiDomestic;

import java.util.List;

/**
 * @Author: jiazhuang
 * @Date: 12:19 2018/6/3
 */
public interface PoiDomesticManager {
    /**
     * 查询全部国内poi
     * @return
     */
    List<PoiDomestic> findAllPoiDomestic();

    PoiDomestic findPoiDomesticById(Long id);
}
