package com.project.mybatis.mapper;

import com.project.mybatis.domain.PoiOverseas;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: jiazhuang
 * @Date: 13:03 2018/6/2
 */
@Repository
public interface PoiOverseasMapper {
    long create(PoiOverseas poiOverseas);

    PoiOverseas findPoiOverseasById(Long id);

    List<PoiOverseas> findPoiOverseasByType(Integer businessType);

    List<PoiOverseas> findAllPoiOverseas();
}

