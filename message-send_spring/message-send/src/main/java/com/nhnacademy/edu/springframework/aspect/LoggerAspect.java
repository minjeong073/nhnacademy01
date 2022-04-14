package com.nhnacademy.edu.springframework.aspect;

import com.nhnacademy.edu.springframework.User;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Aspect
@Component
public class LoggerAspect {

    @Order(2)
    @Around("execution(public * sendMessage(..))")
    public Object loggingSendMessage(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("[logging start]");
        StopWatch stopWatch = new StopWatch();

        try {
            stopWatch.start();
            return pjp.proceed();
        } finally {
            stopWatch.stop();
            System.out.println(stopWatch.prettyPrint());
        }
    }

    @Order(100)
    @Around("execution(public * sendMessage(..))&&args(user, message)")
    public Object profile(ProceedingJoinPoint pjp, User user, String message) throws Throwable {
        System.out.println("[profile start]");
        System.out.println("[Profile]" + user + "\n message : " + message);
        return pjp.proceed();
    }

}
