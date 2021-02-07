#!/bin/bash

docker build -t product-kafka . && \
docker image tag product-kafka:latest hakankaynar/product-kafka:latest

#docker push hakankaynar/product-zookeeper:latest
