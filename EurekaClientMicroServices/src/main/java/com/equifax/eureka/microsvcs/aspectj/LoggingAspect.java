package com.equifax.eureka.microsvcs.aspectj;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

	private static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);

	@Before("execution(* com.equifax.eureka.microsvcs.controller.*.*(..))")
	public void logBeforeForAllMethods(JoinPoint jointPoint) {
		LOGGER.info("================@Before=============");
		LOGGER.debug("Method Name : " + jointPoint.getSignature().getName());
		LOGGER.debug("-----------------------------------");
	}

	@After("execution(* com.equifax.eureka.microsvcs.controller.*.*(..))")
	public void logAfterForAllMethods(JoinPoint jointPoint) {
		LOGGER.info("================@After=============");
		LOGGER.debug("Method Name : " + jointPoint.getSignature().getName());
		LOGGER.debug("-----------------------------------");
	}

	@AfterReturning(pointcut = "execution(* com.equifax.eureka.microsvcs.controller.*.*(..))")
	public void logAfterReturningForAllMethods(JoinPoint jointPoint) {
		LOGGER.info("================@AfterReturning=============");
		LOGGER.debug("Method Name : " + jointPoint.getSignature().getName());
		LOGGER.debug("Method Arguments : " + Arrays.toString(jointPoint.getArgs()));
		LOGGER.debug("-----------------------------------");
	}

	@AfterThrowing(pointcut = "execution(* com.equifax.eureka.microsvcs.controller.*.*(..))", throwing = "error")
	public void logAfterThrowingForAllMethods(JoinPoint jointPoint, Throwable error) {
		LOGGER.info("================@AfterThrowing=============");
		LOGGER.debug("Method Name : " + jointPoint.getSignature().getName());
		LOGGER.debug("Method Arguments : " + Arrays.toString(jointPoint.getArgs()));
		LOGGER.debug("Method After Throwing ERRROR : " + error);
		LOGGER.debug("-----------------------------------");
	}
}