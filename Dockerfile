FROM gradle:latest AS BUILD_STAGE
RUN 'ls'
COPY --chown=gradle:gradle . /home/gradle
RUN gradle build || return 1

FROM openjdk:21-slim-buster
EXPOSE 80
ENV SPRING_PROFILES_ACTIVE=prod
COPY --from=0 /home/gradle .
CMD ["java -jar ./build/libs/hack-connect-0.0.1-SNAPSHOT.jar"]