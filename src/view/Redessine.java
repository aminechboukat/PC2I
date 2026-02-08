package view;

/**
 * Cette classe représente un thread de rafraîchissement de l'affichage.
 * 
 * Son rôle est de demander régulièrement à Swing
 * de redessiner la vue, afin d'obtenir une animation fluide.
 * 
 * Ce thread ne modifie pas le modèle :
 * il se contente d'appeler repaint() sur le composant graphique.
 */
public class Redessine extends Thread {

    /** Temps d'attente entre deux rafraîchissements (en millisecondes) */
    public static final int DELAY = 50;

    /** Composant graphique à redessiner */
    private final javax.swing.JComponent affichage;

    /**
     * Constructeur du thread.
     * 
     * @param affichage le composant Swing à rafraîchir
     */
    public Redessine(javax.swing.JComponent affichage) {
        this.affichage = affichage;
    }

    /**
     * Méthode exécutée lors du démarrage du thread.
     * 
     * La boucle infinie :
     * - demande le rafraîchissement de l'affichage
     * - attend un court délai pour limiter la fréquence
     */
    @Override
    public void run() {
        while (true) {
            // Demande à Swing de redessiner la vue
            affichage.repaint();

            try {
                // Pause pour contrôler la vitesse de rafraîchissement
                Thread.sleep(DELAY);
            } catch (InterruptedException e) {
                // Arrêt du thread en cas d'interruption
                return;
            }
        }
    }
}
