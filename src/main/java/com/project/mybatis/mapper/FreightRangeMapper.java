package com.project.mybatis.mapper;

import com.project.mybatis.domain.FreightRange;
import org.springframework.stereotype.Repository;

@Repository
public interface FreightRangeMapper {

    long create(FreightRange freightRanges);

}
