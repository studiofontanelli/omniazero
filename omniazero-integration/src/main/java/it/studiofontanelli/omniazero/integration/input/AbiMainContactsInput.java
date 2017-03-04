package it.studiofontanelli.omniazero.integration.input;

public class AbiMainContactsInput extends InputBean {
	
	private String nome;
	private String cognome;
	private String ragioneSociale;
	
	public AbiMainContactsInput() {
		setTipoOrdinamento(TIPO_ORDINAMENTO_ASC);
		setCampoOrdinamento("ragioneSociale");		
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getRagioneSociale() {
		return ragioneSociale;
	}

	public void setRagioneSociale(String ragioneSociale) {
		this.ragioneSociale = ragioneSociale;
	}

	

}
