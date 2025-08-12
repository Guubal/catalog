package service;

import model.Ator;
import model.Diretor;
import model.Filme;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe de serviço que gerencia o catálogo de filmes, atores e diretores.
 * Implementa as funcionalidades de cadastro e pesquisa do sistema.
 */
public class CatalogoFilmes {
    private List<Filme> filmes;
    private List<Ator> atores;
    private List<Diretor> diretores;
    
    /**
     * Construtor que inicializa as listas
     */
    public CatalogoFilmes() {
        this.filmes = new ArrayList<>();
        this.atores = new ArrayList<>();
        this.diretores = new ArrayList<>();
    }
    
    /**
     * Adiciona um filme ao catálogo
     * @param filme Filme a ser adicionado
     */
    public void adicionarFilme(Filme filme) {
        if (filme != null && !filmes.contains(filme)) {
            filmes.add(filme);
        }
    }
    
    /**
     * Adiciona um ator ao catálogo
     * @param ator Ator a ser adicionado
     */
    public void adicionarAtor(Ator ator) {
        if (ator != null && !atores.contains(ator)) {
            atores.add(ator);
        }
    }
    
    /**
     * Adiciona um diretor ao catálogo
     * @param diretor Diretor a ser adicionado
     */
    public void adicionarDiretor(Diretor diretor) {
        if (diretor != null && !diretores.contains(diretor)) {
            diretores.add(diretor);
        }
    }
    
    /**
     * Pesquisa filmes pelo nome (case-insensitive)
     * @param nome Nome ou parte do nome do filme
     * @return Lista de filmes encontrados
     */
    public List<Filme> pesquisarFilmes(String nome) {
        List<Filme> filmesEncontrados = new ArrayList<>();
        
        if (nome == null || nome.trim().isEmpty()) {
            return filmesEncontrados;
        }
        
        String nomePesquisa = nome.toLowerCase().trim();
        
        for (Filme filme : filmes) {
            if (filme.getNome() != null && 
                filme.getNome().toLowerCase().contains(nomePesquisa)) {
                filmesEncontrados.add(filme);
            }
        }
        
        return filmesEncontrados;
    }
    
    /**
     * Busca um ator pelo nome
     * @param nome Nome do ator
     * @return Ator encontrado ou null
     */
    public Ator buscarAtor(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            return null;
        }
        
        String nomePesquisa = nome.toLowerCase().trim();
        
        for (Ator ator : atores) {
            if (ator.getNome() != null && 
                ator.getNome().toLowerCase().equals(nomePesquisa)) {
                return ator;
            }
        }
        
        return null;
    }
    
    /**
     * Busca um diretor pelo nome
     * @param nome Nome do diretor
     * @return Diretor encontrado ou null
     */
    public Diretor buscarDiretor(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            return null;
        }
        
        String nomePesquisa = nome.toLowerCase().trim();
        
        for (Diretor diretor : diretores) {
            if (diretor.getNome() != null && 
                diretor.getNome().toLowerCase().equals(nomePesquisa)) {
                return diretor;
            }
        }
        
        return null;
    }
    
    // Getters para acessar as listas (retornando cópias para manter encapsulamento)
    public List<Filme> getFilmes() {
        return new ArrayList<>(filmes);
    }
    
    public List<Ator> getAtores() {
        return new ArrayList<>(atores);
    }
    
    public List<Diretor> getDiretores() {
        return new ArrayList<>(diretores);
    }
    
    /**
     * Retorna estatísticas do catálogo
     */
    public String getEstatisticas() {
        return String.format("Catálogo: %d filmes, %d atores, %d diretores", 
                           filmes.size(), atores.size(), diretores.size());
    }
}
