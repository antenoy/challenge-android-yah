# challenge-android

Le challenge vise à créer une application Android affichant la liste des catégories et sous catégories de dépenses et d'entrées d'argent de Bankin'

Le choix de l'architecture et des méthodes est laissée à l'appréciation du candidat.

Le test a pour but de créer une application avec 2 activités : 
- La première sera une liste regroupant les catégories principales.
- La seconde sera une liste des sous-catégories correspondant à la catégorie principale cliquée.

Le fichier JSON ne doit pas être embarqué dans l'application mais obtenu grâce à un appel réseau, il est disponible ici : https://raw.githubusercontent.com/bankin-engineering/challenge-android/master/categories.json

**Bonus :**
La donnée doit être enregistrée dans une base de données locale, qui doit être utilisé dans les deux activités.

Il n'y a pas de contraintes particulières de design. Nous regarderons ici l'architecture employée et la qualité du code. 
