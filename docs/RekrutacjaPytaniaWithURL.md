# Pytania

TOC
- [General](#General)
- [Methodologies](#Methodologies)
  - [Scrum](#Scrum)
- [JAVA](#JAVA)
  - [Java 11,10,9...](#java11)
  - [JVM](#jvm)
  - [Concurrency](#Concurrency)
  - [Exceptions](#Exceptions)
  - [Streams](#Streams)
  - [GarbageCollector](#GarbageCollector)
- [SQL](#SQL)
- [JPA/Hibernate](#JPA/Hibernate)
- [microservices](#microservices)
- [AOP](#AOP)
- [JMS](#JMS)
- [Test](#Test)

- [Apache Spark](#Apache_Spark)

- [Algorithms](#Algorithms)
  - [General alg](#General_alg)
  - [Big O](#bigO)
  - [SSL](#ssl)
  - [Machine Learing](#Machine_Learing)
  - [Big O](#bigO)
  
- [Architecture](#Architecture)
  - [UML](#uml)
  - [C4](#c4)
  - [BPMN](#bpmn)
  - [Archimate](#archimate)
  - [togaf](#togaf)
  
  
## General <a name="General"></a> 
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

## Methodologies <a name="Methodologies"></a> 
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
object-oriented analysis and design

TDD - Test Driven Development
 coding, testing (in the form of writing unit tests) and design (in the form of refactoring)
 
ATDD - Acceptance Test Driven Development

BDD - Behaviour Driven Development
  user story and 5 why's
  
DDD - Domain-Driven Design
 Context
 Model
 Ubiquitous Language
 Bounded Context - boundary of typically a subsystem, or the work of a specific team
 
 Elements:
 Entity
 Value Object-OrientedDomain event
 Aggregate
 Service
 Repositories
 Factories
 
SOLID
 Single Responsibility Principle
 Open Closed Principle - “Software components should be open for extension, but closed for modification”
 Liskov’s Substitution Principle
 Interface Segregation Principle - “Clients should not be forced to implement unnecessary methods which they will not use”
 Dependency Inversion Principle - “Depend on abstractions, not on concretions”
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

### Scrum <a name="Scrum"></a> 
```
Elementy Scruma:
  daily, 
  planowanie, 
  różnica ready a done - 
  	Definition of Ready is focused on user story level characteristics,
	Definition of Done is focused on the sprint or release level
```
![Scrum](https://media-exp1.licdn.com/dms/image/C5112AQEhnWoYEfazfg/article-inline_image-shrink_1000_1488/0?e=1589414400&v=beta&t=CpMZkqgQcU8Di_MNh__B6crSVxm7_Wvsi8URePDIgGs)



## JAVA <a name="JAVA"></a> 
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
 - HashTable [old. synchronized] - not permits NULL as a key
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

### kawałki kodu <a name="code"></a>
```java
//EQUALS example
@Override
public boolean equals(Object that){
  if(this == that) return true;//if both of them points the same address in memory
  if(!(that instanceof People)) return false; // if "that" is not a People or a childclass
  People thatPeople = (People)that; // than we can cast it to People safely
  return this.name.equals(thatPeople.name) && this.age == thatPeople.age;// if they have the same name and same age, then the 2 objects are equal unless they're pointing to different memory adresses
}
@Override
public int hashCode() {
  int hash = 3;
  hash = 53 * hash + (this.name != null ? this.name.hashCode() : 0);
  hash = 53 * hash + this.age;
  return hash;
}
```

```java
//Builder
public class User {
    //All final attributes
    private final String firstName; // required
    private final String lastName; // required
    private final int age; // optional
    private final String phone; // optional
    private final String address; // optional
 
    private User(UserBuilder builder) {
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.age = builder.age;
        this.phone = builder.phone;
        this.address = builder.address;
    }
 
    //All getter, and NO setter to provde immutability
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public int getAge() {
        return age;
    }
    public String getPhone() {
        return phone;
    }
    public String getAddress() {
        return address;
    }
 
    @Override
    public String toString() {
        return "User: "+this.firstName+", "+this.lastName+", "+this.age+", "+this.phone+", "+this.address;
    }
 
    public static class UserBuilder 
    {
        private final String firstName;
        private final String lastName;
        private int age;
        private String phone;
        private String address;
 
        public UserBuilder(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }
        public UserBuilder age(int age) {
            this.age = age;
            return this;
        }
        public UserBuilder phone(String phone) {
            this.phone = phone;
            return this;
        }
        public UserBuilder address(String address) {
            this.address = address;
            return this;
        }
        //Return the finally consrcuted User object
        public User build() {
            User user =  new User(this);
            validateUserObject(user);
            return user;
        }
        private void validateUserObject(User user) {
            //Do some basic validations to check 
            //if user object does not break any assumption of system
        }
    }
}
```

### Co nowego w Java 11,10,9,8 <a name="java11"></a>
``` 
Java 8 
Before Java 8, interfaces could have only public abstract methods
interfaces can have static and default - Default Methods
Lambda Expressions, Functional Interface
Date/Time API
forEach
Optional
Stream API, Stream Filter
https://www.javatpoint.com/java-8-features

from Java 9, 
Project Jigsaw
JShell
private methods in interfaces
Optional Class - ifPresentOrElse, stream, orElseThrow,  Optional.of(str)
List<String> listOpt = list != null ? list : new ArrayList<>();
List<String> listOpt = getList().orElseGet(() -> new ArrayList<>());

Immutable Collection Factory
Collections.unmodifiableSet - Set.of, Map.of, List.copyOf(), toUnmodifiableList
Enhancements in @Deprecated - since, forRemoval 

Java 10 - Keyword “var” (Local-Variable Type Inference)

Java 11
Launch Single-File Source-Code Programs
new String methods : str1.isBlank() str.lines() ...
Files.writeString
Modularity, Version String Schema, Multi-jar releases, Var keyword, GC G1
```

### Java Virtual machine (JVM) <a name="jvm"></a>
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

### Concurrency <a name="Concurrency"></a>
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

Sekcja krytyczna - w programowaniu współbieżnym fragment kodu programu, który w danej chwili powinien być wykonywany przez nie więcej niż jeden wątek. Brak wzajemnego wykluczania się wykonywania sekcji krytycznych może spowodować błędy wykonania, np. dwukrotne zapisanie danej albo niepoprawna modyfikacja
 rozwiązuje Semafor lub Mutex
 
```
https://winterbe.com/posts/2015/04/30/java8-concurrency-tutorial-synchronized-locks-examples/
https://winterbe.com/posts/2015/05/22/java8-concurrency-tutorial-atomic-concurrent-map-examples/



### Exceptions <a name="Exceptions"></a> 
```
- Exceptions
Throwable - Error | Exception
RuntimeException - nie do złapania, zawsze przejdzie
```
https://airbrake.io/blog/java-exception-handling/the-java-exception-class-hierarchy


### Lambda <a name="lambda"></a>
```
Lambdas in Java 8 - functional interface
Java 8 Collections API has been rewritten and new Stream API is introduced that uses a lot of functional interfaces. 
Java 8 has defined a lot of functional interfaces in java.util.function package. 
Some of the useful java 8 functional interfaces are Consumer, Supplier, Function and Predicate

Any interface with a SAM(Single Abstract Method) is a functional interface
public interface Function<T, R> { … }

Lambda Expressions syntax is (argument) -> (body)

Function<Integer, String> intToString = Object::toString;
Function<String, String> quote = s -> "'" + s + "'";
Function<Integer, String> quoteIntToString = quote.compose(intToString);
assertEquals("'5'", quoteIntToString.apply(5));

@FunctionalInterface
public interface ShortToByteFunction {
    byte applyAsByte(short s);
}

For primitives - thera are always - IntPredicate, DoublePredicate and LongPredicate

BiFunction
salaries.replaceAll((name, oldValue) -> name.equals("Freddy") ? oldValue : oldValue + 10000);
  
- Supplier -
functional interface is yet another Function specialization that does not take any arguments
public double squareLazy(Supplier<Double> lazyValue) {
    return Math.pow(lazyValue.get(), 2);
}
Supplier<Double> lazyValue = () -> {
    Uninterruptibles.sleepUninterruptibly(1000, TimeUnit.MILLISECONDS);
    return 9d;
};
Double valueSquared = squareLazy(lazyValue);

- Consumers -
As opposed to the Supplier, the Consumer accepts a generified argument and returns nothing. It is a function that is representing side effects.

- Predicates -
mathematical logic, a predicate is a function that receives a value and returns a boolean value
Predicate functional interface is a specialization of a Function that receives a generified value and returns a boolean. A typical use case of the Predicate lambda is to filter a collection of values
List<String> namesWithA = names.stream()
  .filter(name -> name.startsWith("A"))
  .collect(Collectors.toList());

- Operator interfaces -
are special cases of a function that receive and return the same value type. 
The UnaryOperator interface receives a single argument. One of its use cases in the Collections API is to replace all values in a list with some computed values of the same type
names.replaceAll(name -> name.toUpperCase());
names.replaceAll(String::toUpperCase);

BinaryOperator is a reduction operation
List<Integer> values = Arrays.asList(3, 5, 8, 9, 12);
int sum = values.stream().reduce(0, (i1, i2) -> i1 + i2);
reduce method receives an initial accumulator value and a BinaryOperator function

https://www.journaldev.com/2763/java-8-functional-interfaces
```

### Streams <a name="Streams"></a> 
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

### GarbageCollector <a name="GarbageCollector"></a> 
```
OpenJDK GarbageCollectors: 
G1 provides better overall experience than a throughput-oriented collectors such as the Parallel GC
Z(JDK11), G1(JDK9,10), Parallel(JDK<=8), CMS-ConcMarkSweep, Serial, Shenandoah
System.gc();
```


## SQL <a name="SQL"></a> 
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

```
KEY - is a single or combination of multiple fields in a table
 Keys are also used to create a relationship among different database tables or views
 Primary key is a set of one or more fields/columns of a table that uniquely identify a record in a database table. 
 It can not accept null, duplicate values
 Foreign Key is a field in a database table that is Primary key in another table  
 database takes the columns specified in a CREATE INDEX command and sorts the values 
 into a special data structure known as a B-tree. 
 B-tree structure supports fast searches with a minimum amount of disk reads, allowing the database engine to 
 quickly find the starting and stopping points for the query we are using
 
Database transaction - by definition, must be ACID
atomic (it must either complete in its entirety or have no effect whatsoever), 
consistent (it must conform to existing constraints in the database), 
isolated (it must not affect other transactions) 
durable (it must get written to persistent storage).

1. Begin the transaction.
2. Execute a set of data manipulations and/or queries.
3. If no error occurs, then commit the transaction.
4. If an error occurs, then roll back the transaction.

SET TRANSACTION ISOLATION LEVEL
    { READ UNCOMMITTED
    | READ COMMITTED
    | REPEATABLE READ
    | SNAPSHOT
    | SERIALIZABLE
    
jdbc:mysql://localhost:3306/library

Spring JDBC to minimize boiler plate (see JdbcTemplate and BeanPropertyRowMapper
stored procedures
SQL driver
Java DataBase Connectivity
ODBC (ang. Open DataBase Connectivity
jOOQ

ETL - Insert into by select - Denormalizacja
ETL based data warehousing -  extract, transform, load
```

## JPA/Hibernate <a name="JPA/Hibernate"></a>
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
@MappedSuperclass - nie jest fizycznie tabelą
InheritanceType.TABLE_PER_CLASS
InheritanceType.SINGLE_TABLE - DiscriminatorColumn - DiscriminatorValue
InheritanceType.JOINED

- Optional - nie zwracać NULLa i za każdym razem sprawdzać czy nie NULL (przy zapytaniu z bazy dzięki Optionalom nie trzeba o tym pamiętać)

N + 1 zapytań, OneToMany, Eager, Query with SQL

JPA - @Embedded
```

### Hibernate
```
Configuration Object:
- Database Connection − This is handled through one or more configuration files supported by Hibernate. 
 These files are hibernate.properties and hibernate.cfg.xml.
- Class Mapping Setup − This component creates the connection between the Java classes and database tables.
- SessionFactory is a thread safe object and used by all the threads of an application
- Session Object - A Session is used to get a physical connection with a database. 
 The Session object is lightweight and designed to be instantiated each time an interaction is needed with the database. 
 Persistent objects are saved and retrieved through a Session object.
- Transaction Object - represents a unit of work with the database and most of the RDBMS supports transaction functionality. 
 Transactions in Hibernate are handled by an underlying transaction manager and transaction (from JDBC or JTA).
- Query Object - use SQL or Hibernate Query Language (HQL) string to retrieve data from the database and create objects. 
 A Query instance is used to bind query parameters, limit the number of results returned by the query, and finally to execute the query.
- Criteria objects are used to create and execute object oriented criteria queries to retrieve objects.

Stany -  Transient / Persistent / Detached 
- transient − A new instance of a persistent class, which is not associated with a Session and has no representation in the database and no identifier value is considered transient by Hibernate.
- persistent − You can make a transient instance persistent by associating it with a Session. A persistent instance has a representation in the database, an identifier value and is associated with a Session.
- detached − Once we close the Hibernate Session, the persistent instance will become a detached instance.


- Prevent Hibernate LazyInitializationException 
Fetch - left join fetch - select distinct c from Customer c left join fetch c.orders;
@BatchSize(size = 100) Set<Bar> bars; - Hibernate.initialize(foo.getBars());

CascadeType.PERSIST : cascade type presist means that save() or persist() operations cascade to related entities.
CascadeType.MERGE : cascade type merge means that related entities are merged when the owning entity is merged.
CascadeType.REFRESH : cascade type refresh does the same thing for the refresh() operation.
CascadeType.REMOVE : cascade type remove removes all related entities association with this setting when the owning entity is deleted.
CascadeType.DETACH : cascade type detach detaches all related entities if a “manual detach” occurs.
CascadeType.ALL : cascade type all is shorthand for all of the above cascade operations.

Cache:
- first-level cache is the Session cache and is a mandatory cache through which all requests must pass. 
 The Session object keeps an object under its own power before committing it to the database.
- Second level cache is an optional cache and first-level cache will always be consulted before any attempt is made to locate an object in the second-level cache. 
 The second level cache can be configured on a per-class and per-collection basis and mainly responsible for caching objects across sessions.

Interceptors:
findDirty() - this method is be called when the flush() method is called on a Session object.
instantiate() - This method is called when a persisted class is instantiated.
isUnsaved() - this method is called when an object is passed to the saveOrUpdate() method
Delete() - This method is called before an object is deleted.
onFlushDirty() - This method is called when Hibernate detects that an object is dirty (i.e. have been changed) during a flush i.e. update operation.
onLoad() - This method is called before an object is initialized.
onSave() - This method is called before an object is saved.
postFlush() - This method is called after a flush has occurred and an object has been updated in memory.
preFlush() - This method is called before a flush.

```


### microservices <a name="microservices"></a> 
```
architecture patterns next to SOA - Services Oriented Architecture
communicate with each other using widely adopted lightweight protocols, 
such as HTTP and REST, or messaging protocols, such as JMS or AMQP

Principles of Microservices
 Single responsibility principle - object should have one and only one responsibility
 Built around business capabilities
 You build it, you own it!
 Infrastructure Automation - A service shall be independently deployable
 Design for Failure - how service failures will affect the user experience
```

### AOP <a name="AOP"></a> 
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

## JMS - standard <a name="JMS"></a>
```
- RabbitMQ - Producer, Exchange - binding/queue, Consumer 
- ActiveMQ
- Amzaon SQS - Simple Queue Service

JMS 
messaging systems primarily use an asynchronous message passing pattern with no tight relationship 
between requests and responses

two main styles of asynchronous messaging: 
- message queue messaging (also known as point-to-point messaging) 
- publish subscribe messaging
durable and non-durable messages

Quality Of Service:
-AT_MOST_ONCE
-AT LEAST ONCE
-EXACTLY ONCE
Bridge:
-DUPLICATES_OK
-ONCE_AND_ONLY_ONCE

Apache ActiveMQ : different protocol implementations:
- AMQP
- OpenWire
- MQTT
- STOMP
- HornetQ (for use with HornetQ clients).
```

## Test <a name="Test"></a> 
```
Test Pyramid:
- Unit Tests: Unit tests are the tests that target small units of code, preferably in isolation
- Integration Tests: tests that target the behavior of an application while integrating with external dependencies
- UI Tests: UI or API - target the behavior of these interfaces, which often are highly interactive in nature
Manual vs. Automated Tests

This presents a visual representation of the number of tests that we should write at different levels of granularity.
(Less, Slow) UI -> Integraqtion -> Unit (Most, Fast)


Test structure - BDD - given(init), when(operation to test), then (assertion)
AssertJ, 
Testcontainers
Biblioteki do Mockowania - Mockito, EasyMock
Biblioteki do testów - Junit, Spock - Groovy

Test-driven development (TDD)

    Red – phase where tests are implemented according to requirements, but they still fail
    Green – phase where module or feature is implemented and tests pass
    Refactor – phase where a working code is made more readable and well structured

Behaviour-driven development (BDD)
BDD emerged from and extends TDD. Instead of writing unit tests from specification why not make the specification a test itself. The main idea is that business analysts, project managers, users or anyone without technical, but with sufficient business, knowledge can define tests.

Gherkin - documentation sufficient for testing
Business Readable, Domain Specific Language created especially to describe behavior without defining how to implement it. Gherkin serves two purposes: it is your project’s documentation and automated tests.
 
    Feature
    Scenario
    Given, When, Then, And, But (Steps)
    Background - like BeforeAll
	
    Scenario Outline
    Examples - many question/answers

Cucumber - understands Gherkin and runs the automated tests
each step from documentation should have underlying test code that manipulates the application and should have test conditions

JUnit - @RunWith(Cucumber.class) 
Selenium

Rest-assured - Java DSL for easy testing of REST services
given().
    params("firstName", "John", "lastName", "Doe").
when().
    post("/greetMe").
then().
    body(hasXPath("/greeting/firstName[text()='John']")).
```
https://automationrhapsody.com/introduction-to-cucumber-and-bdd-with-examples/


## Apache Spark  (Apache Flink) <a name="Apache_Spark"></a> 
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


# Algorithms <a name="Algorithms"></a> 

## General - alg <a name="General_alg"></a> 
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

## Big O - notation  <a name="bigO"></a> 
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

## SSL - HTTPS <a name="ssl"></a> 
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

## Machine Learing <a name="Machine_Learing"></a> 
```
ML -/ CSV, Python / PowerBI Microsoft (GUI), ML - Keras, TensorFlow
```
https://www.kaggle.com/datasets


# Architecture <a name="Architecture"></a> 

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

## UML - Unified Modeling Language <a name="uml"></a> 
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
## C4 <a name="c4"></a> 
```
system context
container
components
code
```

## BPMN - Business Process Model and Notation <a name="bpmn"></a> 
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

## ArchiMate <a name="archimate"></a> 
```
bazuje na dwóch paradygmatach
 warstwowości (wprowadza on warstwę: biznesową, danych i aplikacji oraz techniczną);
 usługowości (identyfikowane są usługi biznesowe, aplikacyjne i infrastrukturalne).
```
https://wolski.pro/archimate-3-0/

## TOGAF (ang. The Open Group Architecture Framework) <a name="togaf"></a> 
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
