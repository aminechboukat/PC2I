package model;

/**
  
 * Cette classe représente le modèle du jeu.
 * Elle contient les données qui définissent l'état du cercle :
 * - sa hauteur
 * - les limites de déplacement
 * 
 * La vue ne modifie jamais directement ces valeurs :
 * elle les lit seulement pour afficher le cercle.
 */
public class Position {

    /** Valeur ajoutée à la hauteur à chaque saut */
    public static final int IMPULSION = 10;

    /** Hauteur logique de l'ovale dans le modèle */
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

     /* Avancement horizontal */
    private int avancement = 0;


    /**
     * Accesseur permettant de connaître la hauteur actuelle du cercle.
     * @return la hauteur du cercle
     */
    public int getHauteur() {
        return hauteur;
    }


    public int getAvancement() {
        return avancement;
    }

    /**
     * Méthode appelée lors d'un clic de l'utilisateur.
     * 
     * Elle simule un saut :
     * - la hauteur augmente d'une valeur fixe
     * - la hauteur est limitée à H_MAX pour éviter de sortir de la zone visible
     */
    public void jump() {
        hauteur += IMPULSION;

        // Limite haute : le cercle ne peut pas monter indéfiniment
        if (hauteur > H_MAX) {
            hauteur = H_MAX;
        }
    }

    /**
     * Méthode appelée automatiquement par le thread Descendre.
     * 
     * Elle simule la gravité :
     * - la hauteur diminue progressivement
     * - la descente s'arrête lorsque la hauteur minimale est atteinte
     */
    public void move() {
        if (hauteur > H_MIN) {
            hauteur--;
        }
    }

 /**
     * Fait avancer le cercle dans le parcours.
     * L’ovale reste fixe dans la vue,
     * c’est la ligne brisée qui se déplace en sens inverse.
     */
        public void avancer() {
        avancement++;
    }
}
