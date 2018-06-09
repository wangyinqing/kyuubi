package com.project.service;

import com.project.model.dto.PoiDomesticVO;
import com.project.model.dto.PoiOverseasVO;
import com.project.model.dto.freight.FreightTypeVO;

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
    List<PoiDomesticVO> buildDomesticPoiVo();

    /**
     * 根据businessType获取海外poi
     * @param businessType
     * @return
     */
    List<PoiOverseasVO> buildOverseasPoiVoByType(Integer businessType);

    /**
     * 根据type查询货物种类
     * @param type
     * @return
     */
    List<FreightTypeVO> queryFreightTypeByType(Integer type);
}
