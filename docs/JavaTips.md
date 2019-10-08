# Java Tips

TOC
- [Useful links](#useful_links)
- [Code exchange](#code_exchange)
    - Print properties to logs on start
    - Scheduler in Spring
- [Microbenchmarking](#microbenchmarking)


## Useful links <a name="useful_links"></a>

https://howtodoinjava.com

Swagger:

https://howtodoinjava.com/swagger2/swagger-spring-mvc-rest-example/

JHipster Mini-Book

https://www.programmableweb.com/


## Code exchange <a name="code_exchange"></a>

### Print properties to logs on start

```Java

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class SimpleConfig {

    @Value("${simple.test:#{null}}")
    private String test;
    
    @PostConstruct
    public void printProps() {
        log.info("PROPERTIES: test = " + test);
    }
}
```

### Scheduler in Spring

```Java
/*
https://www.freeformatter.com/cron-expression-generator-quartz.html - here is 7 elements but after deleteing last char '?' this is OK for Spring
https://docs.spring.io/spring/docs/current/javadoc-api/org/springframework/scheduling/support/CronSequenceGenerator.html

second, minute, hour, day of month, month, day(s) of week
https://o7planning.org/en/11131/running-background-scheduled-tasks-in-spring

 @Scheduled(cron = "0 0 0 1,10,20 * *")
 @Scheduled(cron = "0 5 11 * * MON-FRI")
*/
```

## Microbenchmarking <a name="microbenchmarking"></a>

https://www.baeldung.com/java-microbenchmark-harness

https://openjdk.java.net/projects/code-tools/jmh/

