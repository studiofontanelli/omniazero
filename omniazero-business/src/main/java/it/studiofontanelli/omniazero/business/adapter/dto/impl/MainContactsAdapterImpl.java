package it.studiofontanelli.omniazero.business.adapter.dto.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import it.studiofontanelli.omniazero.business.adapter.AbstractDtoAdapter;
import it.studiofontanelli.omniazero.business.adapter.dto.IstatComuneAdapter;
import it.studiofontanelli.omniazero.business.adapter.dto.LkContactsStatusAdapter;
import it.studiofontanelli.omniazero.business.adapter.dto.LkContactsTypeAdapter;
import it.studiofontanelli.omniazero.business.adapter.dto.MainContactsAdapter;
import it.studiofontanelli.omniazero.business.exception.ApplicationException;
import it.studiofontanelli.omniazero.business.exception.DtoConversionException;
import it.studiofontanelli.omniazero.dto.MainContacts;
import it.studiofontanelli.omniazero.integration.dto.AbiMainContacts;


@Service
public class MainContactsAdapterImpl extends AbstractDtoAdapter <MainContacts, AbiMainContacts> implements MainContactsAdapter {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private ApplicationContext applicationContext;
	
	@Autowired
	private LkContactsTypeAdapter lkContactsTypeAdapter;
	
	@Autowired
	private LkContactsStatusAdapter lkContactsStatusAdapter;
	
	@Autowired
	private IstatComuneAdapter istatComuneAdapter;

	@Override
	public ApplicationContext getApplicationContext() {
		return applicationContext;
	}
	
	public MainContactsAdapterImpl() throws ApplicationException {
		super();
	}

	@Override
	public AbiMainContacts convertTo(MainContacts t) throws DtoConversionException {
		
		AbiMainContacts v = super.convertTo(t);
		if(v != null){
			v.setAbiLkContactsType(lkContactsTypeAdapter.convertTo(t.getLkContactsType()));
			v.setAbiLkContactsStatus(lkContactsStatusAdapter.convertTo(t.getLkContactsStatus()));
			v.setAbiIstatComune(istatComuneAdapter.convertTo(t.getIstatComune()));
			v.setAbiMainContacts(convertTo(t.getMainContactsParent()));
		}
		
		return v;
	}

	@Override
	public MainContacts convertFrom(AbiMainContacts v) throws DtoConversionException {
		MainContacts t = super.convertFrom(v);
		if(t != null){
			t.setLkContactsType(lkContactsTypeAdapter.convertFrom(v.getAbiLkContactsType()));
			t.setLkContactsStatus(lkContactsStatusAdapter.convertFrom(v.getAbiLkContactsStatus()));
			t.setIstatComune(istatComuneAdapter.convertFrom(v.getAbiIstatComune()));
			t.setMainContactsParent(convertFrom(v.getAbiMainContacts()));
		}
		return t;
	}

	
}
