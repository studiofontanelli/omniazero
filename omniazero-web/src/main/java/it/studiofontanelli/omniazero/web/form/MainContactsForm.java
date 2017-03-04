package it.studiofontanelli.omniazero.web.form;

import java.io.Serializable;

import it.studiofontanelli.omniazero.dto.MainContacts;

public class MainContactsForm  implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4960912890299649536L;
	
	
	private MainContacts mainContacts;

	private String denominazione;

	public MainContacts getMainContacts() {
		return mainContacts;
	}

	public void setMainContacts(MainContacts mainContacts) {
		this.mainContacts = mainContacts;
	}


	public String getDenominazione() {
		return denominazione;
	}


	public void setDenominazione(String denominazione) {
		this.denominazione = denominazione;
	}

}
