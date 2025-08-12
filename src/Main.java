import model.Ator;
import model.Diretor;
import model.Filme;
import service.CatalogoFilmes;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 * Classe principal que implementa a interface do usuário para o sistema de catálogo de filmes.
 * Permite cadastrar filmes, atores, diretores e realizar pesquisas.
 */
public class Main {
    private static CatalogoFilmes catalogo = new CatalogoFilmes();
    private static Scanner scanner = new Scanner(System.in);
    private static SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    
    public static void main(String[] args) {
        limparConsole();
        System.out.println("=== SISTEMA DE CATÁLOGO DE FILMES ===");
        System.out.println("Bem-vindo ao sistema similar ao IMDB!");
        
        // Adicionar alguns dados de exemplo
        carregarDadosExemplo();
        
        int opcao;
        do {
            exibirMenu();
            opcao = lerOpcao();
            processarOpcao(opcao);
        } while (opcao != 0);
        
        limparConsole();
        System.out.println("Obrigado por usar o sistema!");
        scanner.close();
    }
    
    private static void exibirMenu() {
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
    
    private static int lerOpcao() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }
    
    private static void processarOpcao(int opcao) {
        limparConsole();
        switch (opcao) {
            case 1:
                menuCadastrarAtor();
                break;
            case 2:
                menuCadastrarDiretor();
                break;
            case 3:
                menuCadastrarFilme();
                break;
            case 4:
                menuAssociarAtorFilme();
                break;
            case 5:
                menuPesquisarFilmes();
                break;
            case 6:
                menuListarFilmes();
                break;
            case 7:
                menuListarAtores();
                break;
            case 8:
                menuListarDiretores();
                break;
            case 9:
                menuEstatisticas();
                break;
            case 0:
                break;
            default:
                System.out.println("Opção inválida! Tente novamente.");
                pausar();
        }
    }
    
    private static void menuCadastrarAtor() {
        int opcao;
        do {
            System.out.println("\n--- CADASTRAR ATOR ---");
            System.out.println("1. Cadastrar novo ator");
            System.out.println("0. Voltar ao menu principal");
            System.out.print("Escolha uma opção: ");
            
            opcao = lerOpcao();
            
            switch (opcao) {
                case 1:
                    limparConsole();
                    cadastrarAtor();
                    pausar();
                    limparConsole();
                    break;
                case 0:
                    limparConsole();
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
                    pausar();
                    limparConsole();
            }
        } while (opcao != 0);
    }
    
    private static void cadastrarAtor() {
        System.out.println("\n--- CADASTRAR ATOR ---");
        
        System.out.print("Nome do ator: ");
        String nome = scanner.nextLine();
        
        System.out.print("Data de nascimento (dd/MM/yyyy): ");
        Date dataNascimento = lerData();
        
        System.out.print("Nacionalidade: ");
        String nacionalidade = scanner.nextLine();
        
        Ator ator = new Ator(nome, dataNascimento, nacionalidade);
        catalogo.adicionarAtor(ator);
        
        System.out.println("\nAtor cadastrado com sucesso!");
        System.out.println(ator.getDescricao());
    }
    
    private static void menuCadastrarDiretor() {
        int opcao;
        do {
            System.out.println("\n--- CADASTRAR DIRETOR ---");
            System.out.println("1. Cadastrar novo diretor");
            System.out.println("0. Voltar ao menu principal");
            System.out.print("Escolha uma opção: ");
            
            opcao = lerOpcao();
            
            switch (opcao) {
                case 1:
                    limparConsole();
                    cadastrarDiretor();
                    pausar();
                    limparConsole();
                    break;
                case 0:
                    limparConsole();
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
                    pausar();
                    limparConsole();
            }
        } while (opcao != 0);
    }
    
    private static void cadastrarDiretor() {
        System.out.println("\n--- CADASTRAR DIRETOR ---");
        
        System.out.print("Nome do diretor: ");
        String nome = scanner.nextLine();
        
        System.out.print("Data de nascimento (dd/MM/yyyy): ");
        Date dataNascimento = lerData();
        
        System.out.print("Nacionalidade: ");
        String nacionalidade = scanner.nextLine();
        
        Diretor diretor = new Diretor(nome, dataNascimento, nacionalidade);
        catalogo.adicionarDiretor(diretor);
        
        System.out.println("\nDiretor cadastrado com sucesso!");
        System.out.println(diretor.getDescricao());
    }
    
    private static void menuCadastrarFilme() {
        int opcao;
        do {
            System.out.println("\n--- CADASTRAR FILME ---");
            System.out.println("1. Cadastrar novo filme");
            System.out.println("0. Voltar ao menu principal");
            System.out.print("Escolha uma opção: ");
            
            opcao = lerOpcao();
            
            switch (opcao) {
                case 1:
                    limparConsole();
                    cadastrarFilme();
                    pausar();
                    limparConsole();
                    break;
                case 0:
                    limparConsole();
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
                    pausar();
                    limparConsole();
            }
        } while (opcao != 0);
    }
    
    private static void cadastrarFilme() {
        System.out.println("\n--- CADASTRAR FILME ---");
        
        System.out.print("Nome do filme: ");
        String nome = scanner.nextLine();
        
        System.out.print("Data de lançamento (dd/MM/yyyy): ");
        Date dataLancamento = lerData();
        
        System.out.print("Orçamento (em dólares): ");
        double orcamento = lerDouble();
        
        System.out.print("Descrição: ");
        String descricao = scanner.nextLine();
        
        // Selecionar diretor
        System.out.print("Nome do diretor: ");
        String nomeDiretor = scanner.nextLine();
        Diretor diretor = catalogo.buscarDiretor(nomeDiretor);
        
        if (diretor == null) {
            System.out.println("Diretor não encontrado! Filme será cadastrado sem diretor.");
        }
        
        Filme filme = new Filme(nome, dataLancamento, orcamento, descricao, diretor);
        catalogo.adicionarFilme(filme);
        
        System.out.println("\nFilme cadastrado com sucesso!");
    }
    
    private static void menuAssociarAtorFilme() {
        int opcao;
        do {
            System.out.println("\n--- ASSOCIAR ATOR A FILME ---");
            System.out.println("1. Associar ator a filme");
            System.out.println("0. Voltar ao menu principal");
            System.out.print("Escolha uma opção: ");
            
            opcao = lerOpcao();
            
            switch (opcao) {
                case 1:
                    limparConsole();
                    associarAtorFilme();
                    pausar();
                    limparConsole();
                    break;
                case 0:
                    limparConsole();
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
                    pausar();
                    limparConsole();
            }
        } while (opcao != 0);
    }
    
    private static void associarAtorFilme() {
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
            return;
        }
        
        filme.adicionarAtor(ator);
        System.out.println("\nAtor associado ao filme com sucesso!");
    }
    
    private static void menuPesquisarFilmes() {
        int opcao;
        do {
            System.out.println("\n--- PESQUISAR FILMES ---");
            System.out.println("1. Pesquisar filmes");
            System.out.println("0. Voltar ao menu principal");
            System.out.print("Escolha uma opção: ");
            
            opcao = lerOpcao();
            
            switch (opcao) {
                case 1:
                    limparConsole();
                    pesquisarFilmes();
                    pausar();
                    limparConsole();
                    break;
                case 0:
                    limparConsole();
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
                    pausar();
                    limparConsole();
            }
        } while (opcao != 0);
    }
    
    private static void pesquisarFilmes() {
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
    
    private static void menuListarFilmes() {
        int opcao;
        do {
            System.out.println("\n--- LISTAR FILMES ---");
            System.out.println("1. Ver todos os filmes");
            System.out.println("0. Voltar ao menu principal");
            System.out.print("Escolha uma opção: ");
            
            opcao = lerOpcao();
            
            switch (opcao) {
                case 1:
                    limparConsole();
                    listarFilmes();
                    pausar();
                    limparConsole();
                    break;
                case 0:
                    limparConsole();
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
                    pausar();
                    limparConsole();
            }
        } while (opcao != 0);
    }
    
    private static void listarFilmes() {
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
    
    private static void menuListarAtores() {
        int opcao;
        do {
            System.out.println("\n--- LISTAR ATORES ---");
            System.out.println("1. Ver todos os atores");
            System.out.println("0. Voltar ao menu principal");
            System.out.print("Escolha uma opção: ");
            
            opcao = lerOpcao();
            
            switch (opcao) {
                case 1:
                    limparConsole();
                    listarAtores();
                    pausar();
                    limparConsole();
                    break;
                case 0:
                    limparConsole();
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
                    pausar();
                    limparConsole();
            }
        } while (opcao != 0);
    }
    
    private static void listarAtores() {
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
    
    private static void menuListarDiretores() {
        int opcao;
        do {
            System.out.println("\n--- LISTAR DIRETORES ---");
            System.out.println("1. Ver todos os diretores");
            System.out.println("0. Voltar ao menu principal");
            System.out.print("Escolha uma opção: ");
            
            opcao = lerOpcao();
            
            switch (opcao) {
                case 1:
                    limparConsole();
                    listarDiretores();
                    pausar();
                    limparConsole();
                    break;
                case 0:
                    limparConsole();
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
                    pausar();
                    limparConsole();
            }
        } while (opcao != 0);
    }
    
    private static void listarDiretores() {
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
    
    private static void menuEstatisticas() {
        int opcao;
        do {
            System.out.println("\n--- ESTATÍSTICAS ---");
            System.out.println("1. Ver estatísticas do catálogo");
            System.out.println("0. Voltar ao menu principal");
            System.out.print("Escolha uma opção: ");
            
            opcao = lerOpcao();
            
            switch (opcao) {
                case 1:
                    limparConsole();
                    exibirEstatisticas();
                    pausar();
                    limparConsole();
                    break;
                case 0:
                    limparConsole();
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
                    pausar();
                    limparConsole();
            }
        } while (opcao != 0);
    }
    
    private static void exibirEstatisticas() {
        System.out.println("\n--- ESTATÍSTICAS DO CATÁLOGO ---");
        System.out.println(catalogo.getEstatisticas());
    }
    
    private static Date lerData() {
        while (true) {
            try {
                String dataStr = scanner.nextLine();
                return dateFormat.parse(dataStr);
            } catch (ParseException e) {
                System.out.print("Data inválida! Use o formato dd/MM/yyyy: ");
            }
        }
    }
    
    private static double lerDouble() {
        while (true) {
            try {
                String valor = scanner.nextLine();
                return Double.parseDouble(valor);
            } catch (NumberFormatException e) {
                System.out.print("Valor inválido! Digite um número: ");
            }
        }
    }
    
    /**
     * Limpa o console para melhor navegação
     */
    private static void limparConsole() {
        try {
            // Para Windows
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                // Para Linux/Mac
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (Exception e) {
            // Se não conseguir limpar, apenas adiciona algumas linhas em branco
            for (int i = 0; i < 50; i++) {
                System.out.println();
            }
        }
    }
    
    /**
     * Pausa a execução até o usuário pressionar Enter
     */
    private static void pausar() {
        System.out.println("\nPressione Enter para continuar...");
        scanner.nextLine();
    }
    
    /**
     * Carrega alguns dados de exemplo para demonstrar o sistema
     */
    private static void carregarDadosExemplo() {
        try {
            // Atores
            Ator leonardoDiCaprio = new Ator("Leonardo DiCaprio", dateFormat.parse("11/11/1974"), "Americano");
            Ator kateWinslet = new Ator("Kate Winslet", dateFormat.parse("05/10/1975"), "Britânica");
            Ator robertDowneyJr = new Ator("Robert Downey Jr.", dateFormat.parse("04/04/1965"), "Americano");
            
            catalogo.adicionarAtor(leonardoDiCaprio);
            catalogo.adicionarAtor(kateWinslet);
            catalogo.adicionarAtor(robertDowneyJr);
            
            // Diretores
            Diretor jamesCameron = new Diretor("James Cameron", dateFormat.parse("16/08/1954"), "Canadense");
            Diretor christopherNolan = new Diretor("Christopher Nolan", dateFormat.parse("30/07/1970"), "Britânico");
            
            catalogo.adicionarDiretor(jamesCameron);
            catalogo.adicionarDiretor(christopherNolan);
            
            // Filmes
            Filme titanic = new Filme("Titanic", dateFormat.parse("19/12/1997"), 200000000.0, 
                "Um épico romance e desastre de 1997 dirigido por James Cameron", jamesCameron);
            titanic.adicionarAtor(leonardoDiCaprio);
            titanic.adicionarAtor(kateWinslet);
            
            Filme inception = new Filme("A Origem", dateFormat.parse("16/07/2010"), 160000000.0, 
                "Um ladrão que rouba segredos corporativos através da tecnologia de compartilhamento de sonhos", christopherNolan);
            inception.adicionarAtor(leonardoDiCaprio);
            
            catalogo.adicionarFilme(titanic);
            catalogo.adicionarFilme(inception);
            
        } catch (ParseException e) {
            System.out.println("Erro ao carregar dados de exemplo: " + e.getMessage());
        }
    }
}
