package service;

import model.Ator;
import model.Diretor;
import model.Filme;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class CarregarDados {
    private static SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    
     
    /**
     * Carrega alguns dados de exemplo para demonstrar o sistema
     */
    public static void carregarDadosExemplo(CatalogoFilmes catalogo) {
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

            Filme F1 = new Filme("F1", dateFormat.parse("16/07/2010"), 160000000.0, 
                "Um ladrão que rouba segredos corporativos através da tecnologia de compartilhamento de sonhos");
            
            catalogo.adicionarFilme(titanic);
            catalogo.adicionarFilme(inception);
            catalogo.adicionarFilme(F1);
            
        } catch (ParseException e) {
            System.out.println("Erro ao carregar dados de exemplo: " + e.getMessage());
        }
    }
}