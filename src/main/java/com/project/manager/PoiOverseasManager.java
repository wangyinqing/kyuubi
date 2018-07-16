package com.project.manager;

import com.project.mybatis.domain.PoiOverseas;

import java.util.List;

/**
 * @Author: jiazhuang
 * @Date: 16:19 2018/6/3
 */
public interface PoiOverseasManager {
    /**
     * 根据businessType查询全部海外poi
     * @return
     */
    List<PoiOverseas> findAllPoiOverseasByType(Integer businessType);

    List<PoiOverseas> findAllPoiOverseas();

    PoiOverseas findPoiOverseasById(Long id);
}
