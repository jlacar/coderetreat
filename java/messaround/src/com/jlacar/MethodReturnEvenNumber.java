package com.jlacar;

import java.util.Scanner;

public class MethodReturnEvenNumber {
 
    static int userNumber;
    static Scanner sc = new Scanner(System.in);
 
    public static void main(String[] args) {
         
        userInput();
        System.out.println(userNumber);
    }
 
    static void userInput () {
        boolean hasInt = false;
 
        do {System.out.println("Enter a number and I will tell you if its odd or even.");
 
            if (sc.hasNextInt()) {
                userNumber = sc.nextInt();
                hasInt = true;
            }
 
            else {
                System.out.println("Invalid input, enter a number.");
                hasInt = false;
                sc.next();
            }
 
        } while (!hasInt);
    }
 
    static int isEven (int userNumber) {
        return 0;
    }
}