#!/bin/bash
nohup java -Djava.security.egd -Xdebug -agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=*:5005 -jar /home/spring-api/jar-path/spring-api-0.0.1-SNAPSHOT.jar &
sh /home/spring-api/script/jar_monitoring.sh