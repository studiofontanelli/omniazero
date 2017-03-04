package it.studiofontanelli.omniazero.business.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import it.studiofontanelli.omniazero.business.adapter.dto.ConfTemplateAdapter;
import it.studiofontanelli.omniazero.business.adapter.dto.IstatComuneAdapter;
import it.studiofontanelli.omniazero.business.adapter.dto.IstatProvinciaAdapter;
import it.studiofontanelli.omniazero.business.exception.ApplicationException;
import it.studiofontanelli.omniazero.business.exception.SystemException;
import it.studiofontanelli.omniazero.business.service.CommonService;
import it.studiofontanelli.omniazero.business.util.ApplicationContextManager;
import it.studiofontanelli.omniazero.integration.dao.AbiConfTemplateDao;
import it.studiofontanelli.omniazero.integration.dao.AbiIstatComuneDao;
import it.studiofontanelli.omniazero.integration.dao.AbiIstatProvinciaDao;
import it.studiofontanelli.omniazero.util.Constants;
import it.studiofontanelli.omniazero.util.Tracer;




@Service
@Scope("singleton")

public class CommonServiceImpl implements CommonService {

	protected final static  Logger LOG = LoggerFactory.getLogger(Constants.LOGGER_PREFIX);

	@Autowired
	private AbiIstatComuneDao abiIstatComuneDao;

	@Autowired
	private AbiIstatProvinciaDao abiIstatProvinciaDao;
	
	@Autowired
	private AbiConfTemplateDao abiConfTemplateDao;
	
	@Autowired
	private IstatComuneAdapter istatComuneAdapter;
	
	@Autowired
	private IstatProvinciaAdapter istatProvinciaAdapter;

	@Autowired
	private ConfTemplateAdapter confTemplateAdapter;

	
	@Override
	public boolean testResource() throws SystemException, ApplicationException {
		throw new SystemException("not implemented yet");
	}
	
	@Override
	public Object getBean(String beanName) throws ApplicationException{

		String method = "getBean";

		Tracer.debug(LOG, getClass().getSimpleName(), method, "getting bean " + beanName);
		if(StringUtils.isBlank(beanName)){
			Tracer.error(LOG, getClass().getSimpleName(), method, "beanName is null");
			throw new ApplicationException("You cannot get null bean");
		}
		Object obj = ApplicationContextManager.getApplicationContext().getBean(beanName);

		if(obj == null){
			Tracer.warn(LOG, getClass().getSimpleName(), method, "bean " + beanName + " not found");
			throw new ApplicationException("bean " + beanName + " not found");
		}
		Tracer.debug(LOG, getClass().getSimpleName(), method, "got bean " + obj);

		return obj;
	}

	public AbiIstatComuneDao getAbiIstatComuneDao() {
		return abiIstatComuneDao;
	}

	public void setAbiIstatComuneDao(AbiIstatComuneDao abiIstatComuneDao) {
		this.abiIstatComuneDao = abiIstatComuneDao;
	}

	public IstatComuneAdapter getIstatComuneAdapter() {
		return istatComuneAdapter;
	}

	public void setIstatComuneAdapter(IstatComuneAdapter istatComuneAdapter) {
		this.istatComuneAdapter = istatComuneAdapter;
	}


	public IstatProvinciaAdapter getIstatProvinciaAdapter() {
		return istatProvinciaAdapter;
	}

	public void setIstatProvinciaAdapter(IstatProvinciaAdapter istatProvinciaAdapter) {
		this.istatProvinciaAdapter = istatProvinciaAdapter;
	}

	public AbiIstatProvinciaDao getAbiIstatProvinciaDao() {
		return abiIstatProvinciaDao;
	}

	public void setAbiIstatProvinciaDao(AbiIstatProvinciaDao abiIstatProvinciaDao) {
		this.abiIstatProvinciaDao = abiIstatProvinciaDao;
	}

	public ConfTemplateAdapter getConfTemplateAdapter() {
		return confTemplateAdapter;
	}

	public void setConfTemplateAdapter(ConfTemplateAdapter confTemplateAdapter) {
		this.confTemplateAdapter = confTemplateAdapter;
	}

	public AbiConfTemplateDao getAbiConfTemplateDao() {
		return abiConfTemplateDao;
	}

	public void setAbiConfTemplateDao(AbiConfTemplateDao abiConfTemplateDao) {
		this.abiConfTemplateDao = abiConfTemplateDao;
	}




}
