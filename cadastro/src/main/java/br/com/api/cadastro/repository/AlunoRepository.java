package br.com.api.cadastro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.api.cadastro.modelo.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {
	
}


