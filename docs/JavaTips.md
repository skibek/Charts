# Java Tips

TOC


## Code exchange

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

### Java 8

Functional programming - Paradigmat of programming

eg: LISP, Haskell

-- wielowątkowe i rozproszone aplikacje łatwiej

In JAVA - Lambda - (params...) -> {code}
```Java
Collections.sort(words, (o1, o2) -> o2.compareTo(o1));
Collections.sort(words, String::compareTo);
```

Streams:
```Java
words.stream().forEach((String s) -> {System.out.println(s);});
words.stream().forEach(s -> System.out.println(s));
words.stream().forEach(System.out::println);
words.stream().filter(s -> s.length() > 3).forEach(System.out::println);
long count = words.stream.filter(s -> s.length() > 3).peek(System.out::println).count();

List<String> newWords = words.stream().map(String::toUpperCase).collect(Collectors.toList());
newWords.stream().filter(s -> s.length() > 3).forEach(System.out::println);
=
words.stream().map(String::toUpperCase).filter(s -> s.length() > 3).forEach(System.out::println);
Collection<Words> coll = words
    .stream()
    .filter(s -> s.getName().toLowerCase().contains( name.toLowerCase())
    .collect(Collectors.ToList());
```
