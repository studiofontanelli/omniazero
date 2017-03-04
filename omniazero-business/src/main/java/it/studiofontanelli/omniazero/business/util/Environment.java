package it.studiofontanelli.omniazero.business.util;

import java.io.Serializable;

public class Environment implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2213679327579955028L;
	
	
	
	private String urlLogout;
	private String mailFrom;


	public String getUrlLogout() {
		return urlLogout;
	}

	public void setUrlLogout(String urlLogout) {
		this.urlLogout = urlLogout;
	}

	public String getMailFrom() {
		return mailFrom;
	}

	public void setMailFrom(String mailFrom) {
		this.mailFrom = mailFrom;
	}
	
	

}
