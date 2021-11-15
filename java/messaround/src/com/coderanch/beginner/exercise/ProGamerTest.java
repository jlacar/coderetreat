package com.coderanch.beginner.exercise;

import java.util.*; // Importing Java Utility

public class ProGamerTest {
    public static void main(String[] args) {
        // Initializing user input
        Scanner keyboard = new Scanner(System.in);

        // Initializing variables
        double sum = 0;
        double average = 0;
        String awnser = "";
        String continuation = "";
        String name = "";
        String name2 = "";
        String changename = "";
        double changekd = 0;

        // For Gamers
        String[] gamers = new String[4];    //Declaration of gamers array
        gamers[0] = "Ninja";
        gamers[1] = "TimTheTatMan";
        gamers[2] = "Shroud";
        gamers[3] = "Dr. Disrespect";

        // For KD
        double[] kd = new double[4];    //Declaration of KD array
        kd[0] = 8.75;
        kd[1] = 6.99;
        kd[2] = 10.15;
        kd[3] = 9.75;

        do {
            System.out.println("What would you like to do with the ProGamer Team.");
            System.out.println();
            System.out.println("Type 'View' to view the current roster.");
            System.out.println("Type 'Search' to see an indiviual's KD Ratio.");
            System.out.println("Type 'Average' to see the teams average KD.");
            System.out.println("Type 'Change' to replace a member with a new one.");
            System.out.println();
            awnser = keyboard.nextLine();
            switch (awnser) {
                case ("View"):
                    System.out.println();
                    for (int x = 0; x < gamers.length; ++x) //for loop to allow user input into array.
                    {
                        System.out.println("Gamer " + (x + 1) + " is " + gamers[x]); //Printing Rosters Names
                    }
                    System.out.println();
                    break;
                case ("Search"):
                    System.out.println();
                    System.out.println("Enter the name of the Team Member whose KD you want to see. "); //Prompt for gamer name
                    System.out.println();
                    name = keyboard.nextLine(); //Reading input for keyboard and storing is as a name
                    System.out.println();
                    for (int x = 0; x < gamers.length; ++x) {
                        if (name.equals(gamers[x])) // Checks if the name equals any of the 4
                        {
                            System.out.println("The gamer you entered is " + gamers[x] + " and has a KD of " + kd[x]); // Prints out the gamer's info again
                        }
                    }
                    System.out.println();
                    break;
                case ("Average"):
                    for (int x = 0; x < kd.length; ++x) //Runs 4 times
                    {
                        sum = sum + kd[x]; //Adds all kd's together
                    }
                    average = sum / 4; //Gets average from sum

                    System.out.println();
                    System.out.println("As a team the average KD would be " + average); //Prints out the sum and average of the kd's from the gamers
                    System.out.println();
                    break;
                case ("Change"):
                    System.out.println();
                    System.out.println("Enter the name of the Team Member whose KD you want to see. "); //Prompt for gamer name
                    System.out.println();
                    name2 = keyboard.nextLine(); //Reading input for keyboard and storing is as a name
                    System.out.println();
                    for (int x = 0; x < gamers.length; ++x) {
                        if (name2.equals(gamers[x])) // Checks if the name equals any of the 4
                        {
                            System.out.println("The gamer you entered is " + gamers[x] + " and has a KD of " + kd[x]); // Prints out the gamer's info again
                            System.out.println();
                            System.out.println("The new gamers name is ");
                            changename = keyboard.nextLine();
                            gamers[x] = changename;
                            System.out.println("and their kd is ");
                            changekd = keyboard.nextDouble();
                            kd[x] = changekd;
                            keyboard.nextLine();
                        }
                    }
                    break;
                default:
                    System.out.println("That is not a feature.");
            }
            System.out.println("Are you finished, Y or N");
            continuation = keyboard.nextLine();
            System.out.println();

        } while (continuation.equals("N") || continuation.equals("n"));
    }
}