package com.aopexample.aop;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class BeforeAfterAspectExample {
    private static final Logger LOGGER = LogManager.getLogger(BeforeAfterAspectExample.class);

    @Before("execution(* com.aopexample..*(..)))")
    public void logBeforeAllMethodCall(JoinPoint joinPoint) throws Throwable {

        LOGGER.info("====> Before Advice Example ");
        LOGGER.info("*** Start method "
                + joinPoint.getSignature().getName()+ " ***"); 
    }

    @After("execution(* com.aopexample..*(..)))")
    public void logAfterAllMethodCall(JoinPoint joinPoint) throws Throwable {

        LOGGER.info("====> After Advice Example ");
        LOGGER.info("*** End method "
                + joinPoint.getSignature().getName()+ " ***");
    }
    
    // AfterRunning
    // After Throwing
    // Around Advice
    
}
