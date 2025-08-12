package model;

import java.util.Date;

/**
 * Classe que representa um Ator no sistema de catálogo de filmes.
 * Herda de Pessoa e implementa o método abstrato getDescricao().
 */
public class Ator extends Pessoa {
    
    /**
     * Construtor padrão
     */
    public Ator() {
        super();
    }
    
    /**
     * Construtor com parâmetros
     */
    public Ator(String nome, Date dataNascimento, String nacionalidade) {
        super(nome, dataNascimento, nacionalidade);
    }
    
    /**
     * Implementação do método abstrato da classe Pessoa (Polimorfismo)
     * @return Descrição específica do ator
     */
    @Override
    public String getDescricao() {
        return "Ator: " + getNome() + " - Nacionalidade: " + getNacionalidade();
    }
    
    @Override
    public String toString() {
        return "ATOR - " + super.toString();
    }
}
