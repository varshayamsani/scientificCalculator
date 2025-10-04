package org.example;

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
            System.out.println("1. Square Root (√x)");
            System.out.println("2. Factorial (!x)");
            System.out.println("3. Natural Logarithm (ln x)");
            System.out.println("4. Power (x^b)");
            System.out.println("5. Exit");
            System.out.print("Choose an operation: ");

            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter number: ");
                    double x1 = sc.nextDouble();
                    System.out.println("Result = " + squareRoot(x1));
                    break;
                case 2:
                    System.out.print("Enter number: ");
                    int n = sc.nextInt();
                    System.out.println("Result = " + factorial(n));
                    break;
                case 3:
                    System.out.print("Enter number: ");
                    double x2 = sc.nextDouble();
                    System.out.println("Result = " + naturalLog(x2));
                    break;
                case 4:
                    System.out.print("Enter base: ");
                    double base = sc.nextDouble();
                    System.out.print("Enter exponent: ");
                    double exp = sc.nextDouble();
                    System.out.println("Result = " + power(base, exp));
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
