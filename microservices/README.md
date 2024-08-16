
### Build 
- mvn archetype:generate -DgroupId=ksike.sw -DartifactId=ms -DarchetypeArtifactId=maven-archetype-quickstart -DarchetypeVersion=1.4 -DinteractiveMode=false

### Microservices
- [Config](./config/README.md)
- [Eureka](./eureka/README.md)
- [Gateway](./gateway/README.md)

### Commands
- **Start:** docker-compose up -d
- **Stop:** docker-compose down

### Servers
- PostgreSQL
    - **username:** postgres_user
    - **password:** strongpassword
    - **hostname:** postgres_db
    - **database:** mydatabase

- MySQL
    - **username:** mysql_user
    - **password:** strongpassword
    - **hostname:** mysql_db
    - **database:** mydatabase

- Adminer
    - **url:** http://localhost:5051

- PgAdmin
    - **url:** http://localhost:5050
    - **username:** admin@example.com
    - **password:** strongpassword

### Tools
- [Online Spring Boot Banner Generator (with FIGlet Fonts)](https://devops.datenkollektiv.de/banner.txt/index.html)
- [Start Spring](https://start.spring.io/)

### Reference
- [Maven in 5 Minutes](https://maven.apache.org/guides/getting-started/maven-in-five-minutes.html)
- [Configuring Maven](https://maven.apache.org/guides/mini/guide-configuring-maven.html)
- [Downloading Apache Maven 3.9.8](https://maven.apache.org/download.cgi)
- [Spring Boot version 3](https://www.youtube.com/watch?v=t0D4OPcugyI)

