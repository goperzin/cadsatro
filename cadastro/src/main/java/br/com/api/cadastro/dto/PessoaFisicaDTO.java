package br.com.api.cadastro.dto;

public class PessoaFisicaDTO extends PessoaDTO {
	
	private String cpf;
	
	private String apelido;

	private CargoDTO idCargo;
	
	private TipoPessoaFisicaDTO idTipoPessoaFisica;

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getApelido() {
		return apelido;
	}

	public void setApelido(String apelido) {
		this.apelido = apelido;
	}

	public CargoDTO getIdCargo() {
		return idCargo;
	}

	public void setIdCargo(CargoDTO idCargo) {
		this.idCargo = idCargo;
	}

	public TipoPessoaFisicaDTO getIdTipoPessoaFisica() {
		return idTipoPessoaFisica;
	}

	public void setIdTipoPessoaFisica(TipoPessoaFisicaDTO idTipoPessoaFisica) {
		this.idTipoPessoaFisica = idTipoPessoaFisica;
	}
}