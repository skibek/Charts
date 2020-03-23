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

```
Twelve Factor App - from Heroku
 One codebase tracked in revision control, many deploys
 Explicitly declare and isolate dependencies
 Store config in the environment
 Treat backing services as attached resources
```
https://12factor.net/
https://tanzu.vmware.com/content/blog/beyond-the-twelve-factor-app

```
CQRS - Command Query Responsibility Segregation
 clearly separate both the service and the controller layers to deal with 
 Reads – Queries and 
 Writes – Commands coming into the system separately
```

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
- HashCode, Equals - Contracts !!! - equal objects must have equal hash codes
Hashing in its simplest form, is a way to assigning a unique code for any variable/object after applying any formula/algorithm on its properties.
```
https://www.baeldung.com/java-equals-hashcode-contracts

```
- Polymorphism is the provision of a single interface to entities of different types
 Compile Time Polymorphism (static binding or method overloading)
 Runtime Polymorphism (dynamic binding or method overriding)
- Static binding and Dynamic binding in java
SB - When type of the object is determined at compiled time(by the compiler)
DB - When type of the object is determined at run-time
   Dog extends Animal
   Animal a=new Dog();
```
https://www.javatpoint.com/static-binding-and-dynamic-binding

```
- Reflection - API which is used to examine or modify the behavior 
 of methods, classes, interfaces at runtime.
- Immutable class - is one whose state can not be changed once created
- Abstraction - by interfaces and abstract classes
- Encapsulation - access control - package access, protected, or private

- Interface define contracts, which implementing classes need to honor.
 Java 8 default methods in interfaces
 you cannot extend multiple classes whereas you can implement multiple interfaces
 
 
Java Collection hierchy:
Collection (extends Iterable) - 
 Set - SortedSet - (interfaces) - (unique, not ordered - withou indexes - get(i))
  - EnumSet, 
  - HashSet [uses HashMap below], 
  - LinkedHashSet, 
  - TreeSet   
 List - (interface) - (not unique, ordered)
  - Stack - LIFO
  - Vector [synchronized], 
  - ArrayList, 
  - LinkedList 
  - Queue - FIFO
Map - SortedMap - (interfaces) 
 - HashMap, 
 - HashTable [old. synchronized]
 - EnumMap, 
 - IdentityHashMap and WeakHashMap [uses reference equality when comparing elements], 
 - LinkedHashMap
 - ConcurrentHashMap
 - TreeMap [It maintains the ordering of keys, by default “natural ordering”]
 (store key-value pairs)

Iterator - has remove() method
ReadOnly - Collections.unmodifiableList / Set / Map
ThreadSafe - Collections.synchronizedList / Set / Map

Fail-fast Iterators - fail as soon as they realized that structure of Collection has been changed since 
 iteration has begun. Structural changes means adding, removing or updating any element from collection 
 while one thread is Iterating over that collection.
 throws ConcurrentModificationException
Fail-safe iterators are just opposite to fail-fast. 
 They never fail if you modify the underlying collection on which they are iterating, 
 because they work on clone of Collection instead of original collection
 eg: CopyOnWriteArrayList, ConcurrentHashMap 

Collections and Arrays classes are special utility classes to support collection framework core classes

UUID (Universally Unique IDentifier), also known as GUID (Globally Unique IDentifier) 

tuple can be seen as an ordered collection of objects of different types
 Pair<String, Integer> pair = Pair.with("Sajal", 12);

ZonedDateTime, OffsetDateTime 
```

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

- Log levels - trace / debug / info / warn / error (LogBack)

- serialVersionUID - prevent serialization/deserial with java.io.InvalidClassException if this is changed
```

## Concurrency
```
thread-safe - is code that will work even if many Threads are executing it simultaneously 
 best stateless
thread pool is a collection of pre-initialized threads

Structure - 
 CopyOnWriteArrayList - 
 ConcurrentHashMap
 
Thread - implements Runnable, run only method, Start - create Thread
Callable - call() - for result, Future obj - to status

Executor service - 
 ThreadPoolExecutor - Executors.newFixedThreadPool(10), newCachedThreadPool, 
   newScheduledThreadPool, newSingleThreadExecutor, newWorkStealingPool
 ForkJoinPool - new ForkJoinPool(numberOfProcessors);
 ExecutorService, shutdown, List<Runnable> shutdownNow(), 
   awaitTermination, cancel (for Scheduled)
```
https://howtodoinjava.com/java/multi-threading/executor-service-example/

```
- Wątki - thread i runnable (jak zatrzymujemy) w runnable:
private volatile boolean running = true;
public void terminate() {
	running = false;
}
thread.join();

- volatile keyword - guarantees visibility of changes to variables across threads
Essentially, volatile is used to indicate that a variable's value will be modified by different threads.
Declaring a volatile Java variable means:
    The value of this variable will never be cached thread-locally: all reads and writes will go straight to "main memory";
    Access to the variable acts as though it is enclosed in a synchronized block, synchronized on itself. 
	
- to prevent race condition - synchronized (it is pessimistic lock - only one)
- Locks - ReentrantLock (as synchronized), ReadWriteLock, StampedLock
- Semaphore 
- atomic - java.concurrent.atomic operation is atomic when you can safely perform the operation in parallel 
  on multiple threads without using the synchronized keyword or locks
  compare-and-swap (CAS), an atomic instruction directly supported by most modern CPUs. 
  Those instructions usually are much faster than synchronizing via locks
AtomicInteger - atomicInt::incrementAndGet, LongAdder, LongAccumulator

- CountDownLatch - enables a java thread to wait until other set of threads completes
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

SQL - Brent Ozar

SQL query to find nth highest salary
 max function
```
```sql
 SELECT *
FROM Employee_Test Emp1
WHERE ( n ) = (
                SELECT COUNT( DISTINCT ( Emp2.Employee_Salary ) )
                FROM Employee_Test Emp2
                WHERE Emp2.Employee_Salary >= Emp1.Employee_Salary
            }
```
```
inner correlated query
```
```sql
SELECT TOP 1 EMPLOYEE_SALARY
FROM
(
    SELECT DISTINCT TOP N EMPLOYEE_SALARY
    FROM EMPLOYEE_TEST
    ORDER BY EMPLOYEE_SALARY DESC
) A
WHERE N > 1
ORDER BY EMPLOYEE_SALARY
```

```
Remove Duplicate Rows without Temporary Table
```
```sql
 DELETE e1 FROM EMPLOYEE e1, EMPLOYEE e2 WHERE e1.name = e2.name AND e1.id > e2.id;
```

## JPA/Hibernate
```
JDBC perf - pool, batch, commit not so often, select columns

- Optimistic Lock - @Version private Long version;
```
https://www.baeldung.com/jpa-optimistic-locking
https://stackoverflow.com/questions/21120043/optimistic-locking-by-concrete-java-example
https://www.baeldung.com/jpa-pessimistic-locking
```
PESSIMISTIC_READ, PESSIMISTIC_WRITE 

- fetch - fetch=FetchType.Lazy | Eager, fetching my entity along with sub-entities using JOIN FETCH
 FetchType.LAZY
 FetchType.EAGER

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

CascadeType.PERSIST : cascade type presist means that save() or persist() operations cascade to related entities.
CascadeType.MERGE : cascade type merge means that related entities are merged when the owning entity is merged.
CascadeType.REFRESH : cascade type refresh does the same thing for the refresh() operation.
CascadeType.REMOVE : cascade type remove removes all related entities association with this setting when the owning entity is deleted.
CascadeType.DETACH : cascade type detach detaches all related entities if a “manual detach” occurs.
CascadeType.ALL : cascade type all is shorthand for all of the above cascade operations.
	
```

## Spring
```
Spring modules 
- Data Acess/Integration - JDBC, IRM, JMS, Transactions
- Web - WebSocket, Servlet, Web, Portlet
- Core - Beans, Context, SpEL
- Test
- others - AOP, Aspects, Messaging

Inversion of control (IoC) is a programming technique in which object coupling is bound at run time by an assembler object and is typically not known at compile time using static analysis.
Inversion of control is a design paradigm with the goal of giving more control to the targeted components of your application, the ones that are actually doing the work

Dependency injection is a pattern used to create instances of objects that other objects rely on without knowing at compile time which class will be used to provide that functionality

Spring IoC container - BeanFactory - ApplicationContext 

- Spring Bean Scope - 
 singleton - default,  one instance per spring container
 prototype - This bean scope just reverses the behavior of singleton scope and produces a new instance each and every time a bean is requested
 request - new bean instance will be created for each web request made by client
 session - instance of bean per user session
 global-session - connected to Portlet

- Injection - constuctor, setter
You can mix both, Constructor-based and Setter-based DI but it is a good rule to use constructor arguments for mandatory dependencies and setters for optional dependencies.
 Constructor - throws ObjectCurrentlyInCreationException in circular dependencies
 @Required - on setter
 @Autowired, @Qualifier("personA")

- Transaction
propagation - default PROPAGATION_REQUIRED, PROPAGATION_REQUIRES_NEW, PROPAGATION_MANDATORY, PROPAGATION_SUPPORTS, PROPAGATION_NESTED ..
isolation - default (DEFAULT) READ_COMMITTED in mssql,postgres... Isolation.REPEATABLE_READ, Isolation.SERIALIZABLE
@Transactional(rollbackFor = Exception.class) - bo runtime exception zawsze przerwie, application/checked exception nie przerwie
```
https://netjs.blogspot.com/2018/08/spring-transaction-attributes-propagation-isolation-settings.html
https://stackoverflow.com/questions/8490852/spring-transactional-isolation-propagation
https://www.baeldung.com/spring-transactional-propagation-isolation

```
- SpringBoot lifecycle - Life cycle callback methods
InitializingBean and DisposableBean callback interfaces
*Aware interfaces for specific behavior
Custom init() and destroy() methods in bean configuration file
@PostConstruct and @PreDestroy annotations
    
- WEB-INF dir - This means that WEB-INF resources are accessible to the resource loader of your Web-Application and not directly visible for the public. 

- Servlet Redirect vs Forward
Simply put, forwarded requests still carry this value, but redirected requests don't.
```
https://www.baeldung.com/servlet-redirect-forward
```
- Jak Spring dostaje request - define servlets, filters, listeners...
dispatcher servlet on app url-pattern of servlet- in web.xml
After receiving an HTTP request, DispatcherServlet consults the HandlerMapping (configuration files) to call the appropriate Controller. The Controller takes the request and calls the appropriate service methods and set model data and then returns view name to the DispatcherServlet.
For example, HttpRequestHandler, WebRequestHandler, MessageHandler are all handlers which can work with the DispatcherServlet

- Jak wyczyścić kontekst Springa przed uruchomieniem kolejnego testu
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)

Component Scan

Mapper - mapstruct, modelmapper
```

## Design patterns in Spring
```
Spring Design Patterns
    Proxy – used heavily in AOP, and remoting.
    Singleton – beans defined in spring config files are singletons by default.
    Template method – used extensively to deal with boilerplate repeated code e.g. RestTemplate, JmsTemplate, JpaTemplate.
    Front Controller – Spring provides DispatcherServlet to ensure an incoming request gets dispatched to your controllers.
    View Helper – Spring has a number of custom JSP tags, and velocity macros, to assist in separating code from presentation in views.
    Dependency injection – Center to the whole BeanFactory / ApplicationContext concepts.
    Factory pattern – BeanFactory for creating instance of an object.

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


## Spring MVC
```
- Stereotype annotations
 @Component -  component-scanning mechanism 
 @Repository: When you annotate a class @Repository, spring container understands it's a DAO class and translates all unchecked exceptions (thrown from DAO methods) into Spring DataAccessException
 @Service - nothing
 @Controller - marks a class as a Spring Web MVC controller for eg: @RequestMapping
```
https://howtodoinjava.com/spring-core/stereotype-annotations/
```
@RestController = @Controller + @ResponseBody
@RequestMapping(value = "/employees")
@PostMapping(value = "/content", produces = MediaType.APPLICATION_JSON_VALUE)
@ResponseStatus(HttpStatus.BAD_REQUEST, reason = "Some parameters are invalid")
@RequestBody / @ResponseBody
@ExceptionHandler, @ControllerAdvice - a global @ExceptionHandler

RestTemplate - for testing, Java Servlet API - synch, blocking
WebClient - async, non-blocking - Flux,  flux.subscribe()

MultipartResolver 
Validator - or Hibernate Validator
HandlerInterceptor  - like servlet filter - preHandle(), postHandle() and afterCompletion()
HandlerExceptionResolver 
Locale - SessionLocaleResolver, LocaleChangeInterceptor 
ServletContextAware and ServletConfigAware
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

## Spring security
```
 Registration, Authentication [Remember me], Single Sign-On
 LDAP, 
 OAuth2 
	[Authorization Server (AS) - issues tokens for authorization] 
	[Resource Owner - grant access to its protected resources]
	[Resource Server - requires an access token to allow]
	[Client - apable of obtaining access tokens from authorization servers]
	eg: Amazon Cognito,
 OpenID Connect (OIDC) 
 SecurityContextHolder.getContext()
  .getAuthentication()
  .getUserPrincipal
 hasRole
 http.authorizeRequests().antMatchers("/login*").permitAll();
 http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
  Concurrent Session
  Session Timeout
 PasswordEncoderFactories.createDelegatingPasswordEncoder()
 BCryptPasswordEncoder().encode(plainTextPassword)
    bcrypt - BCryptPasswordEncoder (Also used for encoding)
    ldap - LdapShaPasswordEncoder
    MD4 - Md4PasswordEncoder
    MD5 - new MessageDigestPasswordEncoder("MD5")
    noop - NoOpPasswordEncoder
    pbkdf2 - Pbkdf2PasswordEncoder
    scrypt - SCryptPasswordEncoder
    SHA-1 - new MessageDigestPasswordEncoder("SHA-1")
    SHA-256 - new MessageDigestPasswordEncoder("SHA-256")
    sha256 - StandardPasswordEncoder
    argon2 - Argon2PasswordEncoder
 JSON Web Signature (JWS) 
 JSON Web Key (JWK)
```

## Spring Cloud
```
 Zuul by Netflix - Reverse Proxy, Router and Filter, @EnableOAuth2Sso, @EnableResourceServer
 Ribbon - Client Side Load Balancer
 Eureka - Service Discovery
 Hystrix - Circuit Breaker, Fallback info
 turbine - provides a way to aggregate info from Hystrix
 Archaius - external configuration
```

## AOP
```
- Aspect Oriented Programming
  najlepszy przykład Transaction w Spring, oraz Remoting
  
Bazuje na wzorcu projektowym - Proxy - proxy is an object that looks like another object, but adds special functionality behind the scene
  
By AspectJ or Spring XML config

@Before, @AfterReturning, @AfterThrowing, @After, @Around
AOP - @Aspect, @Around("execution(* com.mycomp

join point always represents a method execution
Pointcut is a predicate or expression that matches join points
```

## Spring WebFlux 
```
has been added Spring 5.0. It is fully non-blocking, supports reactive streams back pressure
Reactive programming is a programming paradigm that promotes an asynchronous, non-blocking, 
 event-driven approach to data processing. 
 Reactive programming involves modeling data and events as observable data streams and 
 implementing data processing routines to react to the changes in those streams.

 Publisher - subscribe()
 Subscriber - onNext, onSubscribe ...
 Subscription - request(), cancel()
 Processor

@EnableWebFlux
ReactiveMongoRepository
text/event-stream
```

## JMS - standard
```
- RabbitMQ - Producer, Exchange - binding/queue, Consumer 
- Amzaon SQS - Simple Queue Service
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

Java Spliterator interface is an internal iterator that breaks the stream into the smaller parts. 
These smaller parts can be processed in parallel
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
- Jaba type:
Heap - Sterta - Binary Tree
Stack - Stos - Push/Pop LIFO
HashMap - array of Entry {Entry next (like LinkedList), V value, k key}
  ConcurrentHashMap - thread safe
LinkedList vs ArrayList - O(n) depends on,  
  - LinkedList - you can walk the list forwards or backwards, but finding a position in the list takes time proportional to the size of the list
  uses more memory
  - ArrayList - allow fast random read access, so you can grab any element in constant time. But adding or removing from anywhere but the end requires shifting all the latter elements over
  
Puzzles
 Stream reduce - to Factorial - silnia
 Stack - Push, Pop
 Set - to find duplicate
 without new - new obj = Class.newInstance() / classLoader.loadClass / obj.clone / serialization_deser
```
https://howtodoinjava.com/puzzles/

## Big O - notation
```
Constant Time - O(1), 
Logarithmic Time - O(log n) for, we know how much calls will be, but fewer - i = i * 2
Linear Time - O(n) for, we know how much calls will be - i++
N Log N Time - O(n log n) for in for finite, i++ and i = i * 2
Polynomial Time - O(n^p) - for in for = O(n^2), O(n^3) - 3 times for
Exponential Time - O(k^n) for Pow - for - i <= Math.pow(2, n); i++
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

## Startups
```
HackCrisis.com / govtech.gov.pl
Lean startup - Build(Experiment), Measure(Metrics), Learn(Pivot or persevere) -> once more

Zoom - team eeting
https://www.mentimeter.com - questionnaire during online presentation
Hackathons - https://www.guaana.com/
```

## Java Virtual machine (JVM) 
```
is the virtual machine that runs the Java bytecodes. 

 You get this bytecode by compiling the .java files into .class files. .class files contain the bytecodes understood by the JVM.
JVM delivers the optimal performance for Java applications using many advanced techniques, incorporating a state-of-the-art memory model, garbage collector, and adaptive optimizer.
JVM comes in two different flavors – client and server. 
 Although the Server and the Client VMs are similar, the Server VM has been specially tuned to maximize peak operating speed.

Class loader - Loading, Linking, Initialization
 Types: Bootstrap, extension and application class loaders
JVM Memory - 
 Method Area - stores class structures like metadata, the constant runtime pool, and the code for methods.
 Heap - stores all objects that are created during application execution
 Stack - store local variables, and intermediate results. 
  All such variables are local to the thread by which they are created. 
  Each thread has its own JVM stack, created simultaneously as the thread is created. 
  So all such local variable are called thread-local variables
 PC Register - store the physical memory address of the statements which is currently executing
 Native Method Stack - Many low level code is written in languages like C and C++. 
  Native method stacks hold the instruction of native code
JVM Execution Engine - The execution engine reads the byte code and executes one by one. 
 It uses two inbuilt interpreter and JIT compiler to convert the bytecode to machine code and execute it.
  Interpreter - converts each byte-code instruction to corresponding native instruction
  JIT Compiler - (just-in-time) improve performance, not one statement at a time as interpreter
   Inlining, Local optimizations, Control flow optimizations, Global optimizations, Native code generation
Java Runtime Environment (JRE) is a software package which bundles the libraries (jars) and the Java Virtual Machine
    JRE = JVM + libraries to run Java application.
    JDK = JRE + tools to develop Java Application.
```

## Machine Learing
```
ML -/ CSV, Python / PowerBI Microsoft (GUI), ML - Keras, TensorFlow
```
https://www.kaggle.com/datasets


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

CASE (Computer-Aided Software Engineering, Computer-Aided Systems Engineering

canonical data model (CDM) 
 is a type of data model that presents data entities and relationships in the simplest possible form.
 It is generally used in system/database integration processes where data is exchanged between different systems, 
 regardless of the technology used.

Siatka Zachmana (ang. Zachman Framework) 
 szablon i sposób postępowania, który pozwala w sposób formalny i ściśle ustrukturalizowany definiować 
 architekturę systemów korporacyjnych. 
 Używa siatki bazując na sześciu podstawowych pytaniach (Co, Jak, Gdzie, Kto, Kiedy, Dlaczego) 
 zadanych pięciu grupom użytkowników (Planujący, Właściciel, Projektant, Twórca, Podwykonawca) 
 aby przedstawić holistyczny obraz przedsiębiorstwa, które jest modelowane. 

```

## UML - Unified Modeling Language
```
Structural UML diagrams
    Class diagram
    Component diagram
    Composite structure diagram
    Deployment diagram
    Object diagram
    Package diagram
    Profile diagram

Behavioral UML diagrams
    Activity diagram
    Communication diagram
    Interaction overview diagram
    Sequence diagram
    State diagram
    Timing diagram
    Use case diagram

APPS: Enterprise Architect, Visio, IBM Rational Rose, ArgoUML, Dia, StarUML 
```
## C4
```
system context
container
components
code
```

## BPMN - Business Process Model and Notation
```
graphical representation for specifying business processes in a business process model
 event - start, intermediate, end
 activity - task, sub-process, transaction, call
 gateway - exclusive, event based, parallel, inclusive, complex
 connections - sequence flow, message flow, association
 
 swim lanes - poll, lanes
 data objects
 groups
 annotation
```

## ArchiMate
```
bazuje na dwóch paradygmatach
 warstwowości (wprowadza on warstwę: biznesową, danych i aplikacji oraz techniczną);
 usługowości (identyfikowane są usługi biznesowe, aplikacyjne i infrastrukturalne).
```
https://wolski.pro/archimate-3-0/

## TOGAF (ang. The Open Group Architecture Framework)
```
szkielet dla architektury korporacyjnej, który zapewnia kompleksowe podejście do projektowania, planowania, implementacji oraz zarządzania informacyjną architekturą organizacji
    biznes,
    aplikacje,
    dane,
    technologia
```

![UML2](https://external-content.duckduckgo.com/iu/?u=http%3A%2F%2Fi.stack.imgur.com%2F1dl9G.png&f=1&nofb=1)

![BPMN2](https://external-content.duckduckgo.com/iu/?u=http%3A%2F%2Fwww.signavio.com%2Fwp-content%2Fuploads%2F2012%2F10%2Fposter-preview-bpmn-en.png&f=1&nofb=1)

![SDLC](https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Fwww.amplewebsol.com%2Fwp-content%2Fuploads%2F2018%2F06%2Fsdlc.png&f=1&nofb=1)

![SDLC models](https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Fwww.janbasktraining.com%2Fblog%2Fuploads%2Fimages%2F2019%2F02%2FSDLC-Models.jpg&f=1&nofb=1)

![SDLC phases](https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Fwww.learntek.org%2Fblog%2Fwp-content%2Fuploads%2F2019%2F05%2Fsdlc-phases.png&f=1&nofb=1)

![V model](https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2F2.bp.blogspot.com%2F--tHa1GONsaM%2FUWkni_oSX-I%2FAAAAAAAAAw4%2FB7twinmzHvI%2Fs1600%2FV-Model-sdlc2.jpg&f=1&nofb=1)
