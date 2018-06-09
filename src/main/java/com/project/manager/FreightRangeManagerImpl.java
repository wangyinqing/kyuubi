package com.project.manager;

import com.google.common.base.Function;
import com.google.common.collect.Lists;
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

    @Override
    public List<FreightRange> findFreightRangeByFreightId(long freightId) {
        List<com.project.mybatis.domain.FreightRange> freightRanges = freightRangeMapper.findByFreightId(freightId);
        List<FreightRange> freightRangeLists = Lists.transform(freightRanges, new Function<com.project.mybatis.domain.FreightRange, FreightRange>(){
            @Override
            public FreightRange apply(com.project.mybatis.domain.FreightRange freightRange) {
                FreightRange freightRangeDto = new FreightRange();
                BeanUtils.copyProperties(freightRange, freightRangeDto);
                return freightRangeDto;
            }
        });
        return Lists.newArrayList(freightRangeLists);
    }

    @Override
    public int deleteByFreightId(long freightId) {
        return freightRangeMapper.deleteByFreightId(freightId);
    }
}
