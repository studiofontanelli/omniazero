package it.studiofontanelli.omniazero.business.helper;

import it.studiofontanelli.omniazero.business.exception.ApplicationException;
import it.studiofontanelli.omniazero.business.exception.SystemException;
import net.sf.jasperreports.engine.JasperReport;

public interface ReportHelper {

	
	
	public byte [] buildReport(JasperReport jasperReport) throws SystemException, ApplicationException ;
	
	
	
	
}
