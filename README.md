# Setting Up Dropwizard Project with Gradle in Kotlin

This guide will walk you through the steps to create a Dropwizard project using Gradle and Kotlin. Dropwizard is a Java framework for developing RESTful web services and is highly customizable for various application needs.

## Prerequisites

- Java Development Kit (JDK) installed (version 8 or higher)
- Gradle build tool installed

## Steps

### 1. Create a new Gradle Kotlin project

You can create a new Gradle project using the Gradle command-line interface (CLI). Open your terminal or command prompt and execute the following commands:

```bash
# Create a new directory for your project
mkdir MyDropwizardProject

# Navigate into your project directory
cd MyDropwizardProject

# Initialize a new Gradle Kotlin project
gradle init --type kotlin-application
```
This will create a basic Gradle Kotlin project structure.

### 2. Configure build.gradle.kts

Edit the build.gradle.kts file to include the necessary dependencies for Dropwizard and other components. [Refer here](https://github.com/sgs-umar/DropWizardAPI-kotlin-Basic/blob/master/app/build.gradle.kts) 

### 3. Create Application Class and Configuration class

Create your Dropwizard application class [APIApplication.kt](https://github.com/sgs-umar/DropWizardAPI-kotlin-Basic/blob/master/app/src/main/kotlin/org/example/APIApplication.kt) and other necessary components like resources like [HelloWorldResources](https://github.com/sgs-umar/DropWizardAPI-kotlin-Basic/blob/master/app/src/main/kotlin/org/example/resources/HelloWorldResources.kt), services like[HelloWorldService](https://github.com/sgs-umar/DropWizardAPI-kotlin-Basic/blob/master/app/src/main/kotlin/org/example/services/HelloWorldServices.kt), and etc. 

Create a Configuration Class [APIConfiguration.kt](https://github.com/sgs-umar/DropWizardAPI-kotlin-Basic/blob/master/app/src/main/kotlin/org/example/APIConfiguration.kt) to configure the configurations from config.yml

### 4. Create config.yml

Create a [config.yml](https://github.com/sgs-umar/DropWizardAPI-kotlin-Basic/blob/master/config.yml) file in the root folder. Provide configurations for server, database and etc based on your requirements.

### 5. Run your Application

You can run your Dropwizard application using Gradle. Open a terminal or command prompt in your project directory and run:
```bash
gradlew run
```
This command will compile your Kotlin code, package it, and start the Dropwizard application. You should see output indicating that your application has started successfully.




