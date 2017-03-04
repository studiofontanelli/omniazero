package it.studiofontanelli.omniazero.integration.input;

public class AbiConfTemplateInput extends InputBean {
	
	private String codice;
	private String descrizione;
	
	
	public AbiConfTemplateInput() {
		setTipoOrdinamento(TIPO_ORDINAMENTO_ASC);
		setCampoOrdinamento("descrizione");		
	}


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


	
	

	


}
