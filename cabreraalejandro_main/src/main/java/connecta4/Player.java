package connecta4;

public class Player {
    private String name;
    private int wins;
    private char ficha;

    /**
     * Constructor de jugador
     * @param name Nombre del jugador
     * @param ficha Ficha del jugador ('X' o 'O')
     */
    public Player(String name, char ficha) {
        this.name = name;
        this.ficha = ficha;
        this.wins = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public char getFicha() {
        return ficha;
    }

    public boolean afegirVictoria(String jugador){ 
        if (jugador.equals(this.name)){
            this.wins++;
            return true;

        }
        return false;
    }
}