```mermaid
gantt
    title Projet PCII – Diagramme de Gantt
    dateFormat  YYYY-MM-DD

    section S1 – Interface graphique
    Création fenêtre Swing        :done, s1a, 2026-02-01, 1d
    Zone de dessin               :done, s1b, 2026-02-01, 1d
    Dessin du cercle             :done, s1c, 2026-02-02, 1d

    section S2 – Parcours
    Génération points            :done, s2a, 2026-02-03, 1d
    Dessin ligne brisée          :done, s2b, 2026-02-03, 1d

    section S3 – Interaction utilisateur
    Détection clic souris        :done, s3a, 2026-02-04, 1d
    Saut du cercle               :done, s3b, 2026-02-04, 1d

    section S4 – Mouvement vertical
    Gravité (descente auto)      :done, s4a, 2026-02-05, 1d
    Limites min / max            :done, s4b, 2026-02-05, 1d

    section S5 – Défilement horizontal
    Avancement du jeu            :done, s5a, 2026-02-06, 1d
    Décalage du parcours         :done, s5b, 2026-02-06, 1d

    section S6 – Collision
    Calcul hauteur ligne         :active, s6a, 2026-02-07, 1d
    Détection collision          :active, s6b, 2026-02-07, 1d
    Animation visuelle           :active, s6c, 2026-02-08, 1d

    section S7 – Finalisation
    Tests et validation          :s7a, 2026-02-09, 1d
