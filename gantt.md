```mermaid
gantt
    title Projet PCII – Diagramme de Gantt (jours et heures)
    dateFormat  YYYY-MM-DD
    axisFormat  %d/%m

    section S1 – Interface graphique (8h)
    Création fenêtre Swing        :done, s1a, 2026-02-01, 4h
    Zone de dessin               :done, s1b, after s1a, 2h
    Dessin du cercle             :done, s1c, after s1b, 2h

    section S2 – Parcours (6h)
    Génération des points        :done, s2a, 2026-02-02, 3h
    Dessin ligne brisée          :done, s2b, after s2a, 3h

    section S3 – Interaction utilisateur (4h)
    Détection clic souris        :done, s3a, 2026-02-03, 2h
    Déclenchement du saut        :done, s3b, after s3a, 2h

    section S4 – Mouvement vertical (6h)
    Gestion de la gravité        :done, s4a, 2026-02-04, 3h
    Limites min/max              :done, s4b, after s4a, 3h

    section S5 – Défilement horizontal (6h)
    Avancement du jeu            :done, s5a, 2026-02-05, 3h
    Décalage du parcours         :done, s5b, after s5a, 3h

    section S6 – Collision (8h)
    Calcul hauteur de la ligne   :done, s6a, 2026-02-06, 3h
    Détection collision          :done, s6b, after s6a, 3h
    Animation visuelle           :done, s6c, after s6b, 2h

    section S7 – Finalisation (4h)
    Tests et validation          :done, s7a, 2026-02-07, 4h
