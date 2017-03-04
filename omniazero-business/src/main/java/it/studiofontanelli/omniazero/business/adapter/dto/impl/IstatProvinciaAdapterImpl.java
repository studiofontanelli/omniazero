package it.studiofontanelli.omniazero.business.adapter.dto.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import it.studiofontanelli.omniazero.business.adapter.AbstractDtoAdapter;
import it.studiofontanelli.omniazero.business.adapter.dto.IstatProvinciaAdapter;
import it.studiofontanelli.omniazero.business.adapter.dto.IstatRegioneAdapter;
import it.studiofontanelli.omniazero.business.exception.ApplicationException;
import it.studiofontanelli.omniazero.business.exception.DtoConversionException;
import it.studiofontanelli.omniazero.dto.IstatProvincia;
import it.studiofontanelli.omniazero.integration.dto.AbiIstatProvincia;


@Service
public class IstatProvinciaAdapterImpl extends AbstractDtoAdapter <IstatProvincia, AbiIstatProvincia> implements IstatProvinciaAdapter {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private ApplicationContext applicationContext;
	
	@Autowired
	private IstatRegioneAdapter istatRegioneAdapter;
	

	@Override
	public ApplicationContext getApplicationContext() {
		return applicationContext;
	}
	
	public IstatProvinciaAdapterImpl() throws ApplicationException {
		super();
	}

	@Override
	public AbiIstatProvincia convertTo(IstatProvincia t) throws DtoConversionException {
		AbiIstatProvincia v = super.convertTo(t);
		if(v != null){
			v.setAbiIstatRegione(istatRegioneAdapter.convertTo(t.getAbiIstatRegione()));
		}
		return v;
	}

	@Override
	public IstatProvincia convertFrom(AbiIstatProvincia v) throws DtoConversionException {
		IstatProvincia t = super.convertFrom(v);
		if(t != null){
			t.setAbiIstatRegione(istatRegioneAdapter.convertFrom(v.getAbiIstatRegione()));
		}
		return t;
	}

	
}
