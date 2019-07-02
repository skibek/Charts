JAVA

Jenkins
Publish over SSH - user one user - eg. tomcat
  send to remote dir by SSH
  call Shell actions: 
sudo systemctl stop APP
mv APP to /app/APP
chmod 755 /app/APP
sudo systemctl start APP

sudo visudo
Cmnd_Alias MYAPP_CMNDS = /bin/systemctl start APP, /bin/systemctl stop APP
tomcat ALL=(ALL) NOPASSWD: MYAPP_CMNDS
