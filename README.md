# selenium-java-spock-boilerplate

## How to build

In case when you don't have installed maven please don't install anything, just use maven wrapper.

### Maven

To build project and run tests execute following command in terminal for project root directory:

    mvn clean test
    
### Maven wrapper

To build project and run tests execute following command in terminal for project root directory

    ./mvnw clean test
    
## Structure

You will find tests under:

    ../tests/src/test/groovy/com/marcinstanek/seleniumjavaspockboilerplate/..

    
## Reporting 

### With maven
    
To serve project report, execute following command in terminal from root directory after running previous command:

    mvn allure:serve 
    
To build project report, execute following command in terminal from root directory after running previous command:

    mvn allure:report 
    
### With maven wrapper

To serve project report, execute following command in terminal from root directory after running previous command:

    ./mvnw allure:serve 
    
To build project report, execute following command in terminal from root directory after running previous command:

    ./mvnw allure:report 