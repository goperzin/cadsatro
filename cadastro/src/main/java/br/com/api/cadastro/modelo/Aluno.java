package br.com.api.cadastro.modelo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.api.cadastro.enuns.NivelEnum;
import br.com.api.cadastro.enuns.TurmaEnum;
import br.com.api.cadastro.enuns.TurmaEnum;
import br.com.api.cadastro.enuns.TurmaEnum;
import br.com.api.cadastro.enuns.TurmaEnum;

@Entity
public class Aluno {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nome;

	private String email;

	private String celular;

	private String telefoneFixo;
	
	@Enumerated(EnumType.STRING)
	private TurmaEnum turma;

	@Enumerated(EnumType.STRING)
	private NivelEnum nivel;

	@Temporal(TemporalType.TIMESTAMP)
	private Date horarios;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getTelefoneFixo() {
		return telefoneFixo;
	}

	public void setTelefoneFixo(String telefoneFixo) {
		this.telefoneFixo = telefoneFixo;
	}

	public TurmaEnum getTurma() {
		return turma;
	}

	public void setTurma(TurmaEnum turma) {
		this.turma = turma;
	}

	public NivelEnum getNivel() {
		return nivel;
	}

	public void setNivel(NivelEnum nivel) {
		this.nivel = nivel;
	}

	public Date getHorarios() {
		return horarios;
	}

	public void setHorarios(Date horarios) {
		this.horarios = horarios;
	}
}