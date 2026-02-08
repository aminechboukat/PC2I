package control;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import model.Position;

/**
 * Cette classe correspond au CONTROLEUR dans l'architecture MVC.
 * 
 * Elle gère les interactions de l'utilisateur avec la souris.
 * Lors d'un clic, elle modifie le modèle
 * en demandant un saut du cercle.
 */
public class ReactionClic extends MouseAdapter {

    /** Référence vers le modèle contenant la position du cercle */
    private final Position position;

    /**
     * Constructeur du contrôleur.
     * 
     * @param position le modèle Position à modifier lors d'un clic
     */
    public ReactionClic(Position position) {
        this.position = position;
    }

    /**
     * Méthode appelée automatiquement par Swing
     * lorsqu'un clic souris est détecté.
     * 
     * Elle ne modifie pas directement l'affichage :
     * elle se contente de mettre à jour le modèle.
     */
    @Override
    public void mouseClicked(MouseEvent e) {
        position.jump();
    }
}
