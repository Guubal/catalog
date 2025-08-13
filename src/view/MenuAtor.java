package view;

import model.Ator;
import java.util.Date;
import java.util.Scanner;
import service.CatalogoFilmes;
import utils.catalogUtils;
import java.text.SimpleDateFormat;

public class MenuAtor {
    private static Scanner scanner = new Scanner(System.in);
    private static SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    public static void menuCadastrarAtor(CatalogoFilmes catalogo) {
        int opcao;
        do {
            System.out.println("\n--- CADASTRAR ATOR ---");
            System.out.println("1. Cadastrar novo ator");
            System.out.println("0. Voltar ao menu principal");
            System.out.print("Escolha uma opção: ");

            opcao = catalogUtils.lerOpcao();

            switch (opcao) {
                case 1:
                    catalogUtils.limparConsole() ;
                    cadastrarAtor(catalogo);
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

    private static void cadastrarAtor(CatalogoFilmes catalogo) {
        System.out.println("\n--- CADASTRAR ATOR ---");

        System.out.print("Nome do ator: ");
        String nome = scanner.nextLine();

        System.out.print("Data de nascimento (dd/MM/yyyy): ");
        Date dataNascimento = catalogUtils.lerData();

        System.out.print("Nacionalidade: ");
        String nacionalidade = scanner.nextLine();

        Ator ator = new Ator(nome, dataNascimento, nacionalidade);
        catalogo.adicionarAtor(ator);

        System.out.println("\nAtor cadastrado com sucesso!");
        System.out.println(ator.getDescricao());
    }
}