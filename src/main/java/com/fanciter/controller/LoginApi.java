package com.fanciter.controller;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.fanciter.data.db.domain.master.User;
import com.fanciter.request.UserRequest;
import com.fanciter.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

@Api(tags = "行内数据服务")
@Slf4j
@RestController
@RequestMapping("/api/v1")
public class LoginApi {

    @Autowired
    UserService userService;

    @PostMapping("/login")
    @ApiOperation("登录")
    @ResponseBody
    public String login(@RequestBody @Validated UserRequest request) {
        //log.info("登录-login, {}", request);
        List<User> list = userService.loginIn(request.getName(), request.getPassword());
        if(!list.isEmpty()){
            return "success";
        }else {
            return "error";
        }
    }


    @PostMapping("/multiTest")
    @ApiOperation("多数据测试")
    @ResponseBody
    public Map multiTest(@RequestBody @Validated UserRequest request) {
        //log.info("登录-login, {}", request);
        return userService.multiTest();
    }
}
