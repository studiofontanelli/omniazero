package it.studiofontanelli.omniazero.business.service;

import it.studiofontanelli.omniazero.business.exception.ApplicationException;
import it.studiofontanelli.omniazero.business.exception.SystemException;

public interface TestResourceService {

	
	
	public boolean testResource() throws SystemException, ApplicationException;
	
	
	
	public void buildReport(String codTemplate) throws SystemException, ApplicationException;
}
