package it.studiofontanelli.omniazero.integration.input;

public class InputBean implements Input {
	
	public static final String TIPO_ORDINAMENTO_ASC = "ASC";
	public static final String TIPO_ORDINAMENTO_DESC = "DESC";
	
	private String campoOrdinamento = null;
    private String tipoOrdinamento = null;
    
    
	public String getCampoOrdinamento() {
		return campoOrdinamento;
	}
	public void setCampoOrdinamento(String campoOrdinamento) {
		this.campoOrdinamento = campoOrdinamento;
	}
	public String getTipoOrdinamento() {
		return tipoOrdinamento;
	}
	public void setTipoOrdinamento(String tipoOrdinamento) {
		this.tipoOrdinamento = tipoOrdinamento;
	}
    
    

}
