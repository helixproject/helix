#!/bin/bash

idDocker=$1
version=$2

cd /home/yuanbo/docker-checkpoint-images
mkdir -p $idDocker/$version

docker checkpoint --leave-running --image-dir=/home/yuanbo/docker-checkpoint-images/$idDocker/$version $idDocker
