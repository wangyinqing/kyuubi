package com.project.service.business;

import com.project.manager.FreightMainManager;
import com.project.manager.FreightRangeManager;
import com.project.model.dto.freight.Freight;
import com.project.model.dto.freight.FreightRange;
import com.project.mybatis.domain.FreightMain;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public List<Freight> findByProviderId(Long providerId) {
        List<Freight> freights = freightMainManager.findByProviderId(providerId);
        for(Freight freight:freights){
            List<FreightRange> freightRanges = freightRangeManager.findByFreightId(freight.getId());
            freight.setFreights(freightRanges);
        }
        return freights;
    }

    @Override
    public int update(Freight freight) {
        FreightMain freightMain = new FreightMain();
        BeanUtils.copyProperties(freight, freightMain);
        long count = freightMainManager.update(freightMain);
        freightRangeManager.deleteByFreightId(freight.getId());
        for(FreightRange freightRange: freight.getFreights()){
            freightRange.setFreightId(freight.getId());
        }
        freightRangeManager.create(freight.getFreights());
        return Long.valueOf(count).intValue();
    }

    @Override
    public int delete(long id) {
        freightRangeManager.deleteByFreightId(id);
        return freightMainManager.delete(id);
    }
}
