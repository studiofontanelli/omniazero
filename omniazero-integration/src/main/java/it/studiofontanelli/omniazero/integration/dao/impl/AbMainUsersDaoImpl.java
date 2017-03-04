package it.studiofontanelli.omniazero.integration.dao.impl;

import java.io.Serializable;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;

import it.studiofontanelli.omniazero.integration.dao.AbiMainUsersDao;
import it.studiofontanelli.omniazero.integration.dto.AbiMainUsers;
import it.studiofontanelli.omniazero.integration.input.AbiMainUsersInput;


@Service
public class AbMainUsersDaoImpl extends CommonDaoImpl<AbiMainUsers, AbiMainUsersInput> implements AbiMainUsersDao {

	
	@Override
	protected void createCriteriaForGet(Serializable id, Criteria criteria){
		
		
		super.createCriteriaForGet(id, criteria);
		
		
		
		criteria.createAlias("abiLkUsersClass", "abiLkUsersClass", Criteria.INNER_JOIN);
		criteria.createAlias("abiLkUsersStatus", "abiLkUsersStatus", Criteria.INNER_JOIN);
		criteria.createAlias("abiIstatComune", "abiIstatComune", Criteria.INNER_JOIN);
		criteria.createAlias("abiIstatComune.abiIstatProvincia", "abiIstatComune.abiIstatProvincia", Criteria.INNER_JOIN);
		
		
	}
	
	
	@Override
	protected void createCriteriaByInput(AbiMainUsersInput input, Criteria criteria) {
		
		if(StringUtils.isNotBlank(input.getEmail())){
			criteria.add(Restrictions.eq("email", input.getEmail()));
		}
		if(StringUtils.isNotBlank(input.getPwd())){
			criteria.add(Restrictions.eq("pwd", input.getPwd()));
		}
		if(StringUtils.isNotBlank(input.getName())){
			criteria.add(Restrictions.eq("name", input.getName()));
		}
		if(StringUtils.isNotBlank(input.getSurname())){
			criteria.add(Restrictions.eq("surname", input.getSurname()));
		}
		
	}


	@Override
	protected void createCriteriaByInput(Criteria criteria) {
		// TODO Auto-generated method stub
		
	}

}
