package it.studiofontanelli.omniazero.integration.dto;
// Generated 30-dic-2016 12.13.14 by Hibernate Tools 4.3.5.Final

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

/**
 * AbiMainUsers generated by hbm2java
 */
@Entity
@Table(name = "_abi_main_users", schema = "public", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class AbiMainUsers implements java.io.Serializable {

	private int id;
	private AbiLkUsersClass abiLkUsersClass;
	private AbiLkUsersStatus abiLkUsersStatus;
	private String email;
	private String pwd;
	private String name;
	private String surname;
	private Date insertDate;
	private Date updateDate;
	private Date lastAccessDate;
	private Set<AbiMainUsersSession> abiMainUsersSessions = new HashSet<AbiMainUsersSession>(0);

	public AbiMainUsers() {
	}

	public AbiMainUsers(int id, AbiLkUsersClass abiLkUsersClass, AbiLkUsersStatus abiLkUsersStatus, String email,
			String pwd, Date insertDate) {
		this.id = id;
		this.abiLkUsersClass = abiLkUsersClass;
		this.abiLkUsersStatus = abiLkUsersStatus;
		this.email = email;
		this.pwd = pwd;
		this.insertDate = insertDate;
	}

	public AbiMainUsers(int id, AbiLkUsersClass abiLkUsersClass, AbiLkUsersStatus abiLkUsersStatus, String email,
			String pwd, String name, String surname, Date insertDate, Date updateDate, Date lastAccessDate,
			Set<AbiMainUsersSession> abiMainUsersSessions) {
		this.id = id;
		this.abiLkUsersClass = abiLkUsersClass;
		this.abiLkUsersStatus = abiLkUsersStatus;
		this.email = email;
		this.pwd = pwd;
		this.name = name;
		this.surname = surname;
		this.insertDate = insertDate;
		this.updateDate = updateDate;
		this.lastAccessDate = lastAccessDate;
		this.abiMainUsersSessions = abiMainUsersSessions;
	}

	@Id

	@Column(name = "id", unique = true, nullable = false)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_abi_lk_users_class", nullable = false)
	public AbiLkUsersClass getAbiLkUsersClass() {
		return this.abiLkUsersClass;
	}

	public void setAbiLkUsersClass(AbiLkUsersClass abiLkUsersClass) {
		this.abiLkUsersClass = abiLkUsersClass;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_abi_lk_users_status", nullable = false)
	public AbiLkUsersStatus getAbiLkUsersStatus() {
		return this.abiLkUsersStatus;
	}

	public void setAbiLkUsersStatus(AbiLkUsersStatus abiLkUsersStatus) {
		this.abiLkUsersStatus = abiLkUsersStatus;
	}

	@Column(name = "email", unique = true, nullable = false, length = 100)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "pwd", nullable = false, length = 32)
	public String getPwd() {
		return this.pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	@Column(name = "name", length = 40)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "surname", length = 40)
	public String getSurname() {
		return this.surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "insert_date", nullable = false, length = 29)
	public Date getInsertDate() {
		return this.insertDate;
	}

	public void setInsertDate(Date insertDate) {
		this.insertDate = insertDate;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "update_date", length = 29)
	public Date getUpdateDate() {
		return this.updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "last_access_date", length = 29)
	public Date getLastAccessDate() {
		return this.lastAccessDate;
	}

	public void setLastAccessDate(Date lastAccessDate) {
		this.lastAccessDate = lastAccessDate;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "abiMainUsers")
	public Set<AbiMainUsersSession> getAbiMainUsersSessions() {
		return this.abiMainUsersSessions;
	}

	public void setAbiMainUsersSessions(Set<AbiMainUsersSession> abiMainUsersSessions) {
		this.abiMainUsersSessions = abiMainUsersSessions;
	}

}