#!/usr/bin/env sh

systemctl enable --now zookeeper
sleep 5
/opt/devel/kafka/bin/kafka-server-start.sh /opt/devel/kafka/config/server.properties