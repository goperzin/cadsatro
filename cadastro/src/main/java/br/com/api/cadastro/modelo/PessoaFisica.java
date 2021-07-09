package br.com.api.cadastro.modelo;

import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

public class PessoaFisica extends Pessoa {

	private static final long serialVersionUID = 1L;

	private String cpf;
	
	private String apelido;

	@OneToOne
    @MapsId
    @JoinColumn
	private Cargo idCargo;
	
	@OneToOne
    @MapsId
    @JoinColumn
	private TipoPessoaFisica idTipoPessoaFisica;

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

	public Cargo getIdCargo() {
		return idCargo;
	}

	public void setIdCargo(Cargo idCargo) {
		this.idCargo = idCargo;
	}

	public TipoPessoaFisica getIdTipoPessoaFisica() {
		return idTipoPessoaFisica;
	}

	public void setIdTipoPessoaFisica(TipoPessoaFisica idTipoPessoaFisica) {
		this.idTipoPessoaFisica = idTipoPessoaFisica;
	}
}