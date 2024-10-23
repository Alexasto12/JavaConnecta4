package connecta4;

public class Game {
    public static final String RESET = "\u001B[0m";
    public static final String BLACK = "\u001B[30m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static final String PURPLE = "\u001B[35m";
    public static final String CYAN = "\u001B[36m";
    public static final String WHITE = "\u001B[37m";

    Player player1;
    Player player2;
    Table main_Table;
    int turns = 0;

    public Game(Player player1, Player player2, Table main_Table) {
        this.player1 = player1;
        this.player2 = player2;
        this.main_Table = main_Table;
        this.turns = 0;
    }

    public Player getPlayer1() {
        return player1;
    }

    public void setPlayer1(Player player1) {
        this.player1 = player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public void setPlayer2(Player player2) {
        this.player2 = player2;
    }

    public Table getMain_Table() {
        return main_Table;
    }

    public void setMain_Table(Table main_Table) {
        this.main_Table = main_Table;
    }

    public boolean remakeGame(String confirmation) {

        if (confirmation.toUpperCase() == "Y") {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Metode per imprimir taulell pasant-li una array de chars
     * 
     * @param char[][]
     */
    public void printTable(char[][] taulell) {

        System.out.println(PURPLE + "  " + "--".repeat(taulell[0].length) + RESET);
        for (int row = 0; row < taulell.length; row++) {
            System.out.print(GREEN + (row + 1) + " |");
            for (int col = 0; col < taulell[0].length; col++) {
                System.out.print(taulell[row][col] + GREEN);
                System.out.print("|" + GREEN);
            }
            System.out.println(RESET);
            System.out.println(PURPLE + "  " + ("--".repeat(taulell[0].length) + RESET));
        }
        System.out.print("  ");
        for (int i = 1; i <= taulell[0].length; i++) {
            System.out.print(GREEN + " " + i);
        }
        System.out.println(RESET);

    }

    public void tirada(char[][] taulell, int columna) {
        columna -= 1;
        this.turns++;
        boolean torbat = false;
        // Recorro de forma recursiva per comprobar primer l'ultim index
        do {

            for (int i = taulell.length - 1; i >= 0; i--) {
                if (torbat) {
                    break;
                }
                for (int j = 0; j < taulell.length; j++) {
                    if (taulell[i][columna] == ' ') {
                        taulell[i][columna] = asignFitxa();
                        torbat = true;
                    }
                }
            }
        } while (!torbat);

    }

    public boolean comprovaVictoria() {
        char jugador = asignFitxa();
        int files = this.main_Table.grid.length;
        int columnes = this.main_Table.grid[0].length;

        // Comprovar files
        for (int i = 0; i < files; i++) {
            for (int j = 0; j < columnes - 3; j++) { // -3 per no sortir del rang
                if (this.main_Table.grid[i][j] == jugador &&
                        this.main_Table.grid[i][j + 1] == jugador &&
                        this.main_Table.grid[i][j + 2] == jugador &&
                        this.main_Table.grid[i][j + 3] == jugador) {
                    return true;
                }
            }
        }

        // Comprovar columnes
        for (int i = 0; i < files - 3; i++) { // -3 per no sortir del rang
            for (int j = 0; j < columnes; j++) {
                if (this.main_Table.grid[i][j] == jugador &&
                        this.main_Table.grid[i + 1][j] == jugador &&
                        this.main_Table.grid[i + 2][j] == jugador &&
                        this.main_Table.grid[i + 3][j] == jugador) {
                    return true;
                }
            }
        }

        // Comprovar diagonal principal (de dalt a baix)
        for (int i = 0; i < files - 3; i++) {
            for (int j = 0; j < columnes - 3; j++) {
                if (this.main_Table.grid[i][j] == jugador &&
                        this.main_Table.grid[i + 1][j + 1] == jugador &&
                        this.main_Table.grid[i + 2][j + 2] == jugador &&
                        this.main_Table.grid[i + 3][j + 3] == jugador) {
                    return true;
                }
            }
        }

        // Comprovar diagonal inversa (de baix a dalt)
        for (int i = 3; i < files; i++) { // Comença des de 3 per evitar sortir del rang
            for (int j = 0; j < columnes - 3; j++) {
                if (this.main_Table.grid[i][j] == jugador &&
                        this.main_Table.grid[i - 1][j + 1] == jugador &&
                        this.main_Table.grid[i - 2][j + 2] == jugador &&
                        this.main_Table.grid[i - 3][j + 3] == jugador) {
                    return true;
                }
            }
        }

        return false; // No hi ha 4 en ratlla
    }

    /**
     * Metode per assignar un caracter cada torn, si es parell asigna un i si és
     * imparell un altre
     * 
     * @return Un char
     */
    public char asignFitxa() {
        char fitxa;
        if (this.turns % 2 == 0) {
            fitxa = 'X';
        } else {
            fitxa = '0';
        }
        return fitxa;
    }

}
