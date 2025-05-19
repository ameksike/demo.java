
## Project Structure
```
src/  
├── main/  
│   ├── java/          # Your Java code goes here  
│   └── resources/     # You can include configuration files here  
├── test/              # Write test cases here  
```

## Run 
Compile the project:
```sh
mvn clean install  
```

Use the following command to run the program:
```sh
# run file: src\main\java\mdb\quickstart\Collection.java
mvn exec:java -Dexec.mainClass=mdb.quickstart.Collection -Dmongodb.uri="<connectionString>"

# run file: src\main\java\mdb\quickstart\Connection.java
mvn compile exec:java -Dexec.mainClass="mdb.quickstart.Connection" -Dmongodb.uri="<connectionString>"
```

## Recommended Instances
- You should have only one MongoClient instance per Atlas cluster for your application. If you use more than one MongoClient instance for a single Atlas cluster in your application, you risk having higher-than-normal database costs.
- Having more than one MongoClient instance for a single Atlas cluster will cause unnecessary connections to your database. The cost of multiple MongoClient instances include wasted resources due to background threads for each MongoClient instance, extra connections due to background monitoring, and possibly excessive connections in the pool.

## References 
- [MongoDB with Java](https://www.mongodb.com/docs/languages/java/)
- [Start with Guides](https://www.mongodb.com/docs/guides/)
- [Using MongoDB with Java](https://learn.mongodb.com/learning-paths/using-mongodb-with-java)
- [Spring Boot and MongoDB](https://www.mongodb.com/resources/products/compatibilities/spring-boot)
- [Spring Data Unlocked: Advanced Queries With MongoDB](https://www.mongodb.com/developer/products/mongodb/springdata-advanced-queries-with-mongodb/)
- [Spring Data Unlocked: Getting Started With Java and MongoDB](https://www.mongodb.com/developer/products/mongodb/springdata-getting-started-with-java-mongodb/)
- [Unlocking Semantic Search: Building a Java-Powered Movie Search Engine with Atlas Vector Search and Spring Boot](https://www.mongodb.com/developer/products/atlas/java-spring-boot-vector-search/)
- [Demo-Portal: Industry Solutions](https://demo-portal.industrysolutions.prod.corp.mongodb.com/demos?industries=fsi)