
package it.studiofontanelli.omniazero.integration.dao.impl;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;

import it.studiofontanelli.omniazero.integration.dao.AbiConfTemplateDao;
import it.studiofontanelli.omniazero.integration.dto.AbiConfTemplate;
import it.studiofontanelli.omniazero.integration.input.AbiConfTemplateInput;


@Service
public class AbiConfTemplateDaoImpl extends CommonDaoImpl<AbiConfTemplate, AbiConfTemplateInput> implements AbiConfTemplateDao {

	@Override
	protected void createCriteriaByInput(AbiConfTemplateInput input, Criteria criteria) {
		
		if(StringUtils.isNotBlank(input.getCodice())){
			criteria.add(Restrictions.eq("codice", input.getCodice()));
		}
		if(StringUtils.isNotBlank(input.getDescrizione())){
			criteria.add(Restrictions.eq("descrizione", input.getDescrizione()));
		}
		
		
	}

	@Override
	protected void createCriteriaByInput(Criteria criteria) {
		// TODO Auto-generated method stub
		
	}

}
