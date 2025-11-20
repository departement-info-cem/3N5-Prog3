# Manuel étudiant Kotlin pure en mode CLI (powershell lignes de commande)


# Manuel étudiant Kotlin pure en mode Intellij IDEA
alt + 1        explorateur du projet (comme explorateur de solution)

# Manuel étudiant Android en mode CLI (powershell lignes de commande)

- comment rouler les tests dans le terminal
- comment consulter le rapport HTML de l’exécution des tests
- comment installer copilot CLI
- comment tracer une exécution avec des println
- comment voir logcat depuis le CLI général
- comment voir logcat depuis le CLI seulement mes println
- comment exécuter une appli kotlin depuis le terminal (modification au build.gradle puis commande)
- comment voir tous les problèmes d’une appli Android en CLI Error Warning et Typos

# Manuel étudiant Android Studio
alt + 1                explorateur du projet (comme explorateur de solution)
- comment lire une section de code puis plus grand puis plus grand dans Android Studio


Une collecte de raccourcis et procédures pour coder dans 3N5

alt + 1        explorateur du projet (comme explorateur de solution)


**alt + 6** Problems toutes les erreurs de compilation si tu fais enter sur le problème il te mène sur la ligne

Maj + F10 partir le projet

Alt + v puis t amène au menu des tool Windows


Logcat

Powershell "adb logcat System.out:V *:S" filtre tous les print println

si on souhaite mettre dans un fichier 

Pwershell "adb logcat -b all -c" efface logcat 

adb logcat System.out:V *:S > logcat_output.txt    permet de récupérer le logcat dans un fichier pour naviguer ensuite dedans

## exécuter application Android depuis powershell

## accéder au logcat depuis powershell

## cycle débogage Android Studio
- 

# Notice pour le prof + étudiant

1. décider assez rapidement si on y va en CLI (powershell) ou avec Android Studio
2. prévoir un temps pour procéder à l'installation avec l'étudiant (les étudiants aveugles travaillent sur leurs laptops)
  - obtenir un téléphone Android de prêt avant la session
  - installer plusieurs outils avec l'étudiant sur son poste
  - installation de npm nécessaire pour copilot cli
  - installation des outils command line de Android Studio (nécessaire pour logcat, adb etc.)
    - installer via le SDK Manager
    - ajouter AppData\Local\Android\Sdk\cmdline-tools\latest\bin au PATH
    - ajouter \AppData\Local\Android\Sdk\platform-tools au PATH
  - installation de copilot cli pour les appels IA : les plugins d'IDE ne sont pas accessibles : panneaux non lus par NVDA, résultats qui popent dans de nombreuses fenêtres
  - embarquer sur copilot po
    - chercher à voir si le github education pack est actif
    - embarquer sur le coupon copilot pro



## utiliser gemini live pour se faire décrire une interface en mode Talk Back
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

TODO voir s'il n'y a pas moyen de partir gemini live en commande vocale

