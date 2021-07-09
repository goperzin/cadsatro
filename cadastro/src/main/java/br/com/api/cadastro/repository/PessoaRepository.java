package br.com.api.cadastro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.api.cadastro.modelo.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long>{

}
