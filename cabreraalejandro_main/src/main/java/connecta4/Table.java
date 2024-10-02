package connecta4;


public class Table {
int rows;
int columns;
char [][] grid;


public Table(int rows, int columns) {
    this.rows = rows;
    this.columns = columns;
}
public int getRows() {
    return rows;
}

public void setRows(int rows) {
    this.rows = rows;
}

public int getColumns() {
    return columns;
}

public void setColumns(int columns) {
    this.columns = columns;
}



/** Aquest metode omple l'array de espais vuits
 * 
 */
public void getArray() {
    char [][] tableArray = new char [this.rows][this.columns];
    for (int i = 0; i < tableArray.length; i++) {
        for (int j = 0; j < tableArray[0].length; j++) {
            tableArray[i][j] = ' ';
        }
    }
    this.grid = tableArray.clone();

}
}
