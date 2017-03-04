package it.studiofontanelli.omniazero.integration.interceptor;

import java.io.Serializable;
import java.util.Iterator;

import org.hibernate.CallbackException;
import org.hibernate.EmptyInterceptor;
import org.hibernate.EntityMode;
import org.hibernate.Transaction;
import org.hibernate.type.Type;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import it.studiofontanelli.omniazero.util.Constants;
import it.studiofontanelli.omniazero.util.Tracer;

public class HibernateInterceptor extends EmptyInterceptor {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3071923179502935900L;
	
	protected final static Logger LOG = LoggerFactory.getLogger(Constants.LOGGER_PREFIX+".interceptor");


	@Override
	public void onDelete(Object entity, Serializable id, Object[] state, String[] propertyNames, Type[] types) {
		final String method = "onDelete";
		Tracer.debug(LOG, getClass().getSimpleName(), method, "calling....");
		super.onDelete(entity, id, state, propertyNames, types);
	}

	@Override
	public boolean onFlushDirty(Object entity, Serializable id, Object[] currentState, Object[] previousState,
			String[] propertyNames, Type[] types) {
		final String method = "onFlushDirty";
		Tracer.debug(LOG, getClass().getSimpleName(), method, "calling....");
		return super.onFlushDirty(entity, id, currentState, previousState, propertyNames, types);
	}

	@Override
	public boolean onLoad(Object entity, Serializable id, Object[] state, String[] propertyNames, Type[] types) {
		final String method = "onLoad";
		Tracer.debug(LOG, getClass().getSimpleName(), method, "calling....");
		return super.onLoad(entity, id, state, propertyNames, types);
	}

	@Override
	public boolean onSave(Object entity, Serializable id, Object[] state, String[] propertyNames, Type[] types) {
		final String method = "onSave";
		Tracer.debug(LOG, getClass().getSimpleName(), method, "calling....");
		return super.onSave(entity, id, state, propertyNames, types);
	}

	@Override
	public void postFlush(Iterator entities) {
		final String method = "postFlush";
		Tracer.debug(LOG, getClass().getSimpleName(), method, "calling....");
		super.postFlush(entities);
	}

	@Override
	public void preFlush(Iterator entities) {
		final String method = "preFlush";
		Tracer.debug(LOG, getClass().getSimpleName(), method, "calling....");
		super.preFlush(entities);
	}

	@Override
	public Boolean isTransient(Object entity) {
		// TODO Auto-generated method stub
		return super.isTransient(entity);
	}

	@Override
	public Object instantiate(String entityName, EntityMode entityMode, Serializable id) {
		final String method = "onDelete";
		Tracer.debug(LOG, getClass().getSimpleName(), method, "calling....");
		return super.instantiate(entityName, entityMode, id);
	}

	@Override
	public int[] findDirty(Object entity, Serializable id, Object[] currentState, Object[] previousState,
			String[] propertyNames, Type[] types) {
		final String method = "onDelete";
		Tracer.debug(LOG, getClass().getSimpleName(), method, "calling....");
		return super.findDirty(entity, id, currentState, previousState, propertyNames, types);
	}

	@Override
	public String getEntityName(Object object) {
		final String method = "getEntityName";
		Tracer.debug(LOG, getClass().getSimpleName(), method, "calling....");
		return super.getEntityName(object);
	}

	@Override
	public Object getEntity(String entityName, Serializable id) {
		final String method = "getEntity";
		Tracer.debug(LOG, getClass().getSimpleName(), method, "calling....");
		return super.getEntity(entityName, id);
	}

	@Override
	public void afterTransactionBegin(Transaction tx) {
		final String method = "afterTransactionBegin";
		Tracer.debug(LOG, getClass().getSimpleName(), method, "calling....");
		super.afterTransactionBegin(tx);
	}

	@Override
	public void afterTransactionCompletion(Transaction tx) {
		final String method = "afterTransactionCompletion";
		Tracer.debug(LOG, getClass().getSimpleName(), method, "calling....");
		super.afterTransactionCompletion(tx);
	}

	@Override
	public void beforeTransactionCompletion(Transaction tx) {
		final String method = "beforeTransactionCompletion";
		Tracer.debug(LOG, getClass().getSimpleName(), method, "calling....");
		super.beforeTransactionCompletion(tx);
	}

	@Override
	public String onPrepareStatement(String sql) {
		final String method = "onPrepareStatement";
		Tracer.debug(LOG, getClass().getSimpleName(), method, "calling....");
		return super.onPrepareStatement(sql);
	}

	@Override
	public void onCollectionRemove(Object collection, Serializable key) throws CallbackException {
		final String method = "onCollectionRemove";
		Tracer.debug(LOG, getClass().getSimpleName(), method, "calling....");
		super.onCollectionRemove(collection, key);
	}

	@Override
	public void onCollectionRecreate(Object collection, Serializable key) throws CallbackException {
		final String method = "onCollectionRecreate";
		Tracer.debug(LOG, getClass().getSimpleName(), method, "calling....");
		super.onCollectionRecreate(collection, key);
	}

	@Override
	public void onCollectionUpdate(Object collection, Serializable key) throws CallbackException {
		final String method = "onCollectionUpdate";
		Tracer.debug(LOG, getClass().getSimpleName(), method, "calling....");
		super.onCollectionUpdate(collection, key);
	}

	@Override
	public int hashCode() {
		final String method = "hashCode";
		Tracer.debug(LOG, getClass().getSimpleName(), method, "calling....");
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		final String method = "equals";
		Tracer.debug(LOG, getClass().getSimpleName(), method, "calling....");
		return super.equals(obj);
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		final String method = "clone";
		Tracer.debug(LOG, getClass().getSimpleName(), method, "calling....");
		return super.clone();
	}

	@Override
	public String toString() {
		final String method = "toString";
		Tracer.debug(LOG, getClass().getSimpleName(), method, "calling....");
		return super.toString();
	}

	@Override
	protected void finalize() throws Throwable {
		final String method = "finalize";
		Tracer.debug(LOG, getClass().getSimpleName(), method, "calling....");
		super.finalize();
	}

}
