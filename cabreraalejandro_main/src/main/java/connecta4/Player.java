package connecta4;

/**
 * Classe que representa un jugador en el joc Connecta 4.
 */
public class Player {
    private String name; // Nom del jugador
    private int wins; // Nombre de victòries del jugador
    private char ficha; // Ficha del jugador ('X' o 'O')

    /**
     * Constructor de jugador.
     * @param name Nom del jugador
     * @param ficha Ficha del jugador ('X' o 'O')
     */
    public Player(String name, char ficha) {
        this.name = name;
        this.ficha = ficha;
        this.wins = 0; // Inicialitza les victòries a 0
    }

    /**
     * Obté el nom del jugador.
     * @return Nom del jugador
     */
    public String getName() {
        return name;
    }

    /**
     * Estableix el nom del jugador.
     * @param name Nou nom del jugador
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Obté el nombre de victòries del jugador.
     * @return Nombre de victòries
     */
    public int getWins() {
        return wins;
    }

    /**
     * Estableix el nombre de victòries del jugador.
     * @param wins Nou nombre de victòries
     */
    public void setWins(int wins) {
        this.wins = wins;
    }

    /**
     * Obté la ficha del jugador.
     * @return Ficha del jugador ('X' o 'O')
     */
    public char getFicha() {
        return ficha;
    }

    /**
     * Afegeix una victòria al jugador si el nom coincideix.
     * @param jugador Nom del jugador que ha guanyat
     * @return true si s'ha afegit la victòria, false en cas contrari
     */
    public boolean afegirVictoria(String jugador){ 
        if (jugador.equals(this.name)){
            this.wins++; // Incrementa el nombre de victòries
            return true;
        }
        return false;
    }
}