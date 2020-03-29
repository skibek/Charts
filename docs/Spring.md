# Pytania

TOC
- [General](#General)
- [Spring](#Spring)
- [Design patterns in Spring](#Design_patterns_in_Spring)
- [Spring MVC](#Spring_MVC)
- [REST](#REST)
- [Spring security](#Spring_security)
- [Spring Cloud](#Spring_Cloud)
- [Spring WebFlux](#SpringWebFlux)
- [Spring Batch](#Spring_Batch)



## Spring <a name="Spring"></a> 
```
Spring modules 
- Data Acess/Integration - JDBC, IRM, JMS, Transactions
- Web - WebSocket, Servlet, Web, Portlet
- Core - Beans, Context, SpEL
- Test
- others - AOP, Aspects, Messaging

Jak działają Adnotacje np: @HasRole - wzorzec Proxy - dodaje kod poprzez AOP, Aspect
Spring - Annotaton does'nt work on private methods - creates code in proxy by initialization of bean - on private the bean is not

Inversion of control (IoC) is a programming technique in which object coupling is bound at run time by an assembler object and is typically not known at compile time using static analysis.
Inversion of control is a design paradigm with the goal of giving more control to the targeted components of your application, the ones that are actually doing the work
Inversion of Control, or IoC for short, is a process in which an object defines its dependencies without creating them

Dependency injection is a pattern used to create instances of objects that other objects rely on without knowing at compile time which class will be used to provide that functionality

Spring IoC container - BeanFactory - ApplicationContext 

- Spring Bean Scope - 
- singleton - default,  one instance per spring container
- prototype - This bean scope just reverses the behavior of singleton scope and produces a new instance each and every time a bean is requested
- request - new bean instance will be created for each web request made by client
- session - instance of bean per user session
- global-session / application - connected to Portlet
- websocket
@Scope - Prototype - daje możliwość bycia Stanowycm - StateFull, nie jak singleton - Stateless

- Injection - constuctor, setter
You can mix both, Constructor-based and Setter-based DI but it is a good rule to use constructor arguments for mandatory dependencies and setters for optional dependencies.
 Constructor - throws ObjectCurrentlyInCreationException in circular dependencies
 @Required - on setter
 @Autowired, @Qualifier("personA")

- Transaction
propagation - default PROPAGATION_REQUIRED, PROPAGATION_REQUIRES_NEW, PROPAGATION_MANDATORY, PROPAGATION_SUPPORTS, PROPAGATION_NESTED ..
isolation - default (DEFAULT) READ_COMMITTED in mssql,postgres... Isolation.REPEATABLE_READ, Isolation.SERIALIZABLE
@Transactional(rollbackFor = Exception.class) - bo runtime exception zawsze przerwie, application/checked exception nie przerwie

@Transactional - configuration as well:
- the Propagation Type of the transaction
- the Isolation Level of the transaction
- a Timeout for the operation wrapped by the transaction
- a readOnly flag – a hint for the persistence provider that the transaction should be read only
- the Rollback rules for the transaction
by default, rollback happens for runtime, unchecked exceptions only. 
The checked exception does not trigger a rollback of the transaction. 
We can, of course, configure this behavior with the rollbackFor and noRollbackFor annotation parameters.

Spring creates proxies for all the classes annotated with @Transactional 
Any self-invocation calls will not start any transaction
only public methods should be annotated with @Transactional

org.springframework.transaction”, which should be configured with a logging level of TRACE. 

“By default, @Transactional will set the propagation to REQUIRED, the readOnly flag to false, and the rollback only for unchecked exceptions.”

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

### Design patterns in Spring <a name="Design_patterns_in_Spring"></a> 
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
Gang of Four are the four authors of the book, "Design Patterns: Elements of Reusable Object-Oriented Software

```
https://www.tutorialspoint.com/design_pattern/proxy_pattern.htm
https://winterbe.com/posts/2009/08/13/seperation-of-concerns-proxy-pattern/


### Spring MVC <a name="Spring_MVC"></a> 
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

### REST <a name="REST"></a>
```
- PUT, DELETE - idempotentne - zawsze wykonują to samo
- PATCH - zmienia tylko część
- HEAD metoda
 The HEAD method is identical to GET except that the server MUST NOT return a message-body in the response.
- HTTP code 
 1xx - Information, 2xx - Success, 3xx Redirection, 4xx - client error, 5xx - Server error

Jak wysłać GET/POST z:
- Angular - HttpClient
- Node.js - var http = require('http'); http.request(
- Sencha - Ext.Ajax.request({
```

### Spring security <a name="Spring_security"></a> 
```
JWT - ma podspis cyfrowy co może pokazać że jest autentyczny

SecurityContext - jak działa: na ThreadLocal - Zmienna Globalna dla danego wątku przez filtr uzupełniana

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

### Spring Cloud <a name="Spring_Cloud"></a> 
```
 Zuul by Netflix - Reverse Proxy, Router and Filter, @EnableOAuth2Sso, @EnableResourceServer
 Ribbon - Client Side Load Balancer
 Eureka - Service Discovery
 Hystrix - Circuit Breaker, Fallback info
 turbine - provides a way to aggregate info from Hystrix
 Archaius - external configuration
 
 Microservices - API Gateway, Hystrix, Zuul(Gateway/Reverse proxy) i Matchowanie po URL
```

### Spring WebFlux <a name="SpringWebFlux"></a> 
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

## Spring Batch <a name="Spring_Batch"></a> 
```

```
![Workflow](https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Fdiscoversdkcdn.azureedge.net%2Fpostscontent%2Fspring%2Fbatch%2Fimage1.png&f=1&nofb=1)

## Spring Integration
```
???
```
