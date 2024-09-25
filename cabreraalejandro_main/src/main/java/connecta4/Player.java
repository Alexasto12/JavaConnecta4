package connecta4;

public class Player {
String name;
int wins;


/** Constructor de jugador
 * @param name
 */
public Player(String name) {
    this.name = name;
    wins = 0;
}
public String getname() {
    return name;
}
public void setname(String name) {
    this.name = name;
}
public int getWins() {
    return wins;
}
public void setWins(int wins) {
    this.wins = wins;
}

}
