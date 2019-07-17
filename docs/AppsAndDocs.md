# AppsAndDocs

TOC
- [Server Progs](#server_progs)
    - [Logsniffer](#logsniffer)
- [Progs](#progs)
- [Docs](#docs)
- [Containers](#containers)
- [Microservices](#microservices)
- [BPM](#bpm)
- [Apache Kafka](#apache_kafka)
- [EIP - Enterprise Integration Patterns](#eip)
- [Testing](#testing)
- [Tech news](#tech_news)


# Server Progs <a name="server_progs"></a>

## Logsniffer <a name="logsniffer"></a>

[https://github.com/mbok/logsniffer](https://github.com/mbok/logsniffer)

    sudo su tomcat
    java -jar /app/logsniffer.war &    
    /home/tomcat/logsniffer
    http://localhost:8082/

## Jenkins

## GitLab

## Nexus

## Sonar

## Webmin

Webmin: https://hub.docker.com/r/chsliu/docker-webmin/



# Progs <a name="progs"></a>

## Papercut <a name="papercut"></a>

SMTP local

## Postman <a name="postman"></a>

## RoboMongo Robo3T <a name="postman"></a>

SQLDeveloper - by Oracle

## PortableApps 
- jdGui
- Notepad++, Sublime Text, Atom, VisualStudio Code
- ConEmu
- KeePass
- LightScreen
- MobaXTerm
- Rapid Environment Editor
- WinSCP
- GitHub Desktop
- LdapAdmin
- KeyStore Explorer
- ProcessHacker
- TreeSize
- WinMd5
- Wireshark

Inne:
- Astrogrep, grepWin
- Curl
- HostFileEditor
- Speccy
- Pencil


## MC


# Docs <a name="docs"></a>

## Estimates

COCOMO (ang. constructive cost model) – model szacowania liczby osobogodzin w procesie tworzenia oprogramowania.

https://pl.wikipedia.org/wiki/COCOMO

http://csse.usc.edu/csse/research/COCOMOII/cocomo_main.html


## Testing

https://www.javacodegeeks.com/2019/07/regression-testing-tools-techniques.html


# Containers <a name="containers"></a>

by RedHat - https://quay.io/tour/

Kubernetes - Cluster

Helm - https://helm.sh/docs/  - like devfiles

## Docker:

https://blog.docker.com/2019/07/10-reasons-developers-love-docker/




# Microservices <a name="microservices"></a>

Hexadiagonal architecture
> Technology  - many technologies
> Deployment
> Data
> Resilence - failure
> People
> Scalability
> Authonomy - teams and theirs product

Scaling
> Vertical - CPU, Memory
> Horizontal - Instances

Microservices - break complexity, though change without

High cohesion - logic should concrete bussines functionality

One Microservice - One DB

## Monitoring

> Spring Cloud Sleuth
> Zipkin
> ELK - Elasticstack, Logstash, Kibana
> Prometheus


# BPM <a name="bpm"></a>

Business perspective
> Process Modeler
> Workflow Engine --- in microservices - N x Process Orchestrators
> System Integration
> Common UI
> Reporting

Architecture perspective
> User
> UI Controller
> History/Audits
> Reporting
> User and Access Manager
> Human tasks - Tasklist
> Workflow engine
> Database

Event Command Transformation Pattern



# Apache Kafka <a name="apache_kafka"></a>

Consumer, Producers

Publish events, Topics, Filtering ...


# EIP - Enterprise Integration Patterns <a name="eip"></a>

> Command message
> Event message
> Process manager
> Transactional client
> Event driven consumer
> Idempotent receiver

# Testing <a name="testing"></a>

Selenium - https://www.javacodegeeks.com/2019/07/test-automation-selenium-webdriver.html

https://www.testcontainers.org/

Testing SMTP email

GreenMail

http://www.icegreen.com/greenmail/#examples

https://codecouple.pl/2018/02/09/26-spring-boot-testowanie-z-greenmail/


# Tech news <a name="tech_news"></a>

## AWS

Amazon Rekognition Service

https://aws.amazon.com/rekognition/

https://www.websequencediagrams.com/

Bartek Slota

GitHub - DDD by Examples / library

https://bartslota.blogspot.com/




