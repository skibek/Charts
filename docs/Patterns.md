
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

Dependency Injection, Inversion of Control (in Spring)

> Dependency injection (DI) is a process whereby objects define their dependencies (that is, the other objects with which they work) only through constructor arguments, arguments to a factory method, or properties that are set on the object instance after it is constructed or returned from a factory method. The container then injects those dependencies when it creates the bean. This process is fundamentally the inverse (hence the name, Inversion of Control) of the bean itself controlling the instantiation or location of its dependencies on its own by using direct construction of classes or the Service Locator pattern.

> Code is cleaner with the DI principle, and decoupling is more effective when objects are provided with their dependencies. The object does not look up its dependencies and does not know the location or class of the dependencies. As a result, your classes become easier to test, particularly when the dependencies are on interfaces or abstract base classes, which allow for stub or mock implementations to be used in unit tests.

> DI exists in two major variants: Constructor-based dependency injection and Setter-based dependency injection.

> Other elements: Autowiring, Lazy Beans, Lookup, Application Context

- BigOne:

GoF

SAFE

Event sourcing


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
