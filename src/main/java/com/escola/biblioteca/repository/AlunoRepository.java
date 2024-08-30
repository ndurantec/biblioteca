package com.escola.biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.escola.biblioteca.modelo.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Long>{
    
}

