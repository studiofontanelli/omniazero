package it.studiofontanelli.omniazero.integration.dao.impl;

import java.io.Serializable;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;

import it.studiofontanelli.omniazero.integration.dao.AbiIstatComuneDao;
import it.studiofontanelli.omniazero.integration.dto.AbiIstatComune;
import it.studiofontanelli.omniazero.integration.input.AbiIstatComuneInput;


@Service
public class AbIstatComuneDaoImpl extends CommonDaoImpl<AbiIstatComune, AbiIstatComuneInput> implements AbiIstatComuneDao {

	@Override
	protected void createCriteriaForGet(Serializable id, Criteria criteria) {
		super.createCriteriaForGet(id, criteria);
	}
	
	@Override
	protected void createCriteriaByInput(AbiIstatComuneInput input, Criteria criteria) {
		
		if(StringUtils.isNotBlank(input.getCodProvincia())){
			criteria.add(Restrictions.eq("abiIstatProvincia.codProvincia", input.getCodProvincia()));
		}
		if(StringUtils.isNotBlank(input.getDenominazione())){
			criteria.add(Restrictions.ilike("denominazione", input.getDenominazione(), MatchMode.ANYWHERE));
		}
		
		criteria.createAlias("abiIstatProvincia", "abiIstatProvincia", Criteria.INNER_JOIN);
		criteria.createAlias("abiIstatProvincia.abiIstatRegione", "abiIstatProvincia.abiIstatRegione", Criteria.INNER_JOIN);
		
	}

	@Override
	protected void createCriteriaByInput(Criteria criteria) {
		// TODO Auto-generated method stub
		criteria.createAlias("abiIstatProvincia", "abiIstatProvincia", Criteria.INNER_JOIN);
		criteria.createAlias("abiIstatProvincia.abiIstatRegione", "abiIstatProvincia.abiIstatRegione", Criteria.INNER_JOIN);
		
	}

	

}
