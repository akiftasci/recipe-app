FROM openjdk:8
add target/*.jar app.jar
ENTRYPOINT ["java","-jar","app.jar"]