package it.studiofontanelli.omniazero.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import it.studiofontanelli.omniazero.business.dto.MainContactsSalvataggio;
import it.studiofontanelli.omniazero.business.exception.ApplicationException;
import it.studiofontanelli.omniazero.business.exception.SystemException;
import it.studiofontanelli.omniazero.business.filter.MainUsersFilter;
import it.studiofontanelli.omniazero.dto.IstatComune;
import it.studiofontanelli.omniazero.dto.LkContactsStatus;
import it.studiofontanelli.omniazero.dto.LkContactsType;
import it.studiofontanelli.omniazero.dto.MainContacts;
import it.studiofontanelli.omniazero.dto.MainUsers;
import it.studiofontanelli.omniazero.util.Constants;
import it.studiofontanelli.omniazero.util.Tracer;
import it.studiofontanelli.omniazero.util.XmlSerializer;
import it.studiofontanelli.omniazero.web.form.MainContactsForm;




@Controller
//@SessionAttributes({ "mainContactsForm" })
public class ClientiController extends CommonController {
	
	
	private final String MODEL_ATT_MAIN_CONTACTS_FORM = "mainContactsForm";
	
	
	private MainContactsForm initMainContactsForm (Model model){
		String method = "initMainContactsForm";
		
		MainContactsForm  form = new MainContactsForm();
		
		return form;
	}
	
	@RequestMapping(value = "/findIstatComuneByDenominazione", method=RequestMethod.GET)
	public @ResponseBody List<IstatComune> findIstatComuneByDenominazione(  @RequestParam(value = "term"/*, required = true*/) String denominazione) throws SystemException, ApplicationException {
		String method = "findIstatComuneByDenominazione";
		Tracer.debug(LOG, getClass().getSimpleName(), method, "denominazione= " + denominazione);
		if(denominazione != null & denominazione.length() >1)
			return getAnagraficaService().findIstatComuneByDenominazione(denominazione);
		else
			return new ArrayList<IstatComune>();
		
	}
	
	
	
	
	
	@ModelAttribute("webFrameworkList")
	public List<String> populateWebFrameworkList() {

		//Data referencing for web framework checkboxes
		List<String> webFrameworkList = new ArrayList<String>();
		webFrameworkList.add("Spring MVC");
		webFrameworkList.add("Struts 1");
		webFrameworkList.add("Struts 2");
		webFrameworkList.add("JSF");
		webFrameworkList.add("Apache Wicket");

		return webFrameworkList;
	}
	
	@InitBinder
	protected void initBinderMainContacts(HttpServletRequest request, ServletRequestDataBinder binder) {
		String method = "initBinderMainContacts";
		
		try {
			
			//if(1==1) throw new Exception("mi sono rotto");
			
		} catch (Exception e) {
	
			Tracer.debug(LOG, getClass().getSimpleName(), method, "Exception: " + e);
		} finally {
			
		}
	}
	
	@RequestMapping(value = { "/nuovoCliente" }, method = RequestMethod.GET)
	public String nuovoCliente(Model model) {
		String method = "nuovoCliente";
		
		String forward = "manageCliente";
		try{
			
			//if(1==1) throw new Exception("rotto tutto!");
			
			
			Tracer.debug(LOG, getClass().getSimpleName(), method, "model\n " + XmlSerializer.objectToXml(model));
			
			
			MainContactsForm form =  initMainContactsForm (model);
			
			
			
			model.addAttribute(MODEL_ATT_MAIN_CONTACTS_FORM, form);
			
		}
		catch(Exception e){
			Tracer.error(LOG, getClass().getSimpleName(), method, "Exception " + e);
			forward = "error";
		}
		finally{
			
		}
		return forward;
	}
	
	
	@RequestMapping(value = { "/saveCliente" }, method = RequestMethod.POST)
	public String saveCliente(@ModelAttribute("mainContactsForm") MainContactsForm form, Model model) {
		String method = "saveCliente";
		
		String forward = "manageCliente";
		forward = "redirect:/loadCliente/";
		try{
			//Tracer.debug(LOG, getClass().getSimpleName(), method, "model\n " + XmlSerializer.objectToXml(model));
			
			Tracer.debug(LOG, getClass().getSimpleName(), method, "form\n " + XmlSerializer.objectToXml(form));
			
			MainContactsSalvataggio save = new MainContactsSalvataggio();
			save.setMainContacts(form.getMainContacts());
			
			form.getMainContacts().setLkContactsType(new LkContactsType());
			form.getMainContacts().getLkContactsType().setId(Constants.ABI_CONTACT_TYPE_CLIENTE);
			
			form.getMainContacts().setLkContactsStatus(new LkContactsStatus());
			form.getMainContacts().getLkContactsStatus().setId(Constants.ABI_CONTACT_STATUS_ATTIVO);
			
			MainContacts saved = getMainContactsService().save(save);
			
			form.setMainContacts(saved);
			
			//model.addAttribute(Constants.KEY_ABI_CONTACT, saved);
			
			forward += saved.getId();
			
			model.addAttribute(MODEL_ATT_MAIN_CONTACTS_FORM, form);
			
		}
		catch(Exception e){
			Tracer.error(LOG, getClass().getSimpleName(), method, "Exception " + e);
			addErrorMessage(model, "Salvataggio non effettuato", forward);
			forward = "error";
		}
		finally{
			Tracer.debug(LOG, getClass().getSimpleName(), method, "froward= " + forward);
		}
		return forward;
	}
	
	
	
	@RequestMapping(value = { "/loadCliente/{id}" })
	public String loadCliente(@PathVariable("id") Integer id, Model model) {
		String method = "loadCliente";
		
		String forward = "manageCliente";
		try{
			
			Tracer.debug(LOG, getClass().getSimpleName(), method, "form from model\n " + XmlSerializer.objectToXml(model.asMap().get(MODEL_ATT_MAIN_CONTACTS_FORM)));
			
			Tracer.debug(LOG, getClass().getSimpleName(), method, "id " + id);
			
			
			MainContacts mainContacts = getMainContactsService().get (id);
			
			
			MainContactsForm form =  initMainContactsForm (model);
			form.setMainContacts(mainContacts);
			
			model.addAttribute(MODEL_ATT_MAIN_CONTACTS_FORM, form);
			
			
			
		}
		catch(Exception e){
			Tracer.error(LOG, getClass().getSimpleName(), method, "Exception " + e);
			addErrorMessage(model, "Salvataggio non effettuato", forward);
			forward = "error";
		}
		finally{
			Tracer.debug(LOG, getClass().getSimpleName(), method, "forward= " + forward);
		}
		return forward;
	}
	
	@RequestMapping(value = { "/elencoClienti" }, method = RequestMethod.GET)
	public String elencoClienti(Model uiModel) {
		String method = "elencoClienti";
		Tracer.debug(LOG, getClass().getSimpleName(), method, "BEGIN");
		String forward = "listCliente";
		try{
			
			MainUsersFilter filter = new MainUsersFilter();
			
			List<MainUsers> result =  getMainUsersService().find(filter);
			
			
			
			Tracer.debug(LOG, getClass().getSimpleName(), method, "# utenti " + result.size());
			
			
			


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
	

}
