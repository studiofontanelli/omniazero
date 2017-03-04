package it.studiofontanelli.omniazero.test;

import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import it.studiofontanelli.omniazero.business.dto.MainContactsSalvataggio;
import it.studiofontanelli.omniazero.business.filter.MainContactsFilter;
import it.studiofontanelli.omniazero.business.service.MainContactsService;
import it.studiofontanelli.omniazero.dto.IstatComune;
import it.studiofontanelli.omniazero.dto.LkContactsStatus;
import it.studiofontanelli.omniazero.dto.LkContactsType;
import it.studiofontanelli.omniazero.dto.MainContacts;
import it.studiofontanelli.omniazero.util.Tracer;
import it.studiofontanelli.omniazero.util.XmlSerializer;




public class MainContactsServiceTest extends CommonServiceTest {
	
	
	
	
	@Autowired
	private MainContactsService mainContactsService;
	
	
	
	@Test
	public final void testFind() {	
		String method = "testFind";
		Tracer.debug(logger, getClass().getSimpleName(), method, "BEGIN");
		try {
			
			MainContactsFilter filter = new MainContactsFilter();
			
			List<MainContacts> result =  mainContactsService.find(filter);
			
			Tracer.debug(logger, getClass().getSimpleName(), method, "result \n" + XmlSerializer.objectToXml(result));
			
			Assert.assertNotNull(result);
			
			
		} catch (Exception e) {
			Tracer.error(logger, getClass().getSimpleName(), method, "Exception " + e);
			Assert.fail(e.getMessage());
		}
		finally{
			Tracer.debug(logger, getClass().getSimpleName(), method, "END");
		}
	}
	
	@Test
	public final void testGet() {	
		String method = "testGet";
		Tracer.debug(logger, getClass().getSimpleName(), method, "BEGIN");
		try {
			
			Integer pk = 100015;
			
			MainContacts result = mainContactsService.get(pk);
			
			
			
			Tracer.debug(logger, getClass().getSimpleName(), method, "result \n" + XmlSerializer.objectToXml(result));
			
			Assert.assertNotNull(result);
			
			
		} catch (Exception e) {
			Tracer.error(logger, getClass().getSimpleName(), method, "Exception " + e);
			Assert.fail(e.getMessage());
		}
		finally{
			Tracer.debug(logger, getClass().getSimpleName(), method, "END");
		}
	}
	
	@Test
	public final void testSave() {	
		String method = "testSave";
		Tracer.debug(logger, getClass().getSimpleName(), method, "BEGIN");
		try {
			
			
			MainContactsSalvataggio save = new MainContactsSalvataggio();
			
			IstatComune istatComune = new IstatComune();
			istatComune.setCodComune("001001");
			
			
			istatComune.setIstatComune("001001");
			
			LkContactsType lkContactsType = new LkContactsType();
			lkContactsType.setId(1);
			
			LkContactsStatus lkContactstatus = new LkContactsStatus();
			lkContactstatus.setId(1);
			
			
			MainContacts mainContacts = new MainContacts();
			
			save.setMainContacts(mainContacts);
			
			
			mainContacts.setCap("10036");
			
			mainContacts.setNome("Andrea");
			mainContacts.setCognome("Fontanelli");
			mainContacts.setIndirizzo("Via Trento");
			mainContacts.setCivico("6");
			mainContacts.setCap("10036");
			mainContacts.setEmail("studiofontanelli@gmail.com");
			
			
			mainContacts.setIstatComune(istatComune);
			
			
			mainContacts.setInsertDate(new Date(System.currentTimeMillis()));
			//mainContacts.setInsertDate(new Date(System.currentTimeMillis()));
			mainContacts.setLkContactsType(lkContactsType);
			mainContacts.setLkContactsStatus(lkContactstatus);
			
			
			
			MainContacts result =  mainContactsService.save(save);
			
			
			Tracer.debug(logger, getClass().getSimpleName(), method, "result \n" + XmlSerializer.objectToXml(result));
			
			Assert.assertNotNull(result);
			
			
		} catch (Exception e) {
			Tracer.error(logger, getClass().getSimpleName(), method, "Exception " + e);
			Assert.fail(e.getMessage());
		}
		finally{
			Tracer.debug(logger, getClass().getSimpleName(), method, "END");
		}
	}
	
	
	@Test
	public final void testUpdate() {	
		String method = "testUpdate";
		Tracer.debug(logger, getClass().getSimpleName(), method, "BEGIN");
		try {
			
			
			Integer pk = 100015;
			
			MainContacts mainContacts = mainContactsService.get(pk);
			
			
			Tracer.debug(logger, getClass().getSimpleName(), method, "mainContacts \n" + XmlSerializer.objectToXml(mainContacts));
			
			
			
			
			
			
			
			MainContactsSalvataggio s = new MainContactsSalvataggio();
			s.setMainContacts(mainContacts);
			
			
			mainContacts = mainContactsService.save(s);
			
			Assert.assertNotNull(mainContacts);
			
			
		} catch (Exception e) {
			Tracer.error(logger, getClass().getSimpleName(), method, "Exception " + e);
			Assert.fail(e.getMessage());
		}
		finally{
			Tracer.debug(logger, getClass().getSimpleName(), method, "END");
		}
	}
	
	
	
	
	
}
