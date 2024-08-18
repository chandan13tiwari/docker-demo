FROM ubuntu

RUN apt-get update
RUN apt-get upgrade
RUN apt install -y openjdk-17-jdk
RUN apt install -y maven

RUN mkdir docker-poc
WORKDIR docker-poc/

RUN mkdir src && cd src && mkdir main
COPY src/main src/main
COPY Dockerfile .
COPY pom.xml .
COPY .gitignore .
RUN mvn clean install

RUN cd src/ && mkdir test
COPY ./src/test src/test
RUN mvn clean test

COPY target/docker-demo-0.0.1-SNAPSHOT.jar .
ENTRYPOINT [ "java", "-jar", "docker-demo-0.0.1-SNAPSHOT.jar" ]


