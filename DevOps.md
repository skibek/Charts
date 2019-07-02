## JAVA - DevOps

### Jenkins

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
