package com.redis.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * Created by Movie on 2017/7/12.
 */
@Aspect
@Component
public class WebLogAspect {
    private static Logger logger = LoggerFactory.getLogger(WebLogAspect.class);

    private static ThreadLocal<Long> threadLocal = new ThreadLocal<>();

    @Pointcut("execution(public * com.redis.controller..*.*(..))")
    public void weblog() {

    }

    @Before("weblog()")
    public void doBefore(JoinPoint joinPoint) throws Exception {
        threadLocal.set(System.currentTimeMillis());
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = servletRequestAttributes.getRequest();
        logger.info("url[{}]", request.getRequestURI().toString());
        logger.info("http method[{}]", request.getMethod());
        logger.info("ip[{}]", request.getRemoteAddr());
        logger.info("class method[{}]", joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        logger.info("args[{}]", Arrays.toString(joinPoint.getArgs()));
    }

    @AfterReturning(returning = "obj", pointcut = "weblog()")
    public void doAfterReturning(Object obj) throws Exception{
        logger.info("response[{}]", obj);
        logger.info("cost time [{}]ms", System.currentTimeMillis() - threadLocal.get());
    }
}





