FROM openjdk:17-oracle
LABEL maintainer="nttdata.cl"
ADD target/sumativaDosInacap-1.0.jar springboot-docker-demo1.jar
ENTRYPOINT ["java","-jar","springboot-docker-demo1.jar"]