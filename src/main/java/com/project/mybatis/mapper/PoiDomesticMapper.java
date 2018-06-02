package com.project.mybatis.mapper;

import com.project.mybatis.domain.PoiDomestic;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: jiazhuang
 * @Date: 13:02 2018/6/2
 */
@Repository
public interface PoiDomesticMapper {
    long create(PoiDomestic poiDomestic);

    PoiDomestic findPoiDomesticById(Long id);

    List<PoiDomestic> findAllPoiDomestic();
}
