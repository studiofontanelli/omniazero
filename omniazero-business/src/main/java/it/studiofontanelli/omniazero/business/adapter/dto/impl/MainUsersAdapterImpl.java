package it.studiofontanelli.omniazero.business.adapter.dto.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import it.studiofontanelli.omniazero.business.adapter.AbstractDtoAdapter;
import it.studiofontanelli.omniazero.business.adapter.dto.LkUsersClassAdapter;
import it.studiofontanelli.omniazero.business.adapter.dto.LkUsersStatusAdapter;
import it.studiofontanelli.omniazero.business.adapter.dto.MainUsersAdapter;
import it.studiofontanelli.omniazero.business.exception.ApplicationException;
import it.studiofontanelli.omniazero.business.exception.DtoConversionException;
import it.studiofontanelli.omniazero.dto.MainUsers;
import it.studiofontanelli.omniazero.integration.dto.AbiMainUsers;


@Service
public class MainUsersAdapterImpl extends AbstractDtoAdapter <MainUsers, AbiMainUsers> implements MainUsersAdapter {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private ApplicationContext applicationContext;
	
	@Autowired
	private LkUsersClassAdapter lkUsersClassAdapter;
	
	@Autowired
	private LkUsersStatusAdapter lkUsersStatusAdapter;
	
	

	@Override
	public ApplicationContext getApplicationContext() {
		return applicationContext;
	}
	
	public MainUsersAdapterImpl() throws ApplicationException {
		super();
	}

	@Override
	public AbiMainUsers convertTo(MainUsers t) throws DtoConversionException {
		
		AbiMainUsers v = super.convertTo(t);
		if(v != null){
			v.setAbiLkUsersClass(lkUsersClassAdapter.convertTo(t.getLkUsersClass()));
			v.setAbiLkUsersStatus(lkUsersStatusAdapter.convertTo(t.getLkUsersStatus()));
			
		}
		
		return v;
	}

	@Override
	public MainUsers convertFrom(AbiMainUsers v) throws DtoConversionException {
		MainUsers t = super.convertFrom(v);
		
		if(t != null){
			t.setLkUsersClass(lkUsersClassAdapter.convertFrom(v.getAbiLkUsersClass()));
			t.setLkUsersStatus(lkUsersStatusAdapter.convertFrom(v.getAbiLkUsersStatus()));
			
		}
		return t;
	}

	
}
