package view;

import java.awt.*;
import javax.swing.*;
import model.Parcours;
import model.Position;

/**
 * Cette classe correspond à la VUE dans l'architecture MVC.
 * 
 * Son rôle est uniquement graphique :
 * - dessiner le parcours (ligne brisée)
 * - dessiner le cercle
 * 
 * Elle ne modifie jamais le modèle :
 * elle lit les données du modèle pour les afficher.
 */
public class Affichage extends JPanel {

    /** Facteur de conversion horizontal (modèle → vue) */
    public static final int RATIO_X = 2;

    /** Facteur de conversion vertical (modèle → vue) */
    public static final int RATIO_Y = 5;

    /** Référence vers le modèle représentant le parcours */
    private Parcours parcours;

    /** Référence vers le modèle représentant la position du cercle */
    private Position maPosition;

    /**
     * Constructeur de la vue.
     * 
     * Il reçoit les modèles à afficher et
     * définit la taille de la fenêtre en fonction
     * des constantes du modèle.
     * 
     * @param p le modèle Position (cercle)
     * @param parcours le modèle Parcours (ligne brisée)
     */
    public Affichage(Position p, Parcours parcours) {
        this.maPosition = p;
        this.parcours = parcours;

        // Définition de la taille de la fenêtre
        setPreferredSize(
            new Dimension(
                (Position.BEFORE + Position.AFTER) * RATIO_X,
                (Position.H_MAX - Position.H_MIN) * RATIO_Y
            )
        );
    }

    /**
     * Méthode appelée automatiquement par Swing
     * pour redessiner la fenêtre.
     * 
     * Elle transforme les coordonnées du modèle
     * en coordonnées de la vue puis effectue le dessin.
     */
    @Override
    public void paint(Graphics g) {
        super.paint(g); // Nettoie l'affichage avant de redessiner

        

        /*
         * Dessin de la ligne brisée (parcours)
         */
        for (int i = 0; i < parcours.getPoints().size() - 1; i++) {

            // Récupération de deux points consécutifs du modèle
            Point p1 = parcours.getPoints().get(i);
            Point p2 = parcours.getPoints().get(i + 1);

            // Conversion des coordonnées du modèle vers la vue
            int x1 = (p1.x + Position.BEFORE) * RATIO_X;
            int y1 = (Position.H_MAX - p1.y) * RATIO_Y;
            int x2 = (p2.x + Position.BEFORE) * RATIO_X;
            int y2 = (Position.H_MAX - p2.y) * RATIO_Y;

            // Dessin du segment entre les deux points
            g.drawLine(x1, y1, x2, y2);
        }

        /*
         * Dessin du cercle
         */

        // Dimensions du cercle dans la vue
        int largeur = Position.HAUTEUR_OVALE * RATIO_X;
        int hauteur = Position.HAUTEUR_OVALE * RATIO_Y;

        // Position du cercle dans la vue :
        // - X est fixe (le cercle reste au même endroit)
        // - Y dépend de la hauteur du modèle
        int x = Position.BEFORE * RATIO_X - largeur / 2;
        int y = (Position.H_MAX - maPosition.getHauteur()
                - Position.HAUTEUR_OVALE) * RATIO_Y;

        /*
         * Changement de couleur du cercle en fonction de sa hauteur.
         * Cela permet de visualiser son état.
            */
            if (maPosition.isCollision()) {
                g.setColor(Color.MAGENTA); // animation visuelle
            } else if (maPosition.getHauteur() > 20) {
                g.setColor(Color.RED);
            } else if (maPosition.getHauteur() > 0) {
                g.setColor(Color.ORANGE);
            } else {
                g.setColor(Color.BLUE);
            }


        // Dessin final du cercle
        g.drawOval(x, y, largeur, hauteur);
    }
}
