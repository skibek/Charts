# Docker with Dockerfile


## Dockerfile example
```
# Alpine Linux with OpenJDK JRE
FROM openjdk:8-jre-alpine

# Set multiple labels at once, using line-continuation characters to break long lines
LABEL vendor=ACME\ Incorporated \
      com.example.is-beta= \
      com.example.is-production="" \
      com.example.version="0.0.1-beta" \
      com.example.release-date="2015-02-12"
      
# Install tools required for project. Run `docker build --no-cache .` to update dependencies
RUN apk add --no-cache bash
RUN apk add --no-cache git

# Sort multi-line arguments
RUN apt-get update && apt-get install -y \
  bzr \
  cvs \
  git \
  mercurial \
  subversion

# copy WAR into image. These layers are only re-built when files are updated
COPY spring-boot-app-0.0.1-SNAPSHOT.war /app.war 
COPY logback.xml /logback.xml

# Copy the entire project and build it. This layer is rebuilt when a file changes in the project directory
COPY . /go/src/project/
RUN go build -o /bin/project

# run application with this command line 
CMD ["/usr/bin/java", "-jar", "-Dspring.profiles.active=default", "-Dlogging.config=/logback.xml", "/app.war"]

-- OR

COPY run.sh /run.sh
ENTRYPOINT ["/run.sh"]

-- The default ENTRYPOINT is /bin/sh -c
```

run.sh
```bash
#!/bin/sh
java -Dspring.profiles.active=$1 -Dlogging.config=/logback.xml -jar /app.war
```

## Command to build

```bash
docker build -t spring-boot-app:latest
```

## Run docker image
```bash
docker image ls
docker run -d --name bootapp -v /var/log/app:/var/log/Application/ -p 8080:8080 spring-boot-app:latest
docker run -d --name bootapp -v /var/log/app:/var/log/Application/ -p 8080:8080 spring-boot-app:latest dev  # with run.sh
docker ps
docker history spring-boot-app:latest
docker stop imagename
docker ps -a
docker restart imagename
docker rm imagename  # delete image
docker logs imagename
docker exec -it imagename sh
docker exec -it imagename bash
grep profiles /var/log/webapp/application.log
```
> -d run as a daemon process and detach from the console

> -p map port 8080 on the host machine to port 8080 in the container

## Publish docker image
```bash
docker login
docker tag spring-boot-app baeldung/spring-boot-app:.0.0.1
docker image ls
docker push baeldung/spring-boot-app:.0.0.1

-- Other server
docker run  # Pulls image from hub
```

## URLs

https://docs.docker.com/develop/develop-images/dockerfile_best-practices/

https://docs.docker.com/config/containers/start-containers-automatically/

https://blog.softwaremill.com/editing-files-in-a-docker-container-f36d76b9613c
