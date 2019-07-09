Main:

```Bash
alias, where, which
whoami
id  # shows uid and groups
whoami /groups  # shows groups
sudo su -
sudo su - tomcat
sudo mc
ps -aux | grep java
ps -ef | grep sonar
kill -9 PID

yum install jenkins
mysql -u root -p

CTRL + SHIFT + R - cmd history
```

New user:
```Bash
useradd username
passwd username
sudo visudo
sudo usermod -aG wheel username
chmod 755 -R dir
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
    

## VI simple

STARTING vi

     vi filename    edit a file named "filename"

     vi newfile     create a new file named "newfile"

 

ENTERING TEXT

     i            insert text left of cursor

     a            append text right of cursor

 

ESC – go to Command mode

 

CLOSING AND SAVING A FILE

     ZZ            save file and then quit

     :w            save file

     :q!            discard changes and quit file
