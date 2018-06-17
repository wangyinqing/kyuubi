package com.project.service;

import com.project.model.vo.AirlineVO;
import com.project.model.vo.BizTypeVO;
import com.project.model.vo.PoiDomesticVO;
import com.project.model.vo.PoiOverseasVO;
import com.project.model.vo.FreightTypeVO;

import java.util.List;

/**
 * @Author: jiazhuang
 * @Date: 12:22 2018/6/3
 */
public interface ResourceService {
    /**
     * 构建国内poi
     *
     * @return
     */
    List<PoiDomesticVO> buildDomesticPoiVo();

    /**
     * 根据businessType获取海外poi
     *
     * @param businessType
     * @return
     */
    List<PoiOverseasVO> buildOverseasPoiVoByType(Integer businessType);

    /**
     * 获取全部目的地
     * @return
     */
    List<PoiOverseasVO> buildAllOverseasPoi();

    /**
     * 根据type查询货物种类
     *
     * @param type
     * @return
     */
    List<FreightTypeVO> queryFreightTypeByType(Integer type);

    /**
     * 获取所有货物类型
     * @return
     */
    List<FreightTypeVO> queryAllFreightType();

    /**
     * 查询所有航空公司
     * @return
     */
    List<AirlineVO> findAllAirlines();

    /**
     * 获取所有biztype
     * @return
     */
    List<BizTypeVO> findAllBizType();

}
