FROM openjdk:8-jdk-alpine
ENV APP_HOME=/usr/app
ENV APP_DATA_HOME=/usr/data
RUN mkdir $APP_HOME
RUN mkdir $APP_DATA_HOME
WORKDIR $APP_HOME
ARG JAR_FILE=build/libs/demo-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar
CMD ["java", "-jar", "app.jar"]