package view;

import service.CatalogoFilmes;
import utils.catalogUtils;

public class MenuPrincipal {
    
    public static void exibirMenu() {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("MENU PRINCIPAL");
        System.out.println("=".repeat(50));
        System.out.println("1. Cadastrar Ator");
        System.out.println("2. Cadastrar Diretor");
        System.out.println("3. Cadastrar Filme");
        System.out.println("4. Associar Ator a Filme");
        System.out.println("5. Pesquisar Filmes");
        System.out.println("6. Listar Todos os Filmes");
        System.out.println("7. Listar Atores");
        System.out.println("8. Listar Diretores");
        System.out.println("9. Estatísticas do Catálogo");
        System.out.println("0. Sair");
        System.out.println("=".repeat(50));
        System.out.print("Escolha uma opção: ");
    }
    
    public static void processarOpcao(int opcao, CatalogoFilmes catalogo) {
        catalogUtils.limparConsole();
        switch (opcao) {
            case 1:
                MenuAtor.menuCadastrarAtor(catalogo);
                break;
            case 2:
                MenuDiretor.menuCadastrarDiretor(catalogo);
                break;
            case 3:
                MenuFilme.menuCadastrarFilme(catalogo);
                break;
            case 4:
                MenuAssociacao.menuAssociarAtorFilme(catalogo);
                break;
            case 5:
                MenuPesquisa.menuPesquisarFilmes(catalogo);
                break;
            case 6:
                MenuListagem.menuListarFilmes(catalogo);
                break;
            case 7:
                MenuListagem.menuListarAtores(catalogo);
                break;
            case 8:
                MenuListagem.menuListarDiretores(catalogo);
                break;
            case 9:
                MenuEstatisticas.menuEstatisticas(catalogo);
                break;
            case 0:
                break;
            default:
                System.out.println("Opção inválida! Tente novamente.");
                catalogUtils.pausar();
        }
    }
}
