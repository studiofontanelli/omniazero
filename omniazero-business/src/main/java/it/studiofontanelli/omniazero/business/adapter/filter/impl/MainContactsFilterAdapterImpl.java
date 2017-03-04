package it.studiofontanelli.omniazero.business.adapter.filter.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import it.studiofontanelli.omniazero.business.adapter.AbstractDtoAdapter;
import it.studiofontanelli.omniazero.business.adapter.dto.MainContactsAdapter;
import it.studiofontanelli.omniazero.business.adapter.filter.MainContactsFilterAdapter;
import it.studiofontanelli.omniazero.business.exception.ApplicationException;
import it.studiofontanelli.omniazero.business.filter.MainContactsFilter;
import it.studiofontanelli.omniazero.integration.input.AbiMainContactsInput;


@Service
public class MainContactsFilterAdapterImpl extends AbstractDtoAdapter <MainContactsFilter, AbiMainContactsInput> implements MainContactsFilterAdapter {

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
	
	public MainContactsFilterAdapterImpl() throws ApplicationException {
		super();
	}

	
}
