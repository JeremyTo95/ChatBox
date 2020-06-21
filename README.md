ChatBox
======

**Membres du groupe**
Yoann ANAGO

Mostafa OMRANE

Raphael KOSKAS

Sofiane SERKESTI

Jeremy TOURARI


## Ouvrir le projet sur IntelliJ IDEA
* Etape 0 : Installer IntelliJ IDEA.
* Etape 1 : github du projet : https://github.com/JeremyTo95/ChatBox
* Etape 2 : cliquer sur "clone or download"
 copier le lien du projet dans le presse-papier 
( --> https://github.com/JeremyTo95/ChatBox.git)
* Etape 3 : ouvrir IntelliJ IDEA.
<img src="https://raw.githubusercontent.com/JeremyTo95/ChatBox/master/img/IntelliJStartUp.png" width="275">
* Etape 4 : Créer un projet vide pour le moment.
* Etape 5 : Aller dans File -> New -> Project From Version Control -> Git.

<img src="https://raw.githubusercontent.com/JeremyTo95/ChatBox/master/img/Recuperation_projet_git.png" width="275">

Copier le lien et cliquer sur "Ouvrir dans une nouvelle fenêtre", fermer la première.
Vous avez ainsi accès au projet sur votre IDE !

## Installation du serveur en local
* 1ère étape : Télécharger postgreSQL.
  --> https://get.enterprisedb.com/postgresql/postgresql-12.3-1-windows-x64.exe
* 2ème étape : lancer l'installation.
* 3ème étape : suivre les étapes d'installation.
  --> Spécifier le mot de passe : He9Z4EmJu2640&
  --> Laisser le port 5432.
  
Lorsque l'installation s'est terminée : 
* 4ème étape : Cliquer sur la touche Windows du clavier.
* 5ème étape : Rester sur le menu démarrer et descendre jusqu'à la lettre P.
<img src="https://raw.githubusercontent.com/JeremyTo95/ChatBox/master/img/menu_demarrer.png" width="275"> 
Ceci va lancer un proccessus dans la barre d'outils et lancer une page web.
Recopier le mot de passe He9Z4EmJu2640& (deux fois demandé : superutilisateur et pour la base de donnée "postgres")
Vous avez ainsi accès au server.
Il reste à créer les tables, pour cela faire un clique-droit sur la base de donnée postgres et "CREATE SCRIPT"
<img src="https://raw.githubusercontent.com/JeremyTo95/ChatBox/master/img/create_script.png" width="275">
N.B. : il s'agit bien de la base de donnée "postgres" et non ChatBox comme sur la photo
Les données seront toutes insérées directement depuis le java.

## Mise en place du JDBC
* Télécharger le driver JDBC.
  --> https://jdbc.postgresql.org/download/postgresql-42.2.14.jar
* Mettre le .jar dans le classpath :

  --> Sur IntelliJ IDEA, avec le projet ouvert (cf. Section "Ouvrir le projet sur IntelliJ IDEA").

    --> Cliquer sur File -> Project Structure puis sur Librairies, cliquer sur le "+" -> New Project Librairy -> Java .

    --> Dans la fenêtre suivante, séléctionner le fichier postgresql-42.2.14.jar téléchargé et cliquer sur "OK", à nouveau "OK" et une dernière fois "OK" .

Le .jar est ainsi ajouté au projet
Nous pourrons par la suite utiliser ce driver JDBC comme pont entre le code JAVA et notre base de donnée !!
