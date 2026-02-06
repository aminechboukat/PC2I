package control;

import model.Position;

/**
 * Thread qui fait "redescendre" automatiquement le cercle.
 * 
 * Idée est 
 * - Le modèle (Position) contient la hauteur du cercle.
 * - Si l’utilisateur ne clique pas, on veut simuler une gravité :
 *   on diminue la hauteur petit à petit.
 * 
 * Ce thread tourne en boucle et appelle position.move() régulièrement.
 */
public class Descendre extends Thread {

    /** Référence vers le modèle : on modifie la hauteur dans Position */
    private final Position position;

    /** Temps d’attente entre deux mises à jour (en millisecondes) */
    public static final int DELAY = 100;

    /**
     * Constructeur : on donne au thread le modèle à modifier.
     * @param position l'objet Position (modèle) qui contient la hauteur du cercle
     */
    public Descendre(Position position) {
        this.position = position;
    }

    /**
     * Code exécuté quand on démarre le thread avec start().
     * 
     * Boucle infinie :
     * 1) on demande au modèle de faire descendre le cercle (move)
     * 2) on attend DELAY ms pour ne pas aller trop vite
     */
    @Override
    public void run() {
        while (true) {

            // Fait descendre le cercle dans le modèle (ex: hauteur--)
            // La méthode move() doit aussi gérer les limites (ex: ne pas descendre sous H_MIN)
            position.move();

            try {
                // Pause : permet d'avoir une descente progressive et visible
                Thread.sleep(DELAY);

            } catch (InterruptedException e) {
                // Si le thread est interrompu, on arrête proprement la boucle
                return;
            }
        }
    }
}
