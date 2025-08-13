package view;

import model.Diretor;
import java.util.Date;
import java.util.Scanner;
import service.CatalogoFilmes;
import utils.catalogUtils;

public class MenuDiretor {
    private static Scanner scanner = new Scanner(System.in);

    public static void menuCadastrarDiretor(CatalogoFilmes catalogo) {
        int opcao;
        do {
            System.out.println("\n--- CADASTRAR DIRETOR ---");
            System.out.println("1. Cadastrar novo diretor");
            System.out.println("0. Voltar ao menu principal");
            System.out.print("Escolha uma opção: ");
            
            opcao = catalogUtils.lerOpcao();
            
            switch (opcao) {
                case 1:
                    catalogUtils.limparConsole();
                    cadastrarDiretor(catalogo);
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
    
    private static void cadastrarDiretor(CatalogoFilmes catalogo) {
        System.out.println("\n--- CADASTRAR DIRETOR ---");
        
        System.out.print("Nome do diretor: ");
        String nome = scanner.nextLine();
        
        System.out.print("Data de nascimento (dd/MM/yyyy): ");
        Date dataNascimento = catalogUtils.lerData();
        
        System.out.print("Nacionalidade: ");
        String nacionalidade = scanner.nextLine();
        
        Diretor diretor = new Diretor(nome, dataNascimento, nacionalidade);
        catalogo.adicionarDiretor(diretor);
        
        System.out.println("\nDiretor cadastrado com sucesso!");
        System.out.println(diretor.getDescricao());
    }
}
