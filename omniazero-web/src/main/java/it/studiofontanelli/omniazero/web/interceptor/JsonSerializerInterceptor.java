package it.studiofontanelli.omniazero.web.interceptor;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import it.studiofontanelli.omniazero.util.Constants;
import it.studiofontanelli.omniazero.util.Tracer;



public class JsonSerializerInterceptor extends HandlerInterceptorAdapter {

	protected final Logger LOG = LoggerFactory.getLogger(Constants.LOGGER_PREFIX);
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		final String method = "preHandle";
		Tracer.debug(LOG, getClass().getSimpleName(), method, "request " + request.getRequestURL() + " BEGIN");
		return true;
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {
		String method = "postHandle";
		Tracer.debug(LOG, getClass().getSimpleName(), method, "request " + request.getRequestURL() + " END");
	}
	
}
