package com.fanciter.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fanciter.data.db.domain.User;
import com.fanciter.data.db.domain.UserExample;
import com.fanciter.data.db.mapper.UserMapper;
import com.fanciter.util.PwdMd5Util;
import lombok.extern.slf4j.Slf4j;

/**
 * @author fanciter on 2021/6/2 11:21
 */
@Service
@Slf4j
public class UserService {

    @Autowired(required = true)
    private UserMapper userMapper;

    public List<User> loginIn(String name, String password) {
        log.info("info 登录");
        log.warn("warn 登录");
        log.error("error 登录");
        log.debug("debug 登录");
        UserExample example = new UserExample();
        example.createCriteria().andNameEqualTo(name).andPasswordEqualTo(PwdMd5Util.md5Password(password));
        return userMapper.selectByExample(example);
    }
}
