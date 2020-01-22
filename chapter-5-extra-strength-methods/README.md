# Developing a Class

1) Figure out what the class is supposed to do.
2) List the instance variables and methods.
3) Write prepcode for the methods.
4) Write test code for the methods.
5) Implement the class.
6) Test the methods.
7) Debug and reimplement as needed.
8) Express gratitude that we don't have to test our so-called learning experience app on actual live users.

* The three things we'll write for each class:

1) prep code - A form of pseudocode, to help you focus on the logic without stressing about syntax.

2) test code - A class or methods that will test the real code and validate that it's doing the right thing.

3) real code - The actual implementation of the class. This is real Java code.

# Writing the method implementations

* Battleship-style game:

- It's you against the computer, but unlike the real Battleship game, in this one you don't place any ships of your own. Instead, your job is to sink the computer's ships in the fewest number of guesses.

Oh, and we aren't sinking ships. We're killing Dot Coms.

Goal: Sink all of the computer's Dot Coms in the fewest number of guesses. You're given a rating or level, based on how well you perform.

Setup: When the game program is launched, the computer places three Dot Coms on a virtual 7 x 7 grid. When that's complete, the game asks for your first guess.

How to play: We haven't learned to build a GUI yet, so this version works at the command-line. The computer will prompt you to enter a guess (a cell), that you'll type at the command-line as "A3", "C5", etc. In response to your guess, you'll see a result at the command-line, either "Hit", "Miss", or "Kill". When you've sent all three Dot Coms to that big 404 in the sky, the game ends by printing out your rating.

- The concept of writing the test code first is one of the practices of Extreme Programming (XP), and it can make it easier (and faster) for you to write your code. 

* Writing test code for SimpleDotCom class

We need to write test code that can make a SimpleDotCom object and run its methods. For theSimpleDotCom class, we really care about only the checkYourself() method, although we will have to implement the setLocationCells()method in order to get the checkYourself() method to run correctly.

Prepcode:

Method String check Yourself(String userGuess)
    Get the user guess as a String parameter
    Convert the user guess to an int
    Repeat with each of the location cells in the int array
        // Compare the user guess to the location cell
        If the user guess matches
            Increment the number of hits
            // Find Out if it was the last location cell:
            If number of hits is 3, Return "Kill" as the result
            Else it was not a kill, so Return "Hit"
            End IF
        Else the user guess did not match, so Return "Miss"
        End IF
    End Repeat
End Method

# The new stuff

- The things we haven't seen before are on this page. Stop worrying! The rest of the details are at the end of the chapter. This is just enough to let you keep going.

1) Converting a String to an int

* Integer.parseInt("3") <- Takes a String 
   ^A class      ^
that ships    Can "parse" a 
with Java    String into the
            int it represents.

2) The for loop

* for (int cell : locationCells) { }

Read this for loop declaration as "repeat for each element in the 'locationCells' array: take the next element in the array and assign it to the int variable 'cell'."

The colon means "in", so the whole thing means "for each int value IN locationCells..."

Declare a variable that will hold one element from the array Each time through the loop, this variable (in this case an int variable named"cell"), will hold a different element from the array, until there are no more elements (or the code does a "break"...).

The array to iterate over in the loop. Each time through the loop, the next element in the array will be assigned to the variable "cell". 

3) The post-increment operator

* numOfHits++

The ++ means add 1 to whatever's there.

numOfHits++ is the same as saying numOfHits = numOfHits +, except slightly more efficient.

4) break statement

* break;

Gets you out of a loop. Immediately. No iteration, no boolean test.

# random() and getUserInput()

1) Make a random number

``` java

int randomNum = (int) (Math.random() * 5)

```

"int randomNum" - We declare an int variable to hold the random number we get back.

"(int)" - This is a 'cast', and it forces the thing immediately after it to become the type of the cast. Math.random returns a double, so we have to cast it to be an int. In this case, the cast lops off the fractional part of the double.

"(Math.random() * 5)" - The Math.random method returns a number from zero to just less that one. So this formula returns a number from 0 to 4.

2) Getting user input using the GameHelper class

``` java

String guess = helper.getUserInput("Enter a number");

```

"String guess" - We declare a String variable to hold the user input String we get back.

"getUserInput" - A method of the GameHelper class that asks the user for command-line input, readds it in after the user hits RETURN, and gives back the result as a String.

"enter a number" - This method takes a String argument that it uses to prompt the user at the command-line. Whatever you pass in here gets displayed in the terminal just before the method starts looking for user input.

# Trips through a loop

``` java

for (int i = 0; i < 8; i++) {
    System.out.println("i");
}
System.out.println("done");

```

1) declare int i set i to 0
2) is i < 8? (boolean test) if true -> enter loop body -> print the value of i -> increment i (the iteration                                                                                                   expression)
                            if false -> print "done" (jump below the loop)

# Difference between for and while

A while loop has only the boolean test; it doesn't have a built-in initialization or iteration expression. A while loop is good when you don't know how many times to loop and just want to keep going while some condition is true. But if you know how many times to loop , a for loop is cleaner. Here's the loop above rewritten useing while:

``` java

int i = 0;
while (i < 8) {
    System.out.println(i);
    i++;
}
System.out.println("done");

```

# The enhanced for loop

``` java

for (String name : nameArray) { }

``` 

"String name" - Declare an iteration variable that will hold a single element in the array.

":" - The colon means 'IN'
 
"String" - The elements in the array MUST be compatible with the declared variable type.

"name" - With each iteration, a different element in the array will be assigned to the variable "name".

"nameArray" - The collection of elements that you want to iterate over. Imagine that somewhere earlier, the code said: 
String[] nameArray = {"Fred", "Mary", "Bob"};
With the first iteratioin, the name variable has the value of "Fred", and with the second iteration, a value of "Mary", etc.

* What it means in plain English: "For each element in nameArray, assign the element to the 'name' variable, and run the body of the loop."