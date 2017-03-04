package it.studiofontanelli.omniazero.business.helper.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import it.studiofontanelli.omniazero.business.exception.ApplicationException;
import it.studiofontanelli.omniazero.business.exception.SystemException;
import it.studiofontanelli.omniazero.business.helper.ReportHelper;
import it.studiofontanelli.omniazero.util.Constants;
import it.studiofontanelli.omniazero.util.Tracer;
import net.sf.jasperreports.engine.JasperReport;

public class DemoReportHelperImpl implements ReportHelper {

	protected final static  Logger LOG = LoggerFactory.getLogger(Constants.LOGGER_PREFIX);
	
	@Override
	public byte [] buildReport(JasperReport jasperReport) throws SystemException, ApplicationException {
		final String method = "buildReport";
		return null;

	}

	

}
