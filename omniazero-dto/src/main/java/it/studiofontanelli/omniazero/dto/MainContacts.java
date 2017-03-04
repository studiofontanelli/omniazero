package it.studiofontanelli.omniazero.dto;

import java.util.Date;

public class MainContacts implements java.io.Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6886551775985376023L;
	private int id;
	private IstatComune istatComune;
	private LkContactsStatus lkContactsStatus;
	private LkContactsType lkContactsType;
	private MainContacts mainContactsParent;
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
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public IstatComune getIstatComune() {
		return istatComune;
	}
	public void setIstatComune(IstatComune istatComune) {
		this.istatComune = istatComune;
	}
	public LkContactsStatus getLkContactsStatus() {
		return lkContactsStatus;
	}
	public void setLkContactsStatus(LkContactsStatus lkContactsStatus) {
		this.lkContactsStatus = lkContactsStatus;
	}
	public LkContactsType getLkContactsType() {
		return lkContactsType;
	}
	public void setLkContactsType(LkContactsType lkContactsType) {
		this.lkContactsType = lkContactsType;
	}
	public MainContacts getMainContactsParent() {
		return mainContactsParent;
	}
	public void setMainContactsParent(MainContacts mainContactsParent) {
		this.mainContactsParent = mainContactsParent;
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
	public String getIndirizzo() {
		return indirizzo;
	}
	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}
	public String getCivico() {
		return civico;
	}
	public void setCivico(String civico) {
		this.civico = civico;
	}
	public String getCap() {
		return cap;
	}
	public void setCap(String cap) {
		this.cap = cap;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getCell() {
		return cell;
	}
	public void setCell(String cell) {
		this.cell = cell;
	}
	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}
	public Date getDataNascita() {
		return dataNascita;
	}
	public void setDataNascita(Date dataNascita) {
		this.dataNascita = dataNascita;
	}
	public String getWeb() {
		return web;
	}
	public void setWeb(String web) {
		this.web = web;
	}
	public String getCodiceFiscale() {
		return codiceFiscale;
	}
	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}
	public String getPartitaIva() {
		return partitaIva;
	}
	public void setPartitaIva(String partitaIva) {
		this.partitaIva = partitaIva;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getReferente() {
		return referente;
	}
	public void setReferente(String referente) {
		this.referente = referente;
	}
	public Date getInsertDate() {
		return insertDate;
	}
	public void setInsertDate(Date insertDate) {
		this.insertDate = insertDate;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	
	
	
}
