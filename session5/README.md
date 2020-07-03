docker network create microservices

docker build -t database-oracle:v1 .
docker run -d --name db-infra-oracle --network microservices -p 1523:1521 -p 8083:8080 database-oracle:v1
docker exec -it db-infra-oracle /bin/bash
sqlplus sys/oracle@//localhost:1521/XE as sysdba
@/home/taller_ms.sql oracle oracle hrpw SYSTEM TEMP /home/log/ localhost:1521/XE

docker build -t config-server:v1 .
docker run -d --name ms-infra-config-server --network microservices -p 8888:8888 config-server:v1
docker logs -f config-server (para salir CTRL + Z)

docker build -t discovery-server:v1 .
docker run -d --name ms-infra-discovery-server --network microservices -p 8761:8761 discovery-server:v1
docker logs -f discovery-server (para salir CTRL + Z)

docker build -t microservice-areas:v1 .
docker run -d --name ms-hr-areas --network microservices -p 8082:8080 microservice-areas:v1
docker logs -f ms-hr-areas (para salir CTRL + Z)
