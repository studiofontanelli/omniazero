package it.studiofontanelli.omniazero.dto;
// Generated 28-nov-2016 12.06.40 by Hibernate Tools 4.3.5.Final

import java.util.HashSet;
import java.util.Set;


public class LkUsersClass implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6857295982182875024L;
	private int id;
	private String codice;
	private String descrizione;
	

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
	public String getCodice() {
		return this.codice;
	}

	public void setCodice(String codice) {
		this.codice = codice;
	}

	public String getDescrizione() {
		return this.descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	

}
