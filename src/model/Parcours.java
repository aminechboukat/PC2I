package model;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;

/**
 * Cette classe représente le parcours du jeu.
 * 
 * Le parcours est une ligne brisée composée de plusieurs points.
 * Il est stocké dans le modèle et sert uniquement de décor.
 * 
 * En séance 4, le parcours devient infini :
 * - les points sortant de la zone visible sont supprimés
 * - de nouveaux points sont ajoutés automatiquement à droite
 */
public class Parcours {

    /** Générateur de nombres aléatoires utilisé pour créer le parcours */
    public static final Random RAND = new Random();

    /** Distance minimale entre deux points consécutifs (axe X) */
    public static final int X_MIN = 20;

    /** Distance maximale entre deux points consécutifs (axe X) */
    public static final int X_MAX = 50;

    /** Liste des points constituant la ligne brisée */
    private final ArrayList<Point> points = new ArrayList<>();

    /** Référence vers la position du jeu (pour l'avancement horizontal) */
    private final Position position;

    /**
     * Constructeur du parcours.
     * 
     * Il initialise la liste des points et
     * génère les premiers segments visibles.
     * 
     * @param position la position du jeu (avancement)
     */
    public Parcours(Position position) {
        this.position = position;
        genererParcours();
    }

    /**
     * Génère les points initiaux du parcours.
     * 
     * Les points sont créés de gauche à droite,
     * en commençant avant la zone visible.
     */
    private void genererParcours() {
        int x = -Position.BEFORE;
        int y = 0;

        // Premier point du parcours
        points.add(new Point(x, y));

        // Deuxième point horizontal par rapport au premier
        x += X_MIN;
        points.add(new Point(x, y));

        // Génération des points suivants jusqu'à couvrir la zone visible
        while (points.get(points.size() - 1).x < Position.BEFORE + Position.AFTER) {
            ajouterPointApres(points.get(points.size() - 1));
        }
    }

    /**
     * Ajoute un nouveau point après un point existant.
     * 
     * Le nouveau point est généré avec :
     * - un décalage horizontal aléatoire
     * - une hauteur comprise entre H_MIN et H_MAX
     * 
     * @param last le dernier point du parcours
     */
    private void ajouterPointApres(Point last) {
        int dx = X_MIN + RAND.nextInt(X_MAX - X_MIN + 1);
        int x = last.x + dx;
        int y = RAND.nextInt(Position.H_MAX - Position.H_MIN + 1)
                + Position.H_MIN;

        points.add(new Point(x, y));
    }

    /**
     * Retourne les points du parcours adaptés à l'affichage.
     * 
     * Les coordonnées X sont décalées en fonction
     * de l'avancement horizontal afin de simuler le défilement.
     * 
     * @return une liste de points décalés pour la vue
     */
    public ArrayList<Point> getPoints() {
        ArrayList<Point> decales = new ArrayList<>();
        int a = position.getAvancement();

        for (Point p : points) {
            decales.add(new Point(p.x - a, p.y));
        }

        return decales;
    }

    /**
     * Met à jour le parcours pour le rendre infini.
     * 
     * À chaque appel :
     * - les points devenus invisibles à gauche sont supprimés
     * - de nouveaux points sont ajoutés à droite si nécessaire
     */
    public void update() {

        int a = position.getAvancement();

        // Suppression des points trop à gauche
        while (points.size() > 2) {
            if (points.get(1).x - a < -Position.BEFORE) {
                points.remove(0);
            } else {
                break;
            }
        }

        // Ajout de nouveaux points à droite
        while (points.get(points.size() - 1).x - a < Position.AFTER) {

            Point last = points.get(points.size() - 1);

            int dx = X_MIN + RAND.nextInt(X_MAX - X_MIN + 1);
            int x = last.x + dx;
            int y = RAND.nextInt(Position.H_MAX - Position.H_MIN + 1)
                    + Position.H_MIN;

            points.add(new Point(x, y));
        }
    }

    /**
 * Calcule la hauteur de la ligne à une abscisse donnée (modèle).
 * Utilisé pour la détection de collision.
 */
public int getYLignePourX(int x) {
    for (int i = 0; i < points.size() - 1; i++) {
        Point p1 = points.get(i);
        Point p2 = points.get(i + 1);

        if (x >= p1.x && x <= p2.x) {
            double pente = (double) (p2.y - p1.y) / (p2.x - p1.x);
            return (int) (p1.y + (x - p1.x) * pente);
        }
    }
    return Position.H_MIN;
}

}
