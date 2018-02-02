package com.epam.martseniuk.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.lang.reflect.Method;


@Slf4j
@Aspect
@Component
//@Order(Ordered.HIGHEST_PRECEDENCE)
public class AuditAspect {

    @Value("${audit.path}")
    private String path;

    @After("@annotation(com.epam.martseniuk.aspect.Audit)")
    public void afterAdvice(final JoinPoint joinPoint) throws IOException {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        String auditInfo = getAuditInfo(method);
        save(auditInfo);
    }

    private String getAuditInfo(Method method) {
        return method.getName();
    }

    private void save(String auditInfo) throws IOException {
        throw new IOException();
//        try (BufferedWriter in = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(path, true)))) {
//            in.write(auditInfo);
//            in.newLine();
//        } catch (IOException e) {
//            log.error("Cannot write audit info to file", e);
//            System.out.println(e);
//        }
    }
}

