package br.com.api.cadastro.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.cadastro.modelo.Aluno;

@RestController
@RequestMapping("/aluno")
public class AlunoController {

		@GetMapping("/listar-todos")
		public Aluno listarAlunos() {
			
			Aluno aluno = new Aluno();
			aluno.setId(1L);
			aluno.setNome("fabio");
			aluno.setSobrenome("Brandão");
					
			
			return aluno;
		}
		
		@GetMapping("/listar")
		public Aluno listarAluno() {
			
			Aluno aluno = new Aluno();
			aluno.setId(1L);
			aluno.setNome("fabio");
			aluno.setSobrenome("Brandão");
					
			
			return aluno;
		}
		
		@DeleteMapping("/deletar-aluno")
		public Aluno deletarAluno() {
			
			Aluno aluno = new Aluno();
			aluno.setId(1L);
			aluno.setNome("fabio");
			aluno.setSobrenome("Brandão");
					
			
			return aluno;
		}
		
		@PostMapping("/cadastrar-alunos")
		public Aluno cadastrarAlunos() {
			
			Aluno aluno = new Aluno();
			aluno.setId(1L);
			aluno.setNome("fabio");
			aluno.setSobrenome("Brandão");
					
			
			return aluno;
		}
	}


