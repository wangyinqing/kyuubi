package com.project.manager;


import com.project.model.dto.freight.FreightRange;

import java.util.List;

public interface FreightRangeManager {

    long create(List<FreightRange> freightRange);

    List<FreightRange> findFreightRangeByFreightId(long freightId);

    int deleteByFreightId(long freightId);
}
