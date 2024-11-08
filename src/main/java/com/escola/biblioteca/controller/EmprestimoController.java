package com.escola.biblioteca.controller;

import java.net.URI;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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

import com.escola.biblioteca.DTO.EmprestimoDTO;
import com.escola.biblioteca.modelo.Aluno;
import com.escola.biblioteca.modelo.EmailDetails;
import com.escola.biblioteca.modelo.Emprestimo;
import com.escola.biblioteca.repository.AlunoRepository;
import com.escola.biblioteca.repository.EmprestimoRepository;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/emprestimo")
public class EmprestimoController {

    DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    @Autowired
    private EmailService emailService;

    @Autowired
    private EmprestimoRepository emprestimoRepository;

    @Autowired
    private AlunoRepository alunoRepository;

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
    public ResponseEntity<Emprestimo> insert(@RequestBody EmprestimoDTO emprestimoDto) {

        Emprestimo emprestimo = emprestimoDto.novoEmprestimo();
        emprestimoRepository.save(emprestimo);



        Aluno alunoDoBanco = alunoRepository.findByCgm(emprestimo.getCgmAluno() );

        if (alunoDoBanco != null) {
            System.out.println("================================================");
            System.out.println("================================================");
            System.out.println("=====" + alunoDoBanco.getNome() );
            System.out.println("================================================");
            System.out.println("O email do aluno --> " + alunoDoBanco.getEmail());
            System.out.println("================================================");
            System.out.println("================================================");
            System.out.println("================================================");
        } 

        //https://stackoverflow.com/questions/69071784/java-time-format-datetimeparseexception-text-13-11-2020-could-not-be-parsed-a

         EmailDetails emailDetails = new EmailDetails(alunoDoBanco.getEmail(), "Livro Emprestado", "Caro aluno, você emprestou um livro na data: " + 
         LocalDate.parse(emprestimo.getDataEmprestimo(), fmt1) + "</br> A data de devolução é: " + LocalDate.parse( emprestimo.getDataEntrega() , fmt1), null);
         emailService.sendMail(emailDetails);

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

    @PutMapping (value = "/{id}")
    public ResponseEntity<Void> update(@PathVariable long id , @RequestBody Emprestimo emprestimo ) {

        Optional<Emprestimo> emprestimoBanco = emprestimoRepository.findById(id);

        Emprestimo emprestimoModificado = emprestimoBanco.get();
        emprestimoModificado.setDataEmprestimo(emprestimo.getDataEmprestimo());
        emprestimoModificado.setIsbnLivro(emprestimo.getIsbnLivro());
        emprestimoModificado.setCgmAluno(emprestimo.getCgmAluno());
        emprestimoModificado.setDataEntrega(emprestimo.getDataEntrega());
        emprestimoRepository.save(emprestimoModificado);

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping (value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        emprestimoRepository.deleteById(id);
            
        return ResponseEntity.noContent().build();
    }

    private Aluno findyByCgm(int Cgm) {
        return alunoRepository.findByCgm(Cgm);
           
    }
    
    
}
