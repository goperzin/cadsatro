package br.com.api.cadastro.modelo;

public class PessoaJuridica extends Pessoa {
	
	private static final long serialVersionUID = 1L;

	private String cnpj;
	
	private String nomeFantasia;

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

}