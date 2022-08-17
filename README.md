# useful_notes
###### Issue: project not imported well so that when u open the project on IDE the src folder not visible as java/src package   ##

solution: the issue cause by that the .classpath has wrong values. use included fileIN ATTACHMENT folder to have better setting


@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

#################################### get db info from windows   ############################################
open cmd , run below commands
tnsping cpgod

@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

####################### enable specific mode on Spring #########################################

java -jar app.jar --spring.profiles.active=dev

@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

################################ using curl in windows #####################################
curl -XPOST "http://localhost:8080/api/events?title=First%20Event&date=2020-11-30"

//Call self signed endpoint
curl -k -XGET "http://localhost:8080/api/events?title=First%20Event&date=2020-11-30"

@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

######################################################## find default java GC ######################################
java -XX:+PrintCommandLineFlags -version
@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@


################ generate self signed SSL using java Keytool ##########################

keytool -genkeypair -keyalg RSA -keysize 2048 -dname "cn=administrator, ou=Coherence, o=Oracle, c=US" -alias admin -keypass password -keystore /test/server.jks -storepass password -validity 180
keytool -export -alias admin -storepass password -file server.cer -keystore server.jks
keytool -importcert -trustcacerts -file server.cer

@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

################################################### set Java trust store throught command ######################

java -Djavax.net.ssl.trustStore=/apps/cpgmicroservices/cacerts -jar app.java

@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

######################################################## check remote ip and port using windows/ Linux ############
//Windows
open powershell, type below command

Test-NetConnection -ComputerName 10.22.104.15 -Port 9210

//Linux
nc -zvw10 192.168.0.1 22

//linux get PID of process running on specific port
netstat -nlp | grep :9077

z: zero-I/O mode which is used for scanning
v: for verbose output
w10: timeout wait seconds

//Windows get processID running on specific port 
netstat -ano | findstr :<PORT>

//windows kill specific process
taskkill /PID <PID> /F

@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

######################################################## find PID of running process on port Linux #########
sudo ss -lptn 'sport = :80'
sudo netstat -nlp | grep :80
@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
######################################################## JPA find by usefull methods #######################
Using Like: select ... like :username
 List<User> findByUsernameLike(String username);

StartingWith: select ... like :username%
 List<User> findByUsernameStartingWith(String username);

EndingWith: select ... like %:username
 List<User> findByUsernameEndingWith(String username);

Containing: select ... like %:username%
 List<User> findByUsernameContaining(String username);

full reference 
https://docs.spring.io/spring-data/jpa/docs/2.5.4/reference/html/#jpa.query-methods.query-creation
@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

################################# force Maven to run Junit test and not to skip unit test ##################


 <plugin>
          <groupId>org.apache.maven.plugins</groupId>
          <artifactId>maven-surefire-plugin</artifactId>
          <configuration>
          <skip>false</skip>
          </configuration>
          <version>3.0.0-M5</version>
           
        </plugin>
@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

######################################################## Get DB Connection Info #########################
for get connection info for Oracle DB
u must have Oracle client installed on your machine
open cmd, execute below command
tnsping DB_Name

@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

###################################### Encrypt data using Jasypt CLI ####################################

1- download Jasypt CLi tool from https://github.com/jasypt/jasypt/releases/download/jasypt-1.9.3/jasypt-1.9.3-dist.zip
2- extract folder, go to bin folder, go to lib, replace jar file "icu4j-3.4.4.jar" with "icu4j-68_2.jar" from https://github.com/unicode-org/icu/releases/tag/release-68-2
3- and execute below commands
encrypt.bat input="key_to_be_encrypted" password=password_encrypt_key ivGeneratorClassName=org.jasypt.iv.RandomIvGenerator algorithm="PBEWITHHMACSHA512ANDAES_128"
 
 @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
 
 ################################### Adding Code coverage for Eclipse/STS IDE ####################################
 https://dzone.com/articles/java-code-coverage-in-eclipse
 @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
 
 ################################### Adding SonarLint offline to IDE ####################################
 1- go to https://github.com/SonarSource/sonarlint-eclipse/releases
 2- get the last stable version of sonarLint version
 3- replace the VERSION in below link and paste it in your browser 
 https://binaries.sonarsource.com/SonarLint-for-Eclipse/releases/org.sonarlint.eclipse.site-VERSION.zip
 4- go to your IDE, help->install new software-> add-> Archive-> 
 5- select the file u downloaded in step 3
 6 - add any name to your site
 7- follow the UI steps and select all availables options, click next till finished
 
 
 
 @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
 
  ####################### Adding vulnerabilities check on maven or gradle ####################################

 https://blog.adamgamboa.dev/adding-vulnerabilities-check-on-maven-or-gradle/
 https://jeremylong.github.io/DependencyCheck/dependency-check-maven/index.html
 
 @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
