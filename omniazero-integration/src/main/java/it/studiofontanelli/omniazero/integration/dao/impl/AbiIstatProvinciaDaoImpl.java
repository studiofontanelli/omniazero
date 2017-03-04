package it.studiofontanelli.omniazero.integration.dao.impl;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;

import it.studiofontanelli.omniazero.integration.dao.AbiIstatProvinciaDao;
import it.studiofontanelli.omniazero.integration.dto.AbiIstatProvincia;
import it.studiofontanelli.omniazero.integration.input.DecodificaInput;


@Service
public class AbiIstatProvinciaDaoImpl extends CommonDaoImpl<AbiIstatProvincia, DecodificaInput> implements AbiIstatProvinciaDao {

	@Override
	protected void createCriteriaByInput(DecodificaInput input, Criteria criteria) {
		
		if(StringUtils.isNotBlank(input.getCodice())){
			criteria.add(Restrictions.eq("codProvincia", input.getCodice()));
		}
		
		
	}

	@Override
	protected void createCriteriaByInput(Criteria criteria) {
		// TODO Auto-generated method stub
		
	}

}
