# Docs

TOC
- [Docs](#docs)

  - [Spring](#spring)
  - [Java helpers](#java_helpers)
  - [Groovy](#groovy)
  - [Angular (TypeScript)](#angular)
  - [Estimates](#estimates)
  - [Design Patterns](#design_patterns)
  - [Testing](#testing)
- [Containers](#containers)
- [Microservices](#microservices)
- [BPM](#bpm)
- [Apache Kafka](#apache_kafka)
- [EIP - Enterprise Integration Patterns](#eip)
- [Testing](#testing)
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

Spring WebFlux - Rest API with streaming data

WebSockets, React, RxJS

Spring Batch, Shell, 

### Security

OpenID Connect (Authentication)- OICD (layer on OAuth2 with ID token - JWT)

OAuth 2.0 (Authorization)

OKTA - Auth online

CORS - Cross-Origin Resource Sharing

### API

Swagger

SpringFox - JSON API documentation






## Java helpers <a name="java_helpers"></a>

Lombock - anti boiler plate implementation

Fluxtion - embeddable streaming event processing engine

Reactive programming - asynchronous I/O and non-blocking processes, asynchronous processing

ElasticSearch - search engine build on top of Apache Lucene

Jest - HTTP/Rest packager for ElastiSearch by HTTP

Scoop - windows like a bash YUM (installer)

Resin (by Caucho) WebServer




## Groovy <a name="groovy"></a>

Grape - JAR manager (@Grab annotation)


## Angular (TypeScript) <a name="angular"></a>

Service (ng g s shared/car/car), Component (ng g c car-list), Module, START (ng serve - starts on port 4200)

Angular CLI

material.angular.io

## Estimates <a name="estimates"></a>

COCOMO (ang. constructive cost model) – model szacowania liczby osobogodzin w procesie tworzenia oprogramowania.

https://pl.wikipedia.org/wiki/COCOMO

http://csse.usc.edu/csse/research/COCOMOII/cocomo_main.html

## Design Patterns <a name="design_patterns"></a>

- Main elements:

Inheritance, Interface ...

Dependency Injection, Inversion of Control (in Spring)

> Dependency injection (DI) is a process whereby objects define their dependencies (that is, the other objects with which they work) only through constructor arguments, arguments to a factory method, or properties that are set on the object instance after it is constructed or returned from a factory method. The container then injects those dependencies when it creates the bean. This process is fundamentally the inverse (hence the name, Inversion of Control) of the bean itself controlling the instantiation or location of its dependencies on its own by using direct construction of classes or the Service Locator pattern.

> Code is cleaner with the DI principle, and decoupling is more effective when objects are provided with their dependencies. The object does not look up its dependencies and does not know the location or class of the dependencies. As a result, your classes become easier to test, particularly when the dependencies are on interfaces or abstract base classes, which allow for stub or mock implementations to be used in unit tests.

> DI exists in two major variants: Constructor-based dependency injection and Setter-based dependency injection.

> Other elements: Autowiring, Lazy Beans, Lookup, Application Context

- BigOne:

GoF

SAFE




## Testing <a name="testing"></a>

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

SonarQube to test and analyse of Coverage


Selenium - https://www.javacodegeeks.com/2019/07/test-automation-selenium-webdriver.html

https://www.testcontainers.org/

## Testing SMTP email

GreenMail

http://www.icegreen.com/greenmail/#examples

https://codecouple.pl/2018/02/09/26-spring-boot-testowanie-z-greenmail/

## TDD

Js - Karma

# Tech news <a name="tech_news"></a>

## AWS

Amazon Rekognition Service

https://aws.amazon.com/rekognition/

https://www.websequencediagrams.com/

Bartek Slota

GitHub - DDD by Examples / library

https://bartslota.blogspot.com/




