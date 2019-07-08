# Docker Linux

# TOC
1. [Usefull ursl](#cheatsheet)
2. [Install_Docker](#install_docker)
3. [Install_SonarCube](#install_sonarcube)
4. [Usefull ursl](#usefull_urls)

## CheatSheet <a name="cheatsheet"></a>

    docker --version
    docker info
    ip a list docker0
    
    docker image ls
    
    docker container ls --all
    docker container ls --aq
    
    docker ps
    docker ps -a

    docker exec my-nginx-c1 ls /etc/nginx
    docker exec -i -t my-nginx-c1 bash
    
    docker start image
    docker stop image
    docker rm image
       
    docker login
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

SWARM - todo

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


## Usefull ursl <a name="usefull_urls"></a>

DOCKER
https://blog.docker.com/2019/07/intro-guide-to-dockerfile-best-practices/

Install
https://docs.docker.com/install/linux/linux-postinstall/
https://www.cyberciti.biz/faq/install-use-setup-docker-on-rhel7-centos7-linux/
https://forums.docker.com/t/how-do-i-change-the-docker-image-installation-directory/1169

