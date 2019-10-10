# Architecture - Design

TOC
- [CQRS - Command Query Responsibility Segregation](#cqrs)
- [TDD - Test-Driven Development](#tdd)
- [Books](#books)


## CQRS - Command Query Responsibility Segregation <a name="cqrs"></a>

```
Two models 
  simply POJO - read only
  complex object - validation, management, business logic

Materialize view (DB) (materialize cache like) - for read/write - read - more data, write - less data
  Postgres JSON-B

- elements:
Command - UpdateItemQuantityCommand 
Command Bus - queue
Command Handler - validation of command , write, send events
Domain objects (models) - aggragates
Event
Event Bus
Event Handler - save data for future read
Read Database Abstraction

ES - Event Sourcing

https://bulldogjob.pl/articles/122-cqrs-i-event-sourcing-czyli-latwa-droga-do-skalowalnosci-naszych-systemow_
```


## TDD - Test-Driven Development <a name="tdd"></a>

(Red, 'Document', Green, Refactor)

```
three rules of tdd
https://dzone.com/articles/fallbacks-are-overrated-architecting-for-resilienc
https://www.javacodegeeks.com/2019/07/cloud-well-architected-framework.html
https://www.javacodegeeks.com/2019/07/microservices-java-devs-deployment-orchestration.html
```

## Books

```
Book - DesignIt
https://pragprog.com/book/mkdsa/design-it

Patterns of Enterprise Application Architecture
https://www.amazon.com/gp/product/0321127420

Enterprise Integration Patterns: Designing, Building, and Deploying Messaging Solutions
https://www.amazon.com/Enterprise-Integration-Patterns-Designing-Deploying/dp/0321200683

https://softwarearchitecturefordevelopers.com/
```
