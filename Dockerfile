FROM maven:3.8.1-openjdk-17-slim
COPY . .
RUN mvn clean install
CMD mvn spring-boot:run
EXPOSE $SERVER_PORT