package it.studiofontanelli.omniazero.business.adapter.dto.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import it.studiofontanelli.omniazero.business.adapter.AbstractDtoAdapter;
import it.studiofontanelli.omniazero.business.adapter.dto.IstatRegioneAdapter;
import it.studiofontanelli.omniazero.business.exception.ApplicationException;
import it.studiofontanelli.omniazero.dto.IstatRegione;
import it.studiofontanelli.omniazero.integration.dto.AbiIstatRegione;


@Service
public class IstatRegioneAdapterImpl extends AbstractDtoAdapter <IstatRegione, AbiIstatRegione> implements IstatRegioneAdapter {

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
	
	public IstatRegioneAdapterImpl() throws ApplicationException {
		super();
	}

	

	
}
