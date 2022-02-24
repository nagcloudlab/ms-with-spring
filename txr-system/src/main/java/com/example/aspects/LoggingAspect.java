package com.example.aspects;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@Aspect
public class LoggingAspect {

    @Before(value = "execution(void transfer(..))")
    public void doLogBefore(JoinPoint joinPoint){
        log.info("LOG-before - {} ",joinPoint.toShortString());
    }

}
