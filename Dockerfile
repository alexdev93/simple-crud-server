FROM eclipse-temurin:17-jdk-focal

WORKDIR /app

COPY .mvn/ ./mvn

# RUN ls ./mvn

COPY mvnw pom.xml ./

RUN chmod +x mvnw

COPY .mvn/wrapper/ .mvn/wrapper/

EXPOSE 8080

RUN ./mvnw dependency:go-offline

COPY src ./src


CMD ["./mvnw", "spring-boot:run"]