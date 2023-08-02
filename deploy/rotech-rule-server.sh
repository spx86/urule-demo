#!/bin/bash
BUILD_ID=dontKillMe
cd /root/urule
if [ ! -d error_log ]
then
    mkdir -p error_log
fi
pid=$(ps -ef | grep edas-rule-server | grep 'java' | grep -v grep | awk '{print $2'})
if [ -z "$pid" ]; then
 echo 'there are not edas-rule-server process. starting will be continue.'
fi
if [ -n "$pid" ]; then
 echo 'java process id is '$pid
 if ps -p $pid > /dev/null
 then
  echo $pid' will be kill'
  kill -9 $pid
 fi
fi
echo 'start edas-rule-server wait.'
nohup java -jar -Xms128m -Xmx256m -Xmn64m edas-rule-server-1.0.0.jar >/dev/null 2>error_log/edas-rule-server-error.log &
echo 'finish starting edas-rule-server'