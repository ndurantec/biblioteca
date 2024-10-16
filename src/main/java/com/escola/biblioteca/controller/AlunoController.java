package com.escola.biblioteca.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.escola.biblioteca.DTO.AlunoDTO;
import com.escola.biblioteca.modelo.Aluno;
import com.escola.biblioteca.repository.AlunoRepository;

 @RestController
 @CrossOrigin("*")
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
    public ResponseEntity<Aluno>insert(@RequestBody AlunoDTO alunoDto){
        
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
        alunoModificado.setEndereco(aluno.getEndereco());
        alunoModificado.setEmail(aluno.getEmail());
        alunoModificado.setCgm(aluno.getCgm());
        alunoModificado.setTelefone(aluno.getTelefone());
        alunoModificado.setDataNascimento(aluno.getDataNascimento());

        alunoRepository.save(alunoModificado);

        return ResponseEntity.noContent().build();

    }

    @DeleteMapping (value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        alunoRepository.deleteById(id);
            
        return ResponseEntity.noContent().build();
    }

    @GetMapping(value = "/{cgm}")
    public void findByCgm(@PathVariable Long cgm){
        //return alunoRepository.findByCgm(cgm);
        //.map(registro-> ResponseEntity.ok().body(registro))
                 //.orElse(ResponseEntity.notFound().build());

    }

}


 





