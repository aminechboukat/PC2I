package main;

import javax.swing.*;
import model.Position;
import model.Avancer;
import model.Parcours;
import view.Affichage;
import view.Redessine;
import control.ReactionClic;
import control.Descendre;

/**
 * Classe principale
 */
public class Main {

    public static void main(String[] args) {

        JFrame fenetre = new JFrame("Projet PCII");
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

       Position position = new Position();
       Parcours parcours = new Parcours(position);

       new Avancer(position).start();

        Affichage affichage = new Affichage(position, parcours);

        affichage.addMouseListener(new ReactionClic(position));

        fenetre.setContentPane(affichage);
        fenetre.pack();
        fenetre.setResizable(false);
        fenetre.setVisible(true);

        new Redessine(affichage).start();
        new Descendre(position).start();
    }
}
