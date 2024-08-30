package com.escola.biblioteca.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.escola.biblioteca.Dto.LivroDto;
import com.escola.biblioteca.modelo.Livro;
import com.escola.biblioteca.repository.LivroRepository;

@RestController
@RequestMapping(value = "/livro")
public class LivroController {

    @Autowired
    private LivroRepository livroRepository;

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
        return livroRepository.findAll();
    }

    @PostMapping(value = "/insert")
    public ResponseEntity<Livro> insert(@RequestBody LivroDto livroDto) {

        Livro livro = livroDto.novoLivro();

        livroRepository.save(livro);

      URI uri =  ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                    .buildAndExpand(livro.getId())
                        .toUri();

        return ResponseEntity.created(uri).body(livro);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Livro> findyById(@PathVariable Long id) {
        return livroRepository.findById(id)
            .map(registro -> ResponseEntity.ok ().body(registro))
                    .orElse(ResponseEntity.notFound().build());
    }
}