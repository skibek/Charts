
# Patterns

TOC
- [Coding Patterns](#coding_patterns)
- [Design Patterns](#design_patterns)
  - [GoF](#gof)
  - [others](#others)
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

## GoF <a name="gof"></a>

https://howtodoinjava.com/gang-of-four-java-design-patterns/

### Creational Design Patterns
- Builder - alternative way to construct complex objects and should be used only when we want to build different types of immutable objects using same object building process.
- Prototype - used in scenarios where application needs to create a large number of instances of a class, which have almost same state or differ very little.
- Factory - is most suitable when complex object creation steps are involved. To ensure that these steps are centralized and not exposed to composing classes.
- Abstract factory - used whenever we need another level of abstraction over a group of factories created using factory pattern.
- Singleton - enables an application to have one and only one instance of a class per JVM.

### Structural Design Patterns
- Adapter - convert the interface of a class into another interface clients expect. It lets classes work together that couldn’t otherwise because of incompatible interfaces.
- Bridge - used to decouple a class into two parts – abstraction and it’s implementation – so that both can evolve in future without affecting each other. It increases the loose coupling between class abstraction and it’s implementation.
- Composite - helps to compose the objects into tree structures to represent whole-part hierarchies. Composite lets clients treat individual objects and compositions of objects uniformly.
- Decorator - used to add additional features or behaviors to a particular instance of a class, while not modifying the other instances of same class.
- Facade - provide a unified interface to a set of interfaces in a subsystem. Facade defines a higher-level interface that makes the subsystem easier to use.
- Flyweight - enables use sharing of objects to support large numbers of fine-grained objects efficiently. A flyweight is a shared object that can be used in multiple contexts simultaneously. The flyweight acts as an independent object in each context.
- Proxy	- proxy object provide a surrogate or placeholder for another object to control access to it. Proxy is heavily used to implement lazy loading related usecases where we do not want to create full object until it is actually needed.

### Behavioral Design Patterns
- Chain of responsibility - gives more than one object an opportunity to handle a request by linking receiving objects together in form of a chain.
- Command - useful to abstract the business logic into discrete actions which we call commands. These command objects help in loose coupling between two classes where one class (invoker) shall call a method on other class (receiver) to perform a business operation.
- Interpreter - specifies how to evaluate sentences in a language, programatically. It helps in building a grammar for a simple language, so that sentences in the language can be interpreted.
- Iterator - provides a way to access the elements of an aggregate object sequentially without exposing its underlying representation.
- Mediator - defines an object that encapsulates how a set of objects interact. Mediator promotes loose coupling by keeping objects from referring to each other explicitly, and it lets us vary their interaction independently.
- Memento - used to restore state of an object to a previous state. It is also known as snapshot pattern.
- Observer - defines a one-to-many dependency between objects so that when one object changes state, all its dependents are notified and updated automatically. It is also referred to as the publish-subscribe pattern.
- State	- allows an object to alter its behavior when its internal state changes. The object will appear to change its class. There shall be a separate concrete class per possible state of an object.
- Strategy - used where we choose a specific implementation of algorithm or task in run time – out of multiple other implementations for same task.
- Template method - defines the sequential steps to execute a multi-step algorithm and optionally can provide a default implementation as well (based on requirements).
- Visitor - used when we want a hierarchy of objects to modify their behavior but without modifying their source code.


# EIP - Enterprise Integration Patterns <a name="eip"></a>

https://www.enterpriseintegrationpatterns.com/patterns/messaging/toc.html

```
> Command message
> Event message
> Process manager
> Transactional client
> Event driven consumer
> Idempotent receiver
```

```
Endpoint
Channel (Point-to-point and Publish/Subscribe)
Aggregator
Filter
Transformer
Control Bus
```

## Integration Styles
 
- File Transfer	- How can I integrate multiple applications so that they work together and can exchange information?
- Shared Database - How can I integrate multiple applications so that they work together and can exchange information?
- Remote Procedure Invocation - How can I integrate multiple applications so that they work together and can exchange information?
- Messaging - How can I integrate multiple applications so that they work together and can exchange information?
	
## Messaging Systems 

- Message Channel - How does one application communicate with another using messaging?
- Message - How can two applications connected by a message channel exchange a piece of information?
- Pipes and Filters - How can we perform complex processing on a message while maintaining independence and flexibility?
- Message Router - How can you decouple individual processing steps so that messages can be passed to different filters depending on a set of conditions?
- Message Translator - How can systems using different data formats communicate with each other using messaging?
- Message Endpoint - How does an application connect to a messaging channel to send and receive messages?
	
## Messaging Channels

- Point-to-Point Channel - How can the caller be sure that exactly one receiver will receive the document or perform the call?
- Publish-Subscribe Channel - How can the sender broadcast an event to all interested receivers?
- Datatype Channel - How can the application send a data item such that the receiver will know how to process it?
- Invalid Message Channel - How can a messaging receiver gracefully handle receiving a message that makes no sense?
- Dead Letter Channel - What will the messaging system do with a message it cannot deliver?
- Guaranteed Delivery - How can the sender make sure that a message will be delivered, even if the messaging system fails?
- Channel Adapter - How can you connect an application to the messaging system so that it can send and receive messages?
- Messaging Bridge - How can multiple messaging systems be connected so that messages available on one are also available on the others?
- Message Bus - What is an architecture that enables separate applications to work together, but in a decoupled fashion such that applications can be easily added or removed without affecting the others?
	
## Message Construction	
- Command Message - How can messaging be used to invoke a procedure in another application?
- Document Message - How can messaging be used to transfer data between applications?
- Event Message - How can messaging be used to transmit events from one application to another?
- Request-Reply - When an application sends a message, how can it get a response from the receiver?
- Return Address - How does a replier know where to send the reply?
- Correlation Identifier - How does a requestor that has received a reply know which request this is the reply for?
- Message Sequence - How can messaging transmit an arbitrarily large amount of data?
- Message Expiration - How can a sender indicate when a message should be considered stale and thus shouldn’t be processed?
- Format Indicator - How can a message’s data format be designed to allow for possible future changes?
	
## Message Routing
- Content-Based Router - How do we handle a situation where the implementation of a single logical function (e.g., inventory check) is spread across multiple physical systems?
- Message Filter - How can a component avoid receiving uninteresting messages?
- Dynamic Router - How can you avoid the dependency of the router on all possible destinations while maintaining its efficiency?
- Recipient List - How do we route a message to a list of dynamically specified recipients?
- Splitter - How can we process a message if it contains multiple elements, each of which may have to be processed in a different way?
- Aggregator - How do we combine the results of individual, but related messages so that they can be processed as a whole?
- Resequencer - How can we get a stream of related but out-of-sequence messages back into the correct order?
- Composed Message Processor - How can you maintain the overall message flow when processing a message consisting of multiple elements, each of which may require different processing?
 - Scatter-Gather - How do you maintain the overall message flow when a message needs to be sent to multiple recipients, each of which may send a reply?
- Routing Slip - How do we route a message consecutively through a series of processing steps when the sequence of steps is not known at design-time and may vary for each message?
- Process Manager - How do we route a message through multiple processing steps when the required steps may not be known at design-time and may not be sequential?
- Message Broker - How can you decouple the destination of a message from the sender and maintain central control over the flow of messages?
		
## Message Transformation	
- Envelope Wrapper - How can existing systems participate in a messaging exchange that places specific requirements on the message format, such as message header fields or encryption?
- Content Enricher - How do we communicate with another system if the message originator does not have all the required data items available?
- Content Filter - How do you simplify dealing with a large message, when you are interested only in a few data items?
- Claim Check - How can we reduce the data volume of message sent across the system without sacrificing information content?
- Normalizer - How do you process messages that are semantically equivalent, but arrive in a different format?

## Messaging Endpoints
- Messaging Gateway - How do you encapsulate access to the messaging system from the rest of the application?
- Messaging Mapper - How do you move data between domain objects and the messaging infrastructure while keeping the two independent of each other?
- Transactional Client - How can a client control its transactions with the messaging system?
- Polling Consumer - How can an application consume a message when the application is ready?
- Event-Driven Consumer - How can an application automatically consume messages as they become available?
- Competing Consumers - How can a messaging client process multiple messages concurrently?
- Message Dispatcher - How can multiple consumers on a single channel coordinate their message processing?
- Selective Consumer - How can a message consumer select which messages it wishes to receive?
- Durable Subscriber - How can a subscriber avoid missing messages while it’s not listening for them?
- Idempotent Receiver - How can a message receiver deal with duplicate messages?
- Service Activator - How can an application design a service to be invoked both via various messaging technologies and via non-messaging techniques?
	
## System Management
- Control Bus - How can we effectively administer a messaging system that is distributed across multiple platforms and a wide geographic area?
- Detour - How can you route a message through intermediate steps to perform validation, testing or debugging functions?
- Wire Tap - How do you inspect messages that travel on a point-to-point channel?
- Message History - How can we effectively analyze and debug the flow of messages in a loosely coupled system?
- Message Store - How can we report against message information without disturbing the loosely coupled and transient nature of a messaging system?
- Smart Proxy - How can you track messages on a service that publishes reply messages to the Return Address specified by the requestor?
- Test Message - What happens, though, if a component is actively processing messages, but garbles outgoing messages due to an internal fault?
- Channel Purger - How can you keep 'left-over' messages on a channel from disturbing tests or running systems?
	
## Implementations:
```
EAI and SOA platforms, such as IBM WebSphere MQ, TIBCO, Vitria, Oracle Service Bus, WebMethods (now Software AG), Microsoft BizTalk, or Fiorano.
Open source ESB's like Mule ESB, JBoss Fuse, Open ESB, WSo2, Spring Integration, or Talend ESB
Message Brokers like ActiveMQ, Apache Kafka, or RabbitMQ
Web service- or REST-based integration, including Amazon Simple Queue Service (SQS) or Google Cloud Pub/Sub
JMS-based messaging systems
Microsoft technologies like MSMQ or Windows Communication Foundation (WCF)
```
