FROM openjdk:11-jdk
MAINTAINER eyup
VOLUME /tmp
EXPOSE 9091
ADD target/reading-is-good-0.0.1-SNAPSHOT.jar reading-is-good.jar
ENTRYPOINT ["java","-jar","/reading-is-good.jar"]