#!/bin/sh
# script that gets a hash of a directory and checks every few seconds if the hash has changed
# if it has changed, it executes a command

file_path="/home/spring-api/jar-path/spring-api-0.0.1-SNAPSHOT.jar"
exec_script="/home/spring-api/script/jar_restart.sh"

file="${file_path##*/}"
path="${file_path%%$file}"

cd $path
readonly getmd5sum="tar -c $file | md5sum"
md5val="`eval ${getmd5sum}`"

while : ; do
 if [ "${md5val}" != "`eval ${getmd5sum}`" ]; then
  echo "changed"
  md5val="`eval ${getmd5sum}`"
  sh $exec_script &
  wait
 fi
 sleep 1
done