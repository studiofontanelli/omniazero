package it.studiofontanelli.omniazero.business.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import it.studiofontanelli.omniazero.business.adapter.dto.MainContactsAdapter;
import it.studiofontanelli.omniazero.business.adapter.filter.MainContactsFilterAdapter;
import it.studiofontanelli.omniazero.business.dto.MainContactsSalvataggio;
import it.studiofontanelli.omniazero.business.exception.ApplicationException;
import it.studiofontanelli.omniazero.business.exception.SystemException;
import it.studiofontanelli.omniazero.business.filter.MainContactsFilter;
import it.studiofontanelli.omniazero.business.service.MainContactsService;
import it.studiofontanelli.omniazero.dto.MainContacts;
import it.studiofontanelli.omniazero.integration.dao.AbiMainContactsDao;
import it.studiofontanelli.omniazero.integration.dao.exception.DAOException;
import it.studiofontanelli.omniazero.integration.dto.AbiMainContacts;
import it.studiofontanelli.omniazero.integration.input.AbiMainContactsInput;
import it.studiofontanelli.omniazero.util.DateUtil;
import it.studiofontanelli.omniazero.util.Tracer;
import it.studiofontanelli.omniazero.util.XmlSerializer;

@Service
@Scope("singleton")
public class MainContactsServiceImpl extends CommonServiceImpl implements MainContactsService {



	@Autowired
	private MainContactsFilterAdapter mainContactsFilterAdapter;

	@Autowired
	private MainContactsAdapter mainContactsAdapter;

	@Autowired
	private AbiMainContactsDao abiMainContactsDao;

	@Override
	public MainContacts save(MainContactsSalvataggio s) throws ApplicationException, SystemException {

		String method = "save";
		
		MainContacts mainContacts = null;
		
		try {
			
			if(s.getMainContacts() == null)
				throw new ApplicationException("Nessun contatto da salvare");
			
			AbiMainContacts abiMainContacts =  mainContactsAdapter.convertTo(s.getMainContacts());
			if (LOG.isDebugEnabled()) {
				Tracer.debug(LOG, getClass().getSimpleName(), method, "abiMainContacts\n " + XmlSerializer.objectToXml(abiMainContacts));
			}
			if(abiMainContacts.getId() == 0){
				Tracer.debug(LOG, getClass().getSimpleName(), method, "insert....");
				abiMainContacts.setUpdateDate(null);
				
				Integer pk = (Integer) abiMainContactsDao.save(abiMainContacts);
				abiMainContacts.setId(pk);
				
			}
			else{
				Tracer.debug(LOG, getClass().getSimpleName(), method, "merge....");
				abiMainContacts.setUpdateDate(DateUtil.getCurrentDate());
				abiMainContacts = abiMainContactsDao.merge(abiMainContacts);	
			}
			
			mainContacts = mainContactsAdapter.convertFrom(abiMainContacts);
			

		} catch (ApplicationException e) {
			Tracer.error(LOG, getClass().getSimpleName(), method, "Eccezione applicativa " + e);
			throw e;
		} catch (Exception e) {
			Tracer.error(LOG, getClass().getSimpleName(), method, "Exception " + e);
			throw new SystemException(e.getMessage(), e);
		}

		return mainContacts;
	}

	@Override
	public void delete(MainContacts obj) throws ApplicationException, SystemException {
		String method = "delete";
		try {
			abiMainContactsDao.delete(mainContactsAdapter.convertTo(obj));
		} catch (DAOException e) {
			Tracer.error(LOG, getClass().getSimpleName(), method, "DAOException " + e);
			throw new SystemException(e.getMessage(), e);
		}
	}

	@Override
	public List<MainContacts> find(MainContactsFilter filter) throws ApplicationException, SystemException {
		String method = "find";
		List<MainContacts> l = new ArrayList<MainContacts>();
		try {
			AbiMainContactsInput input = mainContactsFilterAdapter.convertTo(filter);
			if (LOG.isDebugEnabled()) {
				Tracer.debug(LOG, getClass().getSimpleName(), method, "input\n " + XmlSerializer.objectToXml(input));
			}
			
			l = mainContactsAdapter.convertFrom(abiMainContactsDao.find(input));

		} catch (ApplicationException e) {
			Tracer.error(LOG, getClass().getSimpleName(), method, "Eccezione applicativa " + e);
			throw e;
		} catch (Exception e) {
			Tracer.error(LOG, getClass().getSimpleName(), method, "Exception " + e);
			throw new SystemException(e.getMessage(), e);
		}

		return l;
	}

	@Override
	public int count(MainContactsFilter filter) throws ApplicationException, SystemException {
		String method = "count";
		List<MainContacts> l = new ArrayList<MainContacts>();
		try {
			AbiMainContactsInput input = mainContactsFilterAdapter.convertTo(filter);
			if (LOG.isDebugEnabled()) {
				Tracer.debug(LOG, getClass().getSimpleName(), method, "input\n " + XmlSerializer.objectToXml(input));
			}
			return abiMainContactsDao.count(input);

		} catch (DAOException e) {
			Tracer.error(LOG, getClass().getSimpleName(), method, "Eccezione applicativa " + e);
			throw new SystemException(e.getMessage(), e);
		} catch (Exception e) {
			Tracer.error(LOG, getClass().getSimpleName(), method, "Exception " + e);
			throw new SystemException(e.getMessage(), e);
		}
	}

	@Override
	public MainContacts get(Integer pk) throws ApplicationException, SystemException {
		String method = "get";
		try {
			
			return mainContactsAdapter.convertFrom(abiMainContactsDao.get(pk));

		} catch (DAOException e) {
			Tracer.error(LOG, getClass().getSimpleName(), method, "DAOException " + e);
			throw new SystemException(e.getMessage(), e);
		} catch (Exception e) {
			Tracer.error(LOG, getClass().getSimpleName(), method, "Exception " + e);
			throw new SystemException(e.getMessage(), e);
		}
	}

	@Override
	public boolean testResource() throws SystemException, ApplicationException {
		return true;
	}

}
