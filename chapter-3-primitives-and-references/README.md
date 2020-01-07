# Declaring Variables

- Java cares about type. You must declare the type of your variable. Is it an integer? a Dog? Variables come in two flavors: primitive and object reference? Primitives hold fundamental values (think: simple bit patterns)including integers, booleans, and floating point numbers. Object references hold references to objects.
- When you see a statement like: "an object of type X", think of type and class as synonyms.
- A variable is just a cup. A container. It holds something.

* You can assign a value to a variable in one of several ways including:
    - type a literal value after the equals sign (x=12, isGood = true, etc.)
    - assign the value of one variable to another (x = y)
    - use an expression combining the two (x = y + 43)

But what can you use as names? The rules are simple. You can name a class, method, or variable according to the following rules (the real rules are slightly more flexible, but these will keep you safe):
- It must start with a letter, underscore, or dollar sign. You can't start a name with a number.
- After the first character, you can use numbers as well. Just don't start it with a number.
- It can be anything you like, subject to those two rules, just so long as it isn't one of Java's reserved words.

# Reserved Words

boolean, byte, char, double, float, int, long, short, public, private, protected, abstract, final, native, static, strictfp, synchronized, transient, valatile, if, else, do, while, switch, case, default, for, break, continue, assert, class, extends, implements, import, instanceof,interface, new, package, super, this, catch, finally, try, throw, throws, return, void, const, goto, enum

# The 3 steps of object declaration, creation and assignment

1) Declare a reference variable

Dog myDog = new Dog();

Tells the JVM to allocate space for a reference variable, and names that variable myDog. The reference variable is, forever, of type Dog. In other words, a remote controle that has buttons to control a Dog, but not a Cat or a button or a Socket.

2) Create an object

Dog myDog = new Dog();

Tells the JVM to allocate space for a new Dog object on the heap.

3) Link the object and the reference

Dog myDog = new Dog();

Assigns the new Dog to the reference variable myDog. In other words, programs the remote control.

# Life on the garbage-collectible heap

Book b = new Book();
Book c = new Book();

Declare two Book reference variables. Create two new Book objects. Assign the Book objects to the reference variables.
The two Book objects are now living on the heap.

Book d = c;

Declare a new Book reference variable. Rather than creating a new, third Book objects, assign the value of variable c to variable d. But what does this mean? It's like saying, "Take the bits in c, make a copy of them, and stick that copy into d."
Both c and d refer to the same object. 
The c and d variables hold two different copies of the same value. Two remotes programmed to one TV.

c = b;

Assign the value of variable b to variable c. By now you know what this means. The bits inside variable b are copied, and that new copy is stuffed into variable c.
Both b and c refer to the same object.

# Life and death on the heap

Book b = new Book();
Book c = new Book();

Declare two Book reference variables. Create two new Book objects. Assign the Book objects to the reference variables.
The two book objects are now living on the heap.

b = c;

Assign the value of variable c to variable b. The bits inside variable c are copied, and the new copy is stuffed into variable b. Both variables hold identical values.
Both b and c refer to the same object. Object 1 is abandoned and eligible for Garbage Collection (GC).
The first object that b referenced, Object 1, has no more references. It's unreachable.

c = null;

Assign the value null to variable c. This makes c a null reference, meaning it doesn't refer to anything. But it's still a reference variable,and another Book object can still be assigned to it.
Object 2 still has an active reference (b), and as long as it does, the object is not eligible for GC.

# Arrays are objects too

- Arrays (ordered, efficient list of things) give you fast random access by letting you use an index position to get any element in the array. Everey element in an array is just a variable. In other words, one of the eight primitive variable types or a reference variable. Anything you would put in a variable of that type can be assigned to an array element of that type. So in an array of type int (int[]), each element can hold an int. In a Dog array (Dog[]) each element can hold... a Dog? No, remember that a reference variable just hold a reference (a remote control), not the object itself. So in a Dog array, each element can hold a remote control to a Dog. 

* the array is an object, even though it's an array of primitives.

- Arrays are always objects, whether they're declared to hold primitives or object references. But you can have an array of object that's declared to hold primitive values. In other words, the array object can have elements which are primitives, but the array itself is never a primitive. Regardless of what the array holds, the array itself is always an object!

# Making an array of Dogs

``` java 

class Dog {
    String name;
    public static void main (String[] args) {
        // make a Dog object and access it
        Dog dog1 = new Dog();
        dog1.bark();
        dog1.name = "Bart";

        // now make a Dog array
        Dog[] myDogs = new Dog[3];
        // and put some dogs in it
        myDogs[0] = new Dog();
        myDogs[1] = new Dog();
        myDogs[2] = dog1;

        // now access the Dogs using the array references
        myDogs[0].name = "Fred";
        myDogs[1].name = "Marge";

        // myDogs[2]'s name will equal dog1's name (Bart)
        System.out.print("Last dog's name is ");
        System.out.println(myDogs[2].name);

        // now loop through the array and tell all dogs to bark
        int x = 0;
        while (x < myDogs.length) {
            myDogs[x].bark();
            x = x + 1;
        }
    }

    public void bark() {
        System.out.println(name + " says Ruff!");
    }
}

```