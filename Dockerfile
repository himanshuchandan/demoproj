FROM openjdk:8
COPY target/my-app-1.0-SNAPSHOT.jar /sampleapp.jar
CMD ["java", "-jar", "/sampleapp.jar"]
