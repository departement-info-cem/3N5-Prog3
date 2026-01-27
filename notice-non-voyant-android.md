# Manuel étudiant Android — CLI (PowerShell / terminal)

Depuis le dossier de l'application

./gradlew assembleDebug
Permet de compiler une application et voir les erreurs (E) et warnings (W)

./gradlew installDebug
Installe l'application sur l'appareil ou l'émulateur connecté

adb devices
Vérifie qu'un appareil ou un émulateur est connecté (liste les devices)

adb logcat System.out:V *:S
Voir uniquement les println depuis logcat

adb logcat -b all -c
Effacer toutes les lignes précédentes dans logcat (ménage)

À documenter / tâches restantes
- Lancer les tests unitaires (CLI)

./gradlew test
Exécute les tests JVM/unitaires. Les rapports HTML se trouvent généralement dans build/reports/tests/test/index.html

- Lancer les tests instrumentation (sur appareil ou émulateur)

adb devices
Vérifier qu'un appareil ou un émulateur est connecté (liste les devices)

./gradlew connectedAndroidTest
Exécute les tests instrumentés sur l'appareil connecté ou l'émulateur.

ouvrir build/reports/tests/test/index.html 
Consulter le rapport HTML d'exécution des tests

npm install -g @githubnext/github-copilot-cli
Installe la CLI Copilot globalement via npm. Vérifier le nom du paquet et la documentation officielle si besoin : chercher "GitHub Copilot CLI" sur le site de GitHub.



# Exécuter Copilot CLI

Depuis le dossier du projet Android :
copilot

# Manuel étudiant Android — Android Studio (IDE)

Alt + 1 
explorateur de projet (Project)

Alt + 6 
fenêtre Messages / Build (erreurs et warnings)

Maj + F10
exécuter le projet

Alt + V puis T : ouvre le menu des Tool Windows

## Lire une portion de code avec le lecteur d'écran

CTRL + W élargit la selection de code logique
CTRL + SHIFT + W diminue la selection de code logique

Sélectionner la prochaine structure logique dans Android Studio avec Alt + ↑ (Option + flèche haut sur macOS), puis lire avec NVDA (NVDA + flèche bas).
Réduire la sélection : Alt + ↓ (Option + flèche bas sur macOS).

Sélectionner une zone de plus en plus large dans Android Studio avec Maj + flèche droite / gauche, puis lire avec NVDA (NVDA + flèche bas).


## Cycle débogage dans Android Studio

Débogage avec des println: Ajouter des println dans le code

Ensuite exécuter le code et voir les traces dans la fenêtre Logcat (Alt + 6).

# Configurer NVDA pour les caractères et symboles (merci à Pierre-Paul)

Pour NVDA (Windows) :
1. Ouvrir le menu NVDA (touche `NVDA` + `N`) ou via l'icône NVDA.
2. Aller dans Préférences > Paramètres.
3. Dans Parole > Niveau de ponctuation et symboles, choisir « La plupart » ou « Tous » selon vos besoins.
4. Vous pouvez ajuster la façon dont chaque symbole est prononcé. Exemple : j'ai essayé de changer « parenthèse gauche » en « paran G », mais cela créait plus de confusion, donc garder des énoncés clairs est préférable.

Conseils pratiques
- Préférer des commandes isolées sur leur propre ligne pour que le lecteur d'écran lise correctement l'instruction.
- Indiquer la plateforme quand une commande est spécifique (Windows vs macOS vs Linux).
