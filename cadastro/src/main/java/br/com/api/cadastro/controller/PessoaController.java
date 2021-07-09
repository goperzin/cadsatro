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

import br.com.api.cadastro.dto.PessoaDTO;
import br.com.api.cadastro.modelo.Pessoa;
import br.com.api.cadastro.repository.PessoaRepository;

@RestController
@RequestMapping("pessoa")
public class PessoaController {
	
	@Autowired
	PessoaRepository pessoaRepository;
	
	@PostMapping()
	public ResponseEntity<Pessoa> cadastrar(@RequestBody PessoaDTO pessoaDto, UriComponentsBuilder uriBuilder) {
		Pessoa pessoa = new Pessoa();
		
		pessoa.setNome(pessoaDto.getNome());
		pessoa.setCelular(pessoaDto.getCelular());
		pessoa.setTelefone(pessoaDto.getTelefone());
		pessoa.setEmail(pessoaDto.getEmail());
		
		Pessoa pessoaSalva = pessoaRepository.save(pessoa);
		
		URI uri = uriBuilder.path("/cadastrar/{idPessoa}").buildAndExpand(pessoa.getIdPessoa()).toUri();
		
		return ResponseEntity.created(uri).body(pessoaSalva);
	}
	
	@GetMapping()
	public List<Pessoa> listarTodos() {
		return pessoaRepository.findAll();
	}
	
	@GetMapping("/{idPessoa}")
	public Pessoa listarPorId(@PathVariable Long idPessoa) {
		return pessoaRepository.getById(idPessoa);
	}
	
	@PutMapping("/{idPessoa}")
	@Transactional
	public ResponseEntity<Pessoa> alterar(@PathVariable Long idPessoa, @RequestBody PessoaDTO pessoaDto) {
		Pessoa pessoa = pessoaRepository.getById(idPessoa);
		
		pessoa.setNome(pessoaDto.getNome());
		pessoa.setCelular(pessoaDto.getCelular());
		pessoa.setTelefone(pessoaDto.getTelefone());
		pessoa.setEmail(pessoaDto.getEmail());
		pessoa.setCpf(pessoaDto.getCpf());
		pessoa.setCnpj(pessoaDto.getCnpj());
		pessoa.setApelido(pessoaDto.getApelido());
		pessoa.setNomeFantasia(pessoaDto.getEmail());
		
		return ResponseEntity.ok(pessoa);
	}
	
	@DeleteMapping("/{idPessoa}")
	public ResponseEntity<Pessoa> remover(@PathVariable Long idPessoa) {
		pessoaRepository.deleteById(idPessoa);
		return ResponseEntity.ok().build();
	}
}