On AWS
host1: docker swarm init
host2: docker swarm join --token <your_token> <your_ip_address>:2377

docker stack deploy --compose-file docker-compose.yml product-stack

docker stack rm stackdemo


host1: docker network create --driver=overlay --attachable product-net


docker service create --replicas 1 \
--name product-mongodb \
--network product-net \
--env MONGO_INITDB_ROOT_USERNAME=hakan \
--env MONGO_INITDB_ROOT_PASSWORD=kay1983nar \
--env MONGO_INITDB_DATABASE=product \
--publish 27017:27017 \
--mount type=bind,src=/home/ubuntu/mongo-init.js,dst=/docker-entrypoint-initdb.d/mongo-init.js \
mongo:latest

docker service create --replicas 1 \
--name product-api \
--network product-net \
--publish 8080:8080 \
hakankaynar/product:latest