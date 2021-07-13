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

import br.com.api.cadastro.dto.FuncionarioDTO;
import br.com.api.cadastro.enuns.CargoEnum;
import br.com.api.cadastro.modelo.Funcionario;
import br.com.api.cadastro.repository.FuncionarioRepository;

@RestController
@RequestMapping("funcionario")
public class FuncionarioController {
	
	@Autowired
	FuncionarioRepository pessoaRepository;
	
	@PostMapping()
	public ResponseEntity<Funcionario> cadastrar(@RequestBody FuncionarioDTO dto, UriComponentsBuilder uriBuilder) {
		Funcionario funcionario = new Funcionario();
		
		funcionario.setNome(dto.getNome());
		funcionario.setCelular(dto.getCelular());
		funcionario.setTelefoneFixo(dto.getTelefoneFixo());
		funcionario.setEmail(dto.getEmail());
		funcionario.setCargo(CargoEnum.getByCodigo(dto.getCargo()));
		
		Funcionario pessoaSalva = pessoaRepository.save(funcionario);
		
		URI uri = uriBuilder.path("/cadastrar/{idPessoa}").buildAndExpand(funcionario.getId()).toUri();
		
		return ResponseEntity.created(uri).body(pessoaSalva);
	}
	
	@GetMapping()
	public List<Funcionario> listarTodos() {
		return pessoaRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Funcionario listarPorId(@PathVariable Long id) {
		return pessoaRepository.findById(id).get();
	}
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<Funcionario> alterar(@PathVariable Long id, @RequestBody FuncionarioDTO dto) {
		Funcionario funcionario = pessoaRepository.findById(id).get();
		funcionario.setNome(dto.getNome());
		funcionario.setCelular(dto.getCelular());
		funcionario.setTelefoneFixo(dto.getTelefoneFixo());
		funcionario.setEmail(dto.getEmail());
		funcionario.setCargo(CargoEnum.getByCodigo(dto.getCargo()));
		
		return ResponseEntity.ok(funcionario);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Funcionario> remover(@PathVariable Long id) {
		pessoaRepository.deleteById(id);
		return ResponseEntity.ok().build();
	}
}