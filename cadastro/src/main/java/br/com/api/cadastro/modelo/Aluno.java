package br.com.api.cadastro.modelo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MapKeyTemporal;
import javax.persistence.TemporalType;

import br.com.api.cadastro.enuns.NivelEnum;

@Entity
public class Aluno {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	
	private String email;
	
	private String celular;
	
	private String telefonefixo;
	
	@Enumerated(EnumType.STRING)
	private NivelEnum nivel;
	
	@MapKeyTemporal (TemporalType.TIMESTAMP)
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
	public String getTelefonefixo() {
		return telefonefixo;
	}
	public void setTelefonefixo(String telefonefixo) {
		this.telefonefixo = telefonefixo;
	}
	public NivelEnum getNivel() {
		return nivel;
	}
	public void setNivel(NivelEnum nivel) {
		this.nivel = nivel;
	}
	public void setContato(String contato) {
		// TODO Auto-generated method stub
		
	}
	
	
}
