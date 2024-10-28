package connecta4;

/**
 * Classe que representa la taula del joc Connecta 4.
 */
public class Table {
    int rows; // Nombre de files de la taula
    int columns; // Nombre de columnes de la taula
    char[][] grid; // Matriu que representa la taula

    /**
     * Constructor de la taula.
     * @param rows Nombre de files
     * @param columns Nombre de columnes
     */
    public Table(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
    }

    /**
     * Obté el nombre de files de la taula.
     * @return Nombre de files
     */
    public int getRows() {
        return rows;
    }

    /**
     * Estableix el nombre de files de la taula.
     * @param rows Nou nombre de files
     */
    public void setRows(int rows) {
        this.rows = rows;
    }

    /**
     * Obté el nombre de columnes de la taula.
     * @return Nombre de columnes
     */
    public int getColumns() {
        return columns;
    }

    /**
     * Estableix el nombre de columnes de la taula.
     * @param columns Nou nombre de columnes
     */
    public void setColumns(int columns) {
        this.columns = columns;
    }

    /**
     * Omple la matriu de la taula amb espais buits.
     */
    public void getArray() {
        char[][] tableArray = new char[this.rows][this.columns];
        for (int i = 0; i < tableArray.length; i++) {
            for (int j = 0; j < tableArray[0].length; j++) {
                tableArray[i][j] = ' '; // Omple cada cel·la amb un espai buit
            }
        }
        this.grid = tableArray.clone(); // Clona la matriu a la variable grid
    }
}
