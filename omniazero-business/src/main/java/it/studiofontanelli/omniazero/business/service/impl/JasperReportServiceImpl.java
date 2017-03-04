package it.studiofontanelli.omniazero.business.service.impl;


import java.io.ByteArrayInputStream;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import it.studiofontanelli.omniazero.business.dto.Report;
import it.studiofontanelli.omniazero.business.exception.ApplicationException;
import it.studiofontanelli.omniazero.business.exception.SystemException;
import it.studiofontanelli.omniazero.business.service.ReportService;
import it.studiofontanelli.omniazero.dto.ConfTemplate;
import it.studiofontanelli.omniazero.integration.dto.AbiConfTemplate;
import it.studiofontanelli.omniazero.integration.input.AbiConfTemplateInput;
import it.studiofontanelli.omniazero.util.Constants;
import it.studiofontanelli.omniazero.util.Tracer;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;



@Service
@Scope("singleton")

public class JasperReportServiceImpl extends CommonServiceImpl implements ReportService {

	protected final Logger logger = LoggerFactory.getLogger(Constants.LOGGER_PREFIX);

	
	private HashMap<String, JasperReport> report = new LinkedHashMap<String, JasperReport>();

	private JasperReport getReport(String codiceTemplate) throws ApplicationException, SystemException{
		if(report.get(codiceTemplate) == null){
			compileReport(codiceTemplate);
		}
		return report.get(codiceTemplate);
	}

	@Override
	public void compileReport() throws SystemException, ApplicationException {
		compileReport(null);
	}
	
	@Override
	public void compileReport(String codiceTemplate) throws SystemException, ApplicationException {
		final String method = "compileTemplate";
		
		try {
			Tracer.debug(LOG, getClass().getSimpleName(), method, "compiling template " + codiceTemplate);
			AbiConfTemplateInput input = new AbiConfTemplateInput();
			
			if(StringUtils.isNotBlank(codiceTemplate))
				input.setCodice(codiceTemplate);
			
			List<AbiConfTemplate> l = getAbiConfTemplateDao().find(input);
			
			List<ConfTemplate> ll = getConfTemplateAdapter().convertFrom(l);

			for(ConfTemplate confTemplate : ll){
				Tracer.debug(LOG, getClass().getSimpleName(), method, "compiling template.... " + confTemplate.getCodice());
				JasperReport jasperReport =  JasperCompileManager.compileReport(new ByteArrayInputStream(confTemplate.getTemplate().getBytes()));
				report.put(confTemplate.getCodice(), jasperReport);
				Tracer.debug(LOG, getClass().getSimpleName(), method, "template " + confTemplate.getCodice() + " added correctly!");
			}
		}
		catch (ApplicationException e) {
			Tracer.error(logger, getClass().getSimpleName(), method, "ApplicationException " + e);
			throw e;
		}
		catch (Exception e) {
			Tracer.error(logger, getClass().getSimpleName(), method, "Exception " + e);
			throw new SystemException(e.getMessage(), e);
		}
	}


	
	public void init() throws ApplicationException, SystemException{
		final String method = "init";
		Tracer.info(logger, getClass().getSimpleName(), method, "compile templates.... ");
		compileReport();
		Tracer.info(logger, getClass().getSimpleName(), method, "templates compiled correcty!!");
	}
	
	
	@Override
	public Report buildReport(String codice) throws SystemException, ApplicationException {
		final String method = "buildReport";
		
		Report report = new Report();
		try {

			JasperReport jasperReport = getReport(codice);
			if(jasperReport == null)
				throw new ApplicationException("report non compilato.");
			
			
			Map map = new HashMap<>();
			
			JasperPrint jasperPrint =  JasperFillManager.fillReport(jasperReport, map, new JREmptyDataSource());
			byte [] bytes =  JasperExportManager.exportReportToPdf(jasperPrint);
			
			report.setCodice(codice);
			report.setFile(bytes);

		} 
		catch (ApplicationException e) {
			Tracer.error(logger, getClass().getSimpleName(), method, "ApplicationException " + e);
			throw e;
		}
		catch (Exception e) {
			Tracer.error(logger, getClass().getSimpleName(), method, "Exception " + e);
			throw new SystemException(e.getMessage(), e);
		}
		return report;
	}

	

}
