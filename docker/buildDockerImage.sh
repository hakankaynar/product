#!/bin/bash

cd .. && ./gradlew clean assemble && cd docker
cp ../build/libs/product-1.0-SNAPSHOT.jar ./product.jar && \
  docker build -t product-1.0-snapshot . && \
  rm ./product.jar
docker image tag product-1.0-snapshot:latest hakankaynar/product:latest
docker push hakankaynar/product:latest
