package it.studiofontanelli.omniazero.integration.input;

public class AbiIstatComuneInput extends InputBean {
	
	private String denominazione;
	private String codProvincia;
	
	
	public AbiIstatComuneInput() {
		setTipoOrdinamento(TIPO_ORDINAMENTO_ASC);
		setCampoOrdinamento("denominazione");		
	}


	public String getDenominazione() {
		return denominazione;
	}


	public void setDenominazione(String denominazione) {
		this.denominazione = denominazione;
	}


	public String getCodProvincia() {
		return codProvincia;
	}


	public void setCodProvincia(String codProvincia) {
		this.codProvincia = codProvincia;
	}

	

	


}
