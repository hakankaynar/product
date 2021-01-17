How to push docker image to AWS
1) Get user id
   
`aws sts get-caller-identity`

Response: 

`{
    "UserId": "xxxx",
    "Account": "892574972156",
    "Arn": "xxxx"
}`

2) Login with docker

`aws ecr get-login-password --region eu-central-1 | docker login --username AWS --password-stdin 892574972156.dkr.ecr.eu-central-1.amazonaws.com`

3) Push 

docker tag product-1.0-snapshot:latest 892574972156.dkr.ecr.eu-central-1.amazonaws.com/product:1.0-snapshot
docker push 892574972156.dkr.ecr.eu-central-1.amazonaws.com/product:1.0-snapshot



How to push docker image to docker hub

docker image tag product-1.0-snapshot:latest hakankaynar/product:latest
docker push hakankaynar/product:latest

How to run application on AWS EC2
ssh -i "hakan-ubuntu.pem" ubuntu@3.120.26.13
sudo docker run -it --rm --name random-hakan -p 8080:8080 hakankaynar/product






