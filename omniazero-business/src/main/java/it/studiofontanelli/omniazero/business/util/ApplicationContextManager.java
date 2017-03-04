package it.studiofontanelli.omniazero.business.util;



import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import it.studiofontanelli.omniazero.business.exception.ApplicationException;

public class ApplicationContextManager implements ApplicationContextAware {

	private static ApplicationContext currentApplicationContext;
	
	public void setApplicationContext(ApplicationContext paramApplicationContext) throws BeansException {
		currentApplicationContext = paramApplicationContext;
	}
	public static ApplicationContext getApplicationContext() throws ApplicationException{
		if(currentApplicationContext == null){
			throw new ApplicationException("currentApplicationContext is null!!!");
			
		}
		return currentApplicationContext;
	}
	
	

}
