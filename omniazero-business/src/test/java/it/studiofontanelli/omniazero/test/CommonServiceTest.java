package it.studiofontanelli.omniazero.test;




import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import it.studiofontanelli.omniazero.business.service.CommonService;
import it.studiofontanelli.omniazero.business.util.ApplicationContextManager;
import it.studiofontanelli.omniazero.dto.IstatComune;
import it.studiofontanelli.omniazero.util.Constants;
import it.studiofontanelli.omniazero.util.Tracer;
import it.studiofontanelli.omniazero.util.XmlSerializer;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/spring/spring-main-junit.xml")
public class CommonServiceTest  {
	
	protected final Logger logger = LoggerFactory.getLogger(Constants.LOGGER_PREFIX);
	
	
	
	@Autowired
    private ApplicationContext applicationContext;
	
	private ApplicationContextManager applicationContextManager;
	
	
	@Before
    public void setUp() {
		String method = "setUp";
		Tracer.debug(logger, getClass().getSimpleName(), method, "setting application context");
		
		applicationContextManager = (ApplicationContextManager) applicationContext.getBean("applicationContextManager");
		
		applicationContextManager.setApplicationContext(applicationContext);
		
		if(applicationContext != null){
			Tracer.info(logger, getClass().getSimpleName(), method, "application context loaded correctly!!!!");
		}
		
    }

	public ApplicationContext getApplicationContext() {
		return applicationContext;
	}
	
	
	
	
	
	
}
