
# Patterns

TOC
- [Coding Patterns](#coding_patterns)
- [Design Patterns](#design_patterns)
- [EIP - Enterprise Integration Patterns](#eip)



# Coding patterns <a name="coding_patterns"></a>

CodeReview - GitLab with merge request, Gerrit

GitFlow - branching model for Git - https://nvie.com/posts/a-successful-git-branching-model/

Continous Integration CI - CD


Gold coding patterns:

http://itcraftsman.pl/uzyteczne-koncepty-projektowe-kiss-dry-yagni-tda-oraz-separation-of-concerns/

http://butunclebob.com/ArticleS.UncleBob.PrinciplesOfOod

SOLID - https://pl.wikipedia.org/wiki/SOLID_(programowanie_obiektowe)

  - Single responsibility principle 
  - Open/closed principle
  - Liskov substitution principle
  - Interface segregation principle
  - Dependency inversion principle

KISS - Keep It Simple Stupid [BUZI (Bez Udziwnień Zapisu, Idioto]

DRY - Dont Repeat Yourself

YAGNI - You Ain't Gonna Need It

TDA - Tell Don't Ask

SCA - Separation Of Concerns




# Design Patterns <a name="design_patterns"></a>

- Main elements:

Inheritance (person is human), Interface, Composition (human has hearth) ...

Method Overloading/Overriding

Dependency Injection, Inversion of Control (in Spring)

> Dependency injection (DI) is a process whereby objects define their dependencies (that is, the other objects with which they work) only through constructor arguments, arguments to a factory method, or properties that are set on the object instance after it is constructed or returned from a factory method. The container then injects those dependencies when it creates the bean. This process is fundamentally the inverse (hence the name, Inversion of Control) of the bean itself controlling the instantiation or location of its dependencies on its own by using direct construction of classes or the Service Locator pattern.

> Code is cleaner with the DI principle, and decoupling is more effective when objects are provided with their dependencies. The object does not look up its dependencies and does not know the location or class of the dependencies. As a result, your classes become easier to test, particularly when the dependencies are on interfaces or abstract base classes, which allow for stub or mock implementations to be used in unit tests.

> DI exists in two major variants: Constructor-based dependency injection and Setter-based dependency injection.

> Other elements: Autowiring, Lazy Beans, Lookup, Application Context

- BigOne:



SAFE

Event sourcing

GoF

https://howtodoinjava.com/gang-of-four-java-design-patterns/

Creational Design Patterns
- Builder	Builder design pattern is an alternative way to construct complex objects and should be used only when we want to build different types of immutable objects using same object building process.
 - Prototype	Prototype design pattern is used in scenarios where application needs to create a large number of instances of a class, which have almost same state or differ very little.
 - Factory	Factory design pattern is most suitable when complex object creation steps are involved. To ensure that these steps are centralized and not exposed to composing classes.
 - Abstract factory	Abstract factory pattern is used whenever we need another level of abstraction over a group of factories created using factory pattern.
- Singleton	Singleton enables an application to have one and only one instance of a class per JVM.

Structural Design Patterns
- Adapter	An adapter convert the interface of a class into another interface clients expect. It lets classes work together that couldn’t otherwise because of incompatible interfaces.
- Bridge	Bridge design pattern is used to decouple a class into two parts – abstraction and it’s implementation – so that both can evolve in future without affecting each other. It increases the loose coupling between class abstraction and it’s implementation.
- Composite	Composite design pattern helps to compose the objects into tree structures to represent whole-part hierarchies. Composite lets clients treat individual objects and compositions of objects uniformly.
- Decorator	Decorator design pattern is used to add additional features or behaviors to a particular instance of a class, while not modifying the other instances of same class.
- Facade	Facade design pattern provide a unified interface to a set of interfaces in a subsystem. Facade defines a higher-level interface that makes the subsystem easier to use.
- Flyweight	Flyweight design pattern enables use sharing of objects to support large numbers of fine-grained objects efficiently. A flyweight is a shared object that can be used in multiple contexts simultaneously. The flyweight acts as an independent object in each context.
- Proxy	In proxy design pattern, a proxy object provide a surrogate or placeholder for another object to control access to it. Proxy is heavily used to implement lazy loading related usecases where we do not want to create full object until it is actually needed.

Behavioral Design Patterns
- Chain of responsibility	Chain of responsibility design pattern gives more than one object an opportunity to handle a request by linking receiving objects together in form of a chain.
- Command	Command design pattern is useful to abstract the business logic into discrete actions which we call commands. These command objects help in loose coupling between two classes where one class (invoker) shall call a method on other class (receiver) to perform a business operation.
- Interpreter	Interpreter pattern specifies how to evaluate sentences in a language, programatically. It helps in building a grammar for a simple language, so that sentences in the language can be interpreted.
- Iterator	Iterator pattern provides a way to access the elements of an aggregate object sequentially without exposing its underlying representation.
- Mediator	Mediator pattern defines an object that encapsulates how a set of objects interact. Mediator promotes loose coupling by keeping objects from referring to each other explicitly, and it lets us vary their interaction independently.
- Memento	Memento pattern is used to restore state of an object to a previous state. It is also known as snapshot pattern.
- Observer	Observer pattern defines a one-to-many dependency between objects so that when one object changes state, all its dependents are notified and updated automatically. It is also referred to as the publish-subscribe pattern.
- State	In state pattern allows an object to alter its behavior when its internal state changes. The object will appear to change its class. There shall be a separate concrete class per possible state of an object.
- Strategy	Strategy pattern is used where we choose a specific implementation of algorithm or task in run time – out of multiple other implementations for same task.
- Template method	Template method pattern defines the sequential steps to execute a multi-step algorithm and optionally can provide a default implementation as well (based on requirements).
- Visitor	Visitor pattern is used when we want a hierarchy of objects to modify their behavior but without modifying their source code.



# EIP - Enterprise Integration Patterns <a name="eip"></a>

> Command message
> Event message
> Process manager
> Transactional client
> Event driven consumer
> Idempotent receiver


Endpoint

Channel (Point-to-point and Publish/Subscribe)

Aggregator

Filter

Transformer

Control Bus
