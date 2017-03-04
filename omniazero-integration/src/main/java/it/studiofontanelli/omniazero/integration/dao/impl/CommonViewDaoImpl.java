package it.studiofontanelli.omniazero.integration.dao.impl;


import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.Table;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import it.studiofontanelli.omniazero.integration.dao.CommonViewDao;
import it.studiofontanelli.omniazero.integration.dao.exception.DAOException;
import it.studiofontanelli.omniazero.integration.input.InputBean;
import it.studiofontanelli.omniazero.util.Constants;
import it.studiofontanelli.omniazero.util.Tracer;



public abstract class CommonViewDaoImpl<B, I extends InputBean>  implements CommonViewDao<B, I> {
	
	protected final static Logger LOG = LoggerFactory.getLogger(Constants.LOGGER_PREFIX);

	@Autowired
	@Qualifier("sessionFactory")
	private SessionFactory sessionFactory;

	private Class<B> persistentClass;
	private String tableName; 

	public Class<B> getPersistentClass() {
		return persistentClass;
	}

	public void setPersistentClass(Class<B> persistentClass) {
		this.persistentClass = persistentClass;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Session getCurrentSession(){
		return sessionFactory.getCurrentSession();
	}

	@SuppressWarnings("unchecked")
	public CommonViewDaoImpl() {
		this.persistentClass = (Class<B>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
		Table table = this.persistentClass.getAnnotation(Table.class);
		tableName = table.name();
	}

	
	public B get(Serializable id) throws DAOException {
		String method = "get";
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
	
	private void addOrderByDaInput(I input, Criteria criteria) {

		if (input.getCampoOrdinamento() != null && input.getTipoOrdinamento() != null) {
			if (input.getTipoOrdinamento().equals(I.TIPO_ORDINAMENTO_DESC)) {
				criteria.addOrder(Order.desc(input.getCampoOrdinamento()));
			} else {
				criteria.addOrder(Order.asc(input.getCampoOrdinamento()));
			}
		}
		/*
	        if (input.getCampoOrdinamentoSec() != null && input.getTipoOrdinamentoSec() != null) {
	            if (input.getTipoOrdinamentoSec().equals("DESC")) {
	                criteria.addOrder(Order.desc(input.getCampoOrdinamentoSec()));
	            } else {
	                criteria.addOrder(Order.asc(input.getCampoOrdinamentoSec()));
	            }
	        }

	        if (input.getCampoOrdinamentoTer() != null && input.getTipoOrdinamentoTer() != null) {
	            if (input.getTipoOrdinamentoTer().equals("DESC")) {
	                criteria.addOrder(Order.desc(input.getCampoOrdinamentoTer()));
	            } else {
	                criteria.addOrder(Order.asc(input.getCampoOrdinamentoTer()));
	            }
	        }
		 */

		/*
	        if (input.isPaginazioneReale()) {
	            criteria.setFirstResult(input.getPartenza());
	            criteria.setMaxResults(input.getDurata());
	        }
		 */
	}

	public List<B> find(I input) throws DAOException {
		String method = "find";
		try{
			if(input == null)
				throw new DAOException("Input is null");
			
			Criteria criteria = getCurrentSession().createCriteria(getPersistentClass());
			createCriteriaByInput(input, criteria);
			addOrderByDaInput(input, criteria);
			@SuppressWarnings("unchecked")
			List<B> list = (List<B>) criteria.list();
			if(list != null){
				Tracer.debug(LOG, getClass().getSimpleName(), method, "# " + list.size() + " data found");
			}
			return list;
		}
		catch(Exception e){
			Tracer.error(LOG, getClass().getSimpleName(), method, "Exception " + e);
			throw new DAOException(e);
		}


	}

	/*
	 * (non-Javadoc)
	 * @see it.csi.scade.scadeweb.integration.dao.CommonDao#findAll()
	 */
	public List<B> findAll() throws DAOException{
		String method = "findAll";
		try{
			Criteria criteria = getCurrentSession().createCriteria(getPersistentClass());
			//createCriteriaByInput(criteria);
			@SuppressWarnings("unchecked")
			List<B> list = (List<B>) criteria.list();
			if(list != null){
				Tracer.debug(LOG, getClass().getSimpleName(), method, "# " + list.size() + " data found");
			}
			return list;
		}
		catch(Exception e){
			Tracer.error(LOG, getClass().getSimpleName(), method, "Exception " + e);
			throw new DAOException(e);
		}

	}


	public int count(I input) throws DAOException{
		String method = "count";
		int count = 0;
		try{
			Criteria criteria = getCurrentSession().createCriteria(getPersistentClass());
			criteria.setProjection(Projections.rowCount());
			createCriteriaByInput(input, criteria);
			count =  ((Number) criteria.uniqueResult()).intValue();
			if(LOG.isDebugEnabled()){
				Tracer.debug(LOG, getClass().getSimpleName(), method, "# " + count + " count");
			}
		}
		catch(Exception e){
			Tracer.error(LOG, getClass().getSimpleName(), method, "Exception " + e);
			throw new DAOException(e);
		}
		return count;
	}

	

	protected void createCriteriaForGet(Serializable id, Criteria criteria){
		criteria.add(Restrictions.eq("id", id));
	}

	protected abstract void createCriteriaByInput(I input, Criteria criteria);
	
	protected abstract void createCriteriaByInput(Criteria criteria);


}
