package it.studiofontanelli.omniazero.business.aspect;



import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import it.studiofontanelli.omniazero.util.Constants;
import it.studiofontanelli.omniazero.util.Tracer;

@Component
@Aspect
public class LogAspect {


	protected final Logger logger = LoggerFactory.getLogger(Constants.LOGGER_PREFIX + ".util.stopwatch") ;


	@Around("execution(* it.studiofontanelli.omniazero.business.service..*.*(..))")
	public Object log(ProceedingJoinPoint joinPoint) throws Throwable {

		final String className = joinPoint.getTarget().getClass().getName();
		final String method =joinPoint.getSignature().getName();		
		try {
			Tracer.debug(logger, className, method, "BEGIN");
			Object rval = joinPoint.proceed();
			return rval;
		}
		finally {
			Tracer.debug(logger, className, method, "END");
		}
	}

	public void dumpElapsed(String className, String operation, String context, String message, long elapsedTime) {


		if (logger.isInfoEnabled()) {
			StringBuffer sb = new StringBuffer();

			sb.append(className);
			sb.append(" :: ");
			sb.append(operation);
			sb.append(" - ");
			sb.append(message);

			MDC.put(Constants.LOGGER_PREFIX + ".stopwatch.elapsed", String.valueOf(elapsedTime));
			MDC.put(Constants.LOGGER_PREFIX + ".stopwatch.context", context);
			logger.info(sb.toString());
			MDC.remove(Constants.LOGGER_PREFIX + ".stopwatch.elapsed");
			MDC.remove(Constants.LOGGER_PREFIX + ".stopwatch.context");
		}
	}

	@Around("execution(* it.studiofontanelli.omniazero.business.service..*.*(..))")
	public Object stopWatch(ProceedingJoinPoint joinPoint) throws Throwable {

		String method = joinPoint.getTarget().getClass().getSimpleName();
		String className = joinPoint.getSignature().getName();


		StopWatch stopWatch = new StopWatch();
		stopWatch.start();

		try {

			Object rval = joinPoint.proceed();
			return rval;
		}
		finally {
			stopWatch.stop();
			stopWatch.getTotalTimeMillis();
			if(logger.isInfoEnabled()){

				dumpElapsed(className, method, "invocazione servizio [" +Constants.LOGGER_PREFIX+"]::["  + method + "]", "(Interceptor)", stopWatch.getTotalTimeMillis());
			}
		}

	}
}

