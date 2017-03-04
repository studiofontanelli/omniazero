package it.studiofontanelli.omniazero.web.controller;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import it.studiofontanelli.omniazero.business.service.AnagraficaService;
import it.studiofontanelli.omniazero.business.service.MainContactsService;
import it.studiofontanelli.omniazero.business.service.MainUsersService;
import it.studiofontanelli.omniazero.util.Constants;
import it.studiofontanelli.omniazero.util.Tracer;




public class CommonController {

	protected final Logger LOG = LoggerFactory.getLogger(Constants.LOGGER_PREFIX);

	protected final static String  INFO_MESSAGE    = "INFO_MESSAGE";
	protected static final String  ERROR_MESSAGE   = "ERROR_MESSAGE";
	
	
	@Autowired
	private MainUsersService mainUsersService;
	
	@Autowired
	private AnagraficaService anagraficaService;
	
	@Autowired
	private MainContactsService mainContactsService;
	

	protected void traceRequest(HttpServletRequest request){
		String method = "traceRequest";

		Enumeration<String> en =  request.getAttributeNames();
		while(en.hasMoreElements()){
			String key = en.nextElement();
			Tracer.debug(LOG, getClass().getSimpleName(), method, "request element[" + key + "]= " +request.getAttribute(key));
		}
	}

	protected void traceSession(HttpServletRequest request){
		String method = "traceSession";
		HttpSession session =  request.getSession();
		Enumeration<String> en =  session.getAttributeNames();
		while(en.hasMoreElements()){
			String key = en.nextElement();
			Tracer.debug(LOG, getClass().getSimpleName(), method, "session element[" + key + "]= " +request.getAttribute(key));
		}
	}

	protected void traceModel(Model uiModel){
		String method = "traceModel";
		Map<String, Object> map = uiModel.asMap();

		Tracer.debug(LOG, getClass().getSimpleName(), method, "# element in model = " + map.keySet().size());

		Iterator<String> it = map.keySet().iterator();
		while(it.hasNext()){
			String key = it.next();
			Tracer.debug(LOG, getClass().getSimpleName(), method, "element [" + key + "] " + map.get(key));
		}
	}

	protected void traceRedirectAttributes(RedirectAttributes ra){
		String method = "traceRedirectAttributes";
		Map<String, Object> map = ra.asMap();

		Tracer.debug(LOG, getClass().getSimpleName(), method, "# element in redirectAttributes = " + map.keySet().size());

		Iterator<String> it = map.keySet().iterator();
		while(it.hasNext()){
			String key = it.next();
			Tracer.debug(LOG, getClass().getSimpleName(), method, "element [" + key + "] " + map.get(key));
		}
	}

	protected void tracBindingResult(BindingResult result){
		String method = "tracBindingResult";
		if(LOG.isDebugEnabled()){
			Tracer.debug(LOG, getClass().getSimpleName(), method, "has error = " + result.hasErrors());
			Tracer.debug(LOG, getClass().getSimpleName(), method, "# error   = " + result.getErrorCount());

			for(FieldError fe : result.getFieldErrors() ){
				Tracer.debug(LOG, getClass().getSimpleName(), method, "**************");
				Tracer.debug(LOG, getClass().getSimpleName(), method, "code           = " + fe.getCode());
				Tracer.debug(LOG, getClass().getSimpleName(), method, "field          = " + fe.getField());
				Tracer.debug(LOG, getClass().getSimpleName(), method, "rejected value = " + fe.getRejectedValue());
				Tracer.debug(LOG, getClass().getSimpleName(), method, "object name    = " + fe.getObjectName());
				Tracer.debug(LOG, getClass().getSimpleName(), method, "def massage    = " + fe.getDefaultMessage());
			}	
		}
	}

	protected void cleanModel(Model uiModel){
		String method = "cleanModel";
		Map<String, Object> map = uiModel.asMap();
		Iterator<String> it = map.keySet().iterator();
		while(it.hasNext()){
			String key = it.next();
			Tracer.debug(LOG, getClass().getSimpleName(), method, "cleaning element [" + key + "]= " + map.get(key));
			map.remove(key);
		}
	}

	public void addErrorMessage(HttpServletRequest request, Model model, String message, String forward, boolean notNow){
		StringBuffer sb = new StringBuffer();
		if(model.containsAttribute(ERROR_MESSAGE)){
			sb = new StringBuffer((String)model.asMap().get(ERROR_MESSAGE));
			sb.append("<br/>");
			sb.append(message);
		}
		else{
			sb.append(message);
		}
		if(request != null){
			if(StringUtils.startsWith(forward, "redirect:") || notNow  ){
				if(request.getSession() != null) {
					request.getSession().setAttribute(ERROR_MESSAGE, sb.toString());
				}
			}
		}
		else{
			model.addAttribute(ERROR_MESSAGE, sb.toString());
		}
	}

	public void addErrorMessage(Model model, String message, String forward, boolean notNow){
		addErrorMessage(null, model, message, forward, notNow);
	}
	
	public void addErrorMessage(Model model, String message, String forward){
		addErrorMessage(null, model, message, forward, true);
	}

	public MainUsersService getMainUsersService() {
		return mainUsersService;
	}

	public void setMainUsersService(MainUsersService mainUsersService) {
		this.mainUsersService = mainUsersService;
	}

	public AnagraficaService getAnagraficaService() {
		return anagraficaService;
	}

	public void setAnagraficaService(AnagraficaService anagraficaService) {
		this.anagraficaService = anagraficaService;
	}

	public MainContactsService getMainContactsService() {
		return mainContactsService;
	}

	public void setMainContactsService(MainContactsService mainContactsService) {
		this.mainContactsService = mainContactsService;
	}


}
