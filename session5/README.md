docker network create workshopms

docker build -t workshopms-database-oracle:v1 .
docker run -d --name infra-database-oracle --network workshopms -p 1521:1521 workshopms-database-oracle:v1
docker logs -f infra-database-oracle

docker build -t workshopms-microservice-configserver:v1 .
docker run -d --name infra-microservice-configserver --network workshopms -p 8888:8888 workshopms-microservice-configserver:v1
docker logs -f infra-microservice-configserver

docker build -t workshopms-microservice-discoveryserver:v1 .
docker run -d --name infra-microservice-discoveryserver --network workshopms -p 8761:8761 workshopms-microservice-discoveryserver:v1
docker logs -f infra-microservice-discoveryserver

docker build -t workshopms-microservice-securityserver:v1 .
docker run -d --name infra-microservice-securityserver --network workshopms -p 8080:8080 workshopms-microservice-securityserver:v1
docker logs -f infra-microservice-securityserver

docker build -t workshopms-microservice-edgeservice:v1 .
docker run -d --name infra-microservice-edgeservice --network workshopms -p 9090:9090 workshopms-microservice-edgeservice:v1
docker logs -f infra-microservice-edgeservice

docker build -t workshopms-microservice-users:v1 .
docker run -d --name security-microservice-users --network workshopms -p 8081:8080 workshopms-microservice-users:v1
docker logs -f security-microservice-users

docker build -t workshopms-microservice-areas:v1 .
docker run -d --name humanresources-microservice-areas --network workshopms -p 8082:8080 workshopms-microservice-areas:v1
docker logs -f humanresources-microservice-areas

docker build -t workshopms-microservice-employees:v1 .
docker run -d --name humanresources-microservice-employees --network workshopms -p 8083:8080 workshopms-microservice-employees:v1
docker logs -f humanresources-microservice-employees
