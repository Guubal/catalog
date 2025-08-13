package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Classe que representa um Filme no sistema de catálogo.
 * Contém todos os atributos e métodos necessários para gerenciar filmes.
 */
public class Filme {
    private String nome;
    private Date dataLancamento;
    private double orcamento;
    private String descricao;
    private Diretor diretor;
    private List<Ator> atores;
    
    /**
     * Construtor padrão
     */
    public Filme() {
        this.atores = new ArrayList<>();
    }
    
    /**
     * Construtor com parâmetros básicos
     */
    public Filme(String nome, Date dataLancamento, double orcamento, String descricao) {
        this.nome = nome;
        this.dataLancamento = dataLancamento;
        this.orcamento = orcamento;
        this.descricao = descricao;
        this.atores = new ArrayList<>();
    }
    
    /**
     * Construtor completo
     */
    public Filme(String nome, Date dataLancamento, double orcamento, String descricao, Diretor diretor) {
        this(nome, dataLancamento, orcamento, descricao);
        this.diretor = diretor;
    }
    
    // Getters e Setters (Encapsulamento)
    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public Date getDataLancamento() {
        return dataLancamento;
    }
    
    public void setDataLancamento(Date dataLancamento) {
        this.dataLancamento = dataLancamento;
    }
    
    public double getOrcamento() {
        return orcamento;
    }
    
    public void setOrcamento(double orcamento) {
        this.orcamento = orcamento;
    }
    
    public String getDescricao() {
        return descricao;
    }
    
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    public Diretor getDiretor() {
        return diretor;
    }
    
    public void setDiretor(Diretor diretor) {
        this.diretor = diretor;
    }
    
    public List<Ator> getAtores() {
        return new ArrayList<>(atores); // Retorna uma cópia para manter encapsulamento
    }
    
    /**
     * Adiciona um ator ao filme
     * @param ator Ator a ser adicionado
     */
    public void adicionarAtor(Ator ator) {
        if (ator != null && !atores.contains(ator)) {
            atores.add(ator);
        }
    }

    public void adicionarDiretor(Diretor diretor) {
        if (diretor != null) {
            this.diretor = diretor;
        }
    }
    
    /**
     * Remove um ator do filme
     * @param ator Ator a ser removido
     */
    public void removerAtor(Ator ator) {
        atores.remove(ator);
    }
    
    /**
     * Retorna uma representação em string do filme
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("FILME: ").append(nome).append("\n");
        sb.append("Data de Lançamento: ").append(dataLancamento).append("\n");
        sb.append("Orçamento: $").append(String.format("%.2f", orcamento)).append("\n");
        sb.append("Descrição: ").append(descricao).append("\n");
        
        if (diretor != null) {
            sb.append("Diretor: ").append(diretor.getNome()).append("\n");
        }
        
        if (!atores.isEmpty()) {
            sb.append("Atores: ");
            for (int i = 0; i < atores.size(); i++) {
                sb.append(atores.get(i).getNome());
                if (i < atores.size() - 1) {
                    sb.append(", ");
                }
            }
            sb.append("\n");
        }
        
        return sb.toString();
    }
}
