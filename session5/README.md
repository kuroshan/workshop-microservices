************************
*      DOCKERFILE      *
************************

docker network create workshopms

docker build -t workshopms-microservice-configserver:v1 .
docker run -d --name microservice-configserver --network workshopms -p 8888:8888 workshopms-microservice-configserver:v1
docker logs -f microservice-configserver

docker build -t workshopms-microservice-discoveryserver:v1 .
docker run -d --name microservice-discoveryserver --network workshopms -p 8761:8761 workshopms-microservice-discoveryserver:v1
docker logs -f microservice-discoveryserver

docker build -t workshopms-microservice-securityserver:v1 .
docker run -d --name microservice-securityserver --network workshopms -p 8080:8080 workshopms-microservice-securityserver:v1
docker logs -f microservice-securityserver

docker build -t workshopms-microservice-edgeservice:v1 .
docker run -d --name microservice-edgeservice --network workshopms -p 9090:9090 workshopms-microservice-edgeservice:v1
docker logs -f microservice-edgeservice

docker build -t workshopms-microservice-users:v1 .
docker run -d --name microservice-users --network workshopms -p 8081:8080 workshopms-microservice-users:v1
docker logs -f microservice-users

docker build -t workshopms-database-oracle:v1 .
docker run -d --name database-oracle --network workshopms -p 1521:1521 workshopms-database-oracle:v1
docker logs -f database-oracle

docker build -t workshopms-microservice-areas:v1 .
docker run -d --name microservice-areas --network workshopms -p 8082:8080 workshopms-microservice-areas:v1
docker logs -f microservice-areas

docker build -t workshopms-microservice-employees:v1 .
docker run -d --name microservice-employees --network workshopms -p 8083:8080 workshopms-microservice-employees:v1
docker logs -f microservice-employees

docker stop $(docker ps -q)
docker rm $(docker ps -a -q)
docker network rm workshopms

************************
*    DOCKER-COMPOSE    *
************************

docker-compose --version

docker-compose up -d

docker-compose down

docker-compose scale microservice-areas=4 microservice-employees=2
