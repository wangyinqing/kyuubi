package com.project.mybatis.mapper;

import com.project.mybatis.domain.FreightMain;
import org.springframework.stereotype.Repository;

@Repository
public interface FreightMainMapper {

    long create(FreightMain freight);

}
