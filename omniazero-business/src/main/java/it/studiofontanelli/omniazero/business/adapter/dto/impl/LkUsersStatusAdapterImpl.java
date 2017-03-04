package it.studiofontanelli.omniazero.business.adapter.dto.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import it.studiofontanelli.omniazero.business.adapter.AbstractDtoAdapter;
import it.studiofontanelli.omniazero.business.adapter.dto.LkUsersStatusAdapter;
import it.studiofontanelli.omniazero.business.exception.ApplicationException;
import it.studiofontanelli.omniazero.dto.LkUsersStatus;
import it.studiofontanelli.omniazero.integration.dto.AbiLkUsersStatus;


@Service
public class LkUsersStatusAdapterImpl extends AbstractDtoAdapter <LkUsersStatus, AbiLkUsersStatus> implements LkUsersStatusAdapter {

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
	
	public LkUsersStatusAdapterImpl() throws ApplicationException {
		super();
	}

	
}
