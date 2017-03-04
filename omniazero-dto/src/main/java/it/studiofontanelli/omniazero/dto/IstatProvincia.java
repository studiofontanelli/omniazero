package it.studiofontanelli.omniazero.dto;

public class IstatProvincia implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8283718758783240664L;
	private String codProvincia;
	private IstatRegione abiIstatRegione;
	private String denominazione;
	private String sigla;
	

	public String getCodProvincia() {
		return this.codProvincia;
	}

	public void setCodProvincia(String codProvincia) {
		this.codProvincia = codProvincia;
	}

	public IstatRegione getAbiIstatRegione() {
		return this.abiIstatRegione;
	}

	public void setAbiIstatRegione(IstatRegione abiIstatRegione) {
		this.abiIstatRegione = abiIstatRegione;
	}

	
	public String getDenominazione() {
		return this.denominazione;
	}

	public void setDenominazione(String denominazione) {
		this.denominazione = denominazione;
	}

	
	public String getSigla() {
		return this.sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

}
