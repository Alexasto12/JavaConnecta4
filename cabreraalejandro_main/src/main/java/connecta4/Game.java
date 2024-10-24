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

    private Player player1;
    private Player player2;
    private int turns;
    private Table main_Table;

    /**
     * Constructor de la classe Game.
     * Inicialitza els jugadors, el comptador de torns i el taulell del joc.
     *
     * @param player1 El primer jugador.
     * @param player2 El segon jugador.
     * @param main_Table El taulell del joc.
     */
    public Game(Player player1, Player player2, Table main_Table) {
        this.player1 = player1;
        this.player2 = player2;
        this.turns = 0;
        this.main_Table = main_Table;
    }

    /**
     * Obté el primer jugador.
     *
     * @return El primer jugador.
     */
    public Player getPlayer1() {
        return player1;
    }

    /**
     * Estableix el primer jugador.
     *
     * @param player1 El primer jugador.
     */
    public void setPlayer1(Player player1) {
        this.player1 = player1;
    }

    /**
     * Obté el segon jugador.
     *
     * @return El segon jugador.
     */
    public Player getPlayer2() {
        return player2;
    }

    /**
     * Estableix el segon jugador.
     *
     * @param player2 El segon jugador.
     */
    public void setPlayer2(Player player2) {
        this.player2 = player2;
    }

    /**
     * Obté el nombre de torns.
     *
     * @return El nombre de torns.
     */
    public int getTurns() {
        return turns;
    }

    /**
     * Estableix el nombre de torns.
     *
     * @param turns El nombre de torns.
     */
    public void setTurns(int turns) {
        this.turns = turns;
    }

    public Table getMain_Table() {
        return main_Table;
    }

    public void setMain_Table(Table main_Table) {
        this.main_Table = main_Table;
    }

    public boolean remakeGame(String respuesta) {
        return respuesta.toUpperCase().equals("Y");
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

    public void tirada(char[][] taulell, int columna, char fitxa) {
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
                        taulell[i][columna] = fitxa;
                        torbat = true;
                    }
                }
            }
        } while (!torbat);
    }

    public boolean comprovaVictoria(char fitxa) {
        char jugador = fitxa;
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

    public boolean validarColumnaTirada(int columna) {
        if (columna < 1 ) {
            return false;
        }
        if (columna > this.main_Table.getColumns()) {
            return false;
            
        }
        return true;
            
    }

    public boolean comprovaEmpat(){
        return this.turns == (this.main_Table.getColumns() * this.main_Table.getRows()) - 8; // -8 perque a partir de 4 tirades restants ja no es pot guanyar
    }

    /**
     * Comprova si una columna està plena.
     *
     * @param columna L'índex de la columna a verificar.
     * @return true si la columna està plena, false en cas contrari.
     */
    public boolean columnaPlena(int columna) {
        for (int i = 0; i < this.main_Table.grid.length; i++) {
            if (this.main_Table.grid[i][columna-1] == ' ') {
                return false;
            }
        }
        return true;
    }
}
