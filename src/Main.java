import service.CatalogoFilmes;
import service.CarregarDados;
import utils.catalogUtils;
import view.MenuPrincipal;

import java.util.Scanner;

/**
 * Classe principal que implementa a interface do usuário para o sistema de catálogo de filmes.
 * Permite cadastrar filmes, atores, diretores e realizar pesquisas.
 */
public class Main {
    private static CatalogoFilmes catalogo = new CatalogoFilmes();
    private static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        catalogUtils.limparConsole();
        System.out.println("=== SISTEMA DE CATÁLOGO DE FILMES ===");
        System.out.println("Bem-vindo ao sistema similar ao IMDB!");
        
        // Adicionar alguns dados de exemplo
        CarregarDados.carregarDadosExemplo(catalogo);
        
        int opcao;
        do {
            MenuPrincipal.exibirMenu();
            opcao = catalogUtils.lerOpcao();
            MenuPrincipal.processarOpcao(opcao, catalogo);
        } while (opcao != 0);

        catalogUtils.limparConsole();
        System.out.println("Obrigado por usar o sistema!");
        scanner.close();
    }

   
}
