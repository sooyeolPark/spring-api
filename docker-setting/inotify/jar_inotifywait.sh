#!/bin/bash

# 감시할 파일 경로
file_path="/home/spring-api/jar-path/spring-api-0.0.1-SNAPSHOT.jar"

# inotifywait를 사용하여 파일 이벤트 감시
inotifywait -m -e create,modify,delete "$file_path" |
while read -r events file
do
    case $events in
        *)
            echo 'catch'
#            sh /home/spring-api/script/jar_restart.sh
            ;;
    esac
done

inotifywait -m -e create,modify -r "/home/spring-api/jar-path/" |
while read dirname eventlist filename
do
  echo ${dirname} ${filename}
done