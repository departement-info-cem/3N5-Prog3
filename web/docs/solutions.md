---
slug: /solutions
---

# Solutions

## J'ai besoin d'aide pour installer...

- [Amazon Corretto](https://youtu.be/b7MgJDd1Iks)
- [IntelliJ Idea](https://youtu.be/aWd160BjRYE)
- [GitKraken](https://youtu.be/v10jAu1ELac)

## Aucun projet ne démarre

Vous ne devez pas avoir d'accent dans le nom de votre usager windows

## Les tests ne sont pas débogables (affiche "terminated unexpectedly")

Vous ne devez pas avoir d'accent dans le nom de vos méthodes, de votre package et de votre projet

## Mon projet ne démarre plus après un changement de machine

Essaie **Build** > **Clean Project**.

Essaie **File** > **Invalidate Cache** / **Restart puis Invalidate Cache** / **Restart**.

Dans le dossier du projet, entre dans le dossier app, ensuite supprime le dossier **build**. Cela supprime tous les fichiers compilés et force à recompiler l'ensemble de l'application.

Force un sync gradle. [ici pour les différentes versions](https://stackoverflow.com/questions/29565263/android-studio-how-to-run-gradle-sync-manually)

## Le projet démarre mais il y a du rouge partout

Essaie **File** > **Invalidate Cache** / **Restart puis Invalidate Cache** / **Restart**.

## AndroidX

Si on utilise une librairie androidX, il faut toutes les migrer. Je ne peux plus utiliser les support v7 et v4, voir [ici](https://developer.android.com/jetpack/androidx/migrate)

On doit mettre le compileSdkVersion à 28 dans le build.gradle (celui du dossier app)

## Je ne vois pas mon périphérique au lancement de l'appli

1. Aller dans les options développeur de la tablette, désactiver Débogage USB, Annuler les autorisations relatives au …, réactiver Débogage USB
2. Essayer un autre câble, un autre appareil (demander à un collègue)
3. Redémarrer la tablette
4. Redémarrer Android Studio
5. Dans de Gestionnaire des tâches (CTRL + SHIFT + ESCAPE), dans l’onglet Détails, arrêter tous les processus adb.exe
6. Redémarrer la machine de développement

## Ça marche en run, ça ne marche pas en debug

1. Aller dans File > Settings
2. Tape instant run dans le champs de recherche
3. Décocher Enable Instant Run to hot swap ….

## *Cannot sync project with gradle files*

Essaie **File** > **Invalidate Cache** / **Restart puis Invalidate Cache** / **Restart**.

## *Do you want to uninstall the existing application?*

Vérifie que l'application n'est pas déjà sur le périphérique. Si c'est le cas supprime la.

Dans le dossier du projet, entre dans le dossier app, ensuite supprime le dossier **build**. Cela supprime tous les fichiers compilés et force à recompiler l'ensemble de l'application.

Essaie **File** > **Invalidate Cache** / **Restart** puis **Invalidate Cache** / **Restart**.

## Mes tests unitaires ne s'exécutent pas

Dans le fichier build.gradle (dans le dossier app), vérifier que

- on a la dépendance androidTestImplementation 'androidx.test:core:1.1.0'
- on a la dépendance androidTestImplementation 'androidx.test:runner:1.1.0'
- la valeur de testInstrumentationRunner est bien "androidx.test.runner.AndroidJUnitRunner"
- exemple ici : https://github.com/departement-info-cem/3N5-Prog3/tree/main/code/RoomSQL/04-RoomPerformance/app/build.gradle

## Le projet est "*syncing*" mais tourne en boucle

1. Attendre 5min pour valider que ce n'est pas la machine
2. En bas à droite, ouvrir le EVENT LOG
3. NDK Version is UNKNOWN --> pas grave
4. java lang nullpointerexception --> peut être plusieurs choses (voir ci-dessous)
5. Tout d'abord, supprimer le dossier .idea et relancer Android Studio
6. Si ça ne fonctionne pas, aller dans AndroidManifest.xml
7. Si vous voyez le message suivant : Gradle project sync failed. Basic functionality will not work properly.
8. Cliquez sur 'Show Log in Explorer'. Ouvrez idea.log dans notepad++. Cherchez l'erreur en question (nullpointer dans ce cas-ci)

Exemple : Module 'app': platform 'android-28' not found. Gradle sync failed: java.lang.NullPointerException (7 s 897 ms) java.lang.NullPointerException at org.jetbrains.android.sdk.AndroidSdkData.getSdkData(AndroidSdkData.java:117)

**Solution** : Vous n'avez pas la bonne version de SDK d'installé. Cliquez sur SDK Manager pour l'installer. Puis file - invalidate cache and restart pour redémarrer

## Je suis incapable d'ajouter un "package" ou une "class" (le menu offre seulement un folder ou un file)

1. Clic droit sur le dossier java
2. Mark Directory As -> Source Root.

## Mon projet fonctionne à la maison, mais pas à l'école

1. Vous devez mettre le projet sur le Bureau et non sur votre clé USB ou sur un disque dur externe
2. Aller dans Help > About et regarder le numéro de version (ex : 4.2.1)
3. Aller dans build.grable (niveau projet) et vérifier que le numéro de cette ligne correspond au numéro de version
`dependencies { classpath 'com.android.tools.build:gradle:4.2.1' }`

## Je n'arrive pas à faire fonctionner la librairie MPChart

Assurez-vous d'avoir ajouté les deux lignes de code suivantes

- `dependencies {implementation 'com.github.PhilJay:MPAndroidChart:v3.1.0'} // Dans le fichier build.gradle(module)`
- `repositories {maven { url 'https://jitpack.io' }} // Dans le fichier settings.gradle`

## Problèmes depuis l'ajout de dépendances ROOM

1. The minCompileSdk (31) specified in a dependency's AAR metadata (META-INF/com/android/build/gradle/aar-metadata.properties) is greater than this module's compileSdkVersion (android-30). : 
   - Dans **build.gradle** module Supprimer la ligne suivante : `implementation "androidx.room:room-paging:2.4.0-beta01"`
   - Retester. Ça ne fonctionne toujours pas?
   - `CompileSdkVersion 30 -> compileSdkVersion 31`
   - `targetSdkVersion 30 -> targetSdkVersion 31`
2. Manifest merger failed : Apps targeting Android 12 and higher are required to specify an explicit value for `android:exported`
   - Dans **Manifest** : `activity android:name=".MainActivity" android:exported="true"`
3. Library dex files are not supported in multi-dex mode
   - Dans **build.gradle** : `module dependencies { implementation 'com.android.support:multidex:1.0.3' defaultConfig { multiDexEnabled true}`
4. 2 files found with path ‘androidsupportmultidexversion.txt’
   - Dans **build.gradle** : `module android { packagingOptions{ pickFirst 'androidsupportmultidexversion.txt' }`
5. Instance already used
   - **File** > **invalidate cache & restart** > **invalidate & restart**

## Installed Build Tools revision 31.0.0 is corrupted

1. Allez dans "C:\Users\votreUsager\AppData\Local\Android\Sdk\build-tools\31.0.0" si vous êtes à la maison. À l'école ce sera dans "C:\Android\Sdk\build-tools\31.0.0"
2. Copiez d8.bat et renommer le en dx.bat
3. Allez dans le dossier lib, copiez d8.jar et renommez-le en dx.jar

## Manifest merger failed: Apps targeting Android 12 and higher are required to specify an explicit value for android: exported when the corresponding component has an intent filter defined

Aller dans le Manifest, ajouter `android:exported="true"` pour votre Activity d'accueil | Exemple : `activity android:name=".MainActivity" android:exported="true"`

