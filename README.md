# RES - Labo SMTP

Alexandre Marques et Alison Savary

## Description
Ce repository contient une application java ayant pour but de faire des blagues par mail. 

Dans un fichier de mail fourni
par l'utilisateur, l'application forme différents groupes. Pour chaque groupe, une adresse mail est selectionnée en tant
qu'émetteur du mail, les autres adresses seront les récepteurs. 

L'application se charge ensuite, à l'aide du protocole SMTP, d'envoyer un mail à chaque récepteur.

Cette application a été réalisée selon les instructions fournies par le cours de RES 2019 de la HEIG-VD. Le repository 
d'instruction se trouve [ici](https://github.com/SoftEng-HEIGVD/Teaching-HEIGVD-RES-2019-Labo-SMTP).
## Installer et utiliser un serveur SMTP avec Docker
Nous avons choisi d'utiliser le serveur [MockMock](https://github.com/tweakers/MockMock) pour ce labo. 
Nous avons télécharger le fichier .jar proposé. Pour pouvoir utiliser MockMock avec Docker, il nous faut une image,
nous avons donc créer un dockerfile en se basant sur l'exemple donné pour la démo "SimpleJavaServer". Il suffit finalement
de construire l'image et ensuite de lancer un container de cette image. 

Dockerfile :
```
FROM java:8

#
# When we build the image, we copy the executable jar in the image file system. 
#
COPY MockMock.jar /opt/app/server.jar


EXPOSE 25
EXPOSE 8282

#
# This is the command that is executed when the Docker container starts
#
CMD ["java", "-jar", "/opt/app/server.jar"]
```

Création de l'image :
```
docker build --tag mockmock .
```

## Configuration de l'application
## Utilisation de l'application
## Implémentation