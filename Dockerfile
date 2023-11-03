FROM maven:3.8.3-jdk-11 AS builder
VOLUME /tmp
COPY . .
RUN mvn clean install compile package -DskipTests

FROM openjdk:11
VOLUME /tmp
EXPOSE 5001
COPY --from=builder ./target/apiteste-0.0.1-SNAPSHOT.jar /
ADD https://github.com/open-telemetry/opentelemetry-java-instrumentation/releases/latest/download/opentelemetry-javaagent.jar .
ENTRYPOINT ["java","-jar","/apiteste-0.0.1-SNAPSHOT.jar"]