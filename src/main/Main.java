package main;

import javax.swing.JFrame;

import model.Position;
import model.Parcours;
import model.Avancer;
import model.CollisionThread;
import model.Descendre;
import model.CollisionThread;


import view.Affichage;
import view.Redessine;

import control.ReactionClic;

/**
 * Classe principale du programme.
 * 
 * Elle initialise l'application :
 * - création du modèle (Position, Parcours)
 * - création de la vue (Affichage)
 * - association du contrôleur (ReactionClic)
 * - lancement des threads
 * 
 * Cette classe ne contient aucune logique métier.
 */
public class Main {

    /**
     * Point d'entrée du programme.
     * 
     * @param args arguments de la ligne de commande (non utilisés)
     */
    public static void main(String[] args) {

        // Création de la fenêtre principale
        JFrame fenetre = new JFrame("Projet PCII");
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Initialisation du modèle
        Position position = new Position();
        Parcours parcours = new Parcours(position);

        // Initialisation de la vue
        Affichage affichage = new Affichage(position, parcours);

        // Ajout du contrôleur pour gérer les clics souris
        affichage.addMouseListener(new ReactionClic(position));

        // Mise en place de la vue dans la fenêtre
        fenetre.setContentPane(affichage);
        fenetre.pack();
        fenetre.setResizable(false);
        fenetre.setVisible(true);

        // Lancement des threads du jeu
        new Redessine(affichage).start();     // rafraîchissement de l'affichage
        new Descendre(position).start();      // gravité
        new Avancer(position, parcours).start(); // défilement horizontal
        new CollisionThread(position, parcours).start();

    }
}
