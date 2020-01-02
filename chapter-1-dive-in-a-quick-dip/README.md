# How Java works

1) Source - Create a source document and use an established protocol (Java)
2) Compiler - Run your document through a source code compiler. The compiler checks for errors and won't let you compile until it's satisfied that everything will run correctly.
3) Output - The compiler creates a new document, coded into Java bytecode. Any device capable of running Java will be able to interpret/translate this file into something it can run. The compiled bytecode is platform-independent.
4) Virtual Machines - Reads and runs the bytecode.

# Code Structure in Java

- A source codefile holds one class definition. The class represents a piece of your program, a very tiny app might need just a single class. The class must go within a pair of curly braces.

Example:

public class Dog {

}

- A class has one or more methods. In the Dog Class, the bark method will hold instructions for how the Dog should bark. Your methods must be declared INSIDE a class.

Example:

public class Dog {
    void bark() {

    }
}

- Within the curly braces of a method, write your instructions for how that method should be performed. Method code is basically a set of statements, and for now you can think of a method kind of like a function or procedure.

Example:

public class Dog {
    void bark() {
        statement1;
        statement2;
    }
}

# Writing a class with a main

- In Java, everuthing goes in a class. You'll type your source code file, then compile it into a new class file. When you run your program you're really running a class. The "main()" method is where your program starts running.

- Your code can tell the JVM to: 
1) do something
2) do something again and again
3) do something under a condition

# Looping

Java has three standard looping constructs: while, do-while, and for. The key to a loop is the conditional test. In Java, a conditional test is an expression that results in a Bool value.