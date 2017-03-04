package it.studiofontanelli.omniazero.business.adapter.filter.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import it.studiofontanelli.omniazero.business.adapter.AbstractDtoAdapter;
import it.studiofontanelli.omniazero.business.adapter.filter.MainUsersFilterAdapter;
import it.studiofontanelli.omniazero.business.exception.ApplicationException;
import it.studiofontanelli.omniazero.business.filter.MainUsersFilter;
import it.studiofontanelli.omniazero.integration.input.AbiMainUsersInput;


@Service
public class MainUsersFilterAdapterImpl extends AbstractDtoAdapter <MainUsersFilter, AbiMainUsersInput> implements MainUsersFilterAdapter {

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
	
	public MainUsersFilterAdapterImpl() throws ApplicationException {
		super();
	}

	
}
