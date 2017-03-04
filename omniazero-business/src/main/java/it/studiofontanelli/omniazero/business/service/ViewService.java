package it.studiofontanelli.omniazero.business.service;

import java.util.List;

import it.studiofontanelli.omniazero.business.exception.ApplicationException;
import it.studiofontanelli.omniazero.business.exception.SystemException;


public interface ViewService<B, F> extends CommonService {

	
	
	/**
	 * 
	 * @param filter
	 * @return
	 * @throws ApplicationException
	 * @throws SystemException
	 */
	public List<B> find(F filter)  throws ApplicationException, SystemException;
	
	
	
	/**
	 * 
	 * @param filter
	 * @return
	 * @throws ApplicationException
	 * @throws SystemException
	 */
	public int count(F filter)  throws ApplicationException, SystemException;
	
	
	/**
	 * 
	 * @param pk
	 * @return
	 * @throws ApplicationException
	 * @throws SystemException
	 */
	public B get(Integer pk) throws ApplicationException, SystemException;
	
	
	
}
