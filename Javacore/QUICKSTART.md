# Quick Start Guide

## Basic Commands

### Compile a Single File
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

### Compile Specific Exercise
```bash
javac src/basics/E02_SimpleCalculator.java
java -cp src basics.E02_SimpleCalculator
```

## Running Exercises by Category

### Basics (E01-E10)
```bash
cd src/basics
javac *.java

java E01_HelloWorld
java E02_SimpleCalculator
java E03_EvenOddChecker
java E04_LeapYearChecker
java E05_MultiplicationTable
java E06_DataTypeDemo
java E07_TypeCasting
java E08_OperatorPrecedence
java E09_GradeCalculator
java E10_NumberGuessingGame
```

### OOP (E11-E19)
```bash
cd src/oop
javac *.java

java E11_FactorialCalculator
java E12_MethodOverloading
java E13_RecursiveFibonacci
java E14_ArraySumAndAverage
java E15_StringReversal
java E16_PalindromeChecker
java E17_ClassAndObject
java E18_InheritanceExample
java E19_InterfaceImplementation
```

### Exceptions & File I/O (E20-E23)
```bash
cd src/exceptions
javac *.java

java E20_TryCatchExample
java E21_CustomException
java E22_FileWriting
java E23_FileReading
```

### Collections (E24-E25)
```bash
cd src/collections
javac *.java

java E24_ArrayListExample
java E25_HashMapExample
```

### Multithreading (E26)
```bash
cd src/multithreading
javac *.java
java E26_ThreadCreation
```

### Functional Programming (E27-E30)
```bash
cd src/functional
javac *.java

java E27_LambdaExpressions
java E28_StreamAPI
java E29_Records              # Requires Java 16+
java E30_PatternMatching      # Requires Java 21+
```

### JDBC & Modules (E31-E34)
```bash
cd src/jdbc
javac *.java

java E31_BasicJDBCConnection
java E32_InsertUpdateOperations
java E33_TransactionHandling
java E34_ModuleSystem
```

### Networking (E35-E36)
```bash
cd src/networking
javac *.java

# Terminal 1:
java E35_ChatServer

# Terminal 2:
java E35_ChatClient

# For HTTP exercise:
java E36_HTTPClientAPI
```

### Advanced Topics (E37-E41)
```bash
cd src/advanced
javac *.java

java E37_BytecodeInspection
java E38_Decompiling
java E39_Reflection
java E40_VirtualThreads       # Requires Java 21+
java E41_ExecutorServiceCallable
```

## Special Cases

### Using javap (Exercise 37)
```bash
cd src/advanced
javac E37_BytecodeInspection.java

# View bytecode
javap -c E37_BytecodeInspection

# Detailed output
javap -c -v E37_BytecodeInspection

# Method-specific
javap -c E37_BytecodeInspection | grep -A 20 "calculateBirthYear"
```

### Decompilation (Exercise 38)
```bash
cd src/advanced
javac E38_Decompiling.java

# Using CFR (download from https://www.benf.org/other/cfr/)
java -jar cfr.jar E38_Decompiling.class

# Or use online decompiler sites
```

### JDBC with SQLite (Exercises 31-33)
```bash
# Download sqlite-jdbc from:
# https://www.xerial.org/maven/repository/artifact/org/xerial/sqlite-jdbc/

# Compile with SQLite
javac -cp "sqlite-jdbc.jar" E31_BasicJDBCConnection.java

# Run with SQLite in classpath
java -cp ".:sqlite-jdbc.jar" E31_BasicJDBCConnection
```

### Java 21 Features (E30, E40)
```bash
# Compile with preview features
javac --enable-preview --release 21 E30_PatternMatching.java

# Run with preview
java --enable-preview E30_PatternMatching

# Or compile without preview flag if using Java 21+
javac E30_PatternMatching.java
java E30_PatternMatching
```

## Batch Compilation

### Compile All Exercises
```bash
cd src
for dir in */; do
    echo "Compiling $dir..."
    javac $dir/*.java
done
```

### Windows PowerShell
```powershell
Get-ChildItem -Directory | ForEach-Object {
    Write-Host "Compiling $($_.Name)..."
    javac $_.FullName\*.java
}
```

## Useful Tips

### Check Java Version
```bash
java -version
javac -version
```

### Find Available Java Versions
```bash
# Windows
where java

# Linux/Mac
which java
which javac
```

### Clean Compiled Files
```bash
# Find and remove .class files
find src -name "*.class" -delete
```

### Run with Different Java Version
```bash
# Windows - Path to specific JDK
"C:\Program Files\Java\jdk-21\bin\java.exe" E01_HelloWorld

# Linux
/usr/lib/jvm/java-21-openjdk/bin/java E01_HelloWorld
```

### Debug Execution
```bash
# Run with verbose output
java -verbose:class E01_HelloWorld

# Run with system properties
java -Dproperty=value E01_HelloWorld
```

## Interactive Exercises

These exercises require user input:
- E02_SimpleCalculator
- E03_EvenOddChecker
- E04_LeapYearChecker
- E05_MultiplicationTable
- E09_GradeCalculator
- E10_NumberGuessingGame
- E11_FactorialCalculator
- E13_RecursiveFibonacci
- E14_ArraySumAndAverage
- E15_StringReversal
- E16_PalindromeChecker
- E21_CustomException
- E22_FileWriting
- E24_ArrayListExample
- E25_HashMapExample
- E35_ChatClient

## Troubleshooting

### "javac: command not found"
- Add Java bin directory to PATH
- Or use full path to javac

### "Exception in thread "main""
- Ensure class name matches filename
- Check main method signature: `public static void main(String[] args)`
- Verify no syntax errors

### "Class not found"
- Ensure you're in correct directory
- Include full package path if in subdirectories
- Check class name capitalization

### Memory Issues
- Increase heap size: `java -Xmx1024m ClassName`

## IDE Setup

### IntelliJ IDEA
1. Open project folder
2. Mark `src` as Sources Root
3. Right-click file → Run

### Visual Studio Code
1. Install Extension Pack for Java
2. Open folder
3. Use Run button or F5

### Eclipse
1. Create new Java project
2. Link external source folder to `src`
3. Right-click → Run As → Java Application

## Next Steps

After completing exercises:
1. Try modifying exercises to add new features
2. Combine concepts from multiple exercises
3. Create your own mini-projects
4. Explore external libraries
5. Study design patterns
6. Learn about testing (JUnit)
7. Explore Spring Framework
8. Build larger applications
