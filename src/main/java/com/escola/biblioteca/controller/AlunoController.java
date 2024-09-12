package com.escola.biblioteca.controller;

import java.lang.StackWalker.Option;
import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.escola.biblioteca.Dto.AlunoDto;
import com.escola.biblioteca.modelo.Aluno;
import com.escola.biblioteca.repository.AlunoRepository;

 @RestController  
 @RequestMapping(value = "/aluno")
    public class AlunoController {

    @Autowired
    private AlunoRepository alunoRepository;

    @GetMapping(value = "/imprimir")
    public String imprimir(){
    System.out.println("chegou");
    return"okok";
    }
  
    @GetMapping(value = "/criar")
    public String criar (){
       System.out.println("chegou");
       return"okok";
    }

    @GetMapping(value = "/findAll")
    public List findAll (){
       return  alunoRepository.findAll();
    }
    
    @PostMapping(value = "/insert")
    public ResponseEntity<Aluno>insert(@RequestBody AlunoDto alunoDto){
        
        Aluno  aluno = alunoDto.novoAluno();
        
        alunoRepository.save(aluno);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
            .path("/{id}")
              . buildAndExpand(aluno.getId())
                .toUri();
        return   ResponseEntity.created(uri).body(aluno);

    }
     
    @GetMapping(value = "/{id}")
    public ResponseEntity<Aluno> findById(@PathVariable Long id){
        return alunoRepository.findById(id)
        .map(registro-> ResponseEntity.ok().body(registro))
                 .orElse(ResponseEntity.notFound().build());

    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Void> update(@PathVariable long id, @RequestBody Aluno aluno){
        
        Optional<Aluno> alunoBanco = alunoRepository.findById(null);

        Aluno alunoModificado = alunoBanco.get();

        alunoModificado.setNome(aluno.getNome());

        alunoRepository.save(alunoModificado);

        return ResponseEntity.noContent().build();



    }
}


 





