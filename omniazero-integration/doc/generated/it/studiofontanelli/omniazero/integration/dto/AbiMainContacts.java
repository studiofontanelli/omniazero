package it.studiofontanelli.omniazero.integration.dto;
// Generated 5-dic-2016 11.24.36 by Hibernate Tools 4.3.5.Final


import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * AbiMainContacts generated by hbm2java
 */
@Entity
@Table(name="_abi_main_contacts"
,schema="public"
		)
public class AbiMainContacts  implements java.io.Serializable {


	private int id;
	private AbiIstatComune abiIstatComune;
	private AbiLkContactsStatus abiLkContactsStatus;
	private AbiLkContactsType abiLkContactsType;
	private AbiMainContacts abiMainContacts;
	private String nome;
	private String cognome;
	private String ragioneSociale;
	private String indirizzo;
	private String civico;
	private String cap;
	private String telefono;
	private String cell;
	private String fax;
	private Date dataNascita;
	private String web;
	private String codiceFiscale;
	private String partitaIva;
	private String email;
	private String referente;
	private Date insertDate;
	private Date updateDate;
	private String note;
	private Set<AbiMainContacts> abiMainContactses = new HashSet<AbiMainContacts>(0);

	public AbiMainContacts() {
	}


	public AbiMainContacts(int id, AbiIstatComune abiIstatComune, AbiLkContactsStatus abiLkContactsStatus, AbiLkContactsType abiLkContactsType) {
		this.id = id;
		this.abiIstatComune = abiIstatComune;
		this.abiLkContactsStatus = abiLkContactsStatus;
		this.abiLkContactsType = abiLkContactsType;
	}
	public AbiMainContacts(int id, AbiIstatComune abiIstatComune, AbiLkContactsStatus abiLkContactsStatus, AbiLkContactsType abiLkContactsType, AbiMainContacts abiMainContacts, String nome, String cognome, String ragioneSociale, String indirizzo, String civico, String cap, String telefono, String cell, String fax, Date dataNascita, String web, String codiceFiscale, String partitaIva, String email, String referente, Date insertDate, Date updateDate, String note, Set<AbiMainContacts> abiMainContactses) {
		this.id = id;
		this.abiIstatComune = abiIstatComune;
		this.abiLkContactsStatus = abiLkContactsStatus;
		this.abiLkContactsType = abiLkContactsType;
		this.abiMainContacts = abiMainContacts;
		this.nome = nome;
		this.cognome = cognome;
		this.ragioneSociale = ragioneSociale;
		this.indirizzo = indirizzo;
		this.civico = civico;
		this.cap = cap;
		this.telefono = telefono;
		this.cell = cell;
		this.fax = fax;
		this.dataNascita = dataNascita;
		this.web = web;
		this.codiceFiscale = codiceFiscale;
		this.partitaIva = partitaIva;
		this.email = email;
		this.referente = referente;
		this.insertDate = insertDate;
		this.updateDate = updateDate;
		this.note = note;
		this.abiMainContactses = abiMainContactses;
	}

	@Id 
	@Column(name="id", unique=true, nullable=false)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "AbiMainContactsSeq")
	@SequenceGenerator(name = "AbiMainContactsSeq", sequenceName = "_abi_main_contacts_id_seq", allocationSize = 1)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_abi_istat_comune", nullable=false)
	public AbiIstatComune getAbiIstatComune() {
		return this.abiIstatComune;
	}

	public void setAbiIstatComune(AbiIstatComune abiIstatComune) {
		this.abiIstatComune = abiIstatComune;
	}

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_abi_lk_contacts_status", nullable=false)
	public AbiLkContactsStatus getAbiLkContactsStatus() {
		return this.abiLkContactsStatus;
	}

	public void setAbiLkContactsStatus(AbiLkContactsStatus abiLkContactsStatus) {
		this.abiLkContactsStatus = abiLkContactsStatus;
	}

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_abi_lk_contacts_type", nullable=false)
	public AbiLkContactsType getAbiLkContactsType() {
		return this.abiLkContactsType;
	}

	public void setAbiLkContactsType(AbiLkContactsType abiLkContactsType) {
		this.abiLkContactsType = abiLkContactsType;
	}

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_parent")
	public AbiMainContacts getAbiMainContacts() {
		return this.abiMainContacts;
	}

	public void setAbiMainContacts(AbiMainContacts abiMainContacts) {
		this.abiMainContacts = abiMainContacts;
	}


	@Column(name="nome", length=100)
	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}


	@Column(name="cognome", length=100)
	public String getCognome() {
		return this.cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}


	@Column(name="ragione_sociale", length=100)
	public String getRagioneSociale() {
		return this.ragioneSociale;
	}

	public void setRagioneSociale(String ragioneSociale) {
		this.ragioneSociale = ragioneSociale;
	}


	@Column(name="indirizzo", length=100)
	public String getIndirizzo() {
		return this.indirizzo;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}


	@Column(name="civico", length=10)
	public String getCivico() {
		return this.civico;
	}

	public void setCivico(String civico) {
		this.civico = civico;
	}


	@Column(name="cap", length=5)
	public String getCap() {
		return this.cap;
	}

	public void setCap(String cap) {
		this.cap = cap;
	}


	@Column(name="telefono", length=50)
	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}


	@Column(name="cell", length=50)
	public String getCell() {
		return this.cell;
	}

	public void setCell(String cell) {
		this.cell = cell;
	}


	@Column(name="fax", length=50)
	public String getFax() {
		return this.fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	@Temporal(TemporalType.DATE)
	@Column(name="data_nascita", length=13)
	public Date getDataNascita() {
		return this.dataNascita;
	}

	public void setDataNascita(Date dataNascita) {
		this.dataNascita = dataNascita;
	}


	@Column(name="web", length=100)
	public String getWeb() {
		return this.web;
	}

	public void setWeb(String web) {
		this.web = web;
	}


	@Column(name="codice_fiscale", length=50)
	public String getCodiceFiscale() {
		return this.codiceFiscale;
	}

	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}


	@Column(name="partita_iva", length=50)
	public String getPartitaIva() {
		return this.partitaIva;
	}

	public void setPartitaIva(String partitaIva) {
		this.partitaIva = partitaIva;
	}


	@Column(name="email", length=50)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	@Column(name="referente", length=100)
	public String getReferente() {
		return this.referente;
	}

	public void setReferente(String referente) {
		this.referente = referente;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="insert_date", length=29)
	public Date getInsertDate() {
		return this.insertDate;
	}

	public void setInsertDate(Date insertDate) {
		this.insertDate = insertDate;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="update_date", length=29)
	public Date getUpdateDate() {
		return this.updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}


	@Column(name="note", length=200)
	public String getNote() {
		return this.note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	@OneToMany(fetch=FetchType.LAZY, mappedBy="abiMainContacts")
	public Set<AbiMainContacts> getAbiMainContactses() {
		return this.abiMainContactses;
	}

	public void setAbiMainContactses(Set<AbiMainContacts> abiMainContactses) {
		this.abiMainContactses = abiMainContactses;
	}




}


