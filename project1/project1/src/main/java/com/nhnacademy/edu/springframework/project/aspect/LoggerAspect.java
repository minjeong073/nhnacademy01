package com.nhnacademy.edu.springframework.project.aspect;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Aspect
@Component
public class LoggerAspect {
    Log log = LogFactory.getLog(LoggerAspect.class);
    @Pointcut("@annotation(com.nhnacademy.edu.springframework.project.annotation.Timer)")
    private void timer() {};

    @Around("timer()")
    public Object AssumeExecutionTime(ProceedingJoinPoint pjp) throws Throwable {
        StopWatch stopWatch = new StopWatch();

        try {
            stopWatch.start();
            return pjp.proceed();
        } finally {
            stopWatch.stop();
            System.out.println(stopWatch.prettyPrint());
        }
    }

    @Around("execution(* com.nhnacademy.edu.springframework.project.service.*.*(..))")
    public Object timer(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("[logging start]");
        StopWatch stopWatch = new StopWatch();

        try {
            stopWatch.start(pjp.getSignature().getName());
            return pjp.proceed();
        } finally {
            stopWatch.stop();
            log.info(stopWatch.prettyPrint());
        }
    }
}
