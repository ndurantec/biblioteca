package com.escola.biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.escola.biblioteca.modelo.Emprestimo;

public interface EmprestimoRepository extends JpaRepository<Emprestimo, Long>{
   
}
