package com.fanciter.data.db.mapper.master;

import com.fanciter.data.db.domain.master.Testf;
import com.fanciter.data.db.domain.master.TestfExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TestfMapper {
    int countByExample(TestfExample example);

    int deleteByExample(TestfExample example);

    int insert(Testf record);

    int insertSelective(Testf record);

    List<Testf> selectByExample(TestfExample example);

    int updateByExampleSelective(@Param("record") Testf record, @Param("example") TestfExample example);

    int updateByExample(@Param("record") Testf record, @Param("example") TestfExample example);
}