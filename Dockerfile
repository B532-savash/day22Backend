FROM eclipse-temurin:17 AS builder
WORKDIR /home
COPY . .
RUN chmod +x mvnw && ./mvnw clean package -DskipTests

FROM eclipse-temurin:17
WORKDIR /home
COPY --from=builder /home/target/pancake-house-0.0.1-SNAPSHOT.jar pancake-house.jar
ENTRYPOINT ["java", "-jar", "pancake-house.jar"]
