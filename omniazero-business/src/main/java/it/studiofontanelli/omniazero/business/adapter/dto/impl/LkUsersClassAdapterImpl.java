package it.studiofontanelli.omniazero.business.adapter.dto.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import it.studiofontanelli.omniazero.business.adapter.AbstractDtoAdapter;
import it.studiofontanelli.omniazero.business.adapter.dto.LkUsersClassAdapter;
import it.studiofontanelli.omniazero.business.exception.ApplicationException;
import it.studiofontanelli.omniazero.dto.LkUsersClass;
import it.studiofontanelli.omniazero.integration.dto.AbiLkUsersClass;


@Service
public class LkUsersClassAdapterImpl extends AbstractDtoAdapter <LkUsersClass, AbiLkUsersClass> implements LkUsersClassAdapter {

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
	
	public LkUsersClassAdapterImpl() throws ApplicationException {
		super();
	}

	
}
