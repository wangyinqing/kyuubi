package com.project.manager;


import com.project.model.dto.freight.Freight;
import com.project.mybatis.domain.FreightMain;

import java.util.List;

public interface FreightMainManager {

    long create(Freight freight);

    List<Freight> findByProviderId(Long providerId);

    long update(FreightMain freight);

    int delete(long id);

}
