package br.com.api.cadastro.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.cadastro.modelo.Funcionario;

@RestController
@RequestMapping("/funcionario")
public class FuncionarioController {

	@GetMapping("/listar-funcionarios")
	public Funcionario listarFuncionarios() {
		
		Funcionario jose = new Funcionario();
		jose.setId(1L);
		jose.setNome("jose");
		jose.setSobrenome("Brandão");
		
		return jose;
	}
	
	@GetMapping("/listar-funcionario")
	public Funcionario listarFuncionario() {
		
		Funcionario jose = new Funcionario();
		jose.setId(1L);
		jose.setNome("jose");
		jose.setSobrenome("Brandão");
		
		return jose;
	}
	
	@GetMapping("/cadastrar-funcionario")
	public Funcionario cadastrarFuncionario() {
		
		Funcionario jose = new Funcionario();
		jose.setId(1L);
		jose.setNome("jose");
		jose.setSobrenome("Brandão");
		
		return jose;
	}
	
	@GetMapping("/deletar-funcionario")
	public Funcionario deletarFuncionario() {
		
		Funcionario jose = new Funcionario();
		jose.setId(1L);
		jose.setNome("jose");
		jose.setSobrenome("Brandão");
		
		return jose;
	}
	
}

