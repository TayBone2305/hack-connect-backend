FROM eclipse-temurin:17-jre
EXPOSE 80

ENV SPRING_PROFILES_ACTIVE=prod
COPY ./build/libs/hack-connect-*-SNAPSHOT.jar ./app.jar
CMD ["java", "-jar", "./app.jar"]