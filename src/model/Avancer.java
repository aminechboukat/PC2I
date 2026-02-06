package model;
import model.Position;
import model.Parcours;
/**
 * Cette classe correspond à un thread qui fait avancer le jeu.
 * Elle appelle régulièrement la méthode avancer() de Position
 * pour simuler le déplacement horizontal du cercle et du parcours.
 */
public class Avancer extends Thread {

    private Position position;

    public Avancer(Position position) {
        this.position = position;
    }

    @Override
    public void run() {
        while (true) {
            position.avancer();
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                return;
            }
        }
    }
}
