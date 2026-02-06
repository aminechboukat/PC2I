package model;
import java.awt.Point;

import java.util.ArrayList;
import java.util.Random;

import model.Position;


/**
 * 
 * Cette classe représente la ligne brisée du jeu.
 * Le parcours est une suite de points (x, y) générés aléatoirement.
 * Ces points sont définis dans le modèle (repère logique du jeu),
 * et seront ensuite transformés pour être affichés dans la vue.
 */
public class Parcours {

    /** Générateur de nombres aléatoires utilisé pour créer le parcours */
    public static final Random RAND = new Random();

    /** Écart minimum en X entre deux points successifs */
    public static final int X_MIN = 20;

    /** Écart maximum en X entre deux points successifs */
    public static final int X_MAX = 50;

    /** Liste contenant tous les points du parcours */
    private ArrayList<Point> points;

    private Position position;


    /**
     * Constructeur de la classe Parcours initialise la liste de points puis appelle une méthode
     * qui génère automatiquement la ligne brisée.
     */
    public Parcours(Position position) {
        this.position = position;
        points = new ArrayList<>();
        genererParcours();
    }

    /**
     * Génère la ligne brisée du parcours 
     * - Les points sont générés de gauche à droite (X croissant)
     * - Les deux premiers points ont la même hauteur (ligne horizontale)
     * - Les points suivants ont une hauteur aléatoire comprise
     *   entre H_MIN et H_MAX
     * - La génération s'arrête lorsque l'on dépasse l'horizon visible
     */
    private void genererParcours() {

        // Position initiale en X : avant l'horizon visible
        int x = -Position.BEFORE;

        // Hauteur initiale du parcours (au même niveau que l'ovale)
        int y = 0;

        // Ajout du premier point
        points.add(new Point(x, y));

        // Ajout du deuxième point, horizontal par rapport au premier
        x += X_MIN;
        points.add(new Point(x, y));

        // Génération des points suivants jusqu'à dépasser la zone visible
        while (x < Position.BEFORE + Position.AFTER) {

            // Décalage aléatoire en X entre X_MIN et X_MAX
            int dx = X_MIN + RAND.nextInt(X_MAX - X_MIN + 1);
            x += dx;

            // Hauteur aléatoire comprise entre H_MIN et H_MAX
            int dy = RAND.nextInt(Position.H_MAX - Position.H_MIN + 1)
                     + Position.H_MIN;

            // Ajout du nouveau point au parcours
            points.add(new Point(x, dy));
        }
    }

    /**
     * Accesseur permettant à la vue d'obtenir la liste des points.
     * @return la liste des points du parcours
     */
    public ArrayList<Point> getPoints() {
    	  ArrayList<Point> pointsDecales = new ArrayList<>();

    	    for (Point p : points) {
    	        int x = p.x - position.getAvancement();
    	        int y = p.y;
    	        pointsDecales.add(new Point(x, y));
    	    }

    	    return pointsDecales;
    }

    /**
     * Méthode de test permet de vérifier que les points du parcours
     * sont bien générés avant de les afficher dans la vue.
     */
    public static void main(String[] args) {
        Position pos = new Position();
        Parcours p = new Parcours(pos);

        for (Point point : p.getPoints()) {
            System.out.println(point);
        }
    }


	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}
}
