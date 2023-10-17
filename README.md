1. 개발 편의를 위해 docker-image에는 빌드된 jar파일만 올라간다.
2. 프로젝트 경로 안에 jar-path 밑에 jar 파일이 빌드 되도록 설정해 두어야 한다.
3. volume을 통하여 local에서 생성된 jar 파일이 바로 이미지 안 jar파일로 반영된다.
4. Dockerfile을 이용하여 이미지가 올라갈때 docker image안에서 jar파일 감시하는 쉘 스크립트(jar_monitoring.sh)를 실행시켜 jar파일이 변경이 있으면(local에서 개발 후 빌드 시) 자동으로 spring-boot를 재시작하게된다. 
   1. 처음엔 inotify와 같은 파일 감시 시스템을 설치하여 파일을 감시하려 했지만 docker volume의 파일 변경은 컨테이너 내의 파일시스템으로 catch할수 없기때문에 shell script를 이용하였다.
5. 결론적으로 local에 있는 프로젝트를 빌드하여 jar-path안에 특정 이름의 jar파일이 생성되면 docker 컨테이너 안에 바로 반영이 된다.

6. script파일 (Window에서는 LF형식으로 변경할 것)
    1. init.sh
       - 컨테이너가 실행되고 아무것도 동작하는 서비스가 없으면 자동으로 컨테이너가 종료된다. 컨테이너가 올라 간 후 jar파일을 실행시켜주고 jar파일의 변경을 감지하는 jar_monioring.sh를 실행시켜주는 쉘스크립트이다.
    2. jar_monitoring.sh
       - volume으로 잡힌 jar파일을 컨테이너 안의 file system에서 감지할 수 없기 때문에 1초마다 반복문을 돌려서 기존 jar파일과 지금의 jar파일이 변경되었는지 검사한다.
       - md5sum을 이용하면 파일의 변경을 잡아낼 수 있다.
       - 변경이 감지되면 비교할 jar파일을 바꾸고 jar_restart.sh 쉘 명령어를 실행하고 다시 감시를 시작한다.
    3. jar_restart.sh
       - 현재 jar 실행하고있는 PID를 찾은 후 강제 종료시킨 후 jar를 재시작 해준다.

7. 프로젝트 빌드할 때 java project 기준 ../docker-setting/jar-build에 jar파일이 생성되게 설정한다.
   1. IntelliJ 기준
      실행/디버그 구성 -> 새구성 추가 -> Gradle 선택 -> 실행 셀렉트박스에서 Build 선택 후 적용 