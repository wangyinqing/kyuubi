package com.project.manager;

import com.project.model.dto.freight.FreightRange;
import com.project.mybatis.mapper.FreightRangeMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FreightRangeManagerImpl implements FreightRangeManager {

    @Autowired
    private FreightRangeMapper freightRangeMapper;

    @Override
    public long create(List<FreightRange> freightRanges) {
        for(FreightRange freightRange : freightRanges) {
            com.project.mybatis.domain.FreightRange freightRangeDomain
                    = new com.project.mybatis.domain.FreightRange();
            BeanUtils.copyProperties(freightRange, freightRangeDomain);
            freightRangeMapper.create(freightRangeDomain);
        }
        return freightRanges.size();
    }

}
