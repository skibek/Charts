# Pytania

## General
```
Bugtrackery - Jira, Redmine
CD/CI - Jenkins, TeamCity
GitFlow - feature/release/hotfix/support branches
https://www.atlassian.com/git/tutorials/comparing-workflows/gitflow-workflow

https://en.wikipedia.org/wiki/SOLID

Optymalizacja - JMC/JFR, YourKit

- AOP
Proxy

JMS jakie?

- Apache Camel - lub inne EIP, MuleSoft | ...
```

## Methodologies
```
Metodyki zarządzania - Scrum, Kanbanm XP - Agile methodologies - iterative development, where requirements and solutions evolve through collaboration between self-organizing cross-functional teams | solutions evolve through the collaborative effort of self-organizing and cross-functional teams and their customer(s)/end user(s).[1] It advocates adaptive planning, evolutionary development, early delivery, and continual improvement,
https://www.cprime.com/resources/what-is-agile-what-is-scrum/
https://en.wikipedia.org/wiki/Agile_software_development

Agile software development process
BDD - behavior-driven development
https://en.wikipedia.org/wiki/Behavior-driven_development

TDD
domain-driven design
object-oriented analysis and design
```

## JAVA
```
- HashCode, Equals - Contracts !!!
https://www.baeldung.com/java-equals-hashcode-contracts

- Static binding and Dynamic binding in java
https://www.javatpoint.com/static-binding-and-dynamic-binding

- Co nowego w Java 11 vs 8
Modularity, Version String Schema, Multi-jar releases, Var keyword, GC G1
Java 8 vs 7
Lambda Expressions, New Date and Time API, Stream API

-- try-catch-finally
Try with Resources - for Closeable resources
Try Catch - in essence, if you have a finally in a try/catch clause, a finally will be executed (after catching the exception before throwing the caught exception out)

- Exceptions
Throwable - Error | Exception
https://airbrake.io/blog/java-exception-handling/the-java-exception-class-hierarchy
	
- concurrent 
CopyOnWriteArrayList - thread-safe
Thread - implements Runnable, run only method, Start - create Thread
Callable - call() - for result, Future obj - to status
Executor service - https://howtodoinjava.com/java/multi-threading/executor-service-example/

- ZonedDataTime

- Duration vs Period - Period uses date-based values, while Duration uses time-based values
```

## SQL
```
- kursor - Kursory są encją w której przechowywane są wiersze zwrócone przez zapytanie z bazy danych.
Przetwarzając kursory wykonujemy cztery operacje: zadeklarować kursor, otworzyć go, pobrać wiersze, zamknąć kursor
namiastka programowania
```

## JPA/Hibernate
```
- Optimistic Lock - @Version private Long version;
https://www.baeldung.com/jpa-optimistic-locking
https://stackoverflow.com/questions/21120043/optimistic-locking-by-concrete-java-example
https://www.baeldung.com/jpa-pessimistic-locking
PESSIMISTIC_READ, PESSIMISTIC_WRITE 

- fetch - fetch=FetchType.Lazy | Eager, fetching my entity along with sub-entities using JOIN FETCH

- Inheritance Strategies - 
@MappedSuperclass
InheritanceType.TABLE_PER_CLASS
InheritanceType.SINGLE_TABLE - DiscriminatorColumn - DiscriminatorValue
InheritanceType.JOINED
```

## Spring
```
- scope - singleton, prototype, request, session, global-session
- WEB-INF dir - This means that WEB-INF resources are accessible to the resource loader of your Web-Application and not directly visible for the public. 

- Stereotype annotations
https://howtodoinjava.com/spring-core/stereotype-annotations/
@Component -  component-scanning mechanism 
@Repository: When you annotate a class @Repository, spring container understands it's a DAO class and translates all unchecked exceptions (thrown from DAO methods) into Spring DataAccessException
@Service - nothing
@Controller - marks a class as a Spring Web MVC controller for eg: @RequestMapping

- Injection - różnice gdzie - Constuctor, AutoWired, setter
You can mix both, Constructor-based and Setter-based DI but it is a good rule of thumb to use constructor arguments for mandatory dependencies and setters for optional dependencies.

- Servlet Redirect vs Forward
https://www.baeldung.com/servlet-redirect-forward

For example, HttpRequestHandler, WebRequestHandler, MessageHandler are all handlers which can work with the DispatcherServlet

- Transaction
propagation - default PROPAGATION_REQUIRED, 
isolation - default (DEFAULT) READ_COMMITTED in mssql,postgres...
https://netjs.blogspot.com/2018/08/spring-transaction-attributes-propagation-isolation-settings.html
https://stackoverflow.com/questions/8490852/spring-transactional-isolation-propagation
https://www.baeldung.com/spring-transactional-propagation-isolation

- Jak wyczyścić kontekst Springa przed uruchomieniem kolejnego testu
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)

- Jak Spring dostaje request - define servlets, filters, listeners...
```

## REST
```
- HEAD metoda - ???
Transakcja - izolowanie transakcji
HTTP code - 1xx - Information, 2xx - Success, 3xx Redirection, 4xx - client error, 5xx - Server error
```

## Test
```
Test structure - BDD - given(init), when(operation to test), then (assertion)
AssertJ, 
Testcontainers
Biblioteki do Mockowania - Mockito, EasyMock
Biblioteki do testów - Junit, Spock - Groovy
```

## Spring Batch
```

```
![Workflow](https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Fdiscoversdkcdn.azureedge.net%2Fpostscontent%2Fspring%2Fbatch%2Fimage1.png&f=1&nofb=1)

## Spring Integration
```

```

## Docker, K8s
```

```

# Algorithms
## General
```
- Autoryzacja vs Authentykacja - Authentication (WHO), Authorization (WHAT CAN DO - Permission)
```

## SSL - HTTPS
```
- Jak działa SSL (asynchronicznie / i sysnchronicznie później [bo wydajność])

- Symetric & Asymetric
https://www.rapidsslonline.com/blog/fundamental-differences-between-symmetric-and-asymmetric-encryption/
https://www.ssl2buy.com/wiki/symmetric-vs-asymmetric-encryption-what-are-differences
```
![Symmetric](https://www.ssl2buy.com/wiki/wp-content/uploads/2015/12/Symmetric-Encryption.png)
![Asymmetric](https://2teyt17s6x52yehgd4cdel0r-wpengine.netdna-ssl.com/wp-content/uploads/2018/05/Asymmetric.png)


## Maze
```
https://www.baeldung.com/java-solve-maze
```

## Graph
```
nodes (instead of vertices) and edges (instead of arcs)

Library: 
https://jgrapht.org/
https://www.graphviz.org/

public class Graph {
    List<Node> nodes;
}

public class Node {
    public String name;
    public List<Edge> connections;
}

public class Edge {
    public Node start;
    public Node end;
    public double weight;
}

https://stackoverflow.com/questions/1737627/java-how-to-represent-graphs
https://www.baeldung.com/java-graphs
```

##Clustering
```
https://towardsdatascience.com/the-5-clustering-algorithms-data-scientists-need-to-know-a36d136ef68
https://en.wikipedia.org/wiki/K-means_clustering
```

