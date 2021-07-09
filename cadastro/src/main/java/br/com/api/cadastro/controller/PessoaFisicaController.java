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

import br.com.api.cadastro.modelo.Pessoa;
import br.com.api.cadastro.modelo.PessoaFisica;
import br.com.api.cadastro.repository.PessoaRepository;

@RestController
@RequestMapping("pessoa-fisica")
public class PessoaFisicaController {
	
	@Autowired
	PessoaRepository PessoaRepository;
	
	@PostMapping()
	public ResponseEntity<Pessoa> cadastrar(@RequestBody Pessoa pessoaDto, UriComponentsBuilder uriBuilder) {
		PessoaFisica pessoa = new PessoaFisica();
		
		pessoa.setNome(pessoaDto.getNome());
		pessoa.setCelular(pessoaDto.getCelular());
		pessoa.setTelefone(pessoaDto.getTelefone());
		pessoa.setEmail(pessoaDto.getEmail());
		
		Pessoa pessoaSalva = PessoaRepository.save(pessoa);
		
		URI uri = uriBuilder.path("/cadastrar/{idPessoa}").buildAndExpand(pessoa.getIdPessoa()).toUri();
		
		return ResponseEntity.created(uri).body(pessoaSalva);
	}
	
	@GetMapping()
	public List<Pessoa> listarTodos() {
		return PessoaRepository.findAll();
	}
	
	@GetMapping("/{idPessoa}")
	public Pessoa listarPorId(@PathVariable Long idPessoa) {
		return PessoaRepository.getById(idPessoa);
	}
	
	@PutMapping("/{idPessoa}")
	@Transactional
	public ResponseEntity<Pessoa> alterar(@PathVariable Long idPessoa, @RequestBody Pessoa pessoaDto) {
		Pessoa pessoa = PessoaRepository.getById(idPessoa);
		
		pessoa.setNome(pessoaDto.getNome());
		pessoa.setCelular(pessoaDto.getCelular());
		pessoa.setTelefone(pessoaDto.getTelefone());
		pessoa.setEmail(pessoaDto.getEmail());
		
		return ResponseEntity.ok(pessoa);
	}
	
	@DeleteMapping("/{idPessoa}")
	public ResponseEntity<?> remover(@PathVariable Long idPessoa) {
		PessoaRepository.deleteById(idPessoa);
		return ResponseEntity.ok().build();
	}
}