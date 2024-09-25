package connecta4;

public class Game {
Player player1;
Player player2;
Table main_Table;

public Game(Player player1, Player player2, Table main_Table) {
    this.player1 = player1;
    this.player2 = player2;
    this.main_Table = main_Table;
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

public boolean remakeGame (String confirmation){
if (confirmation.toUpperCase() == "Y") {
    return true;
} else {
    return false;
}
}
public void printTable(){
for (int i = 0; i < array.length; i++) {
    
}

}

}
