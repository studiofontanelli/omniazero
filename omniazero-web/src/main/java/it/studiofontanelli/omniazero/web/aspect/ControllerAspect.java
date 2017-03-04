package it.studiofontanelli.omniazero.web.aspect;

import java.lang.reflect.Method;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.databind.ObjectMapper;

import it.studiofontanelli.omniazero.util.Constants;
import it.studiofontanelli.omniazero.util.Tracer;
import it.studiofontanelli.omniazero.util.XmlSerializer;




@Aspect
public class ControllerAspect {

	protected final Logger LOG = LoggerFactory.getLogger(Constants.LOGGER_PREFIX);
	private ObjectMapper om = new ObjectMapper();

	@Around(value="execution(* it.studiofontanelli.omniazero.web.controller..*.*(..))", argNames = "joinPoint")
	public Object aroundTask(ProceedingJoinPoint joinPoint) throws Throwable {

		final String clazz = joinPoint.getTarget().getClass().getName();
		final String method =joinPoint.getSignature().getName();		

		Tracer.debug(LOG, clazz, method, "BEGIN");
		Object result = null;
		StopWatch stopWatch = new StopWatch();
		try {
			
			stopWatch.start();

			MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
			Method targetMethod = methodSignature.getMethod();

			RequestMapping requestMapping = targetMethod.getAnnotation(RequestMapping.class);

			//Tracer.debug(LOG, clazz, method, "RequestMapping \n" + XmlSerializer.objectToXml(requestMapping));

			if (LOG.isDebugEnabled()) {
				String logStr = String.format("args (");
				Object[] args = joinPoint.getArgs();
				for (int i = 0; i < args.length; i++) {
					logStr += serParam(args[i]) + ", ";
				}
				if (args.length > 0) {
					logStr = logStr.substring(0,  logStr.length() - 2);
				}
				logStr += ")";

				Tracer.debug(LOG, clazz, method, logStr);  
			}
			
			result = joinPoint.proceed();
		}
		catch (Throwable e) {
			Tracer.error(LOG, clazz, method, "Throwable " + e);	
			throw e;
		}
		finally{
			stopWatch.stop();
			Tracer.debug(LOG, clazz, method, "END [ execution time "+ stopWatch.getTotalTimeMillis() + " ms]");
		}
		

		
		return result;
	}

	private String serParam(Object raw) {
		try {
			if (raw instanceof String) {
				return "\"" + (String) raw + "\"";
			}
			else if (raw instanceof Object) {
				if (raw.getClass().getName().startsWith("it.csi")) {
					try {
						return XmlSerializer.objectToXml(raw);
					}
					catch (Throwable e) {
						return raw.toString();
					}
				}
				else {
					return raw.toString();
				}
			}
			else {
				return String.valueOf(raw);
			}
		}
		catch (Exception e) {
			return String.valueOf(raw);
		}
	}
}
