# Java Tips

TOC
- [Useful links](#useful_links)
- [Code exchange](#code_exchange)
    - Print properties to logs on start
    - Scheduler in Spring
- [Java 8](#java8)
- [Microbenchmarking](#microbenchmarking)
- [Migrating to 11](#migrating_to_11)


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

## Java 8 <a name="java8"></a>

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
filter | findAny | orElse | collect | peek | map | mapToObj/mapToLong | allMatch
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
    
List<String> collect = persons.stream()
    .map(Person::getName)  //convert stream to String
    .collect(Collectors.toList());
```


## Microbenchmarking <a name="microbenchmarking"></a>

https://www.baeldung.com/java-microbenchmark-harness

https://openjdk.java.net/projects/code-tools/jmh/


## Migrating to 11 <a name="migrating_to_11"></a>

Java. Migrating to 11 in real app

```
bit.ly/DevoxxPL-J11
http://przybyl.org/pres/2019/DevoxxPL-migrating2Java11/#/title-slide
http://przybyl.org/pres/
https://www.youtube.com/watch?v=hAbvZs6bJP8&list=PLEof0c3P_3KYAwHoGUTKMG15s205J_1rM&index=133&t=0s
```

```shell
SDKMAN
Upgrade IDE
Upgrade build tools (and CI)
Upgrade containers (if any)
Upgrade all the (POM) dependencies
Compile 8, try running 9? 10? 11!
Add explicit dependencies (for java.se.ee)
Test (and automate) like crazy in each step!
```

```shell
Compile 11 (optional) try running 8
-- illegal-access=debug/deny
--add - [exports|opens|reads]

What might happend:
missing class
illegal access

Missing...
Applet? CORBA? Soryy mate...
javax. ... so: Replacements for deprecated
JPMS modules with Java EE APIs
Missing classes & methods - have you upgraded dependencies?
Missing -XX parameters?

Illegal Access
--illegal-access=permit (like friend) | warn (like wife) | debug (every time and show always) | deny (father-in-law - where and end)

Without modules:
--add-exports
--add-opens (aModule...)
--add-modules
--add-reads
--patch-module

All --classpath JARs end up in ALL-UNNAMED module

[java --list-modules]

Too many tuning options (close in files)
javac @option-file1 ...
```

```shell
git checkout java8 && sdk use java 8.0.192-zulu && .gradlew clean run
git checkout java9 && sdk use java 9.0.4-open && .gradlew clean run
```

Java flight recorder

and analyze in:

Java Mission control
