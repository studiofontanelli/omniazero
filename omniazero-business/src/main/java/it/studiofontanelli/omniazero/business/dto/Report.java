package it.studiofontanelli.omniazero.business.dto;

import java.io.Serializable;

public class Report implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5248716306040984087L;
	private String codice;
	private byte [] file;
	
	
	public String getCodice() {
		return codice;
	}
	public void setCodice(String codice) {
		this.codice = codice;
	}
	
	public byte[] getFile() {
		return file;
	}
	public void setFile(byte[] file) {
		this.file = file;
	}

}
