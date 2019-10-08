# Architecture - Design

TOC
- [CQRS - Command Query Responsibility Segregation](#cqrs)
- [TDD - Test-Driven Development](#tdd)


## CQRS - Command Query Responsibility Segregation <a name="cqrs"></a>

```
Two models 
  simply POJO - read only
  complex object - validation, management, business logic

Materialize view (DB) (materialize cache like) - for read/write - read - more data, write - less data
  Postgres JSON-B

```


## TDD - Test-Driven Development <a name="tdd"></a>

(Red, 'Document', Green, Refactor)

```
three rules of tdd
https://dzone.com/articles/fallbacks-are-overrated-architecting-for-resilienc
https://www.javacodegeeks.com/2019/07/cloud-well-architected-framework.html
https://www.javacodegeeks.com/2019/07/microservices-java-devs-deployment-orchestration.html
```
