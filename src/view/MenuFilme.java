package view;

import model.Filme;
import model.Diretor;
import java.util.Date;
import java.util.Scanner;
import service.CatalogoFilmes;
import utils.catalogUtils;

public class MenuFilme {
    private static Scanner scanner = new Scanner(System.in);

    public static void menuCadastrarFilme(CatalogoFilmes catalogo) {
        int opcao;
        do {
            System.out.println("\n--- CADASTRAR FILME ---");
            System.out.println("1. Cadastrar novo filme");
            System.out.println("0. Voltar ao menu principal");
            System.out.print("Escolha uma opção: ");
            
            opcao = catalogUtils.lerOpcao();
            
            switch (opcao) {
                case 1:
                    catalogUtils.limparConsole();
                    cadastrarFilme(catalogo);
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
    
    private static void cadastrarFilme(CatalogoFilmes catalogo) {
        System.out.println("\n--- CADASTRAR FILME ---");
        
        System.out.print("Nome do filme: ");
        String nome = scanner.nextLine();
        
        System.out.print("Data de lançamento (dd/MM/yyyy): ");
        Date dataLancamento = catalogUtils.lerData();
        
        System.out.print("Orçamento (em dólares): ");
        double orcamento = catalogUtils.lerDouble();
        
        System.out.print("Descrição: ");
        String descricao = scanner.nextLine();
        
        // Selecionar diretor
        System.out.print("Nome do diretor: ");
        String nomeDiretor = scanner.nextLine();
        Diretor diretor = catalogo.buscarDiretor(nomeDiretor);
        
        if (diretor == null) {
            System.out.println("Diretor não encontrado!");
            return;
        }
        
        Filme filme = new Filme(nome, dataLancamento, orcamento, descricao, diretor);
        catalogo.adicionarFilme(filme);
        
        System.out.println("\nFilme cadastrado com sucesso!");
    }
}
