# JDK

TOC
- [Java 8](#java8)
- [Many JDK](#manyjdk)
- [Migrate 8 - 11](#migrate811)
- [Migrating to 11](#migrating_to_11)

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


## Many JDK <a name="manyjdk"></a>

https://www.azul.com/downloads/zulu-community/

https://github.com/AdoptOpenJDK

Docker

https://hub.docker.com/r/azul/zulu-openjdk-alpine


Cool:

https://winterbe.com/posts/2018/09/24/java-11-tutorial/



## Migrate 8 - 11 <a name="migrate811"></a>

https://blog.joda.org/2018/09/from-java-8-to-java-11.html

https://winterbe.com/posts/2018/08/29/migrate-maven-projects-to-java-11-jigsaw/

https://medium.com/criciumadev/its-time-migrating-to-java-11-5eb3868354f9

https://blog.codefx.org/java/java-11-migration-guide/

https://www.infogain.com/making-an-impact/java-8-to-11-a-migration-story/

https://docs.oracle.com/en/java/javase/11/migrate/index.html#JSMIG-GUID-C25E2B1D-6C24-4403-8540-CFEA875B994A

https://docs.oracle.com/en/java/javase/11/migrate/migration-guide.pdf

```
When upgrading to Java 11, a key task is to update all your dependencies to the latest version

https://stackoverflow.com/questions/48204141/replacements-for-deprecated-jpms-modules-with-java-ee-apis



https://spotbugs.github.io/
```

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

