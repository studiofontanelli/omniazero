package it.studiofontanelli.omniazero.integration.dto;
// Generated 30-dic-2016 12.13.14 by Hibernate Tools 4.3.5.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * AbiConfParametro generated by hbm2java
 */
@Entity
@Table(name = "_abi_conf_parametro", schema = "public")
public class AbiConfParametro implements java.io.Serializable {

	private String chiave;
	private String valore;
	private String note;
	private Boolean crypt;

	public AbiConfParametro() {
	}

	public AbiConfParametro(String chiave) {
		this.chiave = chiave;
	}

	public AbiConfParametro(String chiave, String valore, String note, Boolean crypt) {
		this.chiave = chiave;
		this.valore = valore;
		this.note = note;
		this.crypt = crypt;
	}

	@Id

	@Column(name = "chiave", unique = true, nullable = false, length = 50)
	public String getChiave() {
		return this.chiave;
	}

	public void setChiave(String chiave) {
		this.chiave = chiave;
	}

	@Column(name = "valore", length = 100)
	public String getValore() {
		return this.valore;
	}

	public void setValore(String valore) {
		this.valore = valore;
	}

	@Column(name = "note", length = 100)
	public String getNote() {
		return this.note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	@Column(name = "crypt")
	public Boolean getCrypt() {
		return this.crypt;
	}

	public void setCrypt(Boolean crypt) {
		this.crypt = crypt;
	}

}
