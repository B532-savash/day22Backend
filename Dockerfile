FROM eclipse-temurin:17 AS builder
WORKDIR /home
COPY . .
RUN ./mvnw clean package

FROM eclipse-temurin:17
WORKDIR /home
COPY --from=builder /home/target/pancake-house-0.0.1-SNAPSHOT.jar coffee-order.jar
ENTRYPOINT ["java", "-jar", "pancake-house.jar"]