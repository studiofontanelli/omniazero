package it.studiofontanelli.omniazero.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import it.studiofontanelli.omniazero.business.exception.ApplicationException;
import it.studiofontanelli.omniazero.business.exception.SystemException;
import it.studiofontanelli.omniazero.business.service.AnagraficaService;
import it.studiofontanelli.omniazero.business.service.TestResourceService;
import it.studiofontanelli.omniazero.dto.IstatComune;
import it.studiofontanelli.omniazero.dto.IstatProvincia;
import it.studiofontanelli.omniazero.util.Constants;
import it.studiofontanelli.omniazero.util.Tracer;



@Controller
@RequestMapping(value = { "/test" })
public class TestResourceController extends CommonController {
	
	
	
	
	@Autowired
	private TestResourceService testResourceService;
	
	@Autowired
	private AnagraficaService anagraficaService;
	
	
	@RequestMapping(value = "/testAutocomplete", method=RequestMethod.GET)
	public @ResponseBody List<String> testAutocomplete( @RequestParam("term") String name ) throws SystemException, ApplicationException {
		return getAnagraficaService().findDataCache(name);
	}
	
	@RequestMapping(value = "/findIstatComuneByDenominazione", method=RequestMethod.GET)
	public @ResponseBody List<IstatComune> findIstatComuneByDenominazione(  @RequestParam(value = "term"/*, required = true*/) String denominazione) throws SystemException, ApplicationException {
	//public @ResponseBody List<IstatComune> findIstatComuneByDenominazione( ) throws SystemException, ApplicationException {
		
		String method = "findIstatComuneByDenominazione";
		
		Tracer.debug(LOG, getClass().getSimpleName(), method, "denominazione= " + denominazione);
		if(denominazione != null & denominazione.length() > 3)
			return getAnagraficaService().findIstatComuneByDenominazione(denominazione);
		else
			return new ArrayList<IstatComune>();
		
	}
	
	@RequestMapping(value = { "/autocomplete" }, method = RequestMethod.GET)
	public String autocomplete(Model uiModel) {
		String method = "autocomplete";
		Tracer.debug(LOG, getClass().getSimpleName(), method, "BEGIN");
		String forward = "testAutocomplete";
		try{
			
			
		}
		catch(Exception e){
			Tracer.error(LOG, getClass().getSimpleName(), method, "Exception " + e);
			forward = "error";
		}
		finally{
			Tracer.debug(LOG, getClass().getSimpleName(), method, "END");
		}
		return forward;
	}
	
	@RequestMapping(value = { "/test" }, method = RequestMethod.GET)
	public String testResource(Model uiModel) {
		String method = "testResource";
		Tracer.debug(LOG, getClass().getSimpleName(), method, "BEGIN");
		String forward = "testResource";
		try{
			
			boolean testResource = testResourceService.testResource();
			
			
			Tracer.debug(LOG, getClass().getSimpleName(), method, "test resource= " + testResource);
			
		}
		catch(Exception e){
			Tracer.error(LOG, getClass().getSimpleName(), method, "Exception " + e);
			forward = "error";
		}
		finally{
			Tracer.debug(LOG, getClass().getSimpleName(), method, "END");
		}
		return forward;
	}
	
	
	@RequestMapping(value = { "/testAnagrafica" }, method = RequestMethod.GET)
	public String testAnagrafica(Model uiModel) {
		String method = "testAnagrafica";
		
		String forward = "testResource";
		try{
			
			List<IstatComune> istatComuneList = anagraficaService.findAllIstatComune();
			
			List<IstatProvincia> istatProvinciaList = anagraficaService.findAllIstatProvincia();
			
			if(istatComuneList != null)
				Tracer.debug(LOG, getClass().getSimpleName(), method, "# comuni= " + istatComuneList.size());
			else
				Tracer.debug(LOG, getClass().getSimpleName(), method, "NO comuni found ");
			
			if(istatProvinciaList != null)
				Tracer.debug(LOG, getClass().getSimpleName(), method, "# province= " + istatProvinciaList.size());
			else
				Tracer.debug(LOG, getClass().getSimpleName(), method, "NO province found ");
			
			

		}
		catch(Exception e){
			Tracer.error(LOG, getClass().getSimpleName(), method, "Exception " + e);
			forward = "error";
		}
		
		return forward;
	}

}
