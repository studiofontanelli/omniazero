package it.studiofontanelli.omniazero.business.service;

import it.studiofontanelli.omniazero.business.dto.Report;
import it.studiofontanelli.omniazero.business.exception.ApplicationException;
import it.studiofontanelli.omniazero.business.exception.SystemException;

public interface ReportService {

	
	public Report buildReport(String codTemplate) throws SystemException, ApplicationException;
	
	public void compileReport () throws SystemException, ApplicationException;
	
	public void compileReport (String codiceTemplate) throws SystemException, ApplicationException;
}
