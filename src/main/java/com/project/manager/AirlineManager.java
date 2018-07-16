package com.project.manager;

import com.project.mybatis.domain.Airline;

import java.util.List;

/**
 * @Author: jiazhuang
 * @Date: 16:57 2018/6/9
 */
public interface AirlineManager {
    long create(Airline airline);

    Airline findAirlineById(Long id);

    List<Airline> findAllAirlines();
}
