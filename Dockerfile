# Etapa de build com Maven e JDK 17
FROM maven:3.8.3-eclipse-temurin-17 AS builder
VOLUME /tmp
COPY . .
RUN mvn clean install compile package -DskipTests

# Etapa de runtime com JDK 17
FROM eclipse-temurin:17
VOLUME /tmp
EXPOSE 5001

# Copia o JAR gerado na etapa de build
COPY --from=builder ./target/apiteste-0.0.1-SNAPSHOT.jar /

# Baixa o agente do OpenTelemetry
ADD https://github.com/open-telemetry/opentelemetry-java-instrumentation/releases/latest/download/opentelemetry-javaagent.jar .

# Executa a aplicação
ENTRYPOINT ["java", "-javaagent:opentelemetry-javaagent.jar", "-jar", "/apiteste-0.0.1-SNAPSHOT.jar"]
