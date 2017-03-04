package it.studiofontanelli.omniazero.business.service;

import java.util.List;

import it.studiofontanelli.omniazero.business.exception.ApplicationException;
import it.studiofontanelli.omniazero.business.exception.SystemException;
import it.studiofontanelli.omniazero.dto.IstatComune;

public interface CommonService {

	public boolean testResource() throws SystemException, ApplicationException;
	
	public Object getBean(String beanName) throws ApplicationException; 
	
	
	
}
