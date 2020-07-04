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
docker run -d --name infra-microservice-securityserver --network workshopms -p 8081:8080 workshopms-microservice-securityserver:v1
docker logs -f infra-microservice-securityservers



docker build -t microservice-areas:v1 .
docker run -d --name ms-hr-areas --network microservices -p 8082:8080 microservice-areas:v1
docker logs -f ms-hr-areas
