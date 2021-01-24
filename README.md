cd /home/hakan/IdeaProjects/product/docker/mongo
docker-compose up





Test

curl -X PUT -H "Content-Type: application/json" \
-d '{"name":"abc","uuid":"14e0f27d-66f5-4029-864b-c38b3cefd764"}' \
http://localhost:31704/

curl http://localhost:31704/14e0f27d-66f5-4029-864b-c38b3cefd764

curl -X DELETE http://localhost:31704/14e0f27d-66f5-4029-864b-c38b3cefd764
