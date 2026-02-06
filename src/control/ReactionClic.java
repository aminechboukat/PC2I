package control;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import model.Position;

/**
 * 
 * Cette classe correspond au CONTRÔLEUR dans le modèle MVC.
 * Elle gère les interactions de l'utilisateur avec la souris.
 * 
 * Lorsqu'un clic est détecté dans la fenêtre,
 * le contrôleur modifie le modèle en demandant un saut du cercle.
 */
public class ReactionClic extends MouseAdapter {

    /** Référence vers le modèle contenant la position du cercle */
    private final Position position;

    /**
     * Constructeur du contrôleur.
     * 
     * @param position le modèle Position qui sera modifié lors d'un clic
     */
    public ReactionClic(Position position) {
        this.position = position;
    }

    /**
     * Méthode appelée automatiquement par Swing lors d'un clic souris.
     * 
     * Elle ne modifie pas directement l'affichage :
     * elle se contente de mettre à jour le modèle.
     * La vue sera ensuite rafraîchie par le thread Redessine.
     */
    @Override
    public void mouseClicked(MouseEvent e) {

        // Demande au modèle de faire sauter le cercle
        position.jump();
    }
}
