# Understanding Inheritance

- When you design with inheritance, you put common code in a class and then tell other more specific classes that the common class is their superclass. When on class inherits from another, the subclass inherits from the superclass.
- In Java, we say that the subclass extends the superclass. An inheritance relationship means that the subclass inherits the members of the superclass. When we say "members of a class" we mean the instance variables and methods. 

* Instance variables are not overridden because they don't need to be. They don't define any special behavior, so a subclass can give and inherited instance variable any value it chooses. 

# An inheritance example:

``` java
public class Doctor {
    boolean worksAtHospital;

    void treatPatient() {
        // perform a checkup
    }
}

public class FamilyDoctor extends Doctor {

    boolean makeHouseCalls;
    void giveAdvice() {
        // give homespun advice
    }
}

public class Surgeon extends Doctor {
    void treatPatient() {
        // perform surgery
    }

    void makeIncision() {
        // make incision
    }
}
```

* If class B extends class A, class B IS-A class A. This is true anywhere in the inheritance tree. If class C extends class B, class C passes the IS-A test for both B and A.

# Using IS-A and HAS-A

- Remember that when one class inherits from another, we say that the subclass extends the superclass. When you want to know if one thing should extend another, apply the IS-A test. Triangle IS-A Shape. Cat IS-A Feline. Surgeon IS-A Doctor.

- To know if you've designed your types correctly, ask "Does it make sense to say type X IS-A type Y?" If it doesn't, you know there's something wrong with the design, so if we apply the IS-A test, Tub IS-A Bathroom is false.

- What if we reverse it to Bathroom extends Tub? That still doesn't work, Bathroom IS-A Tub doesn't work. Tub and Bathroom are related, but not through inheritance. Tub and Bathroom are joined by HAS-A relationship. Does it make sense to say "Bathroom HAS-A Tub"? If yes, then it means that Bathroom has a Tub instance variable. In other words, Bathroom has a reference to a Tub, but Bathroom does not extend Tub. 

# How do you know if you've got your inheritance right?

- There's obviously more to it than what we've covered so far, but we'll look at a lot more OO issues 

* Keep in mind that the inheritance IS-A relationship works in only one direction!

- Triangle IS-A Shape makes sense, so you can have Triangle extends Shape. But the reverse -- Shape IS-A Triangle -- does not make sense, so Shape should not extend Triangle. Remember that the IS-A relationship implies that if X IS-A Y, then X can do anything a Y can do.

# When designing with inheritance, are you USING or ABUSING?

- Although some of the reasons behind these rules won't be revealed until later, for now, simply knowing a few rules will help you build a better inheritance desing. 

* DO use inheritance when one class is a more specific type of a superclass. 
* DO consider inheritance when you have behavior that should be shared among multiple classes of the same general type. 
* DO NOT use inheritance just so that you can reuse code from another class, if the relationship between the superclass and subclass violate either of the above two rules.
* DO NOT use inheritance if the subclass and superclass do not pass the IS-A test. Always ask yourself if the subclass IS-A more specific type of the superclass.

# So what does all this inheritance really buy you? 

- You get a lot of OO mileag by designing with inheritance. You can get rid of duplicate code by abstracting out the behavior common to a group of classes, and sticking that code in a superclass. That way, when you need to modify it, you have only one place to update, and the change is magically reflected in all the classes that inherit that behavior. 
- Just deliver the newly-changed superclass, and all classes that extend it will automatically use the new version.

1) You avoid duplicate code.
    - Put common code in one place, and let the subclasses inherit that code from a superclass. When you want to change that behavior, you have to modify it in only one place and everybody else will see that change. 

2) You define a common protocol for a group of classes. 

# Inheritance lets you guarantee that all classes grouped under a certain supertype have all the methods that the supertype has.

* In other words, you define a common protocol for a set of classes related through inheritance.

- When you define methods in a superclass, that can be inherited by subclasses, you're announcing a kind of protocol to other code that says, "All my subtypes can do these things, with these methods that look like this..." (establish a contract.)

# Keeping the contract: rules for overriding

- When you override a method from a superclass, you're agreeing to fulfill the contract. The contract that says, for example, "I take no arguments and I return a boolean." In other words, the arguments and return types of your overridig method must look to the outside world exactly like the overridden method in the superclass. - The methods are the contract

1) Arguments must be the same, and return types must be compatible.
- The contract of superclass defines how other code can use a method. Whatever the superclass takes as an argument, the subclass overriding the method must use that same argument. And whatever the superclass declares as a return typye, the overriding method must declare either the same type, or a subclass type. Remember, a subclass object is guaranteed to be able to do anything its superclass declares, so it's safe to return a subclass where the superclass is expected.

2) The method can't be less accessible. 
- Theat means the access level must be the same, or friendlier. That means you can't, for example, override a public method and make it private. 

# Overloading a method

- Method overloading is nothing more than having two methods with the same name but different argument lists. 
- Overloading lets you make multiple versions of a method, with different argument lists, for convenience to the callers. 
- Since an overloading method isn't trying to fulfill the contract defined by its superclass, overloaded methods have much more flexibility.

1) The return types can be different
 - You're free to change the return types in overloaded methods, as long as the argument lists are different

2) You can't change ONLY the return type. 
 - If only the return type is different, it's not a valid overload--the compiler will assume you're trying to override the method. And even that won't be legal unless the reeturn type is a subtype of the return type declared in the superclass. To overload a method, you MUST change the argument list, although you can change the return type to anything.

3) You can vary the access levels in any direction
 - You're free to overload a method with a method that's more restrictive. It doesn't matter, since the new method isn't obligated to fulfill the contract of the overloaded method.

* Legal examples of method overloading: 
``` java
public class Overloads {

    String uniqueID;

    public int addNums(int a, int b) {
        return a + b;
    }

    public double addNums(double a, double b) {
        return a + b;
    }

    public void setUniqueID(String theID) {
        // lots of validation code:
        uniqueID = theID;
    }

    public void setUniqueID(int ssNumber) {
        String numString = "" + ssNumber;
        setUniqueID(numString);
    }
}
```