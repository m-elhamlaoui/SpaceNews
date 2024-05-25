# Utilisation d'une image de base contenant Java 17
FROM openjdk:17

# Définir le répertoire de travail dans le conteneur
WORKDIR /app

# Copier le fichier JAR de l'application dans le conteneur
COPY target/login_service-3.1.1.jar /app/login_service.jar

# Commande pour exécuter l'application Spring Boot lorsque le conteneur démarre
CMD ["java", "-jar", "login_service.jar"]
