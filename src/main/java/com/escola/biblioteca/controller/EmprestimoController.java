package com.escola.biblioteca.controller;

import java.net.URI;
import java.util.List;

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

import com.escola.biblioteca.Dto.EmprestimoDto;
import com.escola.biblioteca.modelo.Emprestimo;
import com.escola.biblioteca.repository.EmprestimoRepository;

@RestController
@RequestMapping(value = "/emprestimo")
public class EmprestimoController {

    @Autowired
    private EmprestimoRepository emprestimoRepository;

    @GetMapping(value = "/imprimir")
    public String imprimir(){
        System.out.println("cheugouu");
        return "okok";
    }

    @GetMapping(value = "/criar")
    public String criar () {
        System.out.println("cheugouu");
        return "okok";  
     }

    @GetMapping(value = "/findAll")
    public List findAll() {
        return emprestimoRepository.findAll();
    }

    @PostMapping(value = "/insert")
    public ResponseEntity<Emprestimo> insert(@RequestBody EmprestimoDto emprestimoDto) {

        Emprestimo emprestimo = emprestimoDto.novoemEmprestimo();

        emprestimoRepository.save(emprestimo);

      URI uri =  ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                    .buildAndExpand(emprestimo.getId())
                        .toUri();

        return ResponseEntity.created(uri).body(emprestimo);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Emprestimo> findyById(@PathVariable Long id) {
        return emprestimoRepository.findById(id)
            .map(registro -> ResponseEntity.ok ().body(registro))
                    .orElse(ResponseEntity.notFound().build());
    }



    @PutMapping(value = "/{id}")
    public ResponseEntity<Emprestimo> update (@PathVariable Long id, @RequestBody EmprestimoDto emprestimoDto) {

        

       return emprestimoRepository.findById(id)
       .map(existingEmprestimo -> {
           Emprestimo emprestimo = emprestimoDto.novoemEmprestimo();
           emprestimo.setId(id);
           emprestimoRepository.save(emprestimo);
           return ResponseEntity.ok(emprestimo);
       })
       .orElse(ResponseEntity.notFound().build()); 

    }

    public ResponseEntity<Void> delete(@PathVariable Long id) {
        emprestimoRepository.deleteById(id);
            
        return ResponseEntity.noContent().build();
       
    
    }


}