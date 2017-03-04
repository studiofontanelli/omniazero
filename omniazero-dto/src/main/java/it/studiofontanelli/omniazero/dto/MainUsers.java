package it.studiofontanelli.omniazero.dto;


import java.util.Date;

public class MainUsers implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4174550585343218701L;
	private int id;
	private IstatComune istatComune;
	private String email;
	private String pwd;
	private String name;
	private String surname;
	private Date insertDate;
	private Date updateDate;
	private Date lastAccessDate;
	private LkUsersClass lkUsersClass;
	private LkUsersStatus lkUsersStatus;
	private Date birthdate;
	private String address;
	private String streetNumber;
	private String postcode;
	

	
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public IstatComune getIstatComune() {
		return this.istatComune;
	}

	public void setIstatComune(IstatComune istatComune) {
		this.istatComune = istatComune;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPwd() {
		return this.pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	public String getSurname() {
		return this.surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	
	public Date getInsertDate() {
		return this.insertDate;
	}

	public void setInsertDate(Date insertDate) {
		this.insertDate = insertDate;
	}

	
	public Date getUpdateDate() {
		return this.updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	
	public Date getLastAccessDate() {
		return this.lastAccessDate;
	}

	public void setLastAccessDate(Date lastAccessDate) {
		this.lastAccessDate = lastAccessDate;
	}

	public Date getBirthdate() {
		return this.birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	
	public String getStreetNumber() {
		return this.streetNumber;
	}

	public void setStreetNumber(String streetNumber) {
		this.streetNumber = streetNumber;
	}

	
	public String getPostcode() {
		return this.postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public LkUsersClass getLkUsersClass() {
		return lkUsersClass;
	}

	public void setLkUsersClass(LkUsersClass lkUsersClass) {
		this.lkUsersClass = lkUsersClass;
	}

	public LkUsersStatus getLkUsersStatus() {
		return lkUsersStatus;
	}

	public void setLkUsersStatus(LkUsersStatus lkUsersStatus) {
		this.lkUsersStatus = lkUsersStatus;
	}

	
	
}
