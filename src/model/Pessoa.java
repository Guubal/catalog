package model;

import java.util.Date;

/**
 * Classe abstrata que representa uma pessoa no sistema de catálogo de filmes.
 * Serve como base para Ator e Diretor, implementando encapsulamento e herança.
 */
public abstract class Pessoa {
    private String nome;
    private Date dataNascimento;
    private String nacionalidade;
    
    /**
     * Construtor padrão
     */
    public Pessoa() {
    }
    
    /**
     * Construtor com parâmetros
     */
    public Pessoa(String nome, Date dataNascimento, String nacionalidade) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.nacionalidade = nacionalidade;
    }
    
    // Getters e Setters (Encapsulamento)
    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public Date getDataNascimento() {
        return dataNascimento;
    }
    
    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
    
    public String getNacionalidade() {
        return nacionalidade;
    }
    
    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }
    
    /**
     * Método abstrato que deve ser implementado pelas classes filhas (Polimorfismo)
     * @return Descrição específica da pessoa
     */
    public abstract String getDescricao();
    
    @Override
    public String toString() {
        return "Nome: " + nome + ", Nascimento: " + dataNascimento + ", Nacionalidade: " + nacionalidade;
    }
}
