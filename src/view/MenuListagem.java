package view;

import model.Filme;
import model.Ator;
import model.Diretor;
import java.util.List;
import service.CatalogoFilmes;
import utils.catalogUtils;

public class MenuListagem {

    public static void menuListarFilmes(CatalogoFilmes catalogo) {
        int opcao;
        do {
            System.out.println("\n--- LISTAR FILMES ---");
            System.out.println("1. Ver todos os filmes");
            System.out.println("0. Voltar ao menu principal");
            System.out.print("Escolha uma opção: ");
            
            opcao = catalogUtils.lerOpcao();
            
            switch (opcao) {
                case 1:
                    catalogUtils.limparConsole();
                    listarFilmes(catalogo);
                    catalogUtils.pausar();
                    catalogUtils.limparConsole();
                    break;
                case 0:
                    catalogUtils.limparConsole();
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
                    catalogUtils.pausar();
                    catalogUtils.limparConsole();
            }
        } while (opcao != 0);
    }
    
    private static void listarFilmes(CatalogoFilmes catalogo) {
        System.out.println("\n--- TODOS OS FILMES ---");
        List<Filme> filmes = catalogo.getFilmes();
        
        if (filmes.isEmpty()) {
            System.out.println("Nenhum filme cadastrado.");
        } else {
            System.out.println("=".repeat(50));
            for (Filme filme : filmes) {
                System.out.println(filme);
                System.out.println("-".repeat(30));
            }
        }
    }
    
    public static void menuListarAtores(CatalogoFilmes catalogo) {
        int opcao;
        do {
            System.out.println("\n--- LISTAR ATORES ---");
            System.out.println("1. Ver todos os atores");
            System.out.println("0. Voltar ao menu principal");
            System.out.print("Escolha uma opção: ");
            
            opcao = catalogUtils.lerOpcao();
            
            switch (opcao) {
                case 1:
                    catalogUtils.limparConsole();
                    listarAtores(catalogo);
                    catalogUtils.pausar();
                    catalogUtils.limparConsole();
                    break;
                case 0:
                    catalogUtils.limparConsole();
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
                    catalogUtils.pausar();
                    catalogUtils.limparConsole();
            }
        } while (opcao != 0);
    }
    
    private static void listarAtores(CatalogoFilmes catalogo) {
        System.out.println("\n--- TODOS OS ATORES ---");
        List<Ator> atores = catalogo.getAtores();
        
        if (atores.isEmpty()) {
            System.out.println("Nenhum ator cadastrado.");
        } else {
            System.out.println("=".repeat(50));
            for (Ator ator : atores) {
                System.out.println(ator.getDescricao());
            }
        }
    }
    
    public static void menuListarDiretores(CatalogoFilmes catalogo) {
        int opcao;
        do {
            System.out.println("\n--- LISTAR DIRETORES ---");
            System.out.println("1. Ver todos os diretores");
            System.out.println("0. Voltar ao menu principal");
            System.out.print("Escolha uma opção: ");
            
            opcao = catalogUtils.lerOpcao();
            
            switch (opcao) {
                case 1:
                    catalogUtils.limparConsole();
                    listarDiretores(catalogo);
                    catalogUtils.pausar();
                    catalogUtils.limparConsole();
                    break;
                case 0:
                    catalogUtils.limparConsole();
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
                    catalogUtils.pausar();
                    catalogUtils.limparConsole();
            }
        } while (opcao != 0);
    }
    
    private static void listarDiretores(CatalogoFilmes catalogo) {
        System.out.println("\n--- TODOS OS DIRETORES ---");
        List<Diretor> diretores = catalogo.getDiretores();
        
        if (diretores.isEmpty()) {
            System.out.println("Nenhum diretor cadastrado.");
        } else {
            System.out.println("=".repeat(50));
            for (Diretor diretor : diretores) {
                System.out.println(diretor.getDescricao());
            }
        }
    }
}
