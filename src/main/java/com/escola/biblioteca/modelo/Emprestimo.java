package com.escola.biblioteca.modelo;

public class Emprestimo {

    private int cgmAluno;
    private String isbnLivro;
    private String dataEmprestimo;
    private String dataEntrega;
    
    public int getCgmAluno() {

        return cgmAluno;
    }
    
    public Emprestimo(String dataEmprestimo, String dataEntrega) {
        this.dataEmprestimo = dataEmprestimo;
        this.dataEntrega = dataEntrega;
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
    public Emprestimo(int cgmAluno, String isbnLivro) {
        this.cgmAluno = cgmAluno;
        this.isbnLivro = isbnLivro;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + cgmAluno;
        result = prime * result + ((isbnLivro == null) ? 0 : isbnLivro.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Emprestimo other = (Emprestimo) obj;
        if (cgmAluno != other.cgmAluno)
            return false;
        if (isbnLivro == null) {
            if (other.isbnLivro != null)
                return false;
        } else if (!isbnLivro.equals(other.isbnLivro))
            return false;
        return true;
    }
    @Override
    public String toString() {
        return "Emprestimo [cgmAluno=" + cgmAluno + ", isbnLivro=" + isbnLivro + "]";
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
    

}
