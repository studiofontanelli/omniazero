package it.studiofontanelli.omniazero.integration.dto;
// Generated 5-dic-2016 11.24.36 by Hibernate Tools 4.3.5.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * AbiLkContactsType generated by hbm2java
 */
@Entity
@Table(name = "_abi_lk_contacts_type", schema = "public")
public class AbiLkContactsType implements java.io.Serializable {

	private int id;
	private String codice;
	private String descrizione;
	private Set<AbiMainContacts> abiMainContactses = new HashSet<AbiMainContacts>(0);

	public AbiLkContactsType() {
	}

	public AbiLkContactsType(int id, String codice, String descrizione) {
		this.id = id;
		this.codice = codice;
		this.descrizione = descrizione;
	}

	public AbiLkContactsType(int id, String codice, String descrizione, Set<AbiMainContacts> abiMainContactses) {
		this.id = id;
		this.codice = codice;
		this.descrizione = descrizione;
		this.abiMainContactses = abiMainContactses;
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

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "abiLkContactsType")
	public Set<AbiMainContacts> getAbiMainContactses() {
		return this.abiMainContactses;
	}

	public void setAbiMainContactses(Set<AbiMainContacts> abiMainContactses) {
		this.abiMainContactses = abiMainContactses;
	}

}