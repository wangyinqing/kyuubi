package com.project.manager;

import com.project.mybatis.domain.Airline;
import com.project.mybatis.mapper.AirlineMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: jiazhuang
 * @Date: 16:57 2018/6/9
 */
@Repository
public class AirlineManagerImpl implements AirlineManager {
    @Autowired
    private AirlineMapper airlineMapper;

    @Override
    public long create(Airline airline) {
        return airlineMapper.create(airline);
    }

    @Override
    public Airline findAirlineById(Long id) {
        return airlineMapper.findAirlineById(id);
    }

    @Override
    public List<Airline> findAllAirlines() {
        return airlineMapper.findAllAirlines();
    }
}
