package it.studiofontanelli.omniazero.business.adapter.dto.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import it.studiofontanelli.omniazero.business.adapter.AbstractDtoAdapter;
import it.studiofontanelli.omniazero.business.adapter.dto.LkContactsTypeAdapter;
import it.studiofontanelli.omniazero.business.exception.ApplicationException;
import it.studiofontanelli.omniazero.dto.LkContactsType;
import it.studiofontanelli.omniazero.integration.dto.AbiLkContactsType;


@Service
public class LkContactsTypeAdapterImpl extends AbstractDtoAdapter <LkContactsType, AbiLkContactsType> implements LkContactsTypeAdapter {

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
	
	public LkContactsTypeAdapterImpl() throws ApplicationException {
		super();
	}

	
}
