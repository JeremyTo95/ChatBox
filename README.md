# ChatBox

#
Membres du groupe 

Yoann ANAGO
Mostafa OMRANE
Raphael KOSKAS
Sofiane SERKESTI
Jeremy TOURARI

<br>
# Ouvrir le projet sur IntelliJ IDEA
Etape 0 : Installer IntelliJ IDEA
Etape 1 : github du projet : https://github.com/JeremyTo95/ChatBox
Etape 2 : cliquer sur "clone or download" et copier le lien du projet dans le presse-papier 
 (--> https://github.com/JeremyTo95/ChatBox.git)
Etape 3 : ouvrir IntelliJ IDEA
<img src="https://raw.githubusercontent.com/JeremyTo95/ChatBox/master/img/IntelliJStartUp.png" width="275">
Etape 4 : Créer un projet vide pour le moment
Etape 5 : Cliquer dans File -> New -> From existing control version -> Git
<img src="https://raw.githubusercontent.com/JeremyTo95/ChatBox/master/img/Recuperation_projet_git.png" width="275">
Copier le lien

Ouvrir dans une nouvelle fenêtre et fermer la première

Vous avez ainsi accès au projet sur votre IDE !
</br>


<br>
# Mise en place de la base de donnée en local
1ère étape : Télécharger postgreSQL
  --> https://get.enterprisedb.com/postgresql/postgresql-12.3-1-windows-x64.exe
2ème étape : Télécharger le driver JDBC
  --> https://jdbc.postgresql.org/download/postgresql-42.2.14.jar
3ème étape : mettre le .jar dans le classpath
  --> Sur IntelliJ IDEA, avec le projet ouvert (cf. Section "Ouvrir le projet sur IntelliJ IDEA")
    --> Cliquer sur File -> Project Structure puis sur Librairies, cliquer sur le "+" -> New Project Librairy -> Java
    --> Dans la fenêtre suivante, séléctionner le fichier postgresql-42.2.14.jar téléchargé et cliquer sur "OK", à nouveau "OK" et une dernière fois "OK"
    --> Le .jar s'ajoute au projet nous pourrons utiliser ce driver JDBC pour communiquer avec notre base de donnée
</br>
