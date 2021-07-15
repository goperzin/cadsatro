package br.com.api.cadastro.controller;

import java.net.URI;
import java.util.Date;
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
import br.com.api.cadastro.enuns.TurmaEnum;
import br.com.api.cadastro.modelo.Aluno;
import br.com.api.cadastro.repository.AlunoRepository;

@RestController
@RequestMapping ("aluno")
public class AlunoController {
	
	@Autowired
	AlunoRepository alunoRepository;
	
	@PostMapping()
	public ResponseEntity<Aluno> cadastrar(@RequestBody AlunoDTO dto, UriComponentsBuilder uriBuilder) {
		Aluno aluno = new Aluno();
		
		aluno.setNome(dto.getNome());
		aluno.setEmail(dto.getEmail());
		aluno.setCelular(dto.getCelular());
		aluno.setTelefoneFixo(dto.getTelefoneFixo());
		aluno.setTurma(TurmaEnum.getByCodigo(dto.getTurma()));
		aluno.setNivel(NivelEnum.getByCodigo(dto.getNivel()));
		aluno.setHorarios(new Date());
		
		Aluno pessoaSalva = alunoRepository.save(aluno);
		
		URI uri = uriBuilder.path("/cadastrar/{idPessoa}").buildAndExpand(aluno.getId()).toUri();
		
		return ResponseEntity.created(uri).body(pessoaSalva);
	}
	
	
	@GetMapping()
	public List<Aluno> listarTodos() {
		return alunoRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public AlunoDTO listarPorId(@PathVariable Long id) {
		Aluno aluno = new Aluno();
		aluno = alunoRepository.findById(id).get();
		
		AlunoDTO alunoDTO = new AlunoDTO();
		
		alunoDTO.setId(aluno.getId());
		alunoDTO.setNome(aluno.getNome());
		alunoDTO.setEmail(aluno.getEmail());
		alunoDTO.setCelular(aluno.getCelular());
		alunoDTO.setTelefoneFixo(aluno.getTelefoneFixo());
		alunoDTO.setTurma(aluno.getTurma().getLabel());
		alunoDTO.setNivel(aluno.getNivel().getLabel());
		alunoDTO.setHorario(new Date());
		
		
		return alunoDTO;
	}	
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<Aluno> alterar(@PathVariable Long id, @RequestBody AlunoDTO dto) {
		Aluno aluno = alunoRepository.findById(id).get();
		aluno.setId(dto.getId());
		aluno.setNome(dto.getNome());
		aluno.setEmail(dto.getEmail());
		aluno.setCelular(dto.getCelular());
		aluno.setTelefoneFixo(dto.getTelefoneFixo());
		aluno.setTurma(TurmaEnum.getByCodigo(dto.getTurma()));
		aluno.setNivel(NivelEnum.getByCodigo(dto.getNivel()));
		aluno.setHorarios(new Date());
		
		return ResponseEntity.ok(aluno);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Aluno> remover(@PathVariable Long id) {
		alunoRepository.deleteById(id);
		return ResponseEntity.ok().build();
	}
}
