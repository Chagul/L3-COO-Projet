# Auteur : 
### Plancke Aurelien
### Plé Lucas 

# Introduction

Ce projet à un but simple, simuler l'organisation de compétition entre différents joueurs avec la possibilité d'avoir des règles spécifiques au déroulement de la compétition et au fonctionnement interne de cette compétition, par le biais du type de match. 
Bien que ce projet soit simple en apparance, dans le cadre d'un cours de Conception Orientée Objet, nous avons dû mettre en place plusieurs principes nous permettant d'avoir un code qui puisse évoluer facilement, qui respecte les principes du clean code et open-close par exemple. C'est ce que nous avons développé avec ce projet, un code qui peut facilement ajouter de nouvelles classes sans devoir refaire les fondations du projet.

# Prérequis 

Le projet à été développé en Java 11 mais il est possible de le lancer sur des versions ultérieurs. Junit5 est quand à lui indispensable pour lancer les tests. Une archive jar est présente dans le dossier `lib` du projet permettant de lancer les tests directement en ligne de commandes.

# HowTo


## Récupération du dépot : 

Si vous avez une clef ssh lancez :
```shell
git clone git@gitlab-etu.fil.univ-lille1.fr:ple/ple_lucas_plancke_aurelien-coo-projet.git
```

Sinon lancez la commande suivante qui vous demandera d'utiliser vos informations de connexion au gitlab du fil:
```shell 
git clone https://gitlab-etu.fil.univ-lille1.fr/ple/ple_lucas_plancke_aurelien-coo-projet.git
```

## Compilation en jar du projet
Pour compiler le projet et générer le jar du projet en partant de la racine du projet : 
```shell 
cd ple_lucas_plancke_aurelien-coo-projet
./compile.sh
cd bin 
jar cvfm ../ProjetCOO.jar ../MANIFEST.MF fr/ulille/l3 
cd ..
```

## Lancement du projet
Pour lancer le projet : 
```shell 
java -jar ProjetCOO.jar
```

## Compilation et lancement des tests
Pour compiler les tests et les lancer en partant de la racine du projet: 
```shell 
./compile.sh
```
```shell
java -jar lib/Junit-console.jar --class-path bin/ --scan-class-path
```

## Génération de la documentation
En partant de la racine du projet : 
```shell
cd src
javadoc -d ../doc -subpackages main  
cd ..
```

La documentation sera généré à l'emplacement suivant :
```shell
cd doc
```
Vous pouvez y acceder avec la commande
```shell
firefox index.html
```

# Diagrammes UML

![umlCompetition](./Screenshots/umlCompetition.png "UML des competitions")


![umlMatch](./Screenshots/umlMatch.png "UML des matchs")


![umlModel](./Screenshots/umlModele.png "UML du modèle")


![umlException](./Screenshots/umlException.png "UML des exceptions")


![umlMapUtil](./Screenshots/umlMapUtil.png "UML de MapUtil")


![umlDisplayer](./Screenshots/umlDisplayer.png "UML de la Displayer")



# Principes et éléments de conceptions important utilisé.

Dans le cadre du principe open-close nous avons mis en place une structure qui permet de respecter ce principe. En voici quelques éléments :


## Abstract classes pour les matchs et compétitions

Ces classes abstraites sont un point essentiel du projet. En effet nous savons que les compétitions et les matchs sont amenés à se diversifier, c'est pourquoi nous avons décidé de mettre en place de l'héritage par le biais des classes abstraites afin de définir un comportement commun entre tout les types de matchs et tout les types de compétitions. Avec ces classes abstraites, si nous rajoutons un type de match ou de compétition, il suffit d'étendre ces classes abstraites et nous n'avons pas à modifier le fonctionnement même du programme comme nous pouvons décrire un comportement spécifique dans les sous-classes.

## Design pattern de singleton pour le displayer

Le displayer est la classe qui centralise les affichages. Il n'y a aucune raison d'instancier plus d'une fois de cette classe, le singleton nous permet donc d'éviter cela en limitant le nombre d'exemplaire de cette classe à 1. Cela permet d'économiser des ressources et s'assurer que nous utilisons toujours la même instance, nous facilitant ainsi la tâche pour l'initialisation et donc potentiellement le débuggage. 

## Héritage de tests

Comme pour les matchs et compétitions, les tests qui concernent ces différentes classes regroupent des comportements communs. En installant une relation d'héritage avec l'aide de classes abstraites, cela nous permet de tester les comportements communs facilement sans devoir réécrire pour chaque nouvelle classe le même test. En plus de cela grâce à cet héritage, nous pouvons faire des tests spécifiques pour une sous-classe.


