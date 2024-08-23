package com.escola.biblioteca.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    
}