FROM amazoncorretto:17.0.6-alpine
LABEL authors="Park"

WORKDIR /home/spring-api
RUN chmod -R 755 /home/spring-api
# 실행 명령
ENTRYPOINT ["java","-Djava.security.egd", "-Xdebug","-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=*:5005","-jar","spring-api-0.0.1-SNAPSHOT.jar"]