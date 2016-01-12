#!/bin/sh
idContainer=$1
outputLocation=$2
touch $2
while [ 1 ]
do
   lineNum=`wc -l < output`
   if [ $lineNum -lt 10 ] 
   then
   	date=`date +"%T" | tr -d '\n'`
	space=`printf " "`
	stats=`docker stats --no-stream=true $idContainer | sed -n 2p`
	output=$date$space$stats
	echo $output >> $2
	sleep 1
   else
        sed -i 1d $2
   	date=`date +"%T" | tr -d '\n'`
	space=`printf " "`
	stats=`docker stats --no-stream=true $idContainer | sed -n 2p`
	output=$date$space$stats
	echo $output >> $2
	sleep 1
   fi
done
