# Pytania

## General
```
- Bugtrackery - Jira, Redmine
- CD/CI - Jenkins, Ansible (do maszyn i nstalacja), Terraform, CloudFoundation, TeamCity
- GitFlow - feature/release/hotfix/support branches
```
https://www.atlassian.com/git/tutorials/comparing-workflows/gitflow-workflow


```
- Optymalizacja - JMC/JFR, YourKit - Testy np LoadUI/SoapUI, JMeter
- JMC - czy można na PROD (nie można - trzeba wykupić lecencję)

- Apache Camel - lub inne EIP, MuleSoft | ...
- Scala, Haskel - functional programming

```

## Methodologies
```
Metodyki zarządzania - 
 Scrum
 Kanbanm 
 XP
 Agile methodologies - iterative development, 
 	where requirements and solutions evolve through collaboration between self-organizing cross-functional teams | 
	solutions evolve through the collaborative effort of self-organizing and cross-functional teams and their customer(s)/end user(s).
	It advocates adaptive planning, evolutionary development, early delivery, and continual improvement
```
https://www.cprime.com/resources/what-is-agile-what-is-scrum/
https://en.wikipedia.org/wiki/Agile_software_development

```
Agile software development process
BDD - behavior-driven development
```
https://en.wikipedia.org/wiki/Behavior-driven_development

```
TDD
domain-driven design
object-oriented analysis and design
```

https://en.wikipedia.org/wiki/SOLID

## Scrum
```
Elementy Scruma:
  daily, 
  planowanie, 
  różnica ready a done - 
  	Definition of Ready is focused on user story level characteristics,
	Definition of Done is focused on the sprint or release level
```
![Scrum](https://media-exp1.licdn.com/dms/image/C5112AQEhnWoYEfazfg/article-inline_image-shrink_1000_1488/0?e=1589414400&v=beta&t=CpMZkqgQcU8Di_MNh__B6crSVxm7_Wvsi8URePDIgGs)

## JAVA
```
- HashCode, Equals - Contracts !!!
Hashing in its simplest form, is a way to assigning a unique code for any variable/object after applying any formula/algorithm on its properties.
```
https://www.baeldung.com/java-equals-hashcode-contracts

```
- Static binding and Dynamic binding in java
SB - When type of the object is determined at compiled time(by the compiler)
DB - When type of the object is determined at run-time
   Dog extends Animal
   Animal a=new Dog();
```
https://www.javatpoint.com/static-binding-and-dynamic-binding
```
- Co nowego w Java 11 vs 8
Modularity, Version String Schema, Multi-jar releases, Var keyword, GC G1
Java 8 vs 7
Lambda Expressions, New Date and Time API, Stream API

-- try-catch-finally
Try with Resources - for Closeable resources
Try Catch - if you have a finally in a try/catch clause, a finally will be executed 
  (after catching the exception before throwing the caught exception out)

- ZonedDataTime

- Duration vs Period - Period uses date-based values, while Duration uses time-based values

- String immutable - nie zmienisz obiektu. Zmienia się referencja do obiektu.
Czy w stringu można trzymać hasła? Nie bo są w pamięci i można zrobić dumpa, (Char[] - tablica char)
String pool - pula stringów magazynowana w Java Heap Memory, bo są immutable

- Reflection is an API which is used to examine or modify the behavior of methods, classes, interfaces at runtime.

- Log levels - trace / debug / info / warn / error (LogBack)
```

## Concurrency
```
- concurrent 
CopyOnWriteArrayList - thread-safe
Thread - implements Runnable, run only method, Start - create Thread
Callable - call() - for result, Future obj - to status
Executor service - 
```
https://howtodoinjava.com/java/multi-threading/executor-service-example/

```
- Wątki - thread i runnable (jak zatrzymujemy) w runnable:
private volatile boolean running = true;
public void terminate() {
	running = false;
}
thread.join();
volatile keyword - guarantees visibility of changes to variables across threads
Essentially, volatile is used to indicate that a variable's value will be modified by different threads.
Declaring a volatile Java variable means:
    The value of this variable will never be cached thread-locally: all reads and writes will go straight to "main memory";
    Access to the variable acts as though it is enclosed in a synchronized block, synchronized on itself. 
	

- to prevent race condition - synchronized
- Locks - ReentrantLock (as synchronized), ReadWriteLock, StampedLock
- Semaphore 
- atomic - java.concurrent.atomic operation is atomic when you can safely perform the operation in parallel 
  on multiple threads without using the synchronized keyword or locks
  compare-and-swap (CAS), an atomic instruction directly supported by most modern CPUs. 
  Those instructions usually are much faster than synchronizing via locks
AtomicInteger - atomicInt::incrementAndGet, LongAdder, LongAccumulator
ConcurrentHashMap
```
https://winterbe.com/posts/2015/04/30/java8-concurrency-tutorial-synchronized-locks-examples/
https://winterbe.com/posts/2015/05/22/java8-concurrency-tutorial-atomic-concurrent-map-examples/

## Exceptions
```
- Exceptions
Throwable - Error | Exception
RuntimeException - nie do złapania, zawsze przejdzie
```
https://airbrake.io/blog/java-exception-handling/the-java-exception-class-hierarchy

## SQL
```
- kursor - Kursory są encją w której przechowywane są wiersze zwrócone przez zapytanie z bazy danych.
Przetwarzając kursory wykonujemy cztery operacje: zadeklarować kursor, otworzyć go, pobrać wiersze, zamknąć kursor
namiastka programowania

INSERT INTO table2
SELECT * FROM table1 WHERE condition; 
```

## JPA/Hibernate
```
- Optimistic Lock - @Version private Long version;
```
https://www.baeldung.com/jpa-optimistic-locking
https://stackoverflow.com/questions/21120043/optimistic-locking-by-concrete-java-example
https://www.baeldung.com/jpa-pessimistic-locking
```
PESSIMISTIC_READ, PESSIMISTIC_WRITE 

- fetch - fetch=FetchType.Lazy | Eager, fetching my entity along with sub-entities using JOIN FETCH

- Inheritance Strategies - 
@MappedSuperclass
InheritanceType.TABLE_PER_CLASS
InheritanceType.SINGLE_TABLE - DiscriminatorColumn - DiscriminatorValue
InheritanceType.JOINED

- Hibernate - stany -  Transient / Persistent / Detached 

- Prevent Hibernate LazyInitializationException 
Fetch - left join fetch - select distinct c from Customer c left join fetch c.orders;
@BatchSize(size = 100) Set<Bar> bars; - Hibernate.initialize(foo.getBars());

- Optional - nie zwracać NULLa i za każdym razem sprawdzać czy nie NULL (przy zapytaniu z bazy dzięki Optionalom nie trzeba o tym pamiętać)
```

## Spring
```
- Scope - singleton, prototype, request, session, global-session
- WEB-INF dir - This means that WEB-INF resources are accessible to the resource loader of your Web-Application and not directly visible for the public. 

- Stereotype annotations
@Component -  component-scanning mechanism 
@Repository: When you annotate a class @Repository, spring container understands it's a DAO class and translates all unchecked exceptions (thrown from DAO methods) into Spring DataAccessException
@Service - nothing
@Controller - marks a class as a Spring Web MVC controller for eg: @RequestMapping
```
https://howtodoinjava.com/spring-core/stereotype-annotations/
```
- Injection - różnice gdzie - Constuctor, AutoWired, setter
You can mix both, Constructor-based and Setter-based DI but it is a good rule to use constructor arguments for mandatory dependencies and setters for optional dependencies.

- Servlet Redirect vs Forward
Simply put, forwarded requests still carry this value, but redirected requests don't.
```
https://www.baeldung.com/servlet-redirect-forward
```
- Jak Spring dostaje request - define servlets, filters, listeners...
For example, HttpRequestHandler, WebRequestHandler, MessageHandler are all handlers which can work with the DispatcherServlet

- Transaction
propagation - default PROPAGATION_REQUIRED, PROPAGATION_REQUIRES_NEW, PROPAGATION_MANDATORY, PROPAGATION_SUPPORTS, PROPAGATION_NESTED ..
isolation - default (DEFAULT) READ_COMMITTED in mssql,postgres... Isolation.REPEATABLE_READ, Isolation.SERIALIZABLE
@Transactional(rollbackFor = Exception.class) - bo runtime exception zawsze przerwie, application/checked exception nie przerwie
```
https://netjs.blogspot.com/2018/08/spring-transaction-attributes-propagation-isolation-settings.html
https://stackoverflow.com/questions/8490852/spring-transactional-isolation-propagation
https://www.baeldung.com/spring-transactional-propagation-isolation
```
- Jak wyczyścić kontekst Springa przed uruchomieniem kolejnego testu
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)

Proxy Bean
Component Scan

- SpringBoot lifecycle - Life cycle callback methods
InitializingBean and DisposableBean callback interfaces
*Aware interfaces for specific behavior
Custom init() and destroy() methods in bean configuration file
@PostConstruct and @PreDestroy annotations
```

## AOP
```
- Aspect Oriented Programming
najlepszy przykład Transaction w Spring, oraz Remoting
Bazuje na wzorcu projektowym - Proxy

AOP - @Aspect, @Around("execution(* com.mycomp
```

## Design patterns in Spring
```
- Dependency injection or inversion of control
- Factory - Spring BeanFactory Container, Spring ApplicationContext Container; 
context.getBean("helloApplicationContext");
- Proxy
a class is used to represent the functionality of another class
Proxy means ‘in place of’, representing’ or ‘in place of’ or ‘on behalf of’
A real world example can be a cheque or credit card is a proxy for what is in our bank account. 
  It can be used in place of cash, and provides a means of accessing that cash when required
Controls and manage access to the object they are protecting
Interface InvocationHandler and the helper class Proxy

- Singleton
- Model View Controller
- Template method
JdbcTemplate, JmsTemplate, and JpaTemplate
- Front Controller
Spring provides DispatcherServlet to ensure an incoming request gets dispatched to your controllers
...
```
https://www.tutorialspoint.com/design_pattern/proxy_pattern.htm
https://winterbe.com/posts/2009/08/13/seperation-of-concerns-proxy-pattern/

## JMS - standard
```
- RabbitMQ - Producer, Exchange - binding/queue, Consumer 
- Amzaon SQS - Simple Queue Service
```

## REST
```
- HEAD metoda
The HEAD method is identical to GET except that the server MUST NOT return a message-body in the response.
- HTTP code 
1xx - Information, 2xx - Success, 3xx Redirection, 4xx - client error, 5xx - Server error

Jak wysłać GET/POST z:
- Angular - HttpClient
- Node.js - var http = require('http'); http.request(
- Sencha - Ext.Ajax.request({
```

## Test
```
Test structure - BDD - given(init), when(operation to test), then (assertion)
AssertJ, 
Testcontainers
Biblioteki do Mockowania - Mockito, EasyMock
Biblioteki do testów - Junit, Spock - Groovy
```

## Streams & Lambda
```
- aggregate operations like:
filter, map, limit, reduce, find, match, and so on.

Arrays.stream(array).reduce((str1, str2) -> str1 + "-" + str2); // accumulator 
list.stream().distinct().forEach( //remove duplicates

List<Pet> pets = people.stream()
	. filter((p) -> p.getAge() > 35)
	. map(Person::getPet)
	. collect(Collectors.toList()); 
List<String> filtered = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());
strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.joining(", "));
numbers.stream().mapToInt((x) -> x).summaryStatistics();
```
https://www.tutorialspoint.com/java8/java8_streams.htm
```
- biblioteka Vavr (funkcyjne prog)
```

## GarbageCollector
```
OpenJDK GarbageCollectors: 
Z(JDK11), G1(JDK9,10), Parallel(JDK<=8), CMS-ConcMarkSweep, Serial, Shenandoah
System.gc();
```

## Spring Batch
```

```
![Workflow](https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Fdiscoversdkcdn.azureedge.net%2Fpostscontent%2Fspring%2Fbatch%2Fimage1.png&f=1&nofb=1)

## Spring Integration
```
???
```

## Apache Spark  (Apache Flink)
```
- Modules: Core, SQL, Streaming, MLib, GraphX
- Query, Analyze, Transform
- faster than MapReduce
Cluster Managers - Apache Spark Standalone, Apache Mesos, Apache YARN, Kubernetes
HDFS - Hadoop Distributed File System
Yarn: Yet another Resource Negotiator is used for job scheduling and manage the cluster
Map Reduce: This is a framework which helps Java programs to do the parallel computation on data using key value pair. 
  The Map task takes input data and converts it into a data set which can be computed in Key value pair. 
  The output of Map task is consumed by reduce task and then the out of reducer gives the desired result. 
```

## ELK
```
Elastic Search, Kibana, Logstash, Beats
```

## Hashicorp
```
Hashicorp stack (Terraform, Vault, Consul) 
```

## Docker, K8s
```
- Jak ustawić port dla image:
poprzez docker compose (uruchomienie - docker compose up) - w pliku YAML
poprzez parametry i docker ( chyba -p 8080:8080)

Amazon Elastic Container Service - ECS
```


# Algorithms

## General
```
- Autoryzacja vs Authentykacja - Authentication (WHO), Authorization (WHAT CAN DO - Permission)
```

## Big O - notation
```
Constant Time - O(1), 
Logarithmic Time - O(log n) n call, 
Linear Time - O(n) for, 
N Log N Time - O(n log n) for in for finite, 
Polynomial Time - O(n^p) - for in for = O(n^2), 
Exponential Time - O(k^n) for Pow
Factorial Time - O(n!)
https://www.bigocheatsheet.com/
https://www.baeldung.com/java-algorithm-complexity
log 8 = 3 - 2^3 = 8
```

## SSL - HTTPS
```
- Jak działa SSL (asynchronicznie / i sysnchronicznie później [bo wydajność])

- Symetric & Asymetric
```
https://www.rapidsslonline.com/blog/fundamental-differences-between-symmetric-and-asymmetric-encryption/
https://www.ssl2buy.com/wiki/symmetric-vs-asymmetric-encryption-what-are-differences

![Symmetric](https://www.ssl2buy.com/wiki/wp-content/uploads/2015/12/Symmetric-Encryption.png)
![Asymmetric](https://2teyt17s6x52yehgd4cdel0r-wpengine.netdna-ssl.com/wp-content/uploads/2018/05/Asymmetric.png)


## Maze
```

```
https://www.baeldung.com/java-solve-maze

## Graph
```
nodes (instead of vertices) and edges (instead of arcs)

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

Library: 
```
https://jgrapht.org/
https://www.graphviz.org/

https://stackoverflow.com/questions/1737627/java-how-to-represent-graphs
https://www.baeldung.com/java-graphs

## Clustering
```
Clustering is a Machine Learning technique that involves the grouping of data points
```
https://towardsdatascience.com/the-5-clustering-algorithms-data-scientists-need-to-know-a36d136ef68
https://en.wikipedia.org/wiki/K-means_clustering

# Architecture

```
Key Performance Indicator (KPI)
Service Level Agreement (SLA)
SLAs are documents that outline the wider service agreements between a service provider and its customers, 
while KPIs are generally used to measure the performance of companies against their strategic goals.

An SLA is forward-looking, while KPIs focus on past performance. 
Your SLA will set benchmarks ahead of time for you to measure performance in the near future. 
The KPIs you choose will measure the performance of your business against those benchmarks as time passes. 
Your SLA could even specify which performance indicators will be used.

```

![UML2](https://external-content.duckduckgo.com/iu/?u=http%3A%2F%2Fi.stack.imgur.com%2F1dl9G.png&f=1&nofb=1)

![BPMN2](https://external-content.duckduckgo.com/iu/?u=http%3A%2F%2Fwww.signavio.com%2Fwp-content%2Fuploads%2F2012%2F10%2Fposter-preview-bpmn-en.png&f=1&nofb=1)

![SDLC](https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Fwww.amplewebsol.com%2Fwp-content%2Fuploads%2F2018%2F06%2Fsdlc.png&f=1&nofb=1)

![SDLC models](https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Fwww.janbasktraining.com%2Fblog%2Fuploads%2Fimages%2F2019%2F02%2FSDLC-Models.jpg&f=1&nofb=1)

![SDLC phases](https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Fwww.learntek.org%2Fblog%2Fwp-content%2Fuploads%2F2019%2F05%2Fsdlc-phases.png&f=1&nofb=1)

![V model](https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2F2.bp.blogspot.com%2F--tHa1GONsaM%2FUWkni_oSX-I%2FAAAAAAAAAw4%2FB7twinmzHvI%2Fs1600%2FV-Model-sdlc2.jpg&f=1&nofb=1)
