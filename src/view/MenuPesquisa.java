package view;

import model.Filme;
import java.util.List;
import java.util.Scanner;
import service.CatalogoFilmes;
import utils.catalogUtils;

public class MenuPesquisa {
    private static Scanner scanner = new Scanner(System.in);

    public static void menuPesquisarFilmes(CatalogoFilmes catalogo) {
        int opcao;
        do {
            System.out.println("\n--- PESQUISAR FILMES ---");
            System.out.println("1. Pesquisar filmes");
            System.out.println("0. Voltar ao menu principal");
            System.out.print("Escolha uma opção: ");
            
            opcao = catalogUtils.lerOpcao();
            
            switch (opcao) {
                case 1:
                    catalogUtils.limparConsole();
                    pesquisarFilmes(catalogo);
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
    
    private static void pesquisarFilmes(CatalogoFilmes catalogo) {
        System.out.println("\n--- PESQUISAR FILMES ---");
        
        System.out.print("Digite o nome ou parte do nome do filme: ");
        String nome = scanner.nextLine();
        
        List<Filme> filmesEncontrados = catalogo.pesquisarFilmes(nome);
        
        if (filmesEncontrados.isEmpty()) {
            System.out.println("Nenhum filme encontrado com esse nome.");
        } else {
            System.out.println("\nFilmes encontrados:");
            System.out.println("=".repeat(50));
            for (Filme filme : filmesEncontrados) {
                System.out.println(filme);
                System.out.println("-".repeat(30));
            }
        }
    }
}
