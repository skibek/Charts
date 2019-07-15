

Print properties to logs on start

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
