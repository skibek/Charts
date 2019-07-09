# JAVA - DevOps - Linux (RHEL > 7.5)

# TOC
1. [Linux Commands](#linux_commands)
2. [Jenkins - JAR/WAR](#jenkins_jarwar)
3. [Others](#others)
    1. [SpringBoot apps](#springboot_apps)
4. [Links](#links)

## Linux Commands <a name="linux_commands"></a>

Check processes

```Shell
    ps -aux | grep java
    ps -aux | grep micro
```

Select Java version

    sudo /usr/sbin/alternatives --config java
    
Check logs of service

    sudo journalctl -xe

Others

    telnet ggg.com 22

Firewall
    
    sudo systemctl start firewalld
    sudo firewall-cmd --list-all
    sudo firewall-cmd --add-port=80/tcp
    sudo firewall-cmd --add-masquerade
    sudo firewall-cmd --add-forward-port=port=443:proto=tcp:toport=8443
    sudo firewall-cmd --runtime-to-permanent
    
    sudo systemctl enable firewalld

## Jenkins - JAR/WAR <a name="jenkins_jarwar"></a>

Publish over SSH - connect to host, use one user - eg. tomcat

    send to remote dir by SSH
    call Shell actions
    
Actions:

    sudo systemctl stop APP
    mv APP to /app/APP
    chmod 755 /app/APP
    sudo systemctl start APP

Sudo for user to work with Jenkins (without password)

    sudo visudo
    
    # comment - what for
    Cmnd_Alias MYAPP_CMNDS = /bin/systemctl start APP, /bin/systemctl stop APP
    tomcat ALL=(ALL) NOPASSWD: MYAPP_CMNDS

## Others <a name="others"></a>

### SpringBoot apps <a name="springboot_apps"></a>

#### Set service

File App.service

    [Unit]
    Description=app
    After=syslog.target

    [Service]
    User=tomcat
    ExecStart=/app/microservice/app/app.jar
    SuccessExitStatus=143

    [Install]
    WantedBy=multi-user.target

copy to /etc/systemd/system/app.service
    
#### Autostart

    check - sudo systemctl is-enabled App
    set - sudo systemctl enable App.service
    
    return - Created symlink from /etc/systemd/system/multi-user.target.wants/App.service to /etc/systemd/system/App.service

#### Service usage

    sudo systemctl start app    

Actions: start, stop, restart, status

Directly run: (to see log on screen)
    
    java -jar /app/app.jar
    
    
    
#### Config file - eg: uaa.conf

    LOG_FOLDER=/app/microservice/smUaa/target/
    PID_FOLDER=/app/microservice/smUaa/target/
    JAVA_OPTS=-Dspring.profiles.active=dev-server

#### Other cmds

    sudo chown -R tomcat:tomcat APPdir
    


# Links <a name="links"></a>

Spring Boot install

[https://docs.spring.io/spring-boot/docs/current/reference/html/deployment-install.html](https://docs.spring.io/spring-boot/docs/current/reference/html/deployment-install.html)
