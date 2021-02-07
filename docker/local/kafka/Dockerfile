FROM adoptopenjdk:11-jre-hotspot

ARG KAFKA_DIR=/opt/devel/kafka

RUN apt-get update && \
apt-get install -y wget && \
apt-get install -y systemctl && \
mkdir -p $KAFKA_DIR/data-zookeeper && \
mkdir -p $KAFKA_DIR/data-kafka && \
mkdir -p $KAFKA_DIR/logs-kafka && \
cd $KAFKA_DIR && \
wget https://mirror.softaculous.com/apache/kafka/2.7.0/kafka_2.13-2.7.0.tgz && \
tar -xvf *.tgz && \
rm kafka_2.13-2.7.0.tgz && \
mv kafka_2.13-2.7.0/* . && \
rmdir kafka_2.13-2.7.0

COPY zookeeper.service /etc/systemd/system/zookeeper.service
COPY kafka.service /etc/systemd/system/kafka.service

RUN systemctl daemon-reload

WORKDIR $KAFKA_DIR

COPY zookeeper.properties config/zookeeper.properties
COPY kafka.properties config/server.properties
COPY start.sh start.sh

HEALTHCHECK --interval=60s --timeout=10s CMD (systemctl status zookeeper && systemctl status zookeeper) || exit 1

EXPOSE 9092

CMD sh start.sh