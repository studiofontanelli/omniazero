package it.studiofontanelli.omniazero.business.service;

import it.studiofontanelli.omniazero.business.dto.MainUsersSalvataggio;
import it.studiofontanelli.omniazero.business.exception.ApplicationException;
import it.studiofontanelli.omniazero.business.exception.SystemException;
import it.studiofontanelli.omniazero.business.filter.MainUsersFilter;
import it.studiofontanelli.omniazero.dto.MainUsers;

public interface MainUsersService extends EntityService<MainUsers, MainUsersFilter, MainUsersSalvataggio> {

	
	
	public boolean testResource() throws SystemException, ApplicationException;
	
	
	
	
}
