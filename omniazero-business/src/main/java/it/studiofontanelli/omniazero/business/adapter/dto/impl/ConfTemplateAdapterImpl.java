package it.studiofontanelli.omniazero.business.adapter.dto.impl;


import org.apache.commons.lang3.StringEscapeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import it.studiofontanelli.omniazero.business.adapter.AbstractDtoAdapter;
import it.studiofontanelli.omniazero.business.adapter.dto.ConfTemplateAdapter;
import it.studiofontanelli.omniazero.business.exception.ApplicationException;
import it.studiofontanelli.omniazero.business.exception.DtoConversionException;
import it.studiofontanelli.omniazero.dto.ConfTemplate;
import it.studiofontanelli.omniazero.integration.dto.AbiConfTemplate;


@Service
public class ConfTemplateAdapterImpl extends AbstractDtoAdapter <ConfTemplate, AbiConfTemplate> implements ConfTemplateAdapter {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private ApplicationContext applicationContext;
	
	
	@Override
	public ApplicationContext getApplicationContext() {
		return applicationContext;
	}
	
	public ConfTemplateAdapterImpl() throws ApplicationException {
		super();
	}

	@Override
	public AbiConfTemplate convertTo(ConfTemplate t) throws DtoConversionException {
		// TODO Auto-generated method stub
		return super.convertTo(t);
	}

	@Override
	public ConfTemplate convertFrom(AbiConfTemplate v) throws DtoConversionException {
		ConfTemplate confTemplate = super.convertFrom(v);
		confTemplate.setTemplate(StringEscapeUtils.unescapeXml(confTemplate.getTemplate()));
		return confTemplate;
	}
	

	

	

	
}
