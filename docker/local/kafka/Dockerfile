FROM adoptopenjdk:11-jre-hotspot

ARG KAFKA_DIR=/opt/devel/kafka
ARG KAFKA_TAR_GZ=kafka_2.13-2.7.0.tgz

RUN mkdir -p $KAFKA_DIR

COPY $KAFKA_TAR_GZ $KAFKA_DIR
COPY start.sh $KAFKA_DIR

WORKDIR $KAFKA_DIR

RUN tar -xvf *.tgz && \
rm $KAFKA_TAR_GZ && \
mv kafka_2.13-2.7.0/* . && \
rmdir kafka_2.13-2.7.0

COPY kafka.properties config/server.properties

EXPOSE 9092

CMD sh start.sh