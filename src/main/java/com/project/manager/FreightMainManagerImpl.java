package com.project.manager;

import com.project.model.dto.freight.Freight;
import com.project.mybatis.domain.FreightMain;
import com.project.mybatis.mapper.FreightMainMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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

}
