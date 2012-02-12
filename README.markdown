# Battleships: Play an AI agent in a Java powered GUI

This code is from my Dissertation in 2005.

I thought it would be an interesting experiment to take some of the oldest code that I still have and apply the concepts I've learnt from <a href='http://www.amazon.co.uk/gp/product/0132350882/ref=ox_sc_act_title_1?ie=UTF8&m=A3P5ROKL5A1OLE'> Robert Martin's book, Clean Code</a>.

Expect much refactoring as the codebase evolves and SOLID principles are applied to code which was written without knowledge of design patterns.

# Installation instructions

You may either run the latest unstable jarfile or run the code from a Java IDE.

* To run the jarfile, download [battleships jar file](https://github.com/michaelokarimia/battleships/blob/master/jarfiles/battleships.jar) and run the jar file. In the command line or terminal use the following command:

	`java -jar battleships.jar`

* Alternatively, open the project in your favourite Java IDE and run the class BattleshipsEngine.java. Unit tests reside in the unitTests directory and are runable under JUnit. Legacy executable test classes can be found in the testrunner directory

## Dissertation Abstract:
The goal of the project is to produce a program of the turn-based board game Battleships, where a human user plays against an Artificial Intelligence agent.
