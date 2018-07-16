package com.project.mybatis.mapper;

import com.project.mybatis.domain.Airline;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: jiazhuang
 * @Date: 12:50 2018/6/2
 */
@Repository
public interface AirlineMapper {
    long create(Airline airline);

    Airline findAirlineById(Long id);

    List<Airline> findAllAirlines();
}
