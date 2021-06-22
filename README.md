# BookApp
Simple library application for books, made as a homework project for Programming 4. @ PTE-MIK 2021 Spring

## Install instructions

### Postgres

To run the project, you will need to have PostgreSQL version 12.4 installed.

The `docker-compose.yml` can be used to create a PostgreSQL service. Use `docker-compose up -d` in the project root to
start it (after having started Docker).

### Tomcat 9

1. Download [Tomcat 9 zip](https://tomcat.apache.org/download-90.cgi)
2. Unzip Tomcat 9
3. Add [postgres.jar](https://jdbc.postgresql.org/download.html) to `${TOMCAT_HOME}/lib/postgres.jar`
4. Edit `${TOMCAT_HOME}/conf/context.xml` with:

```xml

<Resource name="jdbc/bookapp" auth="Container" type="javax.sql.DataSource"
          username="sample"
          password="password"
          driverClassName="org.postgresql.Driver"
          url="jdbc:postgresql://localhost:5452/sample"
          maxTotal="25"
          maxIdle="10"
          validationQuery="select 1"/> 
```

5. Add Tomcat 9 in IDEA, make sure to use `Deployment` > `Application context` to set `bookApp` as context

#### PostgreSQL JDBC Driver as Jboss Module

1. Download the [approriate PostgreSQL JDBC driver](https://jdbc.postgresql.org/download.html) (e.g. 42.2.19)
