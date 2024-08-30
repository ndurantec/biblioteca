package com.escola.biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.escola.biblioteca.modelo.Livro;

public interface LivroRepository extends JpaRepository<Livro, Long>{
    
}
