package utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class catalogUtils {
    private static Scanner scanner = new Scanner(System.in);
    private static SimpleDateFormat dateFormat =  new SimpleDateFormat("dd/MM/yyyy");
    public static int lerOpcao() {

        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    /**
     * Limpa o console para melhor navegação
     */
    public static void limparConsole() {
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

    public static void pausar() {
        System.out.println("\nPressione Enter para continuar...");
        scanner.nextLine();
    }


    public static Date lerData() {
        while (true) {
            try {
                String dataStr = scanner.nextLine();
                return dateFormat.parse(dataStr);
            } catch (ParseException e) {
                System.out.print("Data inválida! Use o formato dd/MM/yyyy: ");
            }
        }
    }

    public static double lerDouble() {
        while (true) {
            try {
                String valor = scanner.nextLine();
                return Double.parseDouble(valor);
            } catch (NumberFormatException e) {
                System.out.print("Valor inválido! Digite um número: ");
            }
        }
    }

}
