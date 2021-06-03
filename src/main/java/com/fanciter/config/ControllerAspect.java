package com.fanciter.config;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import com.fanciter.util.AspectUtil;

/**
 * 接口拦截器  统计接口耗时超过10s的接口
 */
@Component
@Aspect
public class ControllerAspect {
    @Around("execution(public * com.fanciter.controller.*Api.*(..))")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
        return AspectUtil.logAround(joinPoint, 1000);
    }
}