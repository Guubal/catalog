package view;

import model.Filme;
import model.Ator;
import model.Diretor;
import java.util.List;
import java.util.Scanner;
import service.CatalogoFilmes;
import utils.catalogUtils;

public class MenuAssociacao {
    private static Scanner scanner = new Scanner(System.in);

    public static void menuAssociarAtorFilme(CatalogoFilmes catalogo) {
        int opcao;
        do {
            System.out.println("\n--- ASSOCIAR ATOR A FILME ---");
            System.out.println("1. Associar ator e/ou diretor a filme");
            System.out.println("0. Voltar ao menu principal");
            System.out.print("Escolha uma opção: ");
            
            opcao = catalogUtils.lerOpcao();
            
            switch (opcao) {
                case 1:
                    catalogUtils.limparConsole();
                    associarAtorFilme(catalogo);
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
    
    private static void associarAtorFilme(CatalogoFilmes catalogo) {
        System.out.println("\n--- ASSOCIAR ATOR A FILME ---");
        
        System.out.print("Nome do filme: ");
        String nomeFilme = scanner.nextLine();
        List<Filme> filmesEncontrados = catalogo.pesquisarFilmes(nomeFilme);
        
        if (filmesEncontrados.isEmpty()) {
            System.out.println("Filme não encontrado!");
            return;
        }
        
        Filme filme = filmesEncontrados.get(0); // Pega o primeiro filme encontrado
        
        System.out.print("Nome do ator: ");
        String nomeAtor = scanner.nextLine();
        Ator ator = catalogo.buscarAtor(nomeAtor);
        
        if (ator == null) {
            System.out.println("Ator não encontrado!");
        } else {
            filme.adicionarAtor(ator);
        }

        System.out.print("Nome do diretor: ");
        String nomeDiretor = scanner.nextLine();

        Diretor diretor = catalogo.buscarDiretor(nomeDiretor);
        
        if (diretor == null) {
            System.out.println("Diretor não encontrado!");
        } else {
            filme.adicionarDiretor(diretor);
        }
        
        System.out.println("\nAssociações realizadas com sucesso!");
    }
}
