package it.studiofontanelli.omniazero.dto;

import java.io.Serializable;

public class ConfTemplate implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7657767271754866269L;
	
	private String codice;
	private String descrizione;
	private String template;
	
	public String getCodice() {
		return codice;
	}
	public void setCodice(String codice) {
		this.codice = codice;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	public String getTemplate() {
		return template;
	}
	public void setTemplate(String template) {
		this.template = template;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	

	


}
