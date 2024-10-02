package connecta4;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Utilizem la clase Scanner per llegir l'input de l'usuari
        Scanner input = new Scanner(System.in);
        
        // Preguntem el nom dels jugador i creem nous objectes "Player".
        System.out.println("Introdueix el nom del jugador 1");
        Player player1 = new Player(input.nextLine());
        System.out.println("Introdueix el nom del jugador 2");
        Player player2 = new Player(input.nextLine());
        
        // Ara crearem un nou Taulell indicant el nombre de files i columnes
        
        System.out.println("Introdueix el nombre de files");
        Table main_Table = new Table(input.nextInt(), 1);
        System.out.println("Introudeix el nombre de columnes");
        main_Table.setColumns(input.nextInt());
        main_Table.getArray();
        
        // Amb aixó ja podem crear un objecte Game a qui li pasarem els jugadors i
        // taulell per parametre
        
        Game game1 = new Game(player1, player2, main_Table);
        game1.printTable(main_Table.grid);
        do {
            boolean victoria = false;
            do{

                System.out.println("Introdueix la columna on vols tirar:");
                int selectedColumn = input.nextInt();
                game1.tirada(main_Table.grid, selectedColumn);
                game1.printTable(main_Table.grid);
                victoria = game1.comprobarVictoria();
            }while(!victoria);
            System.out.println("Vols tornar a jugar? Y/N");
        } while (!game1.remakeGame(input.next()));
        
        
    }
}