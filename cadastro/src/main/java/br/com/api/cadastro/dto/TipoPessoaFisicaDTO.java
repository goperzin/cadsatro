package br.com.api.cadastro.dto;

public class TipoPessoaFisicaDTO {

	private Long idTipoPessoaFisica;
	
	private String descricao;

	public Long getIdTipoPessoaFisica() {
		return idTipoPessoaFisica;
	}

	public void setIdTipoPessoaFisica(Long idTipoPessoaFisica) {
		this.idTipoPessoaFisica = idTipoPessoaFisica;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}