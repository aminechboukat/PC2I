package view;

/**
 * Thread de rafraîchissement de l’affichage
 */
public class Redessine extends Thread {

    public static final int DELAY = 50;
    private final javax.swing.JComponent affichage;

    public Redessine(javax.swing.JComponent affichage) {
        this.affichage = affichage;
    }

    @Override
    public void run() {
        while (true) {
            affichage.repaint();
            try {
                Thread.sleep(DELAY);
            } catch (InterruptedException e) {
                return;
            }
        }
    }
}
