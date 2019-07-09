
Set Java version as Main:

    sudo /usr/sbin/alternatives --config java
    
    java -version

sudo su - tomcat

chmod 755 /app/apache-tomcat-9.0.6/bin/startup.sh
/app/apache-tomcat-9.0.6/bin/startup.sh


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
    
