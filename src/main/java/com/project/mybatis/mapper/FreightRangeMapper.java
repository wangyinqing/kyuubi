package com.project.mybatis.mapper;

import com.project.mybatis.domain.FreightRange;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FreightRangeMapper {

    long create(FreightRange freightRanges);

    List<FreightRange> findByFreightId(long freightId);

    int deleteByFreightId(long freightId);

}
