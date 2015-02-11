CAMS Reference Implementation for AngularJS
===========================================

# Prerequisites

* Install Node.js and the latest version of npm locally. See [here](https://docs.npmjs.com/getting-started/installing-node) for instructions.
* Configure the connection to a MySql database in `cams-ref-impl-angular-server/src/main/resources/application.yml`

# Quick Start

The easiest way to get started is to switch to the project root and execute this UNIX command to run the application in development mode:

    SPRING_PROFILES_ACTIVE=development RESOURCES_PROJECTROOT=`pwd` ./gradlew :cams-ref-impl-angular-server:bootRun
     
or to run the application in production mode (which optimizes static resources using concatenation and minification), execute this:

    ./gradlew :server:bootRun
    
then go to [http://localhost:8080/](http://localhost:8080/)

## Using an IDE
Gradle can generate the configuration files for either eclipse or IntelliJ IDEA. From the project root execute:

     ./gradlew eclipse
     
or,

     ./gradlew idea  

## Debugging the Client Code
While debugging the AngularJS code locally, it is useful to reload the page in the browser automatically when any source file changes. You can do this by running the `gulp watch` command in `cams-ref-impl-angular/cams-ref-impl-angular-client`.  


# To Do (in descending priority)
* Add authentication and authorization
* Implement use cases 4, 5, and 17. Look at which is the best Spring Data repository interface to use, probably `JpaRepository`. Also, start using value objects to serialize and return to the browser
* Build with Maven (coexisting with Gradle)
* Build WAR with Gradle and test deployment to servlet container. Consult [this](http://docs.spring.io/spring-boot/docs/current/reference/html/build-tool-plugins-gradle-plugin.html) and [this](http://docs.spring.io/spring-boot/docs/current/reference/html/howto-traditional-deployment.html#howto-create-a-deployable-war-file) for details
* Downgrade to AngularJS 1.2.x.
* Find out how to move the database configuration in `/cams-ref-impl-angular-server/src/main/resources/application.yml` 
to the `/cams-ref-impl-angular-domain` project. [This](https://github.com/spring-projects/spring-boot/issues/1805) issue may be related 

# Notes
* Relative state names in `ui-sref` attributes must be prefixed by '`.`'. See `/cams-ref-impl-angular/cams-ref-impl-angular-client/src/partials/Menu/Menu.html` for an example.
* I have lowercased the property names of JSON structures returned to the client.

# References

* [Configuring resource handlers with resource resolvers and resource transformers](https://github.com/bclozel/spring-resource-handling/blob/master/server/src/main/java/org/springframework/samples/resources/WebConfig.java#L96-L117)