package com.project.mybatis.mapper;

import com.project.mybatis.domain.FreightMain;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FreightMainMapper {

    long create(FreightMain freight);

    List<FreightMain> findByProvider(Long providerId);

    long update(FreightMain freight);

    int delete(long id);

}
