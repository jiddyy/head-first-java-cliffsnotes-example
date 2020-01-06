# Classes and Objects

- A class is a blueprint for an object. It tells the VM how to make an object of that particular type. Each object made from that class can have its own values for the instance variables(things an object knows) of that class. 

# How to make an object

1) You have to write your class.

Ex.

``` java
class Dog {
    int size;
    String breed;
    String name;

    void bark() {
        System.out.println("Ruff! Ruff!");
    }
}
```

2) You need to write a tester for that class.

Ex.

``` java
class DogTestDrive {
    public static void main (String[] args) {

        // In your tester, make an object and access the 
        // object's variables and methods

        Dog d = new Dog();
        d.size = 40;
        d.bark();
    }
}
```

# The uses of main

1) to test your real class
2) to launch/start your Java application

- A real Java application is nothing but objects talking to other objects (objects calling methods on one another).

# Bullet Points

* All Java code is defined in a class.
* A class describes how to make an object of that class type.
* A class can inherit instance variables and methods from a more abstract superclass.
* At runtime, a Java program is nothing more than objects 'talking' to other objects.