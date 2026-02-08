package model;

/**
 * Thread chargé de détecter les collisions
 * entre le cercle et la ligne.
 */
public class CollisionThread extends Thread {

    private final Position position;
    private final Parcours parcours;

    public CollisionThread(Position position, Parcours parcours) {
        this.position = position;
        this.parcours = parcours;
    }

    @Override
    public void run() {
        while (true) {

            int xCercle = position.getAvancement();
            int yCercle = position.getHauteur();
            int yLigne = parcours.getYLignePourX(xCercle);

            // Détection de collision (le cercle touche la ligne)
            if (yCercle <= yLigne) {
                position.setCollision(true);
            } else {
                position.setCollision(false);
            }

            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                return;
            }
        }
    }
}
