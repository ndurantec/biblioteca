package com.escola.biblioteca.DTO;


import com.escola.biblioteca.modelo.Emprestimo;

public class EmprestimoDTO {

    private Long id;
    private int cgmAluno;
    private String isbnLivro;
    private String dataEmprestimo;
    private String dataEntrega;

    public EmprestimoDTO() {
    }

    public EmprestimoDTO(int cgmAluno, String isbnLivro, String dataEmprestimo, String dataEntrega) {
        this.cgmAluno = cgmAluno;
        this.isbnLivro = isbnLivro;
        this.dataEmprestimo = dataEmprestimo;
        this.dataEntrega = dataEntrega;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getCgmAluno() {
        return cgmAluno;
    }

    public void setCgmAluno(int cgmAluno) {
        this.cgmAluno = cgmAluno;
    }

    public String getIsbnLivro() {
        return isbnLivro;
    }

    public void setIsbnLivro(String isbnLivro) {
        this.isbnLivro = isbnLivro;
    }

    public String getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(String dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public String getDataEntrega() {
        return dataEntrega;
    }

    public void setDataEntrega(String dataEntrega) {
        this.dataEntrega = dataEntrega;
    }

    public Emprestimo novoEmprestimo(){
        System.out.println("**********************************");
        System.out.println("**********************************");
        System.out.println("**********************************");
        System.out.println(this.cgmAluno);
        System.out.println(this.isbnLivro);
        System.out.println(this.dataEmprestimo);
        System.out.println(this.dataEntrega);
        
        return new Emprestimo(cgmAluno, isbnLivro, dataEmprestimo, dataEntrega);
    }

    @Override
    public String toString() {
        return "EmprestimoDTO [id=" + id + ", cgmAluno=" + cgmAluno + ", isbnLivro=" + isbnLivro + ", dataEmprestimo="
                + dataEmprestimo + ", dataEntrega=" + dataEntrega + "]";
    }

    

}
