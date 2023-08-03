FROM gradle:jdk17

COPY ./build/libs/statistics-generator-0.0.1-SNAPSHOT.jar /statistics-generator.jar

CMD ["java", "-jar", "/statistics-generator.jar"]