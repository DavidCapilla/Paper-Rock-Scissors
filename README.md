# IMC Java home assignment

## Description of the assignment

General test requirements and instructions
* Make sure we can compile and run your code

The purpose of this test is evaluate your technical skills, design skills and ability to interpret
requirements. At IMC we value simple, readable and maintainable code. Use of third party libraries is
acceptable, but ensure they add sufficient value.
They are open problems and there is no right or wrong answer.

**Problem**
Paper-Rock-Scissors is a game for two players. Each player simultaneously opens his/her hand to display
a symbol:
* Fist equals rock
* Open hand equals paper
* Showing the index and middle finger equals scissors.

The winner is determined by the following schema:
* Paper beats (wraps) rock
* Rock beats (blunts) scissors
* Scissors beats (cuts) paper.

Write a program that plays Paper-Rock-Scissors between the computer and a real player. You should be
able to play the game n times before the program exits.

## Compilation and execution

It will require Java 16 and maven* to be installed.

*Maven version 3.6.3 was presenting some issues to run with Java 16 when executed though terminal
(though it was fine when used though IntelliJ IDE). For that reason I would recommend using one of 
the latest versions of maven, such as 3.8.6, if you want to compile it via terminal.

**Compilation**

Running the following maven command at the Paper-Rock-Scissors project directory:

`mvn clean install`

will create a `target` folder where it can be found the `.jar` among others.

**Execution**

In the `target` folder it can be found `Paper-Rock-Scissors-1.0-SNAPSHOT-jar-with-dependencies.jar`.
We can execute the application using the following command:

`java -jar Paper-Rock-Scissors-1.0-SNAPSHOT-jar-with-dependencies.jar`