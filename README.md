CAMS Reference Implementation for AngularJS
===========================================

# Prerequisites

This projects requires a local install of node+npm (see [nvm](https://github.com/creationix/nvm)).

# Quick Start

The easiest way to get started is to switch to the project root and execute this command to run in development mode:

    SPRING_PROFILES_ACTIVE=development RESOURCES_PROJECTROOT=`pwd` ./gradlew :server:bootRun
     
Or the production version (more optimizations):

    ./gradlew :server:bootRun
    
Then go to [http://localhost:8080/](http://localhost:8080/)

# To Do
* Build WAR with Gradle and test deployment to servlet container. Consult [this](http://docs.spring.io/spring-boot/docs/current/reference/html/build-tool-plugins-gradle-plugin.html) and [this](http://docs.spring.io/spring-boot/docs/current/reference/html/howto-traditional-deployment.html#howto-create-a-deployable-war-file) for details
* Find out how to move the database configuration in `/cams-ref-impl-angular-server/src/main/resources/application.yml` 
to the `/cams-ref-impl-angular-domain` project. [This](https://github.com/spring-projects/spring-boot/issues/1805) issue may be related 

# Notes
* Relative state names in `ui-sref` attributes must be prefixed by '`.`'. See `/cams-ref-impl-angular/cams-ref-impl-angular-client/src/partials/Menu/Menu.html` for an example.
* I have lowercased the property names of JSON structures returned to the client.

# References

* [Configuring resource handlers with resource resolvers and resource transformers](https://github.com/bclozel/spring-resource-handling/blob/master/server/src/main/java/org/springframework/samples/resources/WebConfig.java#L96-L117)