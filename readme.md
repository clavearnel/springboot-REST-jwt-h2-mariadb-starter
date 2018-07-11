
**Deployable Springboot REST API**
> A Springboot token-based security starter kit featuring[Springboot](https://projects.spring.io/spring-boot/) ([JSON Web Token](https://jwt.io/)) MariaDB for its database. This project is deployable after build the project it will generate war file that can deploy in any tomcat server.

  


[Spring boot](https://projects.spring.io/spring-boot/),

[Json Web Token](https://jwt.io/)

[MariaDB](https://mariadb.org/)
  
  
  

> Authentication is the most common scenario for using JWT. Once the user is logged in, each subsequent request will include the JWT, allowing the user to access routes, services, and resources that are permitted with that token. Single Sign On is a feature that widely uses JWT nowadays, because of its small overhead and its ability to be easily used across different domains.

  

> -- <cite>Auth0</cite>

  
  

### Quick start

**Make sure you have Maven and Java 1.7 or greater**

  

```bash

# clone our repo

# --depth 1 removes all but one .git commit history

git clone --depth 1 https://github.com/bfwg/springboot-angular-REST-jwt-deployable.git

  

# change directory to our repo

cd springboot-jwt-starter

  

# install the repo with mvn

mvn clean install

  

# start the server

cd target
java -jar project-app.war
or deploy war file in tomcat server
  

# the app will be running on port 8080

# there are two built-in user accounts to demonstrate the differing levels of access to the endpoints:

# - User - user:123

# - Admin - admin:123

```

  
spring:

jpa:

hibernate:

# possible values: validate | update | create | create-drop

ddl-auto: create-drop

datasource:

    url: jdbc:mariadb://localhost:3306/demo
    username: admin
    password: password
    driver-class-name: org.mariadb.jdbc.Driver

```

  

*Hint: For other databases like MySQL sequences don't work for ID generation. So you have to change the GenerationType in the entity beans to 'AUTO' or 'IDENTITY'.*

  

### JSON Web Token

> JSON Web Tokens are an open, industry standard RFC 7519 method for representing claims securely between two parties.

for more info, checkout https://jwt.io/

  

### Contributing

I'll accept pretty much everything so feel free to open a Pull-Request

  
  

This project is inspried by
-  [bfwg](https://github.com/bfwg/springboot-jwt-starter.git)
-  [Cerberus](https://github.com/brahalla/Cerberus)
-  [jwt-spring-security-demo](https://github.com/szerhusenBC/jwt-spring-security-demo)

  

___
  

# License

[MIT](/LICENSE)