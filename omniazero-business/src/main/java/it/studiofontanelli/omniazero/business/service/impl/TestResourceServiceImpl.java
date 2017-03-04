package it.studiofontanelli.omniazero.business.service.impl;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import it.studiofontanelli.omniazero.business.exception.ApplicationException;
import it.studiofontanelli.omniazero.business.exception.SystemException;
import it.studiofontanelli.omniazero.business.service.AnagraficaService;
import it.studiofontanelli.omniazero.business.service.TestResourceService;
import it.studiofontanelli.omniazero.dto.ConfTemplate;
import it.studiofontanelli.omniazero.integration.dao.AbiIstatProvinciaDao;
import it.studiofontanelli.omniazero.integration.dao.exception.DAOException;
import it.studiofontanelli.omniazero.integration.dto.AbiIstatProvincia;
import it.studiofontanelli.omniazero.integration.input.AbiConfTemplateInput;
import it.studiofontanelli.omniazero.util.Constants;
import it.studiofontanelli.omniazero.util.Tracer;
import it.studiofontanelli.omniazero.util.XmlSerializer;


@Service
@Scope("singleton")

public class TestResourceServiceImpl implements TestResourceService {

	protected final Logger logger = LoggerFactory.getLogger(Constants.LOGGER_PREFIX);


	@Autowired
	private AbiIstatProvinciaDao abiIstatProvinciaDao;

	@Autowired
	private AnagraficaService anagraficaService;


	public boolean testResource() throws SystemException, ApplicationException {
		String method = "testResource";

		Tracer.debug(logger, getClass().getSimpleName(), method, "test resource.....");
		List<AbiIstatProvincia> result;
		try {
			result = abiIstatProvinciaDao.findAll();
			Tracer.debug(logger, getClass().getSimpleName(), method, "result\n " + XmlSerializer.objectToXml(result));


			return true;


		} catch (DAOException e) {
			Tracer.error(logger, getClass().getSimpleName(), method, "DAOException " + e);
			throw new SystemException(e);
		}
	}


	@Override
	public void buildReport(String codTemplate) throws SystemException, ApplicationException {
		final String method = "buildReport";

		Tracer.debug(logger, getClass().getSimpleName(), method, "codTemplate= " + codTemplate);

		try {
			ConfTemplate template = anagraficaService.getTemplate(codTemplate);

			if(logger.isDebugEnabled()){
				Tracer.debug(logger, getClass().getSimpleName(), method, "xml template " + template.getTemplate());
			}
			/*
			JasperCompileManager.compileReportToFile(
					"reports/FirstReport.jrxml");
					System.out.println("Done!");
			*/

		} catch (SystemException e) {
			Tracer.error(logger, getClass().getSimpleName(), method, "SystemException " + e);
			throw e;
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





}
