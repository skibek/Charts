# Docs

TOC
- [Docs](#docs)
  - [Spring](#spring)
  - [Java helpers](#java_helpers)
  - [Groovy](#groovy)
  - [Estimates](#estimates)
- [Containers](#containers)
- [Microservices](#microservices)
  - [Monitoring](#monitoring)
- [BPM](#bpm)
- [Apache Kafka](#apache_kafka)
- [Testing](#testing)
- [AWS](#aws)
- [Tech news](#tech_news)



# Docs <a name="docs"></a>


## Spring <a name="spring"></a>

https://docs.spring.io/spring/docs/current/spring-framework-reference/index.html

### Modules - core

@Core - Resources, Validation, Data Binding, Type conversion, Spring Expression Language (SpEL), Aspect Oriented Programming AOP (standard AspectJ), Null safety, Data Buffer

@Testing - Unit testing, Integration testing (JUnit4, JUnit Juniper - JUnit5)

@Data Access - Transaction Management, DAO, Data Access with JDBC, ORM Object Relational Mapping, Marshalling XML

@Web Servlet - Web MVC - DispatcherServlet (provides a shared algorithm for request processing), Filters, Asynchronous Requests, CORS (Cross-Origin Resource Sharing), Web security, Caching, View techs (Themeleaf, FreeMarker, JSP, Tiles, Jackson, XSLT ...), REST clients (RestTemplate, WebClient), Testing, WebScoket, Others(JSF, Apache Struts, Tapestry)

@WebReactive (fully non-blocking, supports Reactive Streams[JDK9 standard] back pressure) - WebFlux, Reactive, Functional, WebClient, WebSockets

@Integration - Remoting (Remote Method Invocation (RMI), HTTP invoker, Hessian(Caucho), JAX-WS, JMS (Java Message Service), AMQP), JMX (Java Management Extensions), JCA (Java EE Connector Architecture) CCI (Common Client Interface) , Email (JavaMail), Scheduling (eg. Quartz), Cache (JCache (JSR-107))

@Languages - Kotlin, Apache Groovy, Dynamic Language Support


### Bean Scopes

- singleton (default) - not compilant with JSR-330 Dependency Injection standard for Java
- prototype (as new) - default with JSR-330
- WebApp
  - request
  - session
  - application
  - websocket

### Transaction - works on top of AOP

https://dzone.com/articles/how-does-spring-transactional

```java

# Standard
UserTransaction utx = entityManager.getTransaction(); 
try { 
    utx.begin(); 
    businessLogic();
    utx.commit(); 
} catch(Exception ex) { 
    utx.rollback(); 
    throw ex; 
} 

#Spring annotation
@Transactional
public void businessLogic() {
... use entity manager inside a transaction ...
}
```

To @Transactional to work - @EnableTransactionManagement

transaction propagation are handled automatically (called method can join transaction)

The transactional annotation itself defines the scope of a single database transaction. The database transaction happens inside the scope of apersistence context.

The persistence context is in JPA the EntityManager, implemented internally using an Hibernate Session (when using Hibernate as the persistence provider).

The persistence context is just a synchronizer object that tracks the state of a limited set of Java objects and makes sure that changes on those objects are eventually persisted back into the database.

### Modules - others

Spring Boot

Spring Boot CLI - SDKMAN (Software Development Kit Manager)

Spring Data - Repository (CRUDRepository, PagingAndSortingRepository)

Spring Actuator - metrics, healt

Spring WebFlux - Rest API with streaming data

WebSockets, React, RxJS

Spring Batch

Spring Shell - command CLI

Spring Statemachine

Spring Boot Admin

Spring Cloud Dataflow - orchestrate

Spring HATEOAS (Hypermedia As The Engine Of Application State) - REST API + return related actions (Links) you can perform on the resource

Spring REST Docs (Swagger RAML, Markdown, AsciiDoc, Wikis, Testing)

Spring WebFlow - flow of view on top of Spring MVC

Spring Integration - support for EIP Enterprise Integration Patterns

### Security

OpenID Connect (Authentication)- OICD (layer on OAuth2 with ID token - JWT)

OAuth 2.0 (Authorization)

OKTA - Auth online

CORS - Cross-Origin Resource Sharing

### API

Swagger

SpringFox - JSON API documentation

ORM - JPA, Hibernate, MyBatis ...



## Java helpers <a name="java_helpers"></a>

Lombock - anti boiler plate implementation

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

**SAAS**

AWS, Alibaba, DigitalOcean, Heroku - Clouds

Algolia - search

Twilio - contact with customer

SendGrid, Mailgun, HubSpot - Emails, Email Validation

slack

Tools for coding: Apache Commons, Google Guava


## Groovy <a name="groovy"></a>

Grape - JAR manager (@Grab annotation)


## Estimates <a name="estimates"></a>

COCOMO (ang. constructive cost model) – model szacowania liczby osobogodzin w procesie tworzenia oprogramowania.

https://pl.wikipedia.org/wiki/COCOMO

http://csse.usc.edu/csse/research/COCOMOII/cocomo_main.html




# Containers <a name="containers"></a>

by RedHat - https://quay.io/tour/

Kubernetes - Cluster

Helm - https://helm.sh/docs/  - like devfiles

Istio (service mesh) - provides building blocks to build distributed microservices in a more Kubernetes-native way and takes the complexity and responsibility of maintaining those blocks away from you. This means you do not have to worry about maintaining the code or deployments for service discovery, tracing and so on

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



# Testing - TDD <a name="testing"></a>

TDD - Test-Driven Development (Red, 'Document', Green, Refactor)

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





# AWS <a name="aws"></a>

Amazon Rekognition Service - https://aws.amazon.com/rekognition/

AWS Kinesis - analyze wideo and Data Streams in real time

AWS Rekognition Video

AWS SageMaker - Machine Learning

AWS EC2 - Virtual server

AWS Lambda

AWS S3 - Simple Storage Service

AWS Aurora - relation DB

AWS Redshift - data warehouse

AWS Elasticsearch

AWS DynamoDB - nosql DB

Amazon SQS - Simple Queue Service

Amazon SNS - Simple Notification Service - topic pub/sub

Amazon MQ - message broker

Amazon EventBridge - event bus

Amazon Chime - chat, video, audio like skype

Amazon Corretto - OpenJDK


# Tech news <a name="tech_news"></a>

## Others - TODO

https://www.websequencediagrams.com/

Bartek Slota - https://bartslota.blogspot.com/

GitHub - DDD by Examples / library






