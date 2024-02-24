FROM gradle:7.6.1-jdk17-alpine AS builder

WORKDIR /usr/app/

COPY . .

RUN gradle bootJar

FROM eclipse-temurin:17.0.5_8-jre-alpine

COPY --from=builder /usr/app/build/libs/web-service-gateway.jar /opt/app/web-service-gateway.jar

RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring

CMD java -jar /opt/app/web-service-gateway.jar
EXPOSE $SERVER_PORT

