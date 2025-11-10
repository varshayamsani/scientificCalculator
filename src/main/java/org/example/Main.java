package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static double squareRoot(double x) {
        if (x < 0) throw new IllegalArgumentException("Negative input for square root");
        return Math.sqrt(x);
    }

    public static long factorial(int n) {
        if (n < 0) throw new IllegalArgumentException("Negative input for factorial");
        long fact = 1;
        for (int i = 1; i <= n; i++) fact *= i;
        return fact;
    }

    public static double naturalLog(double x) {
        if (x <= 0) throw new IllegalArgumentException("Input must be > 0 for ln");
        return Math.log(x);
    }

    public static double power(double base, double exp) {
        return Math.pow(base, exp);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n=== Scientific Calculator ===");
            System.out.println("1. Square Root");
            System.out.println("2. Factorial");
            System.out.println("3. Natural Logarithm");
            System.out.println("4. Power");
            System.out.println("5. Exit");
            System.out.print("Choose an operation: ");

            int choice;
            try {
                choice = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid choice! Please enter a number between 1 and 5.");
                sc.nextLine();
                continue;
            }

            switch (choice) {
                case 1:
                    System.out.print("Enter number: ");
                    try {
                        double x1 = sc.nextDouble();
                        System.out.println("Result = " + squareRoot(x1));
                    } catch (InputMismatchException e) {
                        System.out.println("Error: please enter a valid number.");
                        sc.nextLine();
                    } catch (IllegalArgumentException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 2:
                    System.out.print("Enter number: ");
                    try {
                        int n = sc.nextInt();
                        System.out.println("Result = " + factorial(n));
                    } catch (InputMismatchException e) {
                        System.out.println("Error: please enter a whole number (integer).");
                        sc.nextLine();
                    } catch (IllegalArgumentException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 3:
                    System.out.print("Enter number: ");
                    try {
                        double x2 = sc.nextDouble();
                        System.out.println("Result = " + naturalLog(x2));
                    } catch (InputMismatchException e) {
                        System.out.println("Error: please enter a valid number.");
                        sc.nextLine();
                    } catch (IllegalArgumentException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 4:
                    try {
                        System.out.print("Enter base: ");
                        double base = sc.nextDouble();
                        System.out.print("Enter exponent: ");
                        double exp = sc.nextDouble();
                        System.out.println("Result = " + power(base, exp));
                    } catch (InputMismatchException e) {
                        System.out.println("Error: please enter valid numbers for base and exponent.");
                        sc.nextLine();
                    } catch (IllegalArgumentException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 5:
                    System.out.println("Exiting...");
                    sc.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
//comment
