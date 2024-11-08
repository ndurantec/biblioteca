package com.escola.biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.escola.biblioteca.modelo.Livro;

public interface LivroRepository extends JpaRepository<Livro, Long>{

     //@Transactional(readOnly = true)  
     @Query(value = "select * from livro u where u.livro = ?1", nativeQuery = true)
    String findByIsbn(String livro);
    
}

