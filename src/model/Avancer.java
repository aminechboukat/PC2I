package model;

/**
 * Cette classe représente un thread chargé du défilement horizontal du jeu.
 * 
 * Son rôle est de faire avancer le jeu dans le temps :
 * - l'avancement horizontal est incrémenté
 * - le parcours est mis à jour pour rester infini
 * 
 * Ce thread agit uniquement sur le modèle
 * et ne s'occupe pas de l'affichage.
 */
public class Avancer extends Thread {

    /** Référence vers le modèle Position (avancement du jeu) */
    private final Position position;

    /** Référence vers le modèle Parcours (ligne brisée) */
    private final Parcours parcours;

    /**
     * Constructeur du thread.
     * 
     * @param position le modèle Position à modifier
     * @param parcours le modèle Parcours à mettre à jour
     */
    public Avancer(Position position, Parcours parcours) {
        this.position = position;
        this.parcours = parcours;
    }

    /**
     * Méthode exécutée lors du démarrage du thread.
     * 
     * La boucle infinie :
     * - fait avancer le jeu horizontalement
     * - met à jour le parcours pour le rendre infini
     * - attend un court délai pour contrôler la vitesse
     */
    @Override
    public void run() {
        while (true) {

            // Incrémentation de l'avancement horizontal
            position.avancer();

            // Mise à jour du parcours (fonctionnalité séance 4)
            parcours.update();

            try {
                // Pause pour réguler la vitesse du jeu
                Thread.sleep(50);
            } catch (InterruptedException e) {
                // Arrêt propre du thread en cas d'interruption
                return;
            }
        }
    }
}
