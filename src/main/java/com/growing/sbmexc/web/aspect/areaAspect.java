package com.growing.sbmexc.web.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: yinm5
 * @Version: 1.0
 * @Date:2018/5/12
 */
@Aspect
@Component
@Order(-99)
public class areaAspect {

    private final static Logger logger = LoggerFactory.getLogger(areaAspect.class);

    @Pointcut("execution(public * com.growing.sbmexc.web..*.get*(..))")
    public void log(){
        logger.info("===================Starting My Logging==================");
    }

    @Before("log()")
    public void doBefore(JoinPoint joinPoint){
        logger.info("doBefore");
        ServletRequestAttributes attributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        //url
        logger.info("url={}", request.getRequestURL());
        //request method
        logger.info("method={}", request.getMethod());
        //ip
        logger.info("ip={},port={}", request.getRemoteHost(),request.getRemotePort());
        //request body
        logger.info("body={}", request.getQueryString());
        //methodname
        logger.info("methodname={}", joinPoint.getSignature().getName());
        //method parameter
        logger.info("methodargs={}", joinPoint.getArgs());

    }

    @Before("log()")
    public void doBefore2(){
        logger.info("doBefore2");
    }

    @After("log()")
    public void doAfter(){
        logger.info("doAfter");
    }

    @AfterReturning(pointcut = "log()", returning = "obj")
    public void doReturning(Object obj){
        logger.info("response={}", obj.toString());
    }
}
