package com.escola.biblioteca.DTO;

public class LivroDTO {
    private String nome;
    private String genero;
    private int anoPublicacao;
    private String isbn;
    private int estante;
    private int idadeIndicativa;
    private String autor;


    @Deprecated
    public LivroDTO() {
    }
    
    public LivroDTO(String nome, String genero, int anoPublicacao, String isbn, int estante, int idadeIndicativa,
    String autor) {
    this.nome = nome;
    this.genero = genero;
    this.anoPublicacao = anoPublicacao;
    this.isbn = isbn;
    this.estante = estante;
    this.idadeIndicativa = idadeIndicativa;
    this.autor = autor;
    }






    public String getNome() {
        return nome;
    }


    public void setNome(String nome) {
        this.nome = nome;
    }


    public String getGenero() {
        return genero;
    }


    public void setGenero(String genero) {
        this.genero = genero;
    }


    public int getAnoPublicacao() {
        return anoPublicacao;
    } 


    public void setAnoPublicacao(int anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }


    public String getIsbn() {
        return isbn;
    }


    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }


    public int getEstante() {
        return estante;
    }


    public void setEstante(int estante) {
        this.estante = estante;
    }


    public int getIdadeIndicativa() {
        return idadeIndicativa;
    }

    
    public void setIdadeIndicativa(int idadeIndicativa) {
        this.idadeIndicativa = idadeIndicativa;
    }


    public String getAutor() {
        return autor;
    }


    public void setAutor(String autor) {
        this.autor = autor;
    }


   
    
}
