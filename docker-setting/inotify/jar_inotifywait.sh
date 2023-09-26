#!/bin/bash

# 감시할 파일 경로
file_path="/home/spring-api/spring-api-0.0.1-SNAPSHOT.jar"

# inotifywait를 사용하여 파일 이벤트 감시
inotifywait -m -e create,modify,delete --format "%e %w" "$file_path" |
while read -r events file
do
    case $events in
#        CREATE)
#            echo "파일 $file 가 생성되었습니다."
#            ;;
#        MODIFY)
#            echo "파일 $file 가 수정되었습니다."
#            ;;
#        DELETE)
#            echo "파일 $file 가 삭제되었습니다."
#            ;;
        *)
            sh /home/spring-api/script/jar_restart.sh
            ;;
    esac
done