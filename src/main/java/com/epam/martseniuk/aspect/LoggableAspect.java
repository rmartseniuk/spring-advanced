package com.epam.martseniuk.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
@Slf4j
public class LoggableAspect {

    @Around("@annotation(com.epam.martseniuk.aspect.Loggable)")
    public void aroundAdvice(ProceedingJoinPoint proceedingJoinPoint) {
        log.info("Start execute business method");
        System.err.println("1");
        try {
            proceedingJoinPoint.proceed();
        } catch (Throwable throwable) {
            log.error("Cannot execute business method");
        }
        System.err.println("2");
        log.info("Finish execute business method");
    }

}

