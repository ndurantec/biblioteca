package com.escola.biblioteca.Dto;

import com.escola.biblioteca.modelo.Emprestimo;

public class EmprestimoDto {

    private int cgmAluno;
    private String isbnLivro;
    private String dataEmprestimo;
    private String dataEntrega;

    @Deprecated
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

    public Emprestimo novoemEmprestimo() {
        return new Emprestimo(null, cgmAluno, isbnLivro, dataEmprestimo, dataEntrega);
    }
}
