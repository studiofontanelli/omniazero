package it.studiofontanelli.omniazero.business.interceptor;



import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import it.studiofontanelli.omniazero.util.Constants;
import it.studiofontanelli.omniazero.util.Tracer;



public class LogInterceptor implements MethodInterceptor {

	

	protected final Logger logger = LoggerFactory.getLogger(Constants.LOGGER_PREFIX);

	public Object invoke(MethodInvocation invocation) throws Throwable {
		String method = invocation.getMethod().getName();
		String className = invocation.getMethod().getDeclaringClass().getSimpleName();
		try {
			Tracer.debug(logger, className, method, "BEGIN");
			Object rval = invocation.proceed();
			return rval;
		}
		finally {
			Tracer.debug(logger, className, method, "END");
		}
	}

}