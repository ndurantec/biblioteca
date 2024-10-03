package com.escola.biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.escola.biblioteca.modelo.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Long>{

    //@Transactional(readOnly = true)  
    @Query(value = "select u.id from conta u where u.conta = ?1", nativeQuery = true)
    Long findByCgm(Long cgm);

}

