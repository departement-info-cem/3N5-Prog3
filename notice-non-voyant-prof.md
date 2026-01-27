# Leçons apprises

- Les obstacles sont difficiles à prévoir sans utiliser NVDA sur un poste similaire.
- Il est difficile de se concentrer sur une zone de code dans un très grand fichier avec NVDA.
  - Il existe un mode ligne par ligne, compliqué avec du code formaté.
  - Il existe aussi un mode "tout lire" : c'est infernal, car les fichiers commencent souvent par de nombreuses lignes d'import.
- Le débogueur est un calvaire avec ses indicateurs visuels (mise en évidence de la ligne) et le fait de regarder deux panneaux en même temps (code et Debug).
- Les messages d'erreur d'Android Studio (fenêtre Issues / Messages) ne distinguent les erreurs des avertissements que par une icône.
- Nous avons essayé Gemini Live sur le téléphone pour demander une description de l'interface, mais ce n'est pas optimal :
  - Gemini Live parle en permanence.
  - Il parle en même temps que TalkBack.
  - Il est souvent plus simple de demander à quelqu'un d'être les yeux de l'étudiant.
- Les impressions braille des interfaces sont très bénéfiques : elles permettent à l'étudiant de "voir" l'organisation spatiale de l'écran.
- Il faut se familiariser avec la notice étudiant pour maîtriser les différentes commandes et raccourcis clavier.


# Notice pour le professeur et l'étudiant

Avant la session
- Décider si l'étudiant vient en cours (GROUPE) ou se présente pendant les disponibilités du professeur (DISPOS).
  - GROUPE :
    - L'environnement peut être bruyant pour l'étudiant, car presque tout passe par l'audition.
    - Le son de TalkBack peut être important (prévoir un casque si nécessaire).
    - Le professeur doit être attentif et vérifier régulièrement si l'étudiant a des questions.
  - DISPOS :
    - Permet de limiter le bruit si la session a lieu dans le bureau du professeur.
    - Nécessite l'accord du département pour planifier les disponibilités du professeur.
- Décider rapidement si la session se fera en ligne de commande (CLI) ou avec Android Studio (IDE) : les outils et workflows sont très différents.
- Prévoir 2–3 heures pour l'installation initiale avec l'étudiant (les étudiants non-voyants travaillent souvent sur leurs propres laptops).
  - Obtenir un téléphone Android de prêt et le laisser à l'étudiant pour se familiariser.
  - Passer le téléphone en mode développeur.
  - Montrer comment fonctionne TalkBack si l'étudiant ne l'a jamais utilisé.
  - Installer npm si nécessaire pour Copilot CLI.
  - Installer les outils en ligne de commande d'Android SDK (nécessaires pour logcat, adb, etc.) :
    - Installer via le SDK Manager.
    - Ajouter au PATH : AppData\Local\Android\Sdk\cmdline-tools\latest\bin (Windows) et AppData\Local\Android\Sdk\platform-tools (adb).
  - Installer Copilot CLI pour les appels IA : les plugins d'IDE peuvent être difficiles d'accès avec NVDA.
  - Souscrire à Copilot (voir GitHub Education Pack) si nécessaire :
    - Vérifier si le GitHub Education Pack est actif : https://education.github.com/pack
    - Récupérer le coupon Copilot Pro (l'activation peut prendre 48–72 heures).


# Utiliser Gemini Live pour décrire l'interface (avec TalkBack)

1. Allumer le téléphone (si nécessaire) — repérer le bouton d'alimentation avec l'aide du professeur.
2. Déverrouiller le téléphone (glisser vers le haut avec deux doigts).
3. Ouvrir l'application "Assistant".
4. Double-taper pour entrer dans l'application.
5. Balayer vers la droite jusqu'à "Démarrer Gemini Live".
6. Double-taper pour entrer dans Gemini Live.
7. Balayer vers la droite jusqu'à "Partage de l'écran".
8. Double-taper pour sélectionner.
9. Balayer vers la droite jusqu'à "Accepter".
10. Double-taper pour confirmer.
11. Maintenant, demandez à Gemini de décrire l'écran : « Décris-moi globalement ce qu'il y a à l'écran ».  


# Checklist rapide avant la session
- Téléphone Android prêt et en mode développeur.
- Accès aux comptes nécessaires (GitHub, Copilot) sans partager de mots de passe en session.
- Outils CLI installés (npm, adb, SDK tools).
- Casque pour l'étudiant si l'environnement est bruyant.
- Fichier de support en braille ou version imprimée si disponible.


# Remarques d'accessibilité
- Favoriser des phrases courtes et une navigation par étapes.
- Mettre les commandes dans des blocs de code pour que les lecteurs d'écran les lisent clairement.
- Harmoniser la terminologie : utiliser "TalkBack" pour Android et "NVDA" pour Windows, et expliquer à la première mention.
