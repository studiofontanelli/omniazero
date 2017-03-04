package it.studiofontanelli.omniazero.integration.dao.impl;




import java.io.Serializable;

import org.hibernate.Criteria;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import it.studiofontanelli.omniazero.integration.dao.CommonDao;
import it.studiofontanelli.omniazero.integration.dao.exception.DAOException;
import it.studiofontanelli.omniazero.integration.input.InputBean;
import it.studiofontanelli.omniazero.util.Constants;
import it.studiofontanelli.omniazero.util.Tracer;


public abstract class CommonDaoImpl<B, I extends InputBean>  extends CommonViewDaoImpl<B, I> implements CommonDao<B, I> {

	protected final static Logger LOG = LoggerFactory.getLogger(Constants.LOGGER_PREFIX);

	

	@SuppressWarnings("unchecked")
	public CommonDaoImpl() {
		super();
	}

	/*
	 * (non-Javadoc)
	 * @see biz.abi.jabi.bidivet.dao.ICommonDao#testResources()
	 */
	public boolean testResources() throws DAOException {
		String method = "testResources";
		try{
			return true;
		}
		finally{

		}
	}
	

	public Serializable save(B obj) throws DAOException {
		String method = "save";
		try{
			return  getCurrentSession().save(obj);	
		}
		catch(Exception e){
			Tracer.error(LOG, getClass().getSimpleName(), method, "Exception " + e);
			throw new DAOException(e);
		}

	}

	public B get(Serializable id) throws DAOException {
		final String method = "get";
		Tracer.debug(LOG, getClass().getSimpleName(), method, "getting " + id);
		try{
			Criteria criteria = getCurrentSession().createCriteria(getPersistentClass());
			createCriteriaForGet(id, criteria);
			@SuppressWarnings("unchecked")
			B obj = (B) criteria.uniqueResult();
			Tracer.debug(LOG, getClass().getSimpleName(), method, obj +  " loaded!");
			if(obj == null)
				throw new DAOException("Impossibile recuperare l'entità con pk " + id );
			return obj;
		}
		catch(Exception e){
			Tracer.error(LOG, getClass().getSimpleName(), method, "Exception " + e);
			throw new DAOException(e);
		}
	}
	

	@SuppressWarnings("unchecked")
	public B merge(B obj) throws DAOException {
		String method = "merge";
		
		try{
			obj =  (B) getCurrentSession().merge(obj);
			Tracer.debug(LOG, getClass().getSimpleName(), method, obj +  " merged!");
		}
		catch(Exception e){
			Tracer.error(LOG, getClass().getSimpleName(), method, "Exception " + e);
			throw new DAOException(e);
		}
		return obj;
	}

	public void delete(B obj) throws DAOException {
		delete(obj, false);

	}
	
	public void delete(B obj, boolean doIFlush) throws DAOException {
		String method = "delete"; 
		try{
			getCurrentSession().delete(obj);
			if(doIFlush){
				Tracer.debug(LOG, getClass().getSimpleName(), method, "flush hibernate session!!!");
				getCurrentSession().flush();
			}
			Tracer.debug(LOG, getClass().getSimpleName(), method, obj +  " deleted!");
		}
		catch(Exception e){
			Tracer.error(LOG, getClass().getSimpleName(), method, "Exception " + e);
			throw new DAOException(e);
		}

	}

	

}
