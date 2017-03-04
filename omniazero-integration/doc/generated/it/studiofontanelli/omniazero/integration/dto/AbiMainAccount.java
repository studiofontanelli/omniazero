package it.studiofontanelli.omniazero.integration.dto;
// Generated 30-dic-2016 12.13.14 by Hibernate Tools 4.3.5.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * AbiMainAccount generated by hbm2java
 */
@Entity
@Table(name = "_abi_main_account", schema = "public")
public class AbiMainAccount implements java.io.Serializable {

	private int id;
	private String codice;
	private String descrizione;

	public AbiMainAccount() {
	}

	public AbiMainAccount(int id, String codice, String descrizione) {
		this.id = id;
		this.codice = codice;
		this.descrizione = descrizione;
	}

	@Id

	@Column(name = "id", unique = true, nullable = false)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "codice", nullable = false, length = 3)
	public String getCodice() {
		return this.codice;
	}

	public void setCodice(String codice) {
		this.codice = codice;
	}

	@Column(name = "descrizione", nullable = false, length = 20)
	public String getDescrizione() {
		return this.descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

}
