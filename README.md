mvn clean package spring-boot:run -DskipTests
mvn clean package -DskipTests


mvn jacoco:report
mvn clean verify


-- Dummy
https://start.spring.io/#!type=maven-project&language=java&platformVersion=2.3.1.RELEASE&packaging=jar&jvmVersion=1.8&groupId=com.kuroshan.workshop.ms&artifactId=ms-dummy&name=Ms%20Dummy&description=Workshop%20Microservices&packageName=com.kuroshan.workshop.ms.dummy&dependencies=web,data-jpa,actuator,h2,lombok

https://start.spring.io/#!type=maven-project&language=java&platformVersion=2.3.2.RELEASE&packaging=jar&jvmVersion=1.8&groupId=com.kuroshan.workshop.ms.hr&artifactId=discovery-server&name=Discovery%20Server&description=HR%20Discovery%20Server&packageName=com.kuroshan.workshop.ms.hr.discovery-server&dependencies=cloud-eureka-server

-- api gateway
https://start.spring.io/#!type=maven-project&language=java&platformVersion=2.3.2.RELEASE&packaging=jar&jvmVersion=1.8&groupId=com.kuroshan.workshop.ms.hr&artifactId=zuul-server&name=Zuul%20Server&description=HR%20Zuul%20Server&packageName=com.kuroshan.workshop.ms.hr.zuul.server&dependencies=cloud-eureka,actuator,cloud-zuul

-- config server
https://start.spring.io/#!type=maven-project&language=java&platformVersion=2.3.2.RELEASE&packaging=jar&jvmVersion=1.8&groupId=com.kuroshan.workshop.ms.hr&artifactId=config-server&name=config-server&description=HR%20Config%20Server&packageName=com.kuroshan.workshop.ms.hr.config.server&dependencies=actuator,cloud-config-server

-- admin server
https://start.spring.io/#!type=maven-project&language=java&platformVersion=2.3.2.RELEASE&packaging=jar&jvmVersion=1.8&groupId=com.kuroshan.workshop.ms.hr&artifactId=admin-server&name=Admin%20Server&description=HR%20Admin%20Server&packageName=com.kuroshan.workshop.ms.hr.admin.server&dependencies=codecentric-spring-boot-admin-server,cloud-eureka,web

http://localhost:8888/ms-hr-discovery-server/default
http://localhost:8888/ms-hr-discovery-server/prod

-- users
https://start.spring.io/#!type=maven-project&language=java&platformVersion=2.2.8.RELEASE&packaging=jar&jvmVersion=1.8&groupId=com.kuroshan.workshop.ms.hr&artifactId=ms-users&name=Microservice%20Users&description=HR%20Microservice%20Users&packageName=com.kuroshan.workshop.ms.hr.ms.users&dependencies=web,actuator,data-jpa,h2,lombok,data-rest,cloud-eureka,cloud-config-client

-- security
https://start.spring.io/#!type=maven-project&language=java&platformVersion=2.2.8.RELEASE&packaging=jar&jvmVersion=1.8&groupId=com.kuroshan.workshop.ms.hr&artifactId=security-server&name=Security%20Server&description=HR%20Microservice%20Security%20Server%20-%20OAuth2&packageName=com.kuroshan.workshop.ms.hr.security.server&dependencies=web,actuator,lombok,cloud-eureka,cloud-config-client,cloud-feign,cloud-oauth2



hystrix:
  command:
    getEmployeeCommand:
      execution:
        isolation:
          thread:
            timeoutInMilliseconds: 1000
          strategy: THREAD
      circuitBreaker:
        requestVolumeThreshold: 20
        sleepWindowInMilliseconds: 5000
        errorThresholdPercentage: 50
      metrics:
        rollingStats:
          timeInMilliseconds: 10000
        rollingPercentile:
          timeInMilliseconds: 60000
        healthSnapshot:
          intervalInMilliseconds: 500
      fallback:
        isolation:
          semaphore:
            maxConcurrentRequests: 10