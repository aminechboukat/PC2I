package view;

import java.awt.*;
import javax.swing.*;
import model.Parcours;
import model.Position;

/**
 * Cette classe correspond à la VUE dans le modèle MVC.
 * Elle est responsable de l'affichage graphique :
 * - dessin du parcours (ligne brisée)
 * - dessin du cercle
 * 
 * Elle ne modifie jamais les données du modèle,
 * elle se contente de les lire pour les afficher.
 */
public class Affichage extends JPanel {

    /** Ratio de conversion en X entre le modèle et la vue */
    public static final int RATIO_X = 2;

    /** Ratio de conversion en Y entre le modèle et la vue */
    public static final int RATIO_Y = 5;

    /** Référence vers le parcours (ligne brisée du modèle) */
    private Parcours parcours;

    /** Référence vers la position du cercle (modèle) */
    private Position maPosition;

    /**
     * Constructeur de la vue.
     * 
     * @param p le modèle contenant la position du cercle
     * @param parcours le modèle contenant la ligne brisée
     */
    public Affichage(Position p, Parcours parcours) {
        this.maPosition = p;
        this.parcours = parcours;

        // Définition de la taille de la fenêtre à partir des constantes du modèle
        setPreferredSize(
            new Dimension(
                (Position.BEFORE + Position.AFTER) * RATIO_X,
                (Position.H_MAX - Position.H_MIN) * RATIO_Y
            )
        );
    }

    /**
     * Méthode appelée automatiquement par Swing pour redessiner la fenêtre.
     * 
     * Elle transforme les coordonnées du modèle en coordonnées de la vue
     * puis dessine le parcours et le cercle.
     */
    @Override
    public void paint(Graphics g) {
        super.paint(g); // Nettoie l'affichage avant de redessiner

        /* 
         * Dessin de la ligne brisée
        */
        for (int i = 0; i < parcours.getPoints().size() - 1; i++) {

            // Récupération de deux points consécutifs du modèle
            Point p1 = parcours.getPoints().get(i);
            Point p2 = parcours.getPoints().get(i + 1);

            // Transformation des coordonnées du modèle vers la vue
            int x1 = (p1.x + Position.BEFORE) * RATIO_X;
            int y1 = (Position.H_MAX - p1.y) * RATIO_Y;
            int x2 = (p2.x + Position.BEFORE) * RATIO_X;
            int y2 = (Position.H_MAX - p2.y) * RATIO_Y;

            // Dessin du segment entre les deux points
            g.drawLine(x1, y1, x2, y2);
        }

        

        // Taille du cercle dans la vue
        int largeur = Position.HAUTEUR_OVALE * RATIO_X;
        int hauteur = Position.HAUTEUR_OVALE * RATIO_Y;

        // Position du cercle :
        // - X est fixe
        // - Y dépend de la hauteur dans le modèle
        int x = Position.BEFORE * RATIO_X - largeur / 2;
        int y = (Position.H_MAX - maPosition.getHauteur()
                - Position.HAUTEUR_OVALE) * RATIO_Y;

        // Dessin du cercle
        g.drawOval(x, y, largeur, hauteur);
    }
}
