package it.studiofontanelli.omniazero.dto;

import java.util.HashSet;
import java.util.Set;

public class IstatRegione implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1352019074208726436L;
	
	private String codRegione;
	private String denominazione;
	private String ripartizioneGeografica;

	public String getCodRegione() {
		return this.codRegione;
	}

	public void setCodRegione(String codRegione) {
		this.codRegione = codRegione;
	}

	

	public String getDenominazione() {
		return this.denominazione;
	}

	public void setDenominazione(String denominazione) {
		this.denominazione = denominazione;
	}

	
	public String getRipartizioneGeografica() {
		return this.ripartizioneGeografica;
	}

	public void setRipartizioneGeografica(String ripartizioneGeografica) {
		this.ripartizioneGeografica = ripartizioneGeografica;
	}

	

}
