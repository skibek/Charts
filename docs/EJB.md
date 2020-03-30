# Enterprise Java Beans

TOC
- [General](#General)
- [Persistence](#Persistence)
- [Message driven bean](#mdb)
- [Callback](#Callback)
- [TimerService](#TimerService)
- [di](#di)
- [Interceptors](#Interceptors)
- [Transaction](#Transaction)
- [tos](#tos)
- [JNDI](#JNDI)
- [Exceptions](#Exceptions)
- [jaxrs](#jaxrs)
- [jaxb](#jaxb)
- [cdi](#cdi)
- [BeanValidator](#BeanValidator)


## General <a name="General"></a> 
```
The EJB specification is a subset of the Java EE (or J2EE, now known as Jakarta EE) specification.
concurrency, security, persistence, transaction processing
specification is implemented by many application servers such as GlassFish, IBM WebSphere and JBoss/WildFly

Java Community Process (JCP)
Java Specification Requests (JSRs)
```

## Beans <a name="beans"></a> 
```
Beans:
- Session (Single session) - encapsulates business logic. It can be invoked by local, remote or web service client
 @Stateless - It doesn't maintain state of a client between multiple method calls
 @Statefull - It maintains state of a client across multiple requests
 @Singleton - One instance per application, it is shared between clients and supports concurrent access
- Entity (Persistent data storage)
- Message Driven (JMS)

@Entity - javax.persistence
@Table(name="books")
@Id, @GeneratedValue - strategy = GenerationType.AUTO, IDENTITY
@Column(name="id")

EJB Container normally creates a pool of few stateless bean’s objects and use these objects to process client’s request.
```

```
@PersistenceContext
private EntityManager em;
	
em.persist(customer);

@WebServlet(name = "AccountController", urlPatterns = {"/AccountController"})
public class AccountController extends HttpServlet {
    @EJB
    private AccountServiceRemote accountService;
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       response.setContentType("text/html;charset=UTF-8");
	   
<form action="AccountController" method="post" >
<input type="text" name="firstName" placeholder="First Name" />
<input type="text" name="lastName" placeholder="Last Name"/>
<input type="submit" value="Create"/>
</form>

Remote/Local interface is used to expose business methods that an EJB has to implement.
@Remote
public interface LibrarySessionBeanRemote {

TEST
InitialContex
LibrarySessionBeanRemote libraryBean = (LibrarySessionBeanRemote)ctx.lookup("LibrarySessionBean/remote");
```

## Persistence API <a name="Persistence"></a> 
```
- Entity − A persistent object representing the data-store record. It is good to be serializable.
- EntityManager − Persistence interface to do data operations like add/delete/update/find on persistent object(entity). 
 It also helps to execute queries using Query interface.
- Persistence unit (persistence.xml) − Persistence unit describes the properties of persistence mechanism.
- Data Source (*ds.xml) − Data Source describes the data-store related properties like connection url. user-name,password etc.

DataSource (jboss-ds.xml)
<local-tx-datasource>
      <jndi-name>PostgresDS</jndi-name>
      <connection-url>jdbc:postgresql://localhost:5432/postgres</connection-url>
	  
Persistence Unit (persistence.xml)
<persistence-unit name = "EjbComponentPU2" transaction-type = "JTA">
      <provider>org.hibernate.ejb.HibernatePersistence</provider>
      <jta-data-source>java:/PostgresDS</jta-data-source>

@PersistenceContext(unitName="EjbComponentPU")
private EntityManager entityManager; 

return entityManager.createQuery("From Books").getResultList();

Entity Relationships
-One-to-One − Objects have one-to-one relationship. For example, a passenger can travel using a single ticket at a time.
-One-to-Many − Objects have one-to-many relationship. For example, a father can have multiple kids.
-Many-to-One − Objects have many-to-one relationship. For example, multiple kids having a single mother.
-Many-to-Many − Objects have many-to-many relationship. For example, a book can have multiple authors and an author can write multiple books.

@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}
      , fetch = FetchType.EAGER)
   @JoinTable(table = @Table(name = "book_author"),
      joinColumns = {@JoinColumn(name = "book_id")},
      inverseJoinColumns = {@JoinColumn(name = "author_id")})
	  
Class.forName(driver).newInstance();
con = DriverManager.getConnection(url , userName, password);

PreparedStatement st = con.prepareStatement("insert into book(name) values(?)");
st.setString(1,book.getName());
int result = st.executeUpdate();  
		 
EJB Query Language is quite handy to write custom queries without worrying about underlying database details. It is quite similar to HQL, hibernate query language and is often referred by the name EJBQL

//create an ejbql expression
String ejbQL = "From Book b where b.name like ?1";
//create query
Query query = entityManager.createQuery(ejbQL);
//substitute parameter.
query.setParameter(1, "%test%");   
//execute the query
return query.getResultList();

ResultSet rs = st.executeQuery("select * from book"); 

@Embeddable - POJO added to Entity
@Lob @Basic(fetch= FetchType.EAGER) - Blob, Clob, byte[]
```

## Message-Driven Bean <a name="mdb"></a> 
```
Message driven bean is a stateless bean and is used to do task asynchronously.
bean that contains business logic. But, it is invoked by passing the message. So, it is like JMS Receiver

Point-to-Point Messaging Domain - Queue 
Publisher/Subscriber Messaging Domain - Topic

 jbossmq-destinations-service.xml
 
<mbean code="org.jboss.mq.server.jmx.Queue"  
   name="jboss.mq.destination:service=Queue,name=BookQueue">  
   <depends optional-attribute-name="DestinationManager">
      jboss.mq:service=DestinationManager
   </depends>  

@MessageDriven(
   name = "BookMessageHandler",
   activationConfig = {
      @ActivationConfigProperty( propertyName = "destinationType", 
                                 propertyValue = "javax.jms.Queue"),
      @ActivationConfigProperty( propertyName = "destination", 
                                 propertyValue ="/queue/BookQueue")
   }
)
public class LibraryMessageBean implements MessageListener

Queue queue = (Queue) ctx.lookup("/queue/BookQueue");
 QueueConnectionFactory factory = (QueueConnectionFactory) ctx.lookup("ConnectionFactory");
 QueueConnection connection =  factory.createQueueConnection();
 QueueSession session = connection.createQueueSession(false, QueueSession.AUTO_ACKNOWLEDGE);
 QueueSender sender = session.createSender(queue);
```
![mess](https://www.javatpoint.com/ejbpages/images/jms-programming-model.png)


## Callback <a name="Callback"></a> 
```
Stateless
@PostConstruct 	Invoked when a bean is created for the first time.
@PreDestroy 	Invoked when a bean is removed from the bean pool or is destroyed.

+ Statefull
@PostActivate 	Invoked when a bean is loaded to be used.
@PrePassivate 	Invoked when a bean is put back to bean pool.

Entity bean
@PrePersist 	Invoked when an entity is created in database.
@PostPersist 	Invoked after an entity is created in database.
@PreRemove 	Invoked when an entity is deleted from the database.
@PostRemove 	Invoked after an entity is deleted from the database.
@PreUpdate 	Invoked before an entity is to be updated in the database.
@PostLoad 	Invoked when a record is fetched from database and loaded into the entity.
```

## TimerService <a name="TimerService"></a> 
```
@Resource
private SessionContext context;
@Timeout
public void timeOutHandler(Timer timer) {
context.getTimerService().createTimer(duration, "Hello World!");
```

## dependency injection <a name="di"></a> 
```
@EJB − used to inject other EJB reference. Used to specify or inject a dependency as EJB instance into another EJB.
@Resource − used to inject datasource or singleton services like sessionContext, timerService etc
@Inject
```

## Interceptors <a name="Interceptors"></a> 
```
@AroundInvoke
public Object methodInterceptor(InvocationContext ctx) throws Exception {

@Interceptors ({BusinessInterceptor.class})
Levels:
- Default − Default interceptor is invoked for every bean within deployment. Default interceptor can be applied only via xml (ejb-jar.xml).
- Class − Class level interceptor is invoked for every method of the bean. Class level interceptor can be applied both by annotation of via xml(ejb-jar.xml).
- Method− Method level interceptor is invoked for a particular method of the bean. Method level interceptor can be applied both by annotation of via xml(ejb-jar.xml).
```

## Transaction <a name="Transaction"></a> 
```
transaction is a single unit of work items, which follows the ACID properties. ACID stands for Atomic, Consistent, Isolated, and Durable.
- Atomic − If any of the work item fails, the whole unit will be considered failed. Success meant, all items execute successfully.
- Consistent − A transaction must keep the system in consistent state.
- Isolated − Each transaction executes independent of any other transaction.
- Durable − Transaction should survive system failure if it has been executed or committed.

- Container Managed Transactions − In this type, the container manages the transaction states.
- Bean Managed Transactions − In this type, the developer manages the life cycle of transaction states.

Container
-REQUIRED − Indicates that business method has to be executed within transaction, otherwise a new transaction will be started for that method.
-REQUIRES_NEW − Indicates that a new transaction, is to be started for the business method.
-SUPPORTS − Indicates that business method will execute as part of transaction.
-NOT_SUPPORTED − Indicates that business method should not be executed as part of transaction.
-MANDATORY − Indicates that business method will execute as part of transaction, otherwise exception will be thrown.
-NEVER − Indicates if business method executes as part of transaction, then an exception will be thrown.

@TransactionManagement(value=TransactionManagementType.BEAN)
@Resource
private UserTransaction userTransaction;

try{
   userTransaction.begin();

   confirmAccountDetail(fromAccount);
   withdrawAmount(fromAccount,fund);

   confirmAccountDetail(toAccount);
   depositAmount(toAccount,fund);

   userTransaction.commit();
}catch (InvalidAccountException exception) {
   userTransaction.rollback();
}catch (InsufficientFundException exception) {
   userTransaction.rollback();
}catch (PaymentException exception) {
   userTransaction.rollback();
}
```

## Terms of Security <a name="tos"></a> 
```
-Authentication − This is the process ensuring that user accessing the system or application is verified to be authentic.
-Authorization − This is the process ensuring that authentic user has right level of authority to access system resources.
-User − User represents the client or system, which accesses the application.
-User Groups − Users may be part of the group having certain authorities For example administrator's group.
-User Roles − Roles define the level of authority, a user have or permissions to access a system resource.

Container Managed Security

EJB 3.0 has specified following attributes/annotations of security, which EJB containers implement.
-DeclareRoles − Indicates that class will accept the declared roles. Annotations are applied at class level.
-RolesAllowed − Indicates that a method can be accessed by user of role specified. Can be applied at class level resulting which all methods of class can be accessed buy user of role specified.
-PermitAll − Indicates that a business method is accessible to all. It can be applied at class as well as at method level.
-DenyAll − Indicates that a business method is not accessible to any of the user specified at class or at method level.

@DeclareRoles({"student" "librarian"})

@RolesAllowed({"librarian"})
public void delete(Book book) {
@PermitAll
@DenyAll

<security-role-mapping>
      <role-name>librarian</role-name>
      <group-name>librarian-group</group-name>
   </security-role-mapping>
```

## JNDI <a name="JNDI"></a> 
```
JNDI stands for Java Naming and Directory Interface
-Binding − This refers to assigning a name to an EJB object, which can be used later.
-Lookup − This refers to looking up and getting an object of EJB.

@LocalBinding(jndiBinding="tutorialsPoint/librarySession")
```

## Exceptions <a name="Exceptions"></a> 
```
-Application Exception − If business rule is violated or exception occurs while executing the business logic.
-System Exception − Any exception, which is not caused by business logic or business code. RuntimeException, RemoteException are SystemException. For example, error during EJB lookup. RuntimeException, RemoteException are SystemException.


@WebService(serviceName="LibraryService")
@WebMethod(operationName="getBooks")

@BeforeClass
public void initializeContext() throws NamingException {
    ejbContainer = EJBContainer.createEJBContainer();
    context = ejbContainer.getContext();
    context.bind("inject", this);
} 
```

## Java API for RESTful Web Services (JAX-RS) <a name="jaxrs"></a> 
```
implementations: Jersey , Apache CXF, Resteasy
@ApplicationPath - definiuje główną ścieżkę aplikacji / api
@Path - określa ścieżkę do zasobu
@PathParam - pozwala wykorzystać zmienne w ścieżkach zasobów
@GET, @POST, @PUT, @DELETE - służą do określenia typu żądania obsługiwanego przez metodę. Poszczególne żądania odpowiadają operacjom CRUD, które chcemy wykonać na zasobie.
@Consumes / @Produces - określa typ danych (odbieranych i produkowanych) przez dany punkt krańcowy. Na ich podstawie wykonywany jest marshalling lub unmarshalling z/do odpowiedniego typu.
@QueryParam - mapowanie parametru żądania
@FormParam - mapowanie parametru z formularza

JAX-RS posiada bezpośrednią integrację ze specyfikacją JAXB. Jeśli więc oznaczymy klasę jako @XmlRootElement

@GET
@Produces(MediaType.APPLICATION_JSON)
```

## JAXB - Java Architecture for XML Binding <a name="jaxb"></a> 
```
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlTransient
```

## CDI (Context and Dependency Injection)  <a name="cdi"></a> 
```
jest standardem wstrzykiwania zależności w Javie EE.
@Dependent
@Inject
```

## BeanValidator - Hibernate Validator <a name="BeanValidator"></a> 
```
Bean Validation daje możliwość prostego weryfikowania poprawności pól obiektów w oparciu o zdefiniowane ograniczenia, 
które stosujemy w postaci adnotacji dodanych nad polami klasami lub metodami dostępowymi (getterami).
@NotNull,
@IsEmpty
@Email
@Min
@Future, AssertTrue, @Pattern, @Size, @CreditCardNumber ...
```
