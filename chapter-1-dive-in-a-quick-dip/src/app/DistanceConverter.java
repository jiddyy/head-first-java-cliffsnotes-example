package app;

import java.util.Scanner;

public class DistanceConverter {
    public static void main(String[] args) throws Exception {
        // Gets user input for distance conversion
        Scanner choice = new Scanner(System.in);
        System.out.println("What would you like to convert? (Mi -> Km | Cm -> In | Ft -> Yd | Quit)");

        String userChoice = choice.nextLine();

        while (true) {
            if (userChoice.equals("Mi -> Km")) {
                // Converts Miles to Kilometers
                Scanner miles = new Scanner(System.in);
                Float kilometers;
                System.out.println("Miles -> Kilometers: ");

                Float milesInput = miles.nextFloat();
                kilometers = milesInput * 1.609344f;
                // Prints out the solution with KM's to two decimal places
                System.out.printf(milesInput + " miles is " + "%.2f kilometers.", kilometers);
                miles.close();
                break;
            } else if (userChoice.equals("Cm -> In")) {
                // Converts Centimeters to Inches
                Scanner centimeters = new Scanner(System.in);
                Float inches;
                System.out.println("Centimeters -> Inches: ");

                Float cmInput = centimeters.nextFloat();
                inches = cmInput / 2.54f;
                // Prints out the solution with IN's to two decimal places
                System.out.printf(cmInput + " centimeters is " + "%.2f inches.", inches);
                centimeters.close();
                break;
            } else if (userChoice.equals("Ft -> Yd")) {
                // Converts Feet to Yards
                Scanner feet = new Scanner(System.in);
                Float yards;
                System.out.println("Feet -> Yards: ");

                Float ftInput = feet.nextFloat();
                yards = ftInput / 3f;
                // Prints out the solution with YD's to two decimal places
                System.out.printf(ftInput + " feet is " + "%.2f yards.", yards);
                feet.close();
                break;
            } else if (userChoice.equals("Quit")) {
                break;
            }
            choice.close();
        }
    }
}