package it.studiofontanelli.omniazero.dto;


public class LkUsersStatus implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4081632419706036667L;
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
