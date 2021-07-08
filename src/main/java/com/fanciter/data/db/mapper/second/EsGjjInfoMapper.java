package com.fanciter.data.db.mapper.second;

import java.util.List;
import com.fanciter.data.db.domain.second.EsGjjInfo;

public interface EsGjjInfoMapper {
    int insert(EsGjjInfo record);

    List<EsGjjInfo> selectAll();

    int count();
}