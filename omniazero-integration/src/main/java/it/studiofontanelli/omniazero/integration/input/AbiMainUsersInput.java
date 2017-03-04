package it.studiofontanelli.omniazero.integration.input;

public class AbiMainUsersInput extends InputBean {
	
	private String email;
	private String pwd;
	private String name;
	private String surname;
	
	public AbiMainUsersInput() {
		setTipoOrdinamento(TIPO_ORDINAMENTO_ASC);
		setCampoOrdinamento("surname");		
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}


	


}
