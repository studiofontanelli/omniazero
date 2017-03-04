package it.studiofontanelli.omniazero.business.service;

import java.util.List;

import it.studiofontanelli.omniazero.business.exception.ApplicationException;
import it.studiofontanelli.omniazero.business.exception.SystemException;
import it.studiofontanelli.omniazero.dto.ConfTemplate;
import it.studiofontanelli.omniazero.dto.IstatComune;

import it.studiofontanelli.omniazero.dto.IstatProvincia;

public interface AnagraficaService {

	
	
	public List<IstatComune> findAllIstatComune() throws SystemException, ApplicationException ;
	
	public List<IstatComune> findIstatComuneByDenominazione(String denominazione) throws SystemException, ApplicationException ;
	
	public List<IstatProvincia> findAllIstatProvincia() throws SystemException, ApplicationException ;

	public List<String> findDataCache(String hint) throws SystemException, ApplicationException ;
	
	public ConfTemplate getTemplate(String codice) throws SystemException, ApplicationException ;
	
	
	
	
	
}
