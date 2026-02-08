package model;

/**
 * Cette classe représente le MODELE du jeu.
 * 
 * Elle contient l'état du cercle :
 * - sa hauteur verticale
 * - son avancement horizontal
 * 
 * Elle ne contient aucune logique graphique
 * et ne dépend pas de la vue.
 */
public class Position {

    /** Valeur ajoutée à la hauteur lors d'un saut */
    public static final int IMPULSION = 10;

    /** Taille logique du cercle dans le modèle */
    public static final int HAUTEUR_OVALE = 10;

    /** Hauteur minimale autorisée pour le cercle */
    public static final int H_MIN = -20;

    /** Hauteur maximale autorisée pour le cercle */
    public static final int H_MAX = 50;

    /** Distance visible avant la position du cercle */
    public static final int BEFORE = 200;

    /** Distance visible après la position du cercle */
    public static final int AFTER = 50;

    /** Hauteur actuelle du cercle dans le modèle */
    private int hauteur = H_MIN;

    /** Avancement horizontal du jeu (défilement du parcours) */
    private int avancement = 0;

    // Indique si le cercle est en collision avec la ligne
    private boolean collision = false;


    /**
     * Accesseur de la hauteur du cercle.
     * 
     * @return la hauteur actuelle du cercle
     */
    public int getHauteur() {
        return hauteur;
    }

    /**
     * Accesseur de l'avancement horizontal.
     * 
     * @return la valeur d'avancement
     */
    public int getAvancement() {
        return avancement;
    }

    /**
     * Méthode appelée lors d'un clic souris.
     * 
     * Elle simule un saut du cercle en augmentant sa hauteur.
     * La hauteur est limitée afin de rester dans la zone visible.
     */
    public void jump() {
        hauteur += IMPULSION;
        if (hauteur > H_MAX) {
            hauteur = H_MAX;
        }
    }

    /**
     * Méthode appelée automatiquement par le thread Descendre.
     * 
     * Elle simule la gravité :
     * le cercle redescend progressivement jusqu'à la hauteur minimale.
     */
    public void move() {
        if (hauteur > H_MIN) {
            hauteur--;
        }
    }

    /**
     * Fait avancer le jeu horizontalement.
     * 
     * Le cercle reste fixe dans la vue ;
     * c'est le parcours qui se déplace en sens inverse.
     */
    public void avancer() {
        avancement++;
    }

    public boolean isCollision() {
    return collision;
}

public void setCollision(boolean collision) {
    this.collision = collision;
}

}
