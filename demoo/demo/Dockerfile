FROM eclipse-temurin:17-jre-focal
WORKDDIR /myapp
COPY target/*.jar ./app.jar
EXPOSE 8080
CMD [ "java" , "-jar" , "app.jar" ]

