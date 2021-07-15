package br.com.api.cadastro.controller;

import java.net.URI;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.api.cadastro.dto.AlunoDTO;
import br.com.api.cadastro.enuns.NivelEnum;
import br.com.api.cadastro.modelo.Aluno;
import br.com.api.cadastro.repository.AlunoRepository;

@RestController
@RequestMapping ("Aluno")

public class AlunoController {
	
	@Autowired
	AlunoRepository AlunoRepository;
	
	@PostMapping()
	public ResponseEntity<Aluno> cadastrar(@RequestBody AlunoDTO dto, UriComponentsBuilder uriBuilder) {
		Aluno aluno = new Aluno();
		
		aluno.setNome(dto.getNome());
		aluno.setEmail(dto.getEmail());
		aluno.setContato(dto.getContato());
		aluno.setNivel(NivelEnum.getByCodigo(dto.getNivel()));;		
		
		Aluno pessoaSalva = AlunoRepository.save(aluno);
		
		URI uri = uriBuilder.path("/cadastrar/{idPessoa}").buildAndExpand(aluno.getId()).toUri();
		
		return ResponseEntity.created(uri).body(pessoaSalva);
	}
	
	
	@GetMapping()
	public List<Aluno> listarTodos() {
		return AlunoRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Aluno listarPorId(@PathVariable Long id) {
		return AlunoRepository.findById(id).get();
	}	
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<Aluno> alterar(@PathVariable Long id, @RequestBody AlunoDTO dto) {
		Aluno aluno = AlunoRepository.findById(id).get();
		aluno.setNome(dto.getNome());
		aluno.setEmail(dto.getEmail());
		aluno.setContato(dto.getContato());
		aluno.setNivel(NivelEnum.getByCodigo(dto.getNivel()));;	
		
		return ResponseEntity.ok(aluno);
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Aluno> remover(@PathVariable Long id) {
		AlunoRepository.deleteById(id);
		return ResponseEntity.ok().build();
	}
}
