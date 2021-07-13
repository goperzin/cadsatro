package br.com.api.cadastro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.api.cadastro.modelo.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long>{

}
