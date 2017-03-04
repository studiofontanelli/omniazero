package it.studiofontanelli.omniazero.integration.dto;
// Generated 30-dic-2016 12.13.14 by Hibernate Tools 4.3.5.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * AbiIstatComune generated by hbm2java
 */
@Entity
@Table(name = "_abi_istat_comune", schema = "public")
public class AbiIstatComune implements java.io.Serializable {

	private String istatComune;
	private AbiIstatProvincia abiIstatProvincia;
	private String codComune;
	private String denominazione;
	private String codCatastale;

	public AbiIstatComune() {
	}

	public AbiIstatComune(String istatComune) {
		this.istatComune = istatComune;
	}

	public AbiIstatComune(String istatComune, AbiIstatProvincia abiIstatProvincia, String codComune,
			String denominazione, String codCatastale) {
		this.istatComune = istatComune;
		this.abiIstatProvincia = abiIstatProvincia;
		this.codComune = codComune;
		this.denominazione = denominazione;
		this.codCatastale = codCatastale;
	}

	@Id

	@Column(name = "istat_comune", unique = true, nullable = false, length = 10)
	public String getIstatComune() {
		return this.istatComune;
	}

	public void setIstatComune(String istatComune) {
		this.istatComune = istatComune;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cod_provincia")
	public AbiIstatProvincia getAbiIstatProvincia() {
		return this.abiIstatProvincia;
	}

	public void setAbiIstatProvincia(AbiIstatProvincia abiIstatProvincia) {
		this.abiIstatProvincia = abiIstatProvincia;
	}

	@Column(name = "cod_comune", length = 10)
	public String getCodComune() {
		return this.codComune;
	}

	public void setCodComune(String codComune) {
		this.codComune = codComune;
	}

	@Column(name = "denominazione", length = 100)
	public String getDenominazione() {
		return this.denominazione;
	}

	public void setDenominazione(String denominazione) {
		this.denominazione = denominazione;
	}

	@Column(name = "cod_catastale", length = 10)
	public String getCodCatastale() {
		return this.codCatastale;
	}

	public void setCodCatastale(String codCatastale) {
		this.codCatastale = codCatastale;
	}

}
