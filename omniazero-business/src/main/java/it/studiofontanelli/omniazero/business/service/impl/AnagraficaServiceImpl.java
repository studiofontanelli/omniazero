package it.studiofontanelli.omniazero.business.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringEscapeUtils;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import it.studiofontanelli.omniazero.business.exception.ApplicationException;
import it.studiofontanelli.omniazero.business.exception.SystemException;
import it.studiofontanelli.omniazero.business.helper.DataCacheImpl;
import it.studiofontanelli.omniazero.business.service.AnagraficaService;
import it.studiofontanelli.omniazero.dto.ConfTemplate;
import it.studiofontanelli.omniazero.dto.IstatComune;
import it.studiofontanelli.omniazero.dto.IstatProvincia;
import it.studiofontanelli.omniazero.integration.dao.exception.DAOException;
import it.studiofontanelli.omniazero.integration.dto.AbiConfTemplate;
import it.studiofontanelli.omniazero.integration.input.AbiConfTemplateInput;
import it.studiofontanelli.omniazero.integration.input.AbiIstatComuneInput;
import it.studiofontanelli.omniazero.util.Tracer;
import it.studiofontanelli.omniazero.util.XmlSerializer;


@Service
@Scope("singleton")
public class AnagraficaServiceImpl extends CommonServiceImpl implements AnagraficaService {

	
	@Override
	@Cacheable (value = "cache-anagrafiche" , key="#root.method.name")
	public List<IstatComune> findAllIstatComune() throws SystemException, ApplicationException {
		String method = "findAllIstatComune";
		try{
			return getIstatComuneAdapter().convertFrom(getAbiIstatComuneDao().findAll());
		}
		catch(DAOException e){
			Tracer.error(LOG, getClass().getSimpleName(), method, "DAOException " + e);
			throw new SystemException(e);
		}
		catch(Exception e){
			Tracer.error(LOG, getClass().getSimpleName(), method, "Exception " + e);
			throw new SystemException(e);
		}
	}

	@Override
	public List<IstatProvincia> findAllIstatProvincia() throws SystemException, ApplicationException {
		String method = "findAllIstatProvincia";
		try{
			return getIstatProvinciaAdapter().convertFrom(getAbiIstatProvinciaDao().findAll());

		}
		catch(DAOException e){
			Tracer.error(LOG, getClass().getSimpleName(), method, "DAOException " + e);
			throw new SystemException(e);
		}
		catch(Exception e){
			Tracer.error(LOG, getClass().getSimpleName(), method, "Exception " + e);
			throw new SystemException(e);
		}
	}

	@Override
	public List<IstatComune> findIstatComuneByDenominazione(String denominazione) throws SystemException, ApplicationException {
		String method = "findIstatComuneByDenominazione";
		try{
			AbiIstatComuneInput input = new AbiIstatComuneInput();
			input.setDenominazione(denominazione);
			return getIstatComuneAdapter().convertFrom(getAbiIstatComuneDao().find(input));
		}
		catch(DAOException e){
			Tracer.error(LOG, getClass().getSimpleName(), method, "DAOException " + e);
			throw new SystemException(e);
		}
		catch(Exception e){
			Tracer.error(LOG, getClass().getSimpleName(), method, "Exception " + e);
			throw new SystemException(e);
		}
	}

	@Override
	public List<String> findDataCache(String hint) throws SystemException, ApplicationException {
		
		return DataCacheImpl.getName(hint);
	}

	@Override
	public ConfTemplate getTemplate(String codice) throws SystemException, ApplicationException {
		String method = "getTemplate";
		try{
			Tracer.debug(LOG, getClass().getSimpleName(), method, "codice " + codice);
			AbiConfTemplateInput input = new AbiConfTemplateInput();
			input.setCodice(codice);
			List<AbiConfTemplate> l = getAbiConfTemplateDao().find(input);
			if(LOG.isDebugEnabled()){
				Tracer.error(LOG, getClass().getSimpleName(), method, "AbiConfTemplate\n " + XmlSerializer.objectToXml(l));
			}
			
			List<ConfTemplate> ll = getConfTemplateAdapter().convertFrom(l);
			if(ll != null && ll.size() == 1){
				return ll.get(0);
			}
			else{
				throw new ApplicationException("No data found!");
			}
		}
		catch(DAOException e){
			Tracer.error(LOG, getClass().getSimpleName(), method, "DAOException " + e);
			throw new SystemException(e);
		}
		catch(Exception e){
			Tracer.error(LOG, getClass().getSimpleName(), method, "Exception " + e);
			throw new SystemException(e);
		}
	}
}
