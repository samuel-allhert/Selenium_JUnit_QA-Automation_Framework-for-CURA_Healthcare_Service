# Selenium (JUnit Framework)
## with Cucumber, Gherkin, BDD, and Maven
### Website being tested
```
https://katalon-demo-cura.herokuapp.com/
```
BDD written in Gherkin is located in
<br/>
```
src
|-- test
    |-- resources/features
```
For Maven, it's in
```
pom.xml
```
In this automation framework,
i applied Page Object Model
which can be seen per page in
```
src
|-- test
    |-- java
        |-- pages
```
which will be used for Test Steps in
```
src
|-- test
    |-- java
        |-- steps
```
which will be run by TestRunner in
```
src
|-- test
    |-- java
        |-- runners
```
Meanwhile, Hooks are for setting driver up
and tearing driver down, which is located in
```
src
|-- test
    |-- java
        |-- hooks
```