settings.xml

.m2

Nexus


## Proxy for Maven
```xml
<settings xmlns="http://maven.apache.org/SETTINGS/1.0.0" 
  xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" 
  xsi:schemaLocation="http://maven.apache.org/SETTINGS/1.0.0 
http://maven.apache.org/xsd/settings-1.0.0.xsd"> (http://maven.apache.org/xsd/settings-1.0.0.xsd%27%3E) 
  <localRepository/> 
  <interactiveMode/> 
  <usePluginRegistry/> 
  <offline/> 
  <pluginGroups/> 
  <servers/> 
  <mirrors/> 
  <proxies> 
    <proxy> 
      <id>myproxy</id> 
      <active>true</active> 
      <protocol>http</protocol> 
      <host>v10nhq-mgt-wcg.bank.bps.corp</host> 
      <port>8080</port> 
      <username></username> 
      <password></password> 
      <nonProxyHosts>localhost|127.0.0.1</nonProxyHosts> 
    </proxy> 
    <proxy> 
      <id>myproxy2</id> 
      <active>true</active> 
      <protocol>https</protocol> 
      <host>v10nhq-mgt-wcg.bank.bps.corp</host> 
      <port>8080</port> 
      <username></username> 
      <password></password> 
      <nonProxyHosts>localhost|127.0.0.1</nonProxyHosts> 
    </proxy> 
  </proxies> 
  <activeProfiles>
    <!--make the profile active all the time -->
    <activeProfile>insecurecentral</activeProfile>
  </activeProfiles>
  <profiles>
    <profile>
      <id>insecurecentral</id>
      <!--Override the repository (and pluginRepository) "central" from the Maven Super POM -->
      <repositories>
        <repository>
          <id>central</id>
          <url>http://repo1.maven.org/maven2</url>
          <releases>
            <enabled>true</enabled>
          </releases>
        </repository>
      </repositories>
      <pluginRepositories>
        <pluginRepository>
          <id>central</id>
          <url>http://repo1.maven.org/maven2</url>
          <releases>
            <enabled>true</enabled>
          </releases>
        </pluginRepository>
      </pluginRepositories>
    </profile>
  </profiles>
</settings> 

```
