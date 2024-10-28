package connecta4;

import java.util.Scanner;

public class Main {
    public static final String RESET = "\u001B[0m";
    public static final String BLACK = "\u001B[30m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static final String PURPLE = "\u001B[35m";
    public static final String CYAN = "\u001B[36m";
    public static final String WHITE = "\u001B[37m";

    public static void main(String[] args) {
        // Utilizem la clase Scanner per llegir l'input de l'usuari
        Scanner input = new Scanner(System.in);

        // Preguntem el nom dels jugador i creem nous objectes "Player".
        System.out.println("Introdueix el nom del jugador 1");
        Player player1 = new Player(input.nextLine(), 'X');
        System.out.println("Introdueix el nom del jugador 2");
        Player player2 = new Player(input.nextLine(), 'O');

        // Ara crearem un nou Taulell indicant el nombre de files i columnes
        Table main_Table = null;
        System.out.println("Introdueix el nombre de files");
        int files = input.nextInt();
        System.out.println("Introudeix el nombre de columnes");
        int columnes = input.nextInt();

        while (files < 4 || files > 9 || columnes < 4 || columnes > 9) {
            System.out.println("El nombre de files i columnes ha de ser entre 4 i 9");
            System.out.println("Introdueix el nombre de files");
            files = input.nextInt();
            System.out.println("Introudeix el nombre de columnes");
            columnes = input.nextInt();

        }
        main_Table = new Table(files, columnes);

        // Amb aixó ja podem crear un objecte Game a qui li pasarem els jugadors i
        // taulell per parametre
        Game game1 = null;
        boolean victoria = false;
        String jugador;
        boolean empat;
        do {
            main_Table.getArray();
            game1 = new Game(player1, player2, main_Table);
            game1.printTable(main_Table.grid);
            victoria = false;
            empat = false;
            do {
                jugador = game1.getTurns() % 2 == 0 ? player1.getName() : player2.getName();
                char fitxa = game1.getTurns() % 2 == 0 ? player1.getFicha() : player2.getFicha();
                System.out.println(jugador.toUpperCase() + " és el teu torn");
                System.out.println("Introdueix la columna on vols tirar " + ":");
                int selectedColumn = input.nextInt();
                while (selectedColumn <= 0 || selectedColumn > columnes) {
                    System.out.println("Columna no vàlida, introdueix una altra columna");
                    selectedColumn = input.nextInt();

                }
                // Comprova si la columna està plena
                while (game1.columnaPlena(selectedColumn)) {
                    System.out.println("La columna està plena, introdueix una altra columna");
                    selectedColumn = input.nextInt();
                }
                // Realitza la tirada en la columna seleccionada
                game1.tirada(main_Table.grid, selectedColumn, fitxa);
                // Imprimeix el taulell actualitzat
                game1.printTable(main_Table.grid);
                // Comprova si hi ha una victòria
                victoria = game1.comprovaVictoria(fitxa);
                // Comprova si hi ha un empat
                empat = game1.comprovaEmpat();
            } while (!victoria && !empat); // Continua fins que hi hagi una victòria o un empat

            // Si hi ha un empat, imprimeix el missatge d'empat
            if (empat) {
                System.out.println("Empat!");
            } else {
                // Si hi ha una victòria, imprimeix el missatge de victòria
                System.out.println(jugador + " has guanyat!");
            }

            // Actualitza el nombre de victòries del jugador guanyador
            if (player1.afegirVictoria(jugador)) {
                System.out.println("El jugador " + player1.getName() + " té " + player1.getWins() + " victòries");
                System.out.println("El jugador " + player2.getName() + " té " + player2.getWins() + " victòries");
            } else {
                player2.afegirVictoria(jugador);
                System.out.println("El jugador " + player1.getName() + " té " + player1.getWins() + " victòries");
                System.out.println("El jugador " + player2.getName() + " té " + player2.getWins() + " victòries");
            }

            // Pregunta si es vol tornar a jugar
            System.out.println("Vols tornar a jugar? Y/N");
        } while (game1.remakeGame(input.next())); // Continua el bucle si la resposta és "Y"

        // Tanca l'input
        input.close();
    }
}
