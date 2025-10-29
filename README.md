# projet_java

Pour lancer le mode local :

lancer UserRPL.java

OU

lancer UserRPL "[votre calcul dans le bon ordre]" -> du type "3 3 +"

OU 

lancer UserRPL -user=local -log=[none, rec, replay]


Pour lancer le mode serveur

lancer ServerRPL (changer mode dans le main du serveur: true pour synchronisé entre utilisateurs, false pour désynchronisé)

PUIS

lancer UserRPL -user=remote -log=none