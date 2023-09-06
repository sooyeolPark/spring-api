FROM amazoncorretto:17.0.6-alpine
LABEL authors="Park"

ARG JAR_FILE=build/libs/spring-api-0.0.1-SNAPSHOT.jar

ADD ${JAR_FILE} spring-api.jar

# 실행 명령
ENTRYPOINT ["java","-Djava.security.egd", "-Xdebug","-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=*:5005","-jar","/spring-api.jar"]

