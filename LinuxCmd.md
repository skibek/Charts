Main:

```Bash
whoami
sudo su -
sudo su - tomcat
sudo mc
ps -aux | grep java
kill -9 PID

CTRL + SHIFT + R - cmd history
```

System Manager (SysV, systemd, Upstart)

https://linuxconfig.org/detecting-which-system-manager-is-running-on-linux-system
    
    ps -p 1
    sudo ls -l /proc/1/exe
    ls -l /sbin/init

Check Linux ver

    cat /etc/redhat-release
    
Users ins system

    less /etc/passwd

Ports

    sudo netstat -anlp | grep 1099
    sudo netstat -pln   (busy ports)
    sudo netstat -tulpn | grep :8082

Set Java version as Main:

    sudo /usr/sbin/alternatives --config java
    
    java -version
    which java


Others:
    
    alias
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
    id
    last
    CTRL-D
    w
    who
    history
    curl
    
    chown -R jboss:jboss /opt/jboss
    tar -zcvf archive-name.tar.gz directory-name

Disk space:

    df -a
    df -h 
    du -sh file_path   (disc usage)
    MC - CTRL+SPACE on dir
    sudo iotop -P -a

Free disk space:

    sudo apt-get autoremove
    sudo apt-get clean
    sudo apt-get autoclean

Memory space

    free -g
    free -m

Services:

After changes in service file:

    sudo systemctl daemon-reload
    
    sudo systemctl restart tomcat
    start, stop, restart, status

Processes:

    kill -9 PID
    
Check logs of running service:

    sudo journalctl -xe
    
    sudo chown -R tomcat /app/apache-tomcat-9.0.6/
sudo chgrp -R users /app/apache-tomcat-9.0.6/

    telnet djrcfeed.dowjones.com 22
    telnet 10.7.251.52 1521  
   
Firewall:

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
    
