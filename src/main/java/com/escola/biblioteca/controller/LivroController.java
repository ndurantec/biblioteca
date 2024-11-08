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
import com.escola.biblioteca.DTO.LivroDTO;
import com.escola.biblioteca.modelo.Livro;
import com.escola.biblioteca.repository.LivroRepository;

@RestController
@CrossOrigin("*")
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
    public ResponseEntity<Livro> insert(@RequestBody LivroDTO livroDto) {

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

    @PutMapping(value = "/{id}")
    public ResponseEntity<Void> update(@PathVariable Long id, @RequestBody Livro livro) {

       Optional<Livro> livroBanco = livroRepository.findById(null);

       Livro livroModificado = livroBanco.get();
       livroModificado.setNome(livro.getNome());
       livroModificado.setGenero(livro.getGenero());
       livroModificado.setAnoPublicacao(livro.getAnoPublicacao());
       livroModificado.setIsbn(livro.getIsbn());
       livroModificado.setEstante(livro.getEstante());
       livroModificado.setIdadeIndicativa(livro.getIdadeIndicativa());
       livroModificado.setAutor(livro.getAutor());
       livroRepository.save(livroModificado);

       return ResponseEntity.noContent().build();

    }

       @DeleteMapping (value = "/{id}")
       public ResponseEntity<Void> delete(@PathVariable Long id) {
           livroRepository.deleteById(id);
               
           return ResponseEntity.noContent().build();
       }

        @PostMapping(value = "/findByIsbn")
    public String buscarPorIsbn(@RequestBody LivroDTO livroDTO) {
        return livroRepository.findByIsbn(livroDTO.getIsbn());
    }

        //@PostMapping("/findByIsbn")
       // public ResponseEntity<Long> buscarIsbn(@RequestBody LivroDTO livroDTO) {
           // Optional<Livro> livro = livroRepository.findByIsbn(livroDTO.getIsbn());
            //Livro livroObjeto = livro.get();
          //  System.out.println(livroObjeto.toString());
           // return livro.map(c -> ResponseEntity.ok(c.getId()))
                //        .orElse(ResponseEntity.notFound().build());
       // }

    }
