package it.studiofontanelli.omniazero.business.service;



import it.studiofontanelli.omniazero.business.exception.ApplicationException;
import it.studiofontanelli.omniazero.business.exception.SystemException;

public interface EntityService<B, F, S> extends ViewService<B, F> {

	/**
	 * 
	 * @param obj
	 * @param utente
	 * @return
	 * @throws ApplicationException
	 * @throws SystemException
	 */
	public B save(S s) throws ApplicationException, SystemException;
	
	/**
	 * 
	 * @param obj
	 * @param utente
	 * @throws ApplicationException
	 * @throws SystemException
	 */
	public void delete(B obj)  throws ApplicationException, SystemException;
	
	
	
	
	
	
	
	
}
