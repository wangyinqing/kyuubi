package com.project.service.business;

import com.project.model.dto.freight.Freight;
import com.project.model.vo.FreightVO;

import java.util.List;

public interface FreightService {

    long create(Freight freight);

    List<FreightVO> findFreightByProviderId(Long providerId);

    int update(Freight freight);

    int delete(long id);
}
