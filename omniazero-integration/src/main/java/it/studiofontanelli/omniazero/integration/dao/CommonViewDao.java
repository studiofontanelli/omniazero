package it.studiofontanelli.omniazero.integration.dao;


import java.io.Serializable;
import java.util.List;

import it.studiofontanelli.omniazero.integration.dao.exception.DAOException;


public interface CommonViewDao<B, I> {


	public B get(Serializable pk) throws DAOException;

	public List<B> findAll() throws DAOException;
	
	public List<B> find(I input) throws DAOException;
	
	public int count(I input) throws DAOException;
	
	
	

}
