# Things you can do with ArrayList

1) Make one
``` java
ArrayList<Egg> myList = new ArrayList<Egg>();
```

2) Put something in it
``` java
Egg s = new Egg();

myList.add(s);
```

3) Put another thing in it
``` java
Egg b = new Egg();

myList.add(b);
```

4) Find out how many things are in it
``` java
int theSize = myList.size();
```

5) Find out if it contains something
``` java
boolean isIn = myList.contains(s);
```

6) Find out where something is (i.e. its index)
``` java
int idx = myList.indexOf(b);
```

7) Find out if it's empty
``` java
boolean empty = myList.isEmpty();
```

8) Remove something from it
``` java
myList.remove(s);
```

# Comparing ArrayList to a regular array

1) A plain old array has to know its size at the time it's created.

- But for ArrayList, you just make an object of type ArrayList. Every time. It never needs to know how big it should be, because it grows and shrinks as objects are added or removed.
``` java
new String[2]; // Needs a size.

new ArrayList<String>(); // No size required (although you can give it a size if you want to).
```

2) To put an object in a regular array, you must assign it to a specific location.

- (An index from 0 to one less than the length of the array.) 
``` java
myList[1] = b; // Needs an index.
```
- If that index is outside the boundaries of the array, it blows up at runtime. With ArrayList, you can specify an index using the add(anInt, anObject) method, or you can just keep saying add(anOBject) and the ArrayList will keep growing to make room for the new thing.
``` java
myList.add(b);
```

3) Arrays use array syntax that's not used anywhere else in Java.

- But ArrayLists are plain old Java objects, so they have no special syntax.
``` java
myList[1]; // The array brackets [] are special syntax used only for arrays.
```

4) ArrayLists in Java 5.0 are parameterized.

- We just said that unlike arrays, ArrayLists have no special syntax. But they do use something special that was added to Java 5.0 Tiger--parameterized types.
``` java
ArrayList<String>; // The <String> in angle brackets is a "type parameter". ArrayList<String> means simply "a list of Strings", as opposed to                       ArrayList<Dog> which means, "a list of Dogs".
```

- Prior to Java 5.0, there was no way to declare the type of things that would go in the ArrayList, so to the compiler, all ArrayLists were simply heterogenous collections of objects. But now, using the <typeGoesHere> syntax, we can declare and create an ArrayList that knows the types of objects it can hold.

# Super Powerful Boolean Expressions

* 'And' and 'Or' Operators (&&, ||)

- Let's say you're writing a chooseCamera() method, with lots of rules about which camera to select. Maybe you can choose cameras ranging from $50 to $1000, but in some cases you want to limit the price range more precisely. You want to say something like: 
``` java
if (price >= 300 && price < 400) {
    camera = "X";
}
```
- Let's say that one of the ten camera brands available, you have some logic that applies to only a few of the list:
``` java
if (brand.equals("A") || brand.equals("B") ) {
    // do stuff for only brand A or brand B
}
```
- Boolean expressions can get really big and complicated:
``` java
if ((zoomType.equals("optical") && 
    ( zoomeDegree > 3 && zoomDegree < 8)) ||
    (zoomeType.equals("digital") &&
    (zoomDegree >= 5 && zoomeDegree < 12))) {
        // do appropriate zoom stuff
    }
```

 # Not equals (!= and !)

 - Let's say that you have a logic like, "of the ten available camera models, a certain thing is true for all but one."
 ``` java 
 if (model != 2000) {
     // do non-model 2000 stuff
 }
 
 // or for comparing objects like strings...

 if (!brand.equals("X")) {
     // do non-brand X stuff
 }
 ```

 # To use a class in the API, you have to know which package the class is in

 - Every class in the Java library belongs to a package. The package has a name, like javax.swing. ArrayList is in the package called java.util, which holds a pile of utility classes. 

 - Using a class from the API, in your own code is simple. 

 * Put an import statement at the top of your source code file:
 ``` java 
 import java.util.ArrayList;
 public class myClass {
     ...
 }
 ```