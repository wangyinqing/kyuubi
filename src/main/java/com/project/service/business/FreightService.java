package com.project.service.business;

import com.project.model.dto.freight.Freight;

import java.util.List;

public interface FreightService {

    long create(Freight freight);

    List<Freight> findByProviderId(Long providerId);

    int update(Freight freight);

    int delete(long id);
}
