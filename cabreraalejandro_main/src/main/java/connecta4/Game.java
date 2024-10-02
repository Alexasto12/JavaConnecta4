package connecta4;

public class Game {
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

        System.out.println("  " + "--".repeat(taulell[0].length));
        for (int row = 0; row < taulell.length; row++) {
            System.out.print((row + 1) + " |");
            for (int col = 0; col < taulell[0].length; col++) {
                System.out.print(taulell[row][col]);
                System.out.print("|");
            }
            System.out.println();
            System.out.println("  " + ("--".repeat(taulell[0].length)));
        }
        System.out.print("  ");
        for (int i = 1; i <= taulell[0].length; i++) {
            System.out.print(" " + i);
        }
        System.out.println();
    }

    
    public void tirada(char[][] taulell, int columna) {
        columna -= 1;
        this.turns++;
        boolean torbat = false;
        // Recorro de forma recursiva per comprobar primer l'ultim index
        do{
            
            for (int i = taulell.length - 1; i >= 0; i--) {
                if (torbat){
                    break;
                }
                for (int j = 0; j < taulell.length; j++) {
                    if (taulell[i][columna] == ' ') {
                        taulell[i][columna] = asignFitxa();
                        torbat = true;
                    }
                }
            }
        }while (!torbat);
        
    }
    public boolean comprobarVictoria(){
        boolean victoria = false;
        int matches = 0;
        for (int i = 0; i < this.main_Table.grid.length; i++) {
            for (int j = 0; j < this.main_Table.grid[0].length; j++) {
                if (this.main_Table.grid[i][j] == asignFitxa()) {
                    matches++;
                    if(matches == 4){
                        victoria = true;
                    }
                }
            }

        }
        return victoria;
    }
    
    
    /**Metode per assignar un caracter cada torn, si es parell asigna un i si és imparell un altre
     * @return Un char 
     */
    public char asignFitxa (){
        char fitxa;
        if (this.turns % 2 == 0) {
            fitxa = 'X';
        } else {
            fitxa = '0';
        }
        return fitxa;
    }

}
