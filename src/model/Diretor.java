package model;

import java.util.Date;

/**
 * Classe que representa um Diretor no sistema de catálogo de filmes.
 * Herda de Pessoa e implementa o método abstrato getDescricao().
 */
public class Diretor extends Pessoa {
    
    /**
     * Construtor padrão
     */
    public Diretor() {
        super();
    }
    
    /**
     * Construtor com parâmetros
     */
    public Diretor(String nome, Date dataNascimento, String nacionalidade) {
        super(nome, dataNascimento, nacionalidade);
    }
    
    /**
     * Implementação do método abstrato da classe Pessoa (Polimorfismo)
     * @return Descrição específica do diretor
     */
    @Override
    public String getDescricao() {
        return "Diretor: " + getNome() + " - Nacionalidade: " + getNacionalidade();
    }
    
    @Override
    public String toString() {
        return "DIRETOR - " + super.toString();
    }
}
