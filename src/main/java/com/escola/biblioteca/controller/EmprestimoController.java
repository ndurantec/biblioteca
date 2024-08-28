package com.escola.biblioteca.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.session.Servlet;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
    public ResponseEntity<Emprestimo> insert(@RequestBody EmprestimoDto EmprestimoDto) {

        EmprestimoDto.novoemEmprestimo();
        EmprestimoRepository.save(emprestimo);

      URI uri  ServletUriComponentsBuilder.fromCurrentRequest()
                        .path("/{id}")
                        .buildAndExpand(Emprestimo.getId())
                        .to



        return ResponseEntity.created(uri).body(Emprestimo)

    }
    
}