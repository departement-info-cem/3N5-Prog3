TODO installer command line tools sur machine
TODO ajouter AppData\Local\Android\Sdk\cmdline-tools\latest\bin au PATH
TODO ajouter \AppData\Local\Android\Sdk\platform-tools au PATH

Une collecte de raccourcis et procédures pour coder dans 3N5

**alt + 1** explorateur du projet (comme explorateur de solution)
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

