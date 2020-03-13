FROM openjdk:8

RUN mkdir -p /usr/src/my_blog

WORKDIR /usr/src/my_blog

COPY target/java-k8s-web-1.0-SNAPSHOT-jar-with-dependencies.jar java-k8s-web.jar

EXPOSE 4567

CMD ["java", "-jar", "java-k8s-web.jar"]
