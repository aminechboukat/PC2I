```mermaid
gantt
    title Projet PCII – Organisation temporelle (Diagramme de Gantt)
    axisFormat  S%

    section S1 – Interface graphique
    Fenêtre Swing                 :done, s1a, 0, 1
    Zone de dessin                :done, s1b, 0, 1
    Dessin du cercle              :done, s1c, 1, 1

    section S2 – Parcours
    Génération des points         :done, s2a, 2, 1
    Dessin de la ligne brisée     :done, s2b, 2, 1

    section S3 – Interaction utilisateur
    Détection du clic souris      :done, s3a, 3, 1
    Déclenchement du saut         :done, s3b, 3, 1

    section S4 – Mouvement vertical
    Gestion de la gravité         :done, s4a, 4, 1
    Limites min/max               :done, s4b, 4, 1

    section S5 – Défilement horizontal
    Avancement du jeu             :done, s5a, 5, 1
    Décalage du parcours          :done, s5b, 5, 1

    section S6 – Nouvelle fonctionnalité
    Calcul hauteur de la ligne    :active, s6a, 6, 1
    Détection de collision        :active, s6b, 6, 1
    Animation visuelle            :active, s6c, 7, 1

    section S7 – Finalisation
    Tests et validation           :s7a, 8, 1
