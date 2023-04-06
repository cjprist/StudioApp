package com.uncr.studioapp.aop;

import com.google.common.base.Joiner;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.extern.log4j.Log4j2;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;
import java.util.stream.Collectors;

@Component
@Aspect
@Log4j2
public class RequestLoggingAspect {

    private String returnValue="";

    private String paramMapToString(Map<String, String[]> paramMap) {
        return paramMap.entrySet().stream()
                .map(entry -> String.format("%s -> (%s)",
                        entry.getKey(), Joiner.on(",").join(entry.getValue())))
                .collect(Collectors.joining(", "));
    }

    @Pointcut("within(com.uncr.studioapp.controller..*)")
    public void onRequest() {}

    @Around("com.uncr.studioapp.aop.RequestLoggingAspect.onRequest()")
    public Object doLogging(ProceedingJoinPoint pjp) throws Throwable {
        HttpServletRequest request = // 5
                ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();

        Map<String, String[]> paramMap = request.getParameterMap();
        String params = "";
        if (!paramMap.isEmpty()) {
            params = " [" + paramMapToString(paramMap) + "]";
        }

        long start = System.currentTimeMillis();
        try {
            return pjp.proceed(pjp.getArgs()); // 6
        } finally {
            long end = System.currentTimeMillis();
            log.info("Request: {} {}{} < {} ({}ms)", request.getMethod(), request.getRequestURI(),
                    params, request.getRemoteHost(), end - start);
            log.info("Return: {}", this.returnValue);
        }
    }
    @AfterReturning(value = "onRequest()", returning = "returnValue")
    public void afterReturnLog(Object returnValue) {

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        this.returnValue= gson.toJson(returnValue);
    }

//    private Method getMethod(JoinPoint joinPoint) {
//        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
//        return signature.getMethod();
//    }

}
