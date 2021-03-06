# Docs

TOC
- [Docs](#docs)
  - [API](#API)
  - [Java helpers](#java_helpers)
  - [Groovy](#groovy)
  - [Estimates](#estimates)
- [Profile](#profile)
- [Containers](#containers)
- [Microservices](#microservices)
  - [Monitoring](#monitoring)
- [BPM](#bpm)
- [Apache Kafka](#apache_kafka)
- [Testing TDD](#testing)
  - Testing SMTP email
  - API Testing
- [Tech news](#tech_news)
  - [Mobile apps](#mobile_apps)
  - [Others - TODO](#others_todo)


# Docs <a name="docs"></a>


## API

```
Swagger
SpringFox - JSON API documentation
ORM - JPA, Hibernate, MyBatis ...
```

## Java helpers <a name="java_helpers"></a>

```
Lombok - anti boiler plate implementation
jOOQ (LINQ, JPA) - SQL in Java
Fluxtion - embeddable streaming event processing engine
Reactive programming - asynchronous I/O and non-blocking processes, asynchronous processing
ElasticSearch - search engine build on top of Apache Lucene
Jest - HTTP/Rest packager for ElastiSearch by HTTP
Scoop - windows like a bash YUM (installer)
Resin (by Caucho) WebServer
Lighthouse - automated tool for improving the quality of web pages
Zipkin - tracing, logs
Hashicorp's Vault, Square's Keywhiz - Use "secrets as a service" solution
Advanced Message Queuing Protocol (AMQP) - standard for stream not messages with API, wire protocol
Apache Storm - paraller computation on tuples (stream, spout, bolt)
Apache Samza - steam processing framework
Tensorflow - CNN - Convolutional neural network - eg. clasification
Hibernate Envers - auditing
Hibernate Validator, Validation API
Jackson - JSON
Apache NiFi - powerful and scalable directed graphs of data routing, transformation, and system mediation logic
```

**SAAS**

```
AWS, Alibaba, DigitalOcean, Heroku - Clouds
Algolia - search
Twilio - contact with customer
SendGrid, Mailgun, HubSpot - Emails, Email Validation
slack
Tools for coding: Apache Commons, Google Guava
```

## Groovy <a name="groovy"></a>

Grape - JAR manager (@Grab annotation)


## Estimates <a name="estimates"></a>

COCOMO (ang. constructive cost model) – model szacowania liczby osobogodzin w procesie tworzenia oprogramowania.

https://pl.wikipedia.org/wiki/COCOMO

http://csse.usc.edu/csse/research/COCOMOII/cocomo_main.html





# Profile <a name="profile"></a>

Spring Boot

-Ddebug - shows whole elements by startup


PROFILING
```
vmstat 1
ApacheBench

CPU
Profiling - Flame Graph (shows methods callable)
Race condition - synchronized

Blocking bottlenecks
Wallclock profiling
Locking strategy - (eg synchronized on object per client)


Performance testing
Real Systems, Data and Workload
Requires Low Overhead Profiler
	Async-profiler
	Honest profiler
	Flight Recorder
	Solaris studio
		
Test property
- Fast
- Isolated
- Repeatable
- Self-validating  - Asserts
- Timely (Thorough)

JFC/JFR - Java Flight Control / Java Flight Recorder
JMC - Java Mission Controll
```


# Containers <a name="containers"></a>

by RedHat - https://quay.io/tour/

Kubernetes - Cluster

Helm - https://helm.sh/docs/  - like devfiles

Istio (service mesh) - provides building blocks to build distributed microservices in a more Kubernetes-native way and takes the complexity and responsibility of maintaining those blocks away from you. This means you do not have to worry about maintaining the code or deployments for service discovery, tracing and so on

## Docker:

https://blog.docker.com/2019/07/10-reasons-developers-love-docker/



# Microservices <a name="microservices"></a>

https://dzone.com/articles/mastering-spring-cloud

https://dzone.com/articles/top-5-spring-microservices-courses-with-spring-boo

Hexadiagonal architecture
- Technology  - many technologies
- Deployment
- Data
- Resilence - failure
- People
- Scalability
- Authonomy - teams and theirs product

Scaling
- Vertical - CPU, Memory
- Horizontal - Instances

```
Microservices - break complexity, though change without

High cohesion - logic should concrete bussines functionality

One Microservice - One DB
```

Cloud Native Computing Foundation

https://www.cncf.io/

https://opentracing.io/


## Monitoring <a name="monitoring"></a>

> Spring Cloud Sleuth
> Zipkin
> ELK - Elasticstack, Logstash, Kibana
> Prometheus
> Jaeger - open source, end-to-end distributed tracing, Monitor and troubleshoot transactions in complex distributed systems
> Watch dog



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

Apache Kafka - API on messaging, real time
 - Cluster
 - APIs
	- Producer - send streams of data to topics in the Kafka cluster 
	- Consumer - read streams of data from topics in the Kafka cluster
	- Connect - implementing connectors that continually pull from some source system or application into Kafka or push from Kafka into some sink system or application.
	- AdminClient - allows managing and inspecting topics, brokers, and other Kafka objects.
	- Streams API (key/value) - transform and enrich data, transforming streams of data from input topics to output topics

Publish events, Topics, Filtering ...

Zookeeper - monitoring

like AciveMQ, RabbitMQ

Apache BooKeeper - log 



# Testing  <a name="testing"></a>

Js - Karma

SonarQube to test and analyse of Coverage

Selenium - https://www.javacodegeeks.com/2019/07/test-automation-selenium-webdriver.html

https://www.testcontainers.org/

API Test: Spock, Mockito, AssertJ, Arquillian

https://www.javacodegeeks.com/2019/07/regression-testing-tools-techniques.html

## Testing SMTP email

GreenMail

http://www.icegreen.com/greenmail/#examples

https://codecouple.pl/2018/02/09/26-spring-boot-testowanie-z-greenmail/

## API Testing

Test your front-end against a real API

```
REST
http://httpbin.org/
JSONPlaceholder - Fake Online REST API for Testing and Prototyping - https://jsonplaceholder.typicode.com/
https://reqres.in/
http://ptsv2.com
https://putsreq.com/
https://webhook.site
https://biotools.readthedocs.io/en/latest/what_is_biotools.html
http://www.jsontest.com/
https://www.mocky.io/
https://github.com/softwaremill/softwaremill-common/tree/master/softwaremill-test/softwaremill-test-server

WS
http://www.dneonline.com/calculator.asmx
```


# Tech news <a name="tech_news"></a>



## Mobile apps <a name="mobile_apps"></a>

Flutter - Android i IOS by Google

https://flutter.dev/

https://github.com/flutter/flutter-intellij




## Others - TODO <a name="others_todo"></a>

https://www.websequencediagrams.com/

Bartek Slota - https://bartslota.blogspot.com/

GitHub - DDD by Examples / library

https://github.com/MK-PL/Prezentacje-IT---nietechniczne

https://github.com/MK-PL/Front-End_lista-przydatnych-odnosnikow




