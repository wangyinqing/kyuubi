package com.project.manager;

import com.google.common.base.Function;
import com.google.common.collect.Lists;
import com.project.model.dto.freight.Freight;
import com.project.mybatis.domain.FreightMain;
import com.project.mybatis.mapper.FreightMainMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FreightMainManagerImpl implements FreightMainManager {


    @Autowired
    private FreightMainMapper freightMainMapper;

    @Override
    public long create(Freight freight) {
        FreightMain freightMain = new FreightMain();
        BeanUtils.copyProperties(freight,freightMain);
        freightMainMapper.create(freightMain);
        freight.setId(freightMain.getId());
        return freight.getId();
    }


    @Override
    public List<Freight> findByProviderId(Long providerId) {
        List<FreightMain> freightMains = freightMainMapper.findByProvider(providerId);
        List<Freight> freights = Lists.transform(freightMains, new Function<FreightMain,Freight>(){
            @Override
            public Freight apply(FreightMain freightMain) {
                Freight freight = new Freight();
                BeanUtils.copyProperties(freightMain,freight);
                return freight;
            }
        });
        return Lists.newArrayList(freights);
    }

    @Override
    public long update(FreightMain freight) {
        return freightMainMapper.update(freight);
    }

    @Override
    public int delete(long id) {
        return freightMainMapper.delete(id);
    }

}
