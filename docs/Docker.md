# Docker Linux

TOC
- [Process](#process)
- [Cheat Sheet](#cheatsheet)
- [Install_Docker](#install_docker)
- [Install_SonarCube](#install_sonarcube)
- [Free space](#free_space)
- [Usefull ursl](#usefull_urls)

- [Docker with Dockerfile](docekr_with_dockerfiles)

## Process for App <a name="process"></a>

```bash
docker run -d --name testApp -p 8686:8686 testApp
docker logs testApp
docker exec -i -t testApp bash
docker container ls --all

docker stop testApp
docker start testApp

docker rmi testApp  # delete an image from local image store
```

## Docker run

```bash
docker run
--rm   # remove container automatically after it exits
-it  # connect the container to terminal
--name web  # name the container
-p 5000:80  # expose port 5000 externally and map to port 80
-v ~/dev:/code  # create a host mapped volume inside the container
alpine:3.4  # the image from which the container is instantiated
/bin/sh  # the command to run inside the container

docker stop web  # Stop a running container through SIGTERM
docker kill web  # Stop a running container through SIGKILL
docker network create --subnet 10.1.0.0/24
--gateway 10.1.0.1 -d overlay mynet  # Create an overlay network and specify a subnet

docker network ls  # List the networks
docker ps  # List the running containers
docker rm -f $(docker ps -aq)  # Delete all running and stopped containers
docker exec -it web bash  # Create a new bash process inside the container and connect it to the terminal
docker logs --tail 100 web  # Print the last 100 lines of a container’s logs

```

## CheatSheet <a name="cheatsheet"></a>

```bash
docker --version
docker info
ip a list docker0
    
docker stats  # shows CPU%, MEM usage, Net I/O Block I/O, Pids
    
docker images
docker image ls

# Show containers
docker container ls --all
docker container ls --aq
docker ps
docker ps -a

docker pull IMAGE_ID # Pull an image from a registry
    
docker exec my-nginx-c1 ls /etc/nginx
docker run -i -t <containerIdOrName> /bin/bash
docker exec -it <containerIdOrName> bash
exit
   
docker start IMAGE_ID
docker stop IMAGE_ID
docker rm IMAGE_ID    docker rmi IMAGE_ID
       
docker login dokerHub
docker tag image username/repository:tag
docker tag friendlyhello gordon/get-started:part2
docker push username/repository:tag
       
docker build -t friendlyhello .  # Create image using this directory's Dockerfile
docker run -p 4000:80 friendlyhello  # Run "friendlyhello" mapping port 4000 to 80
docker run -d -p 4000:80 friendlyhello         # Same thing, but in detached mode
docker container ls                                # List all running containers
docker container ls -a             # List all containers, even those not running
docker container stop <hash>           # Gracefully stop the specified container
docker container kill <hash>         # Force shutdown of the specified container
docker container rm <hash>        # Remove specified container from this machine
docker container rm $(docker container ls -a -q)         # Remove all containers
docker image ls -a                             # List all images on this machine
docker image rm <image id>            # Remove specified image from this machine
docker image rm $(docker image ls -a -q)   # Remove all images from this machine
docker login             # Log in this CLI session using your Docker credentials
docker tag <image> username/repository:tag  # Tag <image> for upload to registry
docker push username/repository:tag            # Upload tagged image to registry
docker run username/repository:tag                   # Run image from a registry
    
docker-machine ip [name of Docker VM]
    
docker compose up
    
docker network create reverse-proxy
```

### SWARM - todo

    docker stack ls                                            # List stacks or apps
    docker stack deploy -c <composefile> <appname>  # Run the specified Compose file
    docker service ls                 # List running services associated with an app
    docker service ps <service>                  # List tasks associated with an app
    docker inspect <task or container>                   # Inspect task or container
    docker container ls -q                                      # List container IDs
    docker stack rm <appname>                             # Tear down an application
    docker swarm leave --force      # Take down a single node swarm from the manager

## Install Docker <a name="install_docker"></a>

    sudo yum install docker
    sudo systemctl enable docker

    sudo systemctl restart docker

    Service:
    /etc/system/system/multi-user.target.wants/@docker.service

    Test:
    docker run hello-world

Adding user to group

    sudo groupadd docker
    sudo usermod -aG docker
    
Directory:

    /var/lib/docker

Change directory:

    sudo service docker stop
    ps faux
    sudo ls /var/lib/docker/
    sudo mv /var/lib/docker /app/docker
    sudo ln -s /app/docker /var/lib/docker
    sudo service docker start


## Install Sonarcube <a name="install_sonarcube"></a>

https://hub.docker.com/_/sonarqube/

    docker run -d --name sonarqube -p 9000:9000 sonarqube
    docker container ls
    docker container stop sonarqube

    docker start sonarqube

PROD:

docker run -d --name sonarqube \
    -p 9000:9000 \
    -e sonar.jdbc.username=sonar \
    -e sonar.jdbc.password=sonar \
    -e sonar.jdbc.url=jdbc:postgresql://localhost/sonar \
    sonarqube


## Free space <a name="free_space"></a>

```Bash
docker rm -v $(docker ps -a -q -f status=exited)
docker rmi $(docker images -f "dangling=true" -q)
```

## Usefull ursl <a name="usefull_urls"></a>

DOCKER
https://blog.docker.com/2019/07/intro-guide-to-dockerfile-best-practices/

Install
https://docs.docker.com/install/linux/linux-postinstall/
https://www.cyberciti.biz/faq/install-use-setup-docker-on-rhel7-centos7-linux/
https://forums.docker.com/t/how-do-i-change-the-docker-image-installation-directory/1169




# Docker with Dockerfile <a name="docekr_with_dockerfiles"></a>

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

