FROM openjdk:8-jre-alpine3.9

ADD target/chat-server-1.0-SNAPSHOT.jar /app.jar
ADD hello-world.yml /hello-world.yml

EXPOSE 8080 8081

ENTRYPOINT ["java", "-jar", "/app.jar", "server", "hello-world.yml"]