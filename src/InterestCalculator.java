// InterestCalculator.java
// Kristin Brooks
// calculates the ending balance of a series of equal monthly deposits plus interest

import java.util.Scanner;

public class InterestCalculator {

    public static void main(String[] args) {

        Scanner stdin = new Scanner( System.in);  // create the scanner

        // declare variables
        int months; // number of months over which deposits will be made
        double deposit; // amount of each monthly deposit
        double sumOfDeposits; // sum of all the deposits
        double annualInterestRate; // the annual interest rate as a decimal
        double monthlyInterestRate; // the monthly interest rate as a decimal
        double total; // total amount in the account at the end of the specified number of months

        // get inputs from the user
        System.out.print("Please enter the number of months over which deposits will be made: ");
        months = stdin.nextInt(); // get number of months from user
        while ( months <= 0 ) { // check if months is positive and reprompt until it is
            System.out.print("The number of months must be positive. Please re-enter the number of months: ");
            months = stdin.nextInt();
        }
        System.out.println();

        System.out.print("Please enter the amount of each monthly deposit: ");
        deposit = stdin.nextDouble(); // get the amount from the user
        while ( deposit <= 0.0 ) { // check if deposit amount is positive and reprompt until it is
            System.out.print("The deposit amount must be positive. Please re-enter the amount of each monthly deposit: ");
            deposit = stdin.nextDouble();
        }
        System.out.println();

        System.out.print("Please enter the annual interest rate as a decimal: ");
        annualInterestRate = stdin.nextDouble();
        while ( annualInterestRate <= 0.0 || annualInterestRate >= 1.0 ) { // check that interest rate is a positive decimal and re-prompt until it is
            System.out.print("The interest rate must be entered as a positive decimal. Please re-enter the annual interest rate: ");
            annualInterestRate = stdin.nextDouble();
        }
        System.out.println();

        // calculate monthly interest and total of all the deposits
        monthlyInterestRate = annualInterestRate / 12;
        sumOfDeposits = deposit * months;

        // Print out the table header
        System.out.printf("%-8s%-22s%-43s%-15s%n", "Month", "Months of Interest", "(1 + MonthlyInterestRate)^numberOfMonths", "Total Amount");
        // loop through the months and print the results in the table
        total = 0;
        for ( int i = 1, j = months; i <= months; i++, j--) {
            double growthFactor = Math.pow(1 + monthlyInterestRate, j);
            double currentTotal = deposit * growthFactor;
            total += currentTotal;
            System.out.printf("%-8d%-22d%-43.6f%-15.4f%n",i, j, growthFactor, currentTotal);
        }
        System.out.println();
        // print out the totals
        System.out.printf("The total of the deposits is $%.2f ($%.2f per month for %d months).%n", sumOfDeposits, deposit, months);
        System.out.printf("The end-of-year total is $%.2f, the sum of the accrued-interest totals.%n", total);

        System.out.println();
        System.out.println("krbrooks@mail.pima.edu");
    } // end of main

} //end of class InterestCalculator
