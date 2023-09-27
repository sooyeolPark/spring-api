#!/bin/bash

#jar restart sh 작성
echo "PID Check..."

CURRENT_PID=$(fuser 8080/tcp)

echo "Running PID: {$CURRENT_PID}"

if [ -z $CURRENT_PID ] ; then
    echo "Project is not running"
else
    kill $CURRENT_PID &
fi

wait

echo "Deploy Project...."

nohup java -Djava.security.egd -Xdebug -agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=*:5005 -jar /home/spring-api/jar-path/spring-api-0.0.1-SNAPSHOT.jar &

echo "Done"
