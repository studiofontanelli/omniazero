package it.studiofontanelli.omniazero.integration.dto;
// Generated 28-nov-2016 12.05.19 by Hibernate Tools 4.3.5.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * AbiIstatRegione generated by hbm2java
 */
@Entity
@Table(name = "_abi_istat_regione", schema = "public")
public class AbiIstatRegione implements java.io.Serializable {

	private String codRegione;
	private String codNuts2;
	private String denominazione;
	private String ripartizioneGeografica;
	private Set<AbiIstatProvincia> abiIstatProvincias = new HashSet<AbiIstatProvincia>(0);

	public AbiIstatRegione() {
	}

	public AbiIstatRegione(String codRegione) {
		this.codRegione = codRegione;
	}

	public AbiIstatRegione(String codRegione, String codNuts2, String denominazione, String ripartizioneGeografica,
			Set<AbiIstatProvincia> abiIstatProvincias) {
		this.codRegione = codRegione;
		this.codNuts2 = codNuts2;
		this.denominazione = denominazione;
		this.ripartizioneGeografica = ripartizioneGeografica;
		this.abiIstatProvincias = abiIstatProvincias;
	}

	@Id

	@Column(name = "cod_regione", unique = true, nullable = false, length = 3)
	public String getCodRegione() {
		return this.codRegione;
	}

	public void setCodRegione(String codRegione) {
		this.codRegione = codRegione;
	}

	@Column(name = "cod_nuts2", length = 5)
	public String getCodNuts2() {
		return this.codNuts2;
	}

	public void setCodNuts2(String codNuts2) {
		this.codNuts2 = codNuts2;
	}

	@Column(name = "denominazione", length = 50)
	public String getDenominazione() {
		return this.denominazione;
	}

	public void setDenominazione(String denominazione) {
		this.denominazione = denominazione;
	}

	@Column(name = "ripartizione_geografica", length = 50)
	public String getRipartizioneGeografica() {
		return this.ripartizioneGeografica;
	}

	public void setRipartizioneGeografica(String ripartizioneGeografica) {
		this.ripartizioneGeografica = ripartizioneGeografica;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "abiIstatRegione")
	public Set<AbiIstatProvincia> getAbiIstatProvincias() {
		return this.abiIstatProvincias;
	}

	public void setAbiIstatProvincias(Set<AbiIstatProvincia> abiIstatProvincias) {
		this.abiIstatProvincias = abiIstatProvincias;
	}

}