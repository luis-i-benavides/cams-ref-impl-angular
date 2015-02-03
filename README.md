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

# Interesting Parts of the Application

* [configuring resource handlers with resource resolvers and resource transformers](https://github.com/bclozel/spring-resource-handling/blob/master/server/src/main/java/org/springframework/samples/resources/WebConfig.java#L96-L117)

# To Do
* Create `gitignore`. See [this](https://www.gitignore.io) for help
* Refactor Gradle build scripts. Move common project configuration up to root project
* Find out how to move the database configuration in `/cams-ref-impl-angular-server/src/main/resources/application.yml` 
to the `/cams-ref-impl-angular-domain` project. [This](https://github.com/spring-projects/spring-boot/issues/1805) issue may be related 
* Build WAR with Gradle and test deployment to servlet container 

