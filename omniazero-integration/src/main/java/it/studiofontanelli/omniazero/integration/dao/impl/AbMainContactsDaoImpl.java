package it.studiofontanelli.omniazero.integration.dao.impl;

import java.io.Serializable;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;

import it.studiofontanelli.omniazero.integration.dao.AbiMainContactsDao;
import it.studiofontanelli.omniazero.integration.dto.AbiMainContacts;
import it.studiofontanelli.omniazero.integration.input.AbiMainContactsInput;


@Service
public class AbMainContactsDaoImpl extends CommonDaoImpl<AbiMainContacts, AbiMainContactsInput> implements AbiMainContactsDao {

	
	@Override
	protected void createCriteriaForGet(Serializable id, Criteria criteria){
		
		
		super.createCriteriaForGet(id, criteria);
		
		
		/*
		criteria.createAlias("abiLkContactsClass", "abiLkContactsClass", Criteria.INNER_JOIN);
		criteria.createAlias("abiLkContactsStatus", "abiLkContactsStatus", Criteria.INNER_JOIN);
		criteria.createAlias("abiIstatComune", "abiIstatComune", Criteria.INNER_JOIN);
		criteria.createAlias("abiIstatComune.abiIstatProvincia", "abiIstatComune.abiIstatProvincia", Criteria.INNER_JOIN);
		*/
		
	}
	
	
	@Override
	protected void createCriteriaByInput(AbiMainContactsInput input, Criteria criteria) {
		
		if(StringUtils.isNotBlank(input.getNome())){
			criteria.add(Restrictions.eq("nome", input.getNome()));
		}
		if(StringUtils.isNotBlank(input.getCognome())){
			criteria.add(Restrictions.eq("cognome", input.getCognome()));
		}
		if(StringUtils.isNotBlank(input.getRagioneSociale())){
			criteria.add(Restrictions.eq("ragioneSociale", input.getRagioneSociale()));
		}
		
		
	}


	@Override
	protected void createCriteriaByInput(Criteria criteria) {
		// TODO Auto-generated method stub
		
	}

}
