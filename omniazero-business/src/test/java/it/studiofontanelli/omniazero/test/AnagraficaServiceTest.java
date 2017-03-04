package it.studiofontanelli.omniazero.test;


import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import it.studiofontanelli.omniazero.business.service.AnagraficaService;
import it.studiofontanelli.omniazero.dto.IstatComune;
import it.studiofontanelli.omniazero.util.Tracer;




public class AnagraficaServiceTest extends CommonServiceTest {
	
	@Autowired
	private AnagraficaService anagraficaService;
	
	@Test
	public final void testFindAll() {	
		String method = "testFindAll";
		Tracer.debug(logger, getClass().getSimpleName(), method, "BEGIN");
		try {
			
			
			
			//List<IstatComune> result =  anagraficaService.findAllIstatComune();
			
			
			List<IstatComune> result =  anagraficaService.findIstatComuneByDenominazione("Setti");
			
			//Tracer.debug(logger, getClass().getSimpleName(), method, "result \n" + XmlSerializer.objectToXml(result));

			
			
			Tracer.debug(logger, getClass().getSimpleName(), method, "found " + result.size() + " result(s)");
			
			
			//result =  anagraficaService.findAllIstatComune();
			//Tracer.debug(logger, getClass().getSimpleName(), method, "found " + result.size() + " result(s)");
			
			Assert.assertNotNull(result);
			
			
		} catch (Exception e) {
			Tracer.error(logger, getClass().getSimpleName(), method, "Exception " + e);
			Assert.fail(e.getMessage());
		}
		finally{
			Tracer.debug(logger, getClass().getSimpleName(), method, "END");
		}
	}
	
	
	
	
}
