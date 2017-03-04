package it.studiofontanelli.omniazero.test;


import java.io.FileOutputStream;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import it.studiofontanelli.omniazero.business.dto.Report;
import it.studiofontanelli.omniazero.business.service.ReportService;
import it.studiofontanelli.omniazero.util.Tracer;




public class ReportServiceTest extends CommonServiceTest {
	
	
	@Autowired
	private ReportService reportService;
	
	

	@Test
	public void testBuildReport() {	
		final String method = "testBuildReport";
		Tracer.debug(logger, getClass().getSimpleName(), method, "BEGIN");
		try {
			
			String codTemplate = "DEMO_03";
			
			Report report = reportService.buildReport(codTemplate);
			
			report = reportService.buildReport(codTemplate);
			
			String filePath = "/opt/java/tmp/jasper_report/"+ report.getCodice() + "_"+System.currentTimeMillis() + ".pdf";
			
			Tracer.info(logger, getClass().getSimpleName(), method, "wrinting file " + filePath);
			
			FileOutputStream fos = new FileOutputStream(filePath);
			fos.write(report.getFile());
			fos.close();
			
			Assert.assertTrue(true);
			
			
		} catch (Exception e) {
			Tracer.error(logger, getClass().getSimpleName(), method, "Exception " + e);
			Assert.fail(e.getMessage());
		}
		finally{
			Tracer.debug(logger, getClass().getSimpleName(), method, "END");
		}
	}
	
	
	
	
}
