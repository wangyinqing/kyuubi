package com.project.service.business;

import com.project.manager.FreightMainManager;
import com.project.manager.FreightRangeManager;
import com.project.model.dto.freight.Freight;
import com.project.model.dto.freight.FreightRange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FreightServiceImpl implements FreightService {

    @Autowired
    private FreightMainManager freightMainManager;

    @Autowired
    private FreightRangeManager freightRangeManager;

    @Override
    public long create(Freight freight) {
        long id = freightMainManager.create(freight);
        for(FreightRange freightRange: freight.getFreights()){
            freightRange.setFreightId(id);
        }
        freightRangeManager.create(freight.getFreights());
        return id;
    }

}
