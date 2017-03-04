package it.studiofontanelli.omniazero.web.interceptor;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.fasterxml.jackson.databind.ObjectMapper;

import it.studiofontanelli.omniazero.util.Constants;
import it.studiofontanelli.omniazero.util.Tracer;
import it.studiofontanelli.omniazero.util.XmlSerializer;



public class RequestFormatInterceptor extends HandlerInterceptorAdapter {
	
	protected final Logger LOG = LoggerFactory.getLogger(Constants.LOGGER_PREFIX);
	private ObjectMapper om = new ObjectMapper();
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		final String method = "preHandle";
		Tracer.debug(LOG, getClass().getSimpleName(), method, "BEGIN request " + request.getRequestURL());
		
		if (LOG.isDebugEnabled()) {
			Enumeration<String> en =  request.getParameterNames();
			while(en.hasMoreElements()){
				String key = en.nextElement();		
				Tracer.debug(LOG, getClass().getSimpleName(), method, "request parameter[" + key + "] = " +serParam(request.getParameter(key)));
				
			}
		}
		
		// controlla se la richiesta è ajax
		String requestedWithHeader = request.getHeader("X-Requested-With");
	    if ("XMLHttpRequest".equals(requestedWithHeader)) {
	    	request.setAttribute("isAjax", true);
	    	if (LOG.isDebugEnabled()) {
	    		Tracer.debug(LOG, getClass().getSimpleName(), method, "Call marked as AJAX");	
	    	}
	    }
	    	    
		return true;
	}
	
	public void postHandle( HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
		String method = "postHandle";
		Tracer.debug(LOG, getClass().getSimpleName(), method, "END request " + request.getRequestURL());
		
	}
	
	private String serParam(Object raw) {
		try {
			if (raw instanceof String) {
				return "\"" + (String) raw + "\"";
			}
			else if (raw instanceof Object) {
				if (raw.getClass().getName().startsWith("it.studiofontanelli")) {
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
