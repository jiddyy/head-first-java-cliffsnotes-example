# Sending things to a method

* A method uses parameters. A caller passes arguments.

- Arguments are the hings you pass into the methods. An argument (a value like 2, "Foo", or a reference to a Dog) lands face-down into a parameter. And a parameter is nothing more than a local variable. A variable with a type and a name, that can be used inside the body of the method.
- If a method takes a parameter, you must pass it something. And that something must be a value of the appropriate type.

1) Call the bark method on the Dog reference, and pass in the value 3 (as the argument to the method).

2) The bits representing the int value 3 are delivered into the bark method.

3) The bits land in the numOfBarks parameter (an int-sized variable).

4) Use the numOfBarks parameter as a variable in the method code.

``` java

void bark(int numOfBarks) {
    while (numOfBarks > 0) {
        System.out.println("Ruff");
        numOfBarks = numOfBarks - 1;
    }
}

```

# Getting things back from a method

- Methods can return values. Every method is declared with a return type, but until now we've made all of our methods with a void return type, which means they don't give anything back.

void go() {
}

- But we can declare a method to give a specific type of value back to the caller, such as:

int giveSecret() {
    return 42;
}

- If you declare a method to return a value, you must return a value of the declared type!

``` java

int theSecret = life.giveSecret();
// ^ these types must match!
int giveSecret() {
    // the return value must fit in an int!
    return 42;
    // the bits representing 42 are returned from the giveSecret() method, and land in the variable name theSecret
}

```

# Sending more than one thing to a method

- Methods can have multiple parameters. Separate them with commas when you declare them, and separate the arguments with commas when you pass them. Most importantly, if a method has parameters, you must pass arguments of the right type and order.

* Calling a two-parameter method, and sending it two arguments.

``` java

void go() {
    TestStuff t = new TestStuff();
    t.takeTwo(12, 34);
}

void takeTwo(int x, int y) {
    int z = x + y;
    System.out.println("Total is " + z);
}

```

* You can pass variables into a method, as long as the variable type matches the parameter type.

# How to objects in an array behave?

- Just like any other object, the only difference is how you get to them. In other words, how you get the remote control. Let's try calling methods on Dog objects in an array.

1) Declare and create a Dog array to hold 7 Dog references.

``` java

Dog[] pets;
pets = new Dog[7];

```

2) Create two new Dog objects, and assign them to the first two array elements.

``` java

pets[0] = new Dog();
pets[1] = new Dog();

```

3) Call methods on the two Dog objects.

``` java

pets[0].setSize(30);
int x = pets[0].getSize();
pets[1].setSize(8);

```

# Comparing variables 

* To compare two primitives, use the == operator

- The == operator can be used to compare two variables of any kind, and it simply compares the bits.
- if (a == b) looks at the bits in a and b and returns true if the bit patern is the same (although it doen't care about the size of the variable, so all the extra zeroes on the left end don't matter).

``` java

int a = 3;
byte b = 3;
if (a == b) {
    // true
}

```

- Remember, the == operator cares only about the pattern of the bits in the variable. The rules are the same whether the variable is a reference or primitive. So the == operator returns true if two reference variables refer to the same object! In that case, we don't know what the bit pattern is.

