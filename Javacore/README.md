# Core Java Exercises - Complete Collection

This repository contains **41 comprehensive Core Java exercises** organized by topic, covering fundamental concepts to advanced features.

## Project Structure

```
src/
├── basics/              # Exercises 1-10: Core Java fundamentals
├── oop/                 # Exercises 11-19: OOP, Methods, Recursion, Arrays, Strings
├── exceptions/          # Exercises 20-23: Exception handling, File I/O
├── collections/         # Exercises 24-25: ArrayList, HashMap
├── multithreading/      # Exercise 26: Thread creation
├── functional/          # Exercises 27-30: Lambdas, Streams, Records, Pattern Matching
├── jdbc/                # Exercises 31-34: Database connectivity, Modules
├── networking/          # Exercises 35-36: TCP Chat, HTTP Client
└── advanced/            # Exercises 37-41: Bytecode, Reflection, Virtual Threads, Executor Service
```

## Exercise List

### Basic Exercises (src/basics/)

1. **E01_HelloWorld** - Basic program structure
2. **E02_SimpleCalculator** - Arithmetic operations & user input
3. **E03_EvenOddChecker** - Conditional statements
4. **E04_LeapYearChecker** - Nested conditionals
5. **E05_MultiplicationTable** - For loops
6. **E06_DataTypeDemo** - Primitive data types
7. **E07_TypeCasting** - Type conversion
8. **E08_OperatorPrecedence** - Order of operations
9. **E09_GradeCalculator** - Grade assignment logic
10. **E10_NumberGuessingGame** - Loops & Random numbers

### OOP & Methods (src/oop/)

11. **E11_FactorialCalculator** - Loops & methods
12. **E12_MethodOverloading** - Method overloading
13. **E13_RecursiveFibonacci** - Recursion
14. **E14_ArraySumAndAverage** - Array operations
15. **E15_StringReversal** - String manipulation
16. **E16_PalindromeChecker** - String operations & conditionals
17. **E17_ClassAndObject** - Class definition & objects
18. **E18_InheritanceExample** - Inheritance & polymorphism
19. **E19_InterfaceImplementation** - Interfaces & implementations

### Exception Handling & File I/O (src/exceptions/)

20. **E20_TryCatchExample** - Try-catch blocks
21. **E21_CustomException** - Custom exceptions
22. **E22_FileWriting** - Writing to files
23. **E23_FileReading** - Reading from files

### Collections (src/collections/)

24. **E24_ArrayListExample** - Dynamic lists
25. **E25_HashMapExample** - Key-value pairs

### Multithreading (src/multithreading/)

26. **E26_ThreadCreation** - Creating and running threads

### Functional Programming (src/functional/)

27. **E27_LambdaExpressions** - Lambda syntax & usage
28. **E28_StreamAPI** - Stream operations
29. **E29_Records** - Record keyword (Java 16+)
30. **E30_PatternMatching** - Pattern matching in switch (Java 21)

### Database & Modules (src/jdbc/)

31. **E31_BasicJDBCConnection** - Database connectivity
32. **E32_InsertUpdateOperations** - CRUD operations
33. **E33_TransactionHandling** - JDBC transactions
34. **E34_ModuleSystem** - Java modules

### Networking (src/networking/)

35. **E35_ChatServer/E35_ChatClient** - TCP socket communication
36. **E36_HTTPClientAPI** - HTTP requests

### Advanced Topics (src/advanced/)

37. **E37_BytecodeInspection** - Using javap
38. **E38_Decompiling** - Class file decompilation
39. **E39_Reflection** - Reflection API
40. **E40_VirtualThreads** - Virtual threads (Java 21)
41. **E41_ExecutorServiceCallable** - Concurrent task execution

## How to Compile and Run

### Compile Individual Exercise

```bash
cd src/basics
javac E01_HelloWorld.java
java E01_HelloWorld
```

### Compile All Files in a Directory

```bash
cd src/basics
javac *.java
java E01_HelloWorld
```

### Compile Entire Project

```bash
javac -d bin src/basics/*.java src/oop/*.java src/exceptions/*.java src/collections/*.java src/multithreading/*.java src/functional/*.java src/jdbc/*.java src/networking/*.java src/advanced/*.java
```

## Exercise Details & Notes

### Basic Exercises

- **HelloWorld**: Simple introduction to Java syntax
- **Calculator**: Demonstrates switch statements and arithmetic
- **Even/Odd**: Uses modulus operator
- **Leap Year**: Nested if-else logic
- **Multiplication Table**: For loop iteration
- **Data Types**: Primitive types showcase
- **Type Casting**: Implicit and explicit casting
- **Operator Precedence**: PEMDAS order explanation
- **Grade Calculator**: Multi-way if-else
- **Number Guessing**: While loop with user interaction

### OOP Exercises

- **Factorial**: Mathematical calculation using loops
- **Method Overloading**: Same name, different parameters
- **Recursive Fibonacci**: Recursion concept
- **Array Operations**: Sum and average calculations
- **String Operations**: String reversal and palindrome checking
- **Classes & Objects**: Object-oriented programming
- **Inheritance**: Parent-child class relationships
- **Interfaces**: Contract-based programming

### Exception Handling

- **Try-Catch**: Basic exception handling
- **Custom Exceptions**: Creating domain-specific exceptions
- **File Writing**: Output stream operations
- **File Reading**: Input stream operations

### Collections

- **ArrayList**: Dynamic sizing vs arrays
- **HashMap**: Key-value storage and retrieval

### Advanced Topics

#### Multithreading
- Creating threads by extending Thread class
- Thread synchronization basics
- Sleep and interruption

#### Functional Programming
- **Lambda Expressions**: Anonymous functions
- **Streams**: Functional data processing
- **Records**: Immutable data carriers
- **Pattern Matching**: Type checking in switch (Java 21+)

#### JDBC
- **Connection**: Database setup and queries
- **CRUD Operations**: Insert, update, delete
- **Transactions**: Atomic operations
- **Note**: Uses SQLite for simplicity

#### Networking
- **TCP Chat**: Server-client communication
- **HTTP Client**: REST API calls

#### Advanced Features
- **Bytecode**: Understanding compiled code
- **Reflection**: Dynamic class inspection
- **Virtual Threads**: Lightweight concurrency (Java 21+)
- **Executor Service**: Thread pool management

## Requirements

- **Java 11+** for most exercises
- **Java 16+** for Records (Exercise 29)
- **Java 21** for Pattern Matching (Exercise 30) and Virtual Threads (Exercise 40)

For Java 21 features with older versions, the code will not compile but is shown for reference.

## Database Setup

Exercises 31-33 use SQLite:

1. Download sqlite-jdbc from: https://www.xerial.org/maven/repository/artifact/org/xerial/sqlite-jdbc/
2. Add to classpath when compiling:
   ```bash
   javac -cp ".:sqlite-jdbc.jar" E31_BasicJDBCConnection.java
   java -cp ".:sqlite-jdbc.jar" E31_BasicJDBCConnection
   ```

## Network Exercises

For the TCP Chat (Exercise 35):

**Terminal 1:**
```bash
javac E35_ChatServer.java
java E35_ChatServer
```

**Terminal 2:**
```bash
javac E35_ChatClient.java
java E35_ChatClient
```

## Tips for Learning

1. **Start with basics** (Exercises 1-10)
2. **Progress to OOP** (Exercises 11-19)
3. **Learn exception handling** (Exercises 20-23)
4. **Explore Collections** (Exercises 24-25)
5. **Master functional programming** (Exercises 27-30)
6. **Advance to databases** (Exercises 31-34)
7. **Network programming** (Exercises 35-36)
8. **Deepdive into advanced topics** (Exercises 37-41)

## Common Compilation Issues

### Issue: "javap not found"
- Solution: javap is in JDK bin directory. Use full path or add to PATH

### Issue: "Class not found" for JDBC
- Solution: Download sqlite-jdbc and add to classpath

### Issue: "Preview feature" error for Java 21 features
- Solution: Use `javac --enable-preview --release 21` to compile

### Issue: Database file permission denied
- Solution: Ensure write permissions in current directory

## Additional Resources

- Official Java Documentation: https://docs.oracle.com/
- Java Tutorial: https://docs.oracle.com/javase/tutorial/
- SQLite JDBC: https://www.xerial.org/maven/repository/artifact/org/xerial/sqlite-jdbc/
- Decompilers: JD-GUI, CFR, Procyon

## License

These exercises are provided as educational material for learning Java.

## Notes

- All exercises include comprehensive comments explaining concepts
- Code follows Java naming conventions and best practices
- Examples demonstrate both correct and common patterns
- Each exercise focuses on specific learning objectives
- Production-ready features like error handling are included where appropriate
