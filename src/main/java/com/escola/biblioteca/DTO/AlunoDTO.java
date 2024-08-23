package com.escola.biblioteca.DTO;

public class AlunoDTO {
    private  String nome;
    private String endereco;
    private String email;
    private int cgm;
    private String telefone;
    private String dataNascimento;

    @Deprecated      
    public AlunoDTO() {
    }
   

    public AlunoDTO(String nome, String endereco, String email, int cgm, String telefone, String dataNascimento) {
        this.nome = nome;
        this.endereco = endereco;
        this.email = email;
        this.cgm = cgm;
        this.telefone = telefone;
        this.dataNascimento = dataNascimento;
    }


    public String getNome() {
        return nome;
    }


    public void setNome(String nome) {
        this.nome = nome;
    }


    public String getEndereco() {
        return endereco;
    }


    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }


    public String getEmail() {
        return email;
    }


    public void setEmail(String email) {
        this.email = email;
    }


    public int getCgm() {
        return cgm;
    }


    public void setCgm(int cgm) {
        this.cgm = cgm;
    }


    public String getTelefone() {
        return telefone;
    }


    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }


    public String getDataNascimento() {
        return dataNascimento;
    }


    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

}