package br.com.api.cadastro.modelo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TipoPessoaFisica implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
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