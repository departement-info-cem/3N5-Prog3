# Leçons apprises:
- les obstacles sont difficiles à prévoir sans rouler NVDA sur un poste similaire
- il est assez difficile de se concentrer sur une zone de code dans un très grand fichier avec NVDA
  - il y a un mode ligne par ligne, compliqué dans du code formaté
  - il y un mode tout lire : c'est infernal parce que tous les fichiers commencent par import import import 50 fois
- le débogueur est un calvaire avec ses indicateurs visuels (highlight de la ligne) et le fait de regarder 2 panneaux en même temps (code et debug)
- les messages d'erreurs d'Android Studio (issues) ne distinguent les erreurs des avertissements que par un icone
- on a essayé Gemini Live sur le téléphone pour lui demander de décrire l'interface mais c'est finalement pas génial
  - Gemini Live parle tout le temps
  - Il parle en même temps que Talk Back
  - Plus facile de demander à quelqu'un d'être ses yeux pour décrire l'interface
- les impressions en braille des interfaces sont très bénéfiques. Permettent à l'étudiant de "voir" l'organisation spatiale de l'écran
- il faut se familiariser avec la notice étudiant pour maitriser les différentes commandes raccourcis clavier etc

# Notice pour le prof + étudiant
- décider assez rapidement si l'étudiant vient en cours (GROUPE) ou se présente pendant les dispos du prof (DISPOS)
  - GROUPE :
    - l'environnement peut être bruyant pour l'étudiant sachant que presque tout passe par les oreilles,
    - le téléphone de l'étudiant en mode talk back fait pas mal de bruit (ou prévoir un casque)
    - le prof doit être attentif pour voir quand l'étudiant a des questions ou passer régulièrement
  - DISPOS :
    - permet de limiter le bruit si dans le bureau du prof.
    - Nécessite l'accord du département pour mettre les dispos du prof quand l'étudiant est dispo lui-même (ce qui est souvent du à leur parcours aménagé)
- décider assez rapidement si on y va en ligne de commandes  (CLI) ou avec Android Studio (IDE). L'ensemble des outils est très différent
- prévoir un temps (2-3 heures) pour procéder à l'installation avec l'étudiant (les étudiants aveugles travaillent sur leurs laptops)
  - obtenir un téléphone Android de prêt avant la session et leur laisser pour qu'ils se familiarisent
  - passer le téléphone en mode développeur
  - montrer comment fonctionne talk back à l'étudiant s'il ne l'a jamais utilisé
  - installation de npm nécessaire pour copilot cli
  - installation des outils command line de Android Studio (nécessaire pour logcat, adb etc.)
    - installer via le SDK Manager
    - ajouter AppData\Local\Android\Sdk\cmdline-tools\latest\bin au PATH
    - ajouter \AppData\Local\Android\Sdk\platform-tools au PATH
  - installation de copilot cli pour les appels IA : les plugins d'IDE ne sont pas accessibles : panneaux non lus par NVDA, résultats qui popent dans de nombreuses fenêtres
  - embarquer sur copilot po
    - chercher à voir si le github education pack est actif  https://education.github.com/pack
    - embarquer sur le coupon copilot pro quand c'est actif (peut prendre 48-72 heures après avoir appliqué)



# utiliser gemini live pour se faire décrire une interface en mode Talk Back (non voyant)
1. allumer téléphone si pas allumé (voir bouton avec prof)
2. dévérouiller le téléphone (glisser vers le haut avec 2 doigts)
3. trouver l'application **Assistant**
4. double tap pour rentrer devant
5. swipe droite jusqu'à démarrer Gemini Live
6. double tap pour entrer dans Gemini Live
7. swipe droite jusqu'à partage de l'écran
8. double tap
9. swipe droit jusqu'à accepter
10. double tap
11. tu devrais maintenant pouvoir demander à Gemini de décrire l'écran "Décris moi globalement ce qu'il y a à l'écran"


