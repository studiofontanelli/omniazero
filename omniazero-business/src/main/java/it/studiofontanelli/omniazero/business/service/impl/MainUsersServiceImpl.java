package it.studiofontanelli.omniazero.business.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import it.studiofontanelli.omniazero.business.adapter.dto.MainUsersAdapter;
import it.studiofontanelli.omniazero.business.adapter.filter.MainUsersFilterAdapter;
import it.studiofontanelli.omniazero.business.dto.MainUsersSalvataggio;
import it.studiofontanelli.omniazero.business.exception.ApplicationException;
import it.studiofontanelli.omniazero.business.exception.SystemException;
import it.studiofontanelli.omniazero.business.filter.MainUsersFilter;
import it.studiofontanelli.omniazero.business.service.MainUsersService;
import it.studiofontanelli.omniazero.dto.MainUsers;
import it.studiofontanelli.omniazero.integration.dao.AbiMainUsersDao;
import it.studiofontanelli.omniazero.integration.dao.exception.DAOException;
import it.studiofontanelli.omniazero.integration.dto.AbiMainUsers;
import it.studiofontanelli.omniazero.integration.input.AbiMainUsersInput;
import it.studiofontanelli.omniazero.util.DateUtil;
import it.studiofontanelli.omniazero.util.Tracer;
import it.studiofontanelli.omniazero.util.XmlSerializer;

@Service
@Scope("singleton")
public class MainUsersServiceImpl extends CommonServiceImpl implements MainUsersService {



	@Autowired
	private MainUsersFilterAdapter mainUsersFilterAdapter;

	@Autowired
	private MainUsersAdapter mainUsersAdapter;

	@Autowired
	private AbiMainUsersDao abiMainUsersDao;

	@Override
	public MainUsers save(MainUsersSalvataggio s) throws ApplicationException, SystemException {

		String method = "save";
		
		MainUsers mainUsers = null;
		
		try {
			
			if(s.getMainUsers() == null)
				throw new ApplicationException("Nessun utente da salvare");
			
			AbiMainUsers abiMainUsers =  mainUsersAdapter.convertTo(s.getMainUsers());
			if (LOG.isDebugEnabled()) {
				Tracer.debug(LOG, getClass().getSimpleName(), method, "abiMainUsers\n " + XmlSerializer.objectToXml(abiMainUsers));
			}
			if(abiMainUsers.getId() == 0){
				Tracer.debug(LOG, getClass().getSimpleName(), method, "insert....");
				abiMainUsers.setUpdateDate(null);
				
				Integer pk = (Integer) abiMainUsersDao.save(abiMainUsers);
				abiMainUsers.setId(pk);
				
			}
			else{
				Tracer.debug(LOG, getClass().getSimpleName(), method, "merge....");
				abiMainUsers.setUpdateDate(DateUtil.getCurrentDate());
				abiMainUsers = abiMainUsersDao.merge(abiMainUsers);
				
				
			}
			
			
			
			
			mainUsers = mainUsersAdapter.convertFrom(abiMainUsers);
			

		} catch (ApplicationException e) {
			Tracer.error(LOG, getClass().getSimpleName(), method, "Eccezione applicativa " + e);
			throw e;
		} catch (Exception e) {
			Tracer.error(LOG, getClass().getSimpleName(), method, "Exception " + e);
			throw new SystemException(e.getMessage(), e);
		}

		return mainUsers;
	}

	@Override
	public void delete(MainUsers obj) throws ApplicationException, SystemException {
		String method = "delete";
		try {
			abiMainUsersDao.delete(mainUsersAdapter.convertTo(obj));
		} catch (DAOException e) {
			Tracer.error(LOG, getClass().getSimpleName(), method, "DAOException " + e);
			throw new SystemException(e.getMessage(), e);
		}
	}

	@Override
	public List<MainUsers> find(MainUsersFilter filter) throws ApplicationException, SystemException {
		String method = "find";
		List<MainUsers> l = new ArrayList<MainUsers>();
		try {
			AbiMainUsersInput input = mainUsersFilterAdapter.convertTo(filter);
			if (LOG.isDebugEnabled()) {
				Tracer.debug(LOG, getClass().getSimpleName(), method, "input\n " + XmlSerializer.objectToXml(input));
			}
			
			l = mainUsersAdapter.convertFrom(abiMainUsersDao.find(input));

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
	public int count(MainUsersFilter filter) throws ApplicationException, SystemException {
		String method = "count";
		List<MainUsers> l = new ArrayList<MainUsers>();
		try {
			AbiMainUsersInput input = mainUsersFilterAdapter.convertTo(filter);
			if (LOG.isDebugEnabled()) {
				Tracer.debug(LOG, getClass().getSimpleName(), method, "input\n " + XmlSerializer.objectToXml(input));
			}
			return abiMainUsersDao.count(input);

		} catch (DAOException e) {
			Tracer.error(LOG, getClass().getSimpleName(), method, "Eccezione applicativa " + e);
			throw new SystemException(e.getMessage(), e);
		} catch (Exception e) {
			Tracer.error(LOG, getClass().getSimpleName(), method, "Exception " + e);
			throw new SystemException(e.getMessage(), e);
		}
	}

	@Override
	public MainUsers get(Integer pk) throws ApplicationException, SystemException {
		String method = "get";
		try {
			
			return mainUsersAdapter.convertFrom(abiMainUsersDao.get(pk));

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
