# Tomcat

TOC
- [Tomcat config](#tomcat_config)
jmx
ssl
service
- [Spring Boot](#spring_boot)
- [Rollout of logs](#rollout)
- [Native APR for Tomcat](#native_apr)
- [Performance for standalone Tomcat](#performance_standalone)

## Tomcat config <a name="tomcat_config"></a>

### JMX

https://wiki.scn.sap.com/wiki/pages/viewpage.action?pageId=441453905

Add JAR to lib  dir in Tomcat.
In file server.xml add:

<Listener className="org.apache.catalina.mbeans.JmxRemoteLifecycleListener"
              rmiRegistryPortPlatform="1090"
              rmiServerPortPlatform="1091"
              rmiBindAddress="srv-dev"/>

From JDK - VisualVM we can connect by JMX on port 1099

File tomcat-users.xml
```xml
<role rolename="manager-gui"/>
<role rolename="manager-jmx"/>
<role rolename="manager-script"/>
<user username="tomcat" password="pass" roles="manager-gui, manager-jmx, manager-script"/>
```

### SSL - CERT gen

https://www.openssl.org/docs/man1.0.2/apps/x509v3_config.html#Subject-Alternative-Name
https://support.code42.com/Administrator/6/Configuring/Use_KeyStore_Explorer_to_install_a_keystore
https://support.code42.com/Administrator/5/Configuring/Create_a_signed_keystore_with_the_KeyStore_Explorer

KeyExplorer

    Generate Key Pair (all data + extension)
    Przestawiamy Fingerprint na SHA > 1 - SHA-256
    Generate CSR - check Certificate Extensions to request'
     
Check CSR: https://www.sslshopper.com/csr-decoder.html

File server.xml
```xml
<Connector port="8443"
               protocol="org.apache.coyote.http11.Http11NioProtocol"
               maxThreads="250"
               SSLEnabled="true"
               scheme="https"
               secure="true"
               keystoreFile="conf/srv-di-dev.keystore"
               keystorePass="pass"
               clientAuth="false" sslProtocol="TLS">
```

### Entropy random

```Shell
cat /proc/sys/kernel/random/entropy_avail

read /dev/urandom 3
random="$(dd if=/dev/urandom bs=3 count=1)"

In java:
-Dsecurerandom.source=file:/dev/./urandom

sudo yum install haveged
haveged-1.9.1-1.el7.x86_64

sudo systemctl enable haveged
Created symlink from /etc/systemd/system/multi-user.target.wants/haveged.service to /usr/lib/systemd/system/haveged.service.

sudo systemctl start haveged
```

### Tomcat service

Copy file 'tomcat.service' to

    etc/systemd/system/tomcat.service

Check to start on system startup

    sudo systemctl is-enabled tomcat
    
Enable starting on sys start

    sudo systemctl enable tomcat
    sudo systemctl enable logsniffer
    return:
    Created symlink from /etc/systemd/system/multi-user.target.wants/tomcat.service to /etc/systemd/system/tomcat.service.

Commands

    sudo systemctl start tomcat
    sudo systemctl stop tomcat
    sudo systemctl restart tomcat
    sudo systemctl status tomcat

    sudo systemctl start logsniffer

https://www.digitalocean.com/community/tutorials/how-to-install-apache-tomcat-8-on-ubuntu-16-04

Logs:

    systemctl status tomcat
    ● tomcat.service - Apache Tomcat Web Application Container
       Loaded: loaded (/etc/systemd/system/tomcat.service; disabled; vendor preset: disabled)
          Active: active (running) since Thu 2018-10-25 15:11:30 CEST; 4min 24s ago
            Process: 8527 ExecStop=/app/apache-tomcat-9.0.6/bin/shutdown.sh (code=exited, status=1/FAILURE)
              Process: 8548 ExecStart=/app/apache-tomcat-9.0.6/bin/startup.sh (code=exited, status=0/SUCCESS)
               Main PID: 8558 (java)
                  CGroup: /system.slice/tomcat.service
           └─8558 /usr/lib/jvm/java-1.8.0-openjdk-1.8.0.181-3.b13.el7_5.x86_64/jre/bin/java -Djava.util.logging.config.file=/app/apache-tomcat-...

    Oct 25 15:11:30 srv-di-dev systemd[1]: Starting Apache Tomcat Web Application Container...
    Oct 25 15:11:30 srv-di-dev startup.sh[8548]: Existing PID file found during start.
    Oct 25 15:11:30 srv-di-dev startup.sh[8548]: Removing/clearing stale PID file.
    Oct 25 15:11:30 srv-di-dev systemd[1]: Started Apache Tomcat Web Application Container.

https://docs.spring.io/spring-boot/docs/current/reference/html/boot-features-external-config.html

tomcat.service file:
```Shell
[Unit]
Description=Apache Tomcat Web Application Container
After=network.target

[Service]
Type=forking

Environment=JAVA_HOME=/usr/lib/jvm/java-openjdk/jre
Environment=CATALINA_PID=/app/apache-tomcat-9.0.6/temp/tomcat.pid
Environment=CATALINA_HOME=/app/apache-tomcat-9.0.6
Environment=CATALINA_BASE=/app/apache-tomcat-9.0.6

ExecStart=/app/apache-tomcat-9.0.6/bin/startup.sh
ExecStop=/app/apache-tomcat-9.0.6/bin/shutdown.sh

User=tomcat
Group=tomcat
UMask=0007
RestartSec=10
Restart=always

[Install]
WantedBy=multi-user.target
```


## Spring Boot <a name="spring_boot"></a>

### Manual install

File setenv.sh to tomcat/bin

```Shell
export CATALINA_OPTS="$CATALINA_OPTS -Xms512m"
export CATALINA_OPTS="$CATALINA_OPTS -Xmx2048m"
export CATALINA_OPTS="$CATALINA_OPTS -server -XX:+UseParallelGC"
export JAVA_OPTS="$JAVA_OPTS -Djava.awt.headless=true"
export JAVA_OPTS="$JAVA_OPTS -Djava.security.egd=file:/dev/./urandom"
export JAVA_OPTS="$JAVA_OPTS -Dspring.config.location=/app/apache-tomcat-9.0.6/webapps/config/"

export JAVA_OPTS="$JAVA_OPTS -Dspring.profiles.active=dev-server,other"

LD_LIBRARY_PATH=$LD_LIBRARY_PATH:$CATALINA_HOME/lib
export LD_LIBRARY_PATH

export CATALINA_OPTS="$CATALINA_OPTS -Dcom.sun.management.jmxremote -Dcom.sun.management.jmxremote.port=1099 -Dcom.sun.management.jmxremote.ssl=false -Dcom.sun.management.jmxremote.authenticate=false"
```

- app profile - spring.profiles.active
- dir with config - spring.config.location

Working from user 'tomcat'

```Shell
whoami
sudo su tomcat
```

Delete old app
```Shell
rm -R /app/apache-tomcat-9.0.6/webapps/system_modulowy
rm /app/apache-tomcat-9.0.6/webapps/system_modulowy.war
```

Copy new WAR/JAR
```Shell
cp /home/local/BANK/krzysztof.skibinski/systemModulowy/tools-bps-1.0.0.war.original /app/apache-tomcat-9.0.6/webapps/system_modulowy.war
/app/apache-tomcat-9.0.6/bin/startup.sh
```

Shutdown
```Shell
/app/apache-tomcat-9.0.6/bin/shutdown.sh
systemctl stop tomcat
```

Check process
```Shell
ps -aux | grep java
kill -9 PID
```

## Rollout of logs <a name="rollout"></a>

    mv catalina.out catalina.out.2018.09.10   (rozwiązanie tymczasowe z nadaniem daty oryginalnemu plikowi)

Wymuszenie działania:

    logrotate --force /etc/logrotate.d/tomcatMAD

Plik zawiera (Dla catalina.out):

```Shell
/opt/apache/logs/catalina.out {
 copytruncate
 daily
 rotate 50
 missingok
 size 5M
}
```

```Shell
which logrotate
/usr/sbin/logrotate 
```

### Move for logs:

```Shell
mkdir 2016
mv *2016*.log /opt/apache-tomcat-7.0.28/logs/2016
mv *2016*.txt /opt/apache-tomcat-7.0.28/logs/2016

mkdir 2019
mv *2019*.log ./2019
tar -czvf 2019.tar.gz ./2019
rm -rf 2019

mv *2019*.log ./2019
tar -czvf 2019.tar.gz ./2019
rm -rf 2019

```
-- script in bash
```
touch compressByDate.sh
chmod 755 compressByDate.sh

Open file.sh
#!/bin/bash
# A simple script to move, compress log files and delete them - from the data in param eg: $1 = 2020-01
echo "Im going to compress log files with '$1' in name. Type 'YES' to start"
read startFlag
if [ "$startFlag" == "YES" ]; 
then
  echo "Im going to compress log files with '$1' in name"
  mkdir $1
  mv *$1*.log ./$1
  tar -czvf $1.tar.gz ./$1
  rm -rf $1
  echo "Done."
else
  echo "Exiting"
fi

./compressByDate.sh 2020-01
```

## Native APR for Tomcat <a name="native_apr"></a>

Komunikat:

org.apache.catalina.core.AprLifecycleListener.lifecycleEvent The APR based Apache Tomcat Native library which allows optimal performance in production environments was not found on the java.library.path: [/usr/java/packages/lib/amd64:/usr/lib64:/lib64:/lib:/usr/lib]

http://tomcat.apache.org/native-doc/

https://tomcat.apache.org/tomcat-7.0-doc/apr.html

    tar -xzvf /app/apache-tomcat-9.0.6/bin/tomcat-native.tar.gz

### Przygotowanie - apr, java, gcc

    sudo yum install apr-devel openssl-devel

    readlink -f $(which java)
    zwrotka: /usr/lib/jvm/java-1.8.0-openjdk-1.8.0.171-8.b10.el7_5.x86_64/jre/bin/java

Java:

    sudo yum install java-1.8.0-openjdk-devel
    sudo alternatives --config java

GCC:
    
    sudo yum install gcc glibc-devel glibc-headers

```Shell
cd /app/apache-tomcat-9.0.6/bin/tomcat-native-1.2.16-src/native/
./configure --with-java-home=/usr/lib/jvm/java-1.8.0-openjdk-1.8.0.181-3.b13.el7_5.x86_64 \
--with-ssl=yes \
--prefix=/app/apache-tomcat-9.0.6
make && make install
```

File server.xml
```xml
<Listener className="org.apache.catalina.core.AprLifecycleListener" SSLEngine="on" />
<!-- Define a HTTP/1.1 Connector on port 8443, APR implementation -->
<Connector protocol="org.apache.coyote.http11.Http11AprProtocol"
           port="8443" .../>
```

When all is OK:

(file setenv.sh add)
```Shell
LD_LIBRARY_PATH=$LD_LIBRARY_PATH:$CATALINA_HOME/lib
export LD_LIBRARY_PATH
```

```Log
org.apache.catalina.core.AprLifecycleListener.lifecycleEvent Loaded APR based Apache Tomcat Native library [1.2.16] using APR version [1.4.8].

org.apache.catalina.core.AprLifecycleListener.lifecycleEvent APR capabilities: IPv6 [true], sendfile [true], accept filters [false], random [true].

org.apache.catalina.core.AprLifecycleListener.lifecycleEvent APR/OpenSSL configuration: useAprConnector [false], useOpenSSL [true]

org.apache.catalina.core.AprLifecycleListener.initializeSSL OpenSSL successfully initialized [OpenSSL 1.0.2k-fips  26 Jan 2017]
```



## Performance for standalone Tomcat <a name="performance_standalone"></a>

### Compression - GZIP

In file:

server.xml
```xml
<Connector port="8080" protocol="HTTP/1.1"
               connectionTimeout="20000"
               redirectPort="8443" />
```			   
add:
```xml
compression="on"
compressionMinSize="1024"
compressableMimeType="text/html,text/xml,text/plain,text/css,text/javascript,application/javascript"
```

### Cache - Expired

In file:

$CATALINA_HOME/conf/web.xml

add:
```xml
<filter>
    <filter-name>ExpiresFilter</filter-name>
    <filter-class>org.apache.catalina.filters.ExpiresFilter</filter-class>
    <init-param>
        <param-name>ExpiresByType image</param-name>
        <param-value>access plus 2 weeks</param-value>
    </init-param>
    <init-param>
        <param-name>ExpiresByType text/css</param-name>
        <param-value>access plus 2 weeks</param-value>
    </init-param>
    <init-param>
        <param-name>ExpiresByType text/html</param-name>
        <param-value>access plus 2 weeks</param-value>
    </init-param>
    <init-param>
        <param-name>ExpiresByType application/javascript</param-name>
        <param-value>access plus 2 weeks</param-value>
    </init-param>
    <init-param>
        <param-name>ExpiresByType text/javascript</param-name>
        <param-value>access plus 2 weeks</param-value>
    </init-param>
</filter>
 
<filter-mapping>
    <filter-name>ExpiresFilter</filter-name>
    <url-pattern>/*</url-pattern>
    <dispatcher>REQUEST</dispatcher>
</filter-mapping>
```
