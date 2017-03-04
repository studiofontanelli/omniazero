package it.studiofontanelli.omniazero.business.aspect;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import it.studiofontanelli.omniazero.util.Constants;
import it.studiofontanelli.omniazero.util.Tracer;

@Component
@Aspect
public class StopWatchAspect {

	protected final static  Logger LOG = LoggerFactory.getLogger(Constants.LOGGER_PREFIX);

	//@Around("execution(* com.foo.bar..*.*(..))")
	@Around("execution (* it.studiofontanelli.omniazero.business.service.*.*(..) )")
	public Object logTimeMethod(ProceedingJoinPoint joinPoint) throws Throwable {
		
		final String clazz = joinPoint.getTarget().getClass().getName();
		final String method =joinPoint.getSignature().getName();		
		
		Tracer.debug(LOG, clazz, method, "BEGIN");
		
		StopWatch stopWatch = new StopWatch();
		stopWatch.start();

		Object retVal = joinPoint.proceed();

		StringBuffer logMessage = new StringBuffer();
		logMessage.append(joinPoint.getTarget().getClass().getSimpleName());
		logMessage.append(".");
		logMessage.append(joinPoint.getSignature().getName());
		logMessage.append("(");

		// append args
		/*
		 * 
			  Object[] args = joinPoint.getArgs();

			for (int i = 0; i < args.length; i++) {
				logMessage.append(args[i]).append(",");
			}
			if (args.length > 0) {
				logMessage.deleteCharAt(logMessage.length() - 1);
			}
		 */

		logMessage.append("***");

		logMessage.append(")");
		logMessage.append(" execution time: ");
		logMessage.append(stopWatch.getTotalTimeMillis());
		logMessage.append(" ms");
		//log.info(logMessage.toString());
		//System.out.println(logMessage.toString());
		
		stopWatch.stop();
		Tracer.debug(LOG, clazz, method,  "END [execution time: " + stopWatch.getTotalTimeMillis() + " ms]");

		return retVal;
	}

}
