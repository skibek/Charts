```
-XX:+UseSerialGC
-Xss512k
set Xmx
java -Xmx32m -Xss256k -jar target/main-0.0.1-SNAPSHOT.jar
Go to - elastic beanstalk - NO
Get bigger machine

Try to add some swap space before deploy your application.

dd if=/dev/zero of=/var/swapfile bs=1M count=512
mkswap /var/swapfile
chmod 0600 /var/swapfile
swapon /var/swapfile


https://www.commercialdroneprofessional.com/

https://buddy.works
```
