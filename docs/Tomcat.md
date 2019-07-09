## Tomcat config

TODO

Tomcat APR

CERT gen

Entropy random

Tomcat service

Tomcat users


## Spring Boot

- profil aplikacji - spring.profiles.active
- plik zewnętrzny z configiem - spring.config.location

export JAVA_OPTS="$JAVA_OPTS -Dspring.profiles.active=test"
export JAVA_OPTS="$JAVA_OPTS -Dspring.config.location=/app/apache-tomcat-9.0.6/webapps/system_modulowy-properties.yml"

Skopiowanie pliku setenv.sh do tomcat/bin -  setenv.sh


## Roolout of logs

mv catalina.out catalina.out.2018.09.10   (rozwiązanie tymczasowe z nadaniem daty oryginalnemu plikowi)



Wymuszenie działania:

logrotate --force /etc/logrotate.d/tomcatMAD



Plik zawiera (Dla catalina.out):

/opt/apache/logs/catalina.out {
 copytruncate
 daily
 rotate 50
 missingok
 size 5M
}

which logrotate

/usr/sbin/logrotate 


Move for logs:

mkdir 2016
mv *2016*.log /opt/apache-tomcat-7.0.28/logs/2016
mv *2016*.txt /opt/apache-tomcat-7.0.28/logs/2016

## Native APR for Tomcat

Komunikat:

org.apache.catalina.core.AprLifecycleListener.lifecycleEvent The APR based Apache Tomcat Native library which allows optimal performance in production environments was not found on the java.library.path: [/usr/java/packages/lib/amd64:/usr/lib64:/lib64:/lib:/usr/lib]

http://tomcat.apache.org/native-doc/

https://tomcat.apache.org/tomcat-7.0-doc/apr.html


tar -xzvf /app/apache-tomcat-9.0.6/bin/tomcat-native.tar.gz



Przygotowanie - apr, java, gcc

sudo yum install apr-devel openssl-devel

readlink -f $(which java)
zwrotka: /usr/lib/jvm/java-1.8.0-openjdk-1.8.0.171-8.b10.el7_5.x86_64/jre/bin/java

Java:

sudo yum install java-1.8.0-openjdk-devel
sudo alternatives --config java

GCC:
sudo yum install gcc glibc-devel glibc-headers


Na sudo:

cd /app/apache-tomcat-9.0.6/bin/tomcat-native-1.2.16-src/native/
./configure --with-java-home=/usr/lib/jvm/java-1.8.0-openjdk-1.8.0.181-3.b13.el7_5.x86_64 \
--with-ssl=yes \
--prefix=/app/apache-tomcat-9.0.6
make && make install

Komunikaty po poprawnym skonfigurowaniu ścieżki do wygenerowanych LIBS:

(wpis w setenv.sh)

LD_LIBRARY_PATH=$LD_LIBRARY_PATH:$CATALINA_HOME/lib
export LD_LIBRARY_PATH



org.apache.catalina.core.AprLifecycleListener.lifecycleEvent Loaded APR based Apache Tomcat Native library [1.2.16] using APR version [1.4.8].

org.apache.catalina.core.AprLifecycleListener.lifecycleEvent APR capabilities: IPv6 [true], sendfile [true], accept filters [false], random [true].

org.apache.catalina.core.AprLifecycleListener.lifecycleEvent APR/OpenSSL configuration: useAprConnector [false], useOpenSSL [true]

org.apache.catalina.core.AprLifecycleListener.initializeSSL OpenSSL successfully initialized [OpenSSL 1.0.2k-fips  26 Jan 2017]
