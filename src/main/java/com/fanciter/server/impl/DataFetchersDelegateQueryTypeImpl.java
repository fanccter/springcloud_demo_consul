package com.fanciter.server.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import com.fanciter.data.db.domain.master.Testf;
import com.fanciter.data.db.domain.master.TestfExample;
import com.fanciter.data.db.domain.second.Testg;
import com.fanciter.data.db.domain.second.TestgExample;
import com.fanciter.data.db.mapper.master.TestfMapper;
import com.fanciter.data.db.mapper.second.TestgMapper;
import com.fanciter.server.graphql.test_f;
import com.fanciter.server.graphql.test_g;
import com.fanciter.server.graphql.util.DataFetchersDelegateQueryType;
import com.fanciter.util.BeanCopyUtil;
import graphql.schema.DataFetchingEnvironment;
import lombok.extern.slf4j.Slf4j;

/**
 * @author fanciter on 2021/6/3 16:59
 */
@Component
@Slf4j
public class DataFetchersDelegateQueryTypeImpl implements DataFetchersDelegateQueryType {
//    @Resource
//    private TestfMapper testfMapper;
//
//    @Resource
//    private TestgMapper testgMapper;

    @Override
    public List<test_f> test_f(DataFetchingEnvironment dataFetchingEnvironment, String name) {
          return null;

//        TestfExample example = new TestfExample();
//        example.createCriteria().andIdEqualTo(1);
//        List<Testf> list = testfMapper.selectByExample(example);
//        if(CollectionUtils.isEmpty(list)){
//            return new ArrayList<>();
//        }
//        return list.stream().map(t -> {
//            test_f info = new test_f();
//            BeanCopyUtil.copyDealNull(t, info);
//            return info;
//        }).collect(Collectors.toList());
    }

    @Override
    public List<test_g> test_g(DataFetchingEnvironment dataFetchingEnvironment, String name) {
        return null;
//        TestgExample example2 = new TestgExample();
//        example2.createCriteria().andIdEqualTo(1);
//        List<Testg> list = testgMapper.selectByExample(example2);
//        if(CollectionUtils.isEmpty(list)){
//            return new ArrayList<>();
//        }
//        return list.stream().map(t -> {
//            test_g info = new test_g();
//            BeanCopyUtil.copyDealNull(t, info);
//            return info;
//        }).collect(Collectors.toList());
    }
}
