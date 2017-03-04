package it.studiofontanelli.omniazero.business.adapter.dto.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import it.studiofontanelli.omniazero.business.adapter.AbstractDtoAdapter;
import it.studiofontanelli.omniazero.business.adapter.dto.IstatComuneAdapter;
import it.studiofontanelli.omniazero.business.adapter.dto.IstatProvinciaAdapter;
import it.studiofontanelli.omniazero.business.exception.ApplicationException;
import it.studiofontanelli.omniazero.business.exception.DtoConversionException;
import it.studiofontanelli.omniazero.dto.IstatComune;
import it.studiofontanelli.omniazero.integration.dto.AbiIstatComune;


@Service
public class IstatComuneAdapterImpl extends AbstractDtoAdapter <IstatComune, AbiIstatComune> implements IstatComuneAdapter {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private ApplicationContext applicationContext;
	
	@Autowired
	private IstatProvinciaAdapter istatProvinciaAdapter;
	

	@Override
	public ApplicationContext getApplicationContext() {
		return applicationContext;
	}
	
	public IstatComuneAdapterImpl() throws ApplicationException {
		super();
	}
	

	@Override
	public AbiIstatComune convertTo(IstatComune t) throws DtoConversionException {
		
		AbiIstatComune v = super.convertTo(t);
		if(v != null){
			v.setAbiIstatProvincia(istatProvinciaAdapter.convertTo(t.getIstatProvincia()));
		}
		return v;
	}

	@Override
	public IstatComune convertFrom(AbiIstatComune v) throws DtoConversionException {
		
		IstatComune t = super.convertFrom(v);
		if(t != null){
			t.setIstatProvincia(istatProvinciaAdapter.convertFrom(v.getAbiIstatProvincia()));
		}
		
		return t;
	}

	

	
}
