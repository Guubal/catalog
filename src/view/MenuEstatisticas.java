package view;

import service.CatalogoFilmes;
import utils.catalogUtils;

public class MenuEstatisticas {

    public static void menuEstatisticas(CatalogoFilmes catalogo) {
        int opcao;
        do {
            System.out.println("\n--- ESTATÍSTICAS ---");
            System.out.println("1. Ver estatísticas do catálogo");
            System.out.println("0. Voltar ao menu principal");
            System.out.print("Escolha uma opção: ");
            
            opcao = catalogUtils.lerOpcao();
            
            switch (opcao) {
                case 1:
                    catalogUtils.limparConsole();
                    exibirEstatisticas(catalogo);
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
    
    private static void exibirEstatisticas(CatalogoFilmes catalogo) {
        System.out.println("\n--- ESTATÍSTICAS DO CATÁLOGO ---");
        System.out.println(catalogo.getEstatisticas());
    }
}
