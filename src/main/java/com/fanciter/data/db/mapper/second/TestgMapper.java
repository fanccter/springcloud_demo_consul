package com.fanciter.data.db.mapper.second;

import com.fanciter.data.db.domain.second.Testg;
import com.fanciter.data.db.domain.second.TestgExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TestgMapper {
    int countByExample(TestgExample example);

    int deleteByExample(TestgExample example);

    int insert(Testg record);

    int insertSelective(Testg record);

    List<Testg> selectByExample(TestgExample example);

    int updateByExampleSelective(@Param("record") Testg record, @Param("example") TestgExample example);

    int updateByExample(@Param("record") Testg record, @Param("example") TestgExample example);
}