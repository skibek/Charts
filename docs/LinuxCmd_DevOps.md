# Linux Commands (RHEL > 7.5) & DevOps

TOC
- [Commands - general](#commands_general)
    - [Main](#commands_main)
    - [New user](#commands_newuser)
    - [System Manager (SysV, systemd, Upstart)](#commands_system_manager)
    - Check Linux ver
    - Users in system
    - Ports
    - Others
    - Disk space
    - Free disk space
    - Memory space
    - Processes
    - Firewall    
- [VI simple](#vi_simple)
- [Services - Java](#services_java)
    - Set Java version as Main
    - Check processes
    - Check logs of service
    - Set service
    - Autostart
    - Service usage
    - Config file - eg: uaa.conf
    - Other cmds
    - After changes in service file
- [SpringBoot apps](#springboot_apps)
- [Jenkins - JAR/WAR](#jenkins_jarwar)

## Commands - General <a name="commands_general"></a>

### Main <a name="commands_main"></a>

```Bash
alias, where, which
whoami
id  # shows uid and groups
whoami /groups  # shows groups
sudo su -
sudo su - tomcat
sudo mc
ps -ef | grep sonar
kill -9 PID

yum install jenkins
mysql -u root -p

CTRL + SHIFT + R - cmd history
```

### New user <a name="commands_newuser"></a>

```Bash
useradd username
passwd username
sudo visudo
sudo usermod -aG wheel username
chmod 755 -R dir
```

### System Manager (SysV, systemd, Upstart)  <a name="commands_system_manager"></a>

https://linuxconfig.org/detecting-which-system-manager-is-running-on-linux-system
    
    ps -p 1
    sudo ls -l /proc/1/exe
    ls -l /sbin/init

### Check Linux ver

    cat /etc/redhat-release
    
### Users in system

    less /etc/passwd

### Ports

    sudo netstat -anlp | grep 1099
    sudo netstat -pln   (busy ports)
    sudo netstat -tulpn | grep :8082

### Others

```Bash
    . ~/.bashrc
    cat /etc/passwd | grep ks
    reset
    clear
    chmod 755 /app/apache-tomcat-9.0.6/bin/startup.sh
    /app/apache-tomcat-9.0.6/bin/startup.sh
    
    env | grep xxx – eg. OCI, LD_LIB, NLS
    echo $PATH
    echo $(pwd)
    ll
    ls -l --block-size=M       lub G
    last
    CTRL-D
    w
    who
    history
    curl
    
    chown -R jboss:jboss /opt/jboss
    tar -zcvf archive-name.tar.gz directory-name
```

### Disk space

    df -a
    df -h 
    du -sh file_path   (disc usage)
    MC - CTRL+SPACE on dir
    sudo iotop -P -a

### Free disk space

    sudo apt-get autoremove
    sudo apt-get clean
    sudo apt-get autoclean

### Memory space

    free -g
    free -m

### Processes

    ps -aux | grep java
    kill -9 PID
   
### Firewall

    sudo systemctl start firewalld
    sudo firewall-cmd --list-all
    sudo firewall-cmd --add-port=80/tcp
    sudo firewall-cmd --add-port=443/tcp
    sudo firewall-cmd --add-port=8443/tcp
    sudo firewall-cmd --add-port=8082/tcp
    sudo firewall-cmd --add-port=8080/tcp
    sudo firewall-cmd --add-masquerade
    sudo firewall-cmd --add-forward-port=port=443:proto=tcp:toport=8443
    sudo firewall-cmd --runtime-to-permanent
    sudo firewall-cmd --add-forward-port=port=80:proto=tcp:toport=8788
    
    sudo systemctl status firewalld
    sudo systemctl enable firewalld
    sudo iptables -S





## VI simple <a name="vi_simple"></a>

STARTING vi

     vi filename    edit a file named "filename"
     vi newfile     create a new file named "newfile"

ENTERING TEXT

     i            insert text left of cursor
     a            append text right of cursor

ESC – go to Command mode

position the cursor over the character to be deleted and type x

CLOSING AND SAVING A FILE

     ZZ            save file and then quit
     :w            save file
     :q!            discard changes and quit file







## Services - Java <a name="services_java"></a>

### Set Java version as Main 

```Shell
sudo /usr/sbin/alternatives --config java
    
java -version
which java
```

### Check processes

```Shell
ps -aux | grep java
ps -aux | grep micro
```

### Check logs of service

    sudo journalctl -xe
    
    sudo chown -R tomcat /app/apache-tomcat-9.0.6/
    sudo chgrp -R users /app/apache-tomcat-9.0.6/

    telnet djrcfeed.dowjones.com 22
    telnet 10.7.251.52 1521  

### Set service

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
    
### Autostart

    check - sudo systemctl is-enabled App
    set - sudo systemctl enable App.service
    
    return - Created symlink from /etc/systemd/system/multi-user.target.wants/App.service to /etc/systemd/system/App.service

### Service usage

    sudo systemctl start app    

Actions: start, stop, restart, status

Directly run: (to see log on screen)
    
    java -jar /app/app.jar
    
    
    
### Config file - eg: uaa.conf

    LOG_FOLDER=/app/microservice/smUaa/target/
    PID_FOLDER=/app/microservice/smUaa/target/
    JAVA_OPTS=-Dspring.profiles.active=dev-server

### Other cmds

    sudo chown -R tomcat:tomcat APPdir
    
### After changes in service file

    sudo systemctl daemon-reload
    
    sudo systemctl restart tomcat
    start, stop, restart, status
    
    
    





    
## SpringBoot apps <a name="springboot_apps"></a>

TODO

Spring Boot install

[https://docs.spring.io/spring-boot/docs/current/reference/html/deployment-install.html](https://docs.spring.io/spring-boot/docs/current/reference/html/deployment-install.html)







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
