FROM openjdk:18

RUN mkdir "/app"

ADD target/mini-project-0.0.1-SNAPSHOT.jar /app/mini-project-0.0.1-SNAPSHOT.jar

EXPOSE 8086

CMD java -jar /app/mini-project-0.0.1-SNAPSHOT.jar