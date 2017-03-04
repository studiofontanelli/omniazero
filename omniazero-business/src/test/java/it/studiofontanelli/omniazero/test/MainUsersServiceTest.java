package it.studiofontanelli.omniazero.test;

import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import it.studiofontanelli.omniazero.business.dto.MainUsersSalvataggio;
import it.studiofontanelli.omniazero.business.filter.MainUsersFilter;
import it.studiofontanelli.omniazero.business.service.MainUsersService;
import it.studiofontanelli.omniazero.dto.IstatComune;
import it.studiofontanelli.omniazero.dto.LkUsersClass;
import it.studiofontanelli.omniazero.dto.LkUsersStatus;
import it.studiofontanelli.omniazero.dto.MainUsers;
import it.studiofontanelli.omniazero.util.Tracer;
import it.studiofontanelli.omniazero.util.XmlSerializer;




public class MainUsersServiceTest extends CommonServiceTest {
	
	
	
	
	@Autowired
	private MainUsersService mainUsersService;
	
	
	
	@Test
	public final void testFind() {	
		String method = "testFind";
		Tracer.debug(logger, getClass().getSimpleName(), method, "BEGIN");
		try {
			
			MainUsersFilter filter = new MainUsersFilter();
			
			List<MainUsers> result =  mainUsersService.find(filter);
			
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
			
			MainUsers result = mainUsersService.get(pk);
			
			
			
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
			
			
			MainUsersSalvataggio save = new MainUsersSalvataggio();
			
			IstatComune istatComune = new IstatComune();
			istatComune.setCodComune("001001");
			
			
			istatComune.setIstatComune("001001");
			
			LkUsersClass lkUserClass = new LkUsersClass();
			lkUserClass.setId(1);
			
			LkUsersStatus lkUserStatus = new LkUsersStatus();
			lkUserStatus.setId(1);
			
			
			MainUsers mainUsers = new MainUsers();
			
			
			save.setMainUsers(mainUsers);
			
			
			mainUsers.setPwd("*****");
			
			mainUsers.setName("Andrea");
			mainUsers.setSurname("Fontanelli");
			mainUsers.setAddress("Via Trento");
			mainUsers.setStreetNumber("6");
			mainUsers.setPostcode("10036");
			mainUsers.setEmail("studiofontanelli@gmail.com");
			
			
			mainUsers.setIstatComune(istatComune);
			
			mainUsers.setBirthdate(new Date(System.currentTimeMillis()));
			mainUsers.setInsertDate(new Date(System.currentTimeMillis()));
			//mainUsers.setInsertDate(new Date(System.currentTimeMillis()));
			mainUsers.setLkUsersClass(lkUserClass);
			mainUsers.setLkUsersStatus(lkUserStatus);
			
			
			
			MainUsers result =  mainUsersService.save(save);
			
			
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
			
			MainUsers mainUsers = mainUsersService.get(pk);
			
			
			Tracer.debug(logger, getClass().getSimpleName(), method, "mainUsers \n" + XmlSerializer.objectToXml(mainUsers));
			
			
			
			
			mainUsers.setPwd("ninnolo");
			
			
			MainUsersSalvataggio s = new MainUsersSalvataggio();
			s.setMainUsers(mainUsers);
			
			
			mainUsers = mainUsersService.save(s);
			
			Assert.assertNotNull(mainUsers);
			
			
		} catch (Exception e) {
			Tracer.error(logger, getClass().getSimpleName(), method, "Exception " + e);
			Assert.fail(e.getMessage());
		}
		finally{
			Tracer.debug(logger, getClass().getSimpleName(), method, "END");
		}
	}
	
	
	
	
	
}
