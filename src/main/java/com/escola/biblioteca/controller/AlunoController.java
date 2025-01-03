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
    
    //Cadastrar o aluno
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
    public ResponseEntity<Void> update(@PathVariable long id, @RequestBody AlunoDTO alunoDto){
        
        Optional<Aluno> alunoBanco = alunoRepository.findById(id);

        Aluno alunoModificado = alunoBanco.get();

        alunoModificado.setNome(alunoDto.getNome());
        alunoModificado.setEndereco(alunoDto.getEndereco());
        alunoModificado.setEmail(alunoDto.getEmail());
        alunoModificado.setCgm(alunoDto.getCgm());
        alunoModificado.setTelefone(alunoDto.getTelefone());
        alunoModificado.setDataNascimento(alunoDto.getDataNascimento());

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
        // return alunoRepository.findByCgm(cgm);
        // .map(registro-> ResponseEntity.ok().body(registro))
        //          .orElse(ResponseEntity.notFound().build());

    }



    // @GetMapping(value = "/{nome}")
    // public ResponseEntity<Long> buscarNome(@RequestBody String nome) {
    //     Optional<Aluno> aluno = alunoRepository.findByNome(nome);
    //     Aluno alunoObjeto = aluno.get();
    //     System.out.println(alunoObjeto.toString());
    //     return aluno.map(c -> ResponseEntity.ok(c.getId()))
    //                 .orElse(ResponseEntity.notFound().build());
    
    // }
    
    //  @PostMapping(value = "/findByNome")
    //  public String buscarPorNome(@RequestBody AlunoDTO alunoDTO) {
    //      return alunoRepository.findByNome(alunoDTO.getNome());
    // }

    @PostMapping(value = "/findByNome")
    public String buscarPorNome(@RequestBody AlunoDTO alunoDTO) {
        return alunoRepository.findByNome(alunoDTO.getNome());
    }




    // @PostMapping(value = "findByNome")
    // public ResponseEntity<Long> buscarNome(@RequestBody String nome) {
    //     //Optional<Aluno> aluno = alunoRepository.findByNome(nome);
    //     Aluno aluno = alunoRepository.findByNome(nome);
    //     Aluno alunoObjeto = aluno.get();
    //     System.out.println(alunoObjeto.toString());
    //     return alunoRepository.findByNome(alunoDTO.getNome())
    //                 .orElse(ResponseEntity.notFound().build());
     
    // }   


}


 





