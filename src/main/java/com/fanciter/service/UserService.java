package com.fanciter.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.alibaba.fastjson.JSON;
import com.fanciter.data.db.domain.master.Testf;
import com.fanciter.data.db.domain.master.TestfExample;
import com.fanciter.data.db.domain.master.User;
import com.fanciter.data.db.domain.master.UserExample;
import com.fanciter.data.db.mapper.master.TestfMapper;
import com.fanciter.data.db.mapper.master.UserMapper;
import com.fanciter.data.db.mapper.second.EsGjjInfoMapper;
import com.fanciter.util.PwdMd5Util;
import lombok.extern.slf4j.Slf4j;

/**
 * @author fanciter on 2021/6/2 11:21
 */
@Service
@Slf4j
public class UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private TestfMapper testfMapper;

    @Autowired
    private EsGjjInfoMapper esGjjInfoMapper;

    public List<User> loginIn(String name, String password) {
        log.info("info 登录");
        log.warn("warn 登录");
        log.error("error 登录");
        log.debug("debug 登录");
        UserExample example = new UserExample();
        example.createCriteria().andNameEqualTo(name).andPasswordEqualTo(PwdMd5Util.md5Password(password));
        return userMapper.selectByExample(example);
    }

    public Map multiTest(){
        Map result = new HashMap<>();
        TestfExample example = new TestfExample();
        example.createCriteria().andIdEqualTo(1);
        List<Testf> testfs = testfMapper.selectByExample(example);
        log.info("test_f:" + JSON.toJSONString(testfs));
        result.put("test_f", testfs);

        int total = esGjjInfoMapper.count();
        log.info("test_g:" + total);
        result.put("test_g", total);
        return result;
    }
}
