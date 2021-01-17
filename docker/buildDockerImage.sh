#!/bin/bash
cp ../build/libs/product-1.0-SNAPSHOT.jar ./product.jar && \
  docker build -t product-1.0-snapshot . && \
  rm ./product.jar
