package com.project.service;

import com.project.model.dto.PoiDomesticEntity;
import com.project.model.dto.PoiOverseasEntity;

import java.util.List;

/**
 * @Author: jiazhuang
 * @Date: 12:22 2018/6/3
 */
public interface ResourceService {
    /**
     * 构建国内poi
     * @return
     */
    List<PoiDomesticEntity> buildDomesticPoiEntity();

    /**
     * 根据businessType获取海外poi
     * @param businessType
     * @return
     */
    List<PoiOverseasEntity> buildOverseasPoiEntityByType(Integer businessType);
}
