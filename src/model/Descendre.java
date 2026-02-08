package model;

/**
 * Cette classe représente un thread chargé de simuler la gravité.
 * 
 * Son rôle est de faire redescendre automatiquement le cercle
 * lorsqu'il n'y a pas d'interaction de l'utilisateur.
 * 
 * Ce thread agit uniquement sur le modèle (Position)
 * et ne s'occupe pas de l'affichage.
 */
public class Descendre extends Thread {

    /** Référence vers le modèle contenant la position du cercle */
    private final Position position;

    /** Temps d'attente entre deux mises à jour (en millisecondes) */
    public static final int DELAY = 100;

    /**
     * Constructeur du thread.
     * 
     * @param position le modèle Position à modifier
     */
    public Descendre(Position position) {
        this.position = position;
    }

    /**
     * Méthode exécutée lors du démarrage du thread.
     * 
     * La boucle infinie :
     * - applique la gravité au cercle
     * - attend un court délai pour contrôler la vitesse
     */
    @Override
    public void run() {
        while (true) {

            // Fait redescendre le cercle dans le modèle
            position.move();

            try {
                // Pause pour une descente progressive
                Thread.sleep(DELAY);
            } catch (InterruptedException e) {
                // Arrêt propre du thread en cas d'interruption
                return;
            }
        }
    }
}
