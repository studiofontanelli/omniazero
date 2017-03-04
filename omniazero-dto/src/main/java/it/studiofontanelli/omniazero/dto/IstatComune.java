package it.studiofontanelli.omniazero.dto;

public class IstatComune implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3835192657443058352L;
	private String istatComune;
	private IstatProvincia istatProvincia;
	private String codComune;
	private String denominazione;
	private String codCatastale;
	

	public String getIstatComune() {
		return this.istatComune;
	}

	public void setIstatComune(String istatComune) {
		this.istatComune = istatComune;
	}


	public String getCodComune() {
		return this.codComune;
	}

	public void setCodComune(String codComune) {
		this.codComune = codComune;
	}

	
	public String getDenominazione() {
		return this.denominazione;
	}

	public void setDenominazione(String denominazione) {
		this.denominazione = denominazione;
	}

	public String getCodCatastale() {
		return this.codCatastale;
	}

	public void setCodCatastale(String codCatastale) {
		this.codCatastale = codCatastale;
	}

	public IstatProvincia getIstatProvincia() {
		return istatProvincia;
	}

	public void setIstatProvincia(IstatProvincia istatProvincia) {
		this.istatProvincia = istatProvincia;
	}


}
