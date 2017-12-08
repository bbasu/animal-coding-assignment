# “animals” coding task.

It originates from http://www.starling-software.com/en/employment/interview-process.

It can be solved in different ways each depending which level of coding craftsmanship the programmer wishes to apply.

* Level 1:
 
	1. As a general requirement: Please make sure we can execute the code on our local machines, i.e. please provide all required dependencies and installation documentation or a ready to use build configuration, e.g. a maven pom.xml, composer.json etc. if needed.
	2. Please write a program that reads file input.txt which you find attached to this mail.
	3. In this file you’ll find lines containing categories and data. The categories are “ANIMALS” and “NUMBERS”. <br />
		a. Please note that categories are fix values, i.e. they are NOT determined by being written upper case.<br />
		b. Each line following a category represents data items that belong to the previously read category (unless the new line represents a category itself)<br />
	4. After reading and processing the file please output to the system console:<br />
		a. A sorted list of all unique data items of category “ANIMALS”, i.e.<br />
			ANIMALS:<br />
			cow<br />
			horse<br />
			moose<br />
			sheep<br />
		b. A list of all unique data items of category “NUMBERS”, followed by “: “ and the number of occurrences of the respective data item
 
	!! While there is a straightforward solution for Level 1 you can also try to reach higher levels if you like:
 
* Level 2:

	Provide Unit tests for your code.

* Level 3:
 
	1. Please make sure you have correctly implemented code for categories NUMBERS and ANIMALS.
	2. Now, as a Change Request, you are to add functionality to your program that allows for processing a new category called "CARS"
	3. Read & process file „input2.txt“ which contains category „CARS“, as well as NUMBERS and ANIMALS.
		a. Data items are case insensitive, i.e. OPEL and Opel represent 1 unique data item
	4. Output the data for categories "ANIMALS" and "NUMBERS" as described in Level 1.<br />
		a. Additionally, output the unique data items of category “CARS” as a backwards sorted list, each item written in lower case.<br />
		b. Each data item output shall be followed by the item’s MD5 hash written in brackets.<br />
			Hint: using org.apache.commons.codec.digest.DigestUtils from commons-codec for creating the hash is perfectly legal.<br />
		c. I.e. the expected output for CARS shall be:<br />
			CARS: <br />
			vw (7336a2c49b0045fa1340bf899f785e70)<br />
			opel (f65b7d39472c52142ea2f4ea5e115d59)<br />
			bmw (71913f59e458e026d6609cdb5a7cc53d)<br />
			audi (4d9fa555e7c23996e99f1fb0e286aea8)<br />
	5. Make sure the input file is read and processed only once (as if the file was large and expensive to process).
 
* Level 4:
	 
	1. Do not use conditional statements like if/else, switch/case or Ternary Operations (http://en.wikipedia.org/wiki/Ternary_operation) in your code.
	 
	2. The code should be written in a way that allows for adding more new categories (that might have even different logic and output formatting) without changing the existing code base (also known as the Open Closed Principle).

### Prerequisites

JDK 1.7 or above

```
Give examples
```

### Installing

Import to IDE (Eclipse /IntelliJ)

Import as a Maven Project

## Execution

* From the Main.java class
* Right Click "Run As" -> "Java Application"

## Running the tests

<TO DO>

## Deployment

``` 
mvn clean install
```

## Built With

* [Maven](https://maven.apache.org/) - Dependency Management

## Author

* [Biswadeep Basu](https://github.com/bbasu)
