package org.tukorea.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Aspect
@Component
public class LoggerAspect {
	private static final Logger logger=LoggerFactory.getLogger(LoggerAspect.class);
	
	@Before("execution(* org.tukorea.free.persistence..*.*(..))")
	public void beforeMethod(JoinPoint jp) {
		logger.info("[BeforeMethod]: 메소드 호출 전 ");
		Signature sig = jp.getSignature();
		Object[] obj = jp.getArgs();
		logger.info("method: "+sig.getName());
		if (obj.length <= 0) {
			logger.info("no parameter");
			logger.info("/"+sig.getName()+" URL called. then "+sig.getName()+" method executed");
		}
		else {
			logger.info("인자값: "+obj[0]);
			logger.info("/"+sig.getName()+"/id="+obj[0]+" URL called. then read method executed");
		}
	}
	
	@AfterReturning(value="execution(* org.tukorea.free.persistence..*.*(..))", returning="returnObj")
	public void afterReturningMethod(JoinPoint jp, Object returnObj) {
		logger.info("[afterReturningMethod]: 메소드 호출 후 ");
		Signature sig = jp.getSignature();
		if (returnObj == null || returnObj.toString().isEmpty()) {
			logger.info("method: "+sig.getName());
			logger.info("ok");
		}
		else {
			logger.info("method: "+sig.getName());
			logger.info(returnObj.toString());
		}
	
	}
	
	
	

}
