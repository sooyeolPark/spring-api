FROM amazoncorretto:17.0.6-alpine
LABEL authors="Park"

COPY ./script/jar_monitoring.sh /home/spring-api/script/jar_monitoring.sh
COPY ./script/jar_restart.sh /home/spring-api/script/jar_restart.sh
COPY ./script/init.sh /home/spring-api/script/init.sh

RUN chmod -R 755 /home/spring-api/script/jar_monitoring.sh
RUN chmod -R 755 /home/spring-api/script/jar_restart.sh
RUN chmod -R 755 /home/spring-api/script/init.sh

WORKDIR /home/spring-api/jar-path
RUN chmod -R 755 /home/spring-api/jar-path

# 실행 명령
# ENTRYPOINT와 CMD 명령어는 여러개를 쓸 수 없으며 마지막 명령어만 실행된다.
# 여러 명령어를 쓰려면 shell script로 만들어 쓰는 것이 좋다.
ENTRYPOINT ["sh","/home/spring-api/script/init.sh"]

