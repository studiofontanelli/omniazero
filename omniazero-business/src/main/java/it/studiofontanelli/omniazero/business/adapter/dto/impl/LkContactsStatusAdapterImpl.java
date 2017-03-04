package it.studiofontanelli.omniazero.business.adapter.dto.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import it.studiofontanelli.omniazero.business.adapter.AbstractDtoAdapter;
import it.studiofontanelli.omniazero.business.adapter.dto.LkContactsStatusAdapter;
import it.studiofontanelli.omniazero.business.exception.ApplicationException;
import it.studiofontanelli.omniazero.dto.LkContactsStatus;
import it.studiofontanelli.omniazero.integration.dto.AbiLkContactsStatus;


@Service
public class LkContactsStatusAdapterImpl extends AbstractDtoAdapter <LkContactsStatus, AbiLkContactsStatus> implements LkContactsStatusAdapter {

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
	
	public LkContactsStatusAdapterImpl() throws ApplicationException {
		super();
	}

	
}
