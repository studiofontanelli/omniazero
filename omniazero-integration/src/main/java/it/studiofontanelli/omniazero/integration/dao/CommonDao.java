package it.studiofontanelli.omniazero.integration.dao;


import java.io.Serializable;

import it.studiofontanelli.omniazero.integration.dao.exception.DAOException;


public interface CommonDao<B, I> extends CommonViewDao<B, I> {


	public boolean testResources() throws DAOException;

	public Serializable save(B obj) throws DAOException;
	
	public void delete(B obj) throws DAOException;
	
	public void delete(B obj, boolean doIFlush) throws DAOException;
	
	public B merge(B obj) throws DAOException;
	

}
