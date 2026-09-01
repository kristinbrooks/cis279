// ParkingCalculator.java
// Kristin Brooks
// lets the user enter the day and time range they were parked, and it computes and displays their charge

import java.util.Scanner;

public class ParkingCalculator {

    public static void main(String[] args) {

        Scanner stdin = new Scanner( System.in ); // create the scanner

        // declare variables
        String day;
        String arrivalTime; // time in military time
        String departureTime; // time in military time
        final double WEEKDAY_RATE = 1.25; // parking rate on weekdays
        final double WEEKEND_RATE = .50; // parking rate on weekends
        final double WEEKDAY_MAX_FEE = 20.00; // max fee for a weekday
        final double WEEKEND_MAX_FEE = 15.00; // max fee on the weekend

        System.out.print("Please enter the day of the week : ");
        day = stdin.next(); // get the day from the user

        System.out.print("Please enter the arrival time : ");
        arrivalTime = stdin.next(); // get arrival time from the user

        System.out.print("Please enter the departure time : ");
        departureTime = stdin.next(); // get the departure time from the user

        // validate and convert the arrival time
        int arrivalTimeInt = getValidTime(arrivalTime);
        if ( arrivalTimeInt == -1 ) {
            System.out.println("Error: invalid arrival time.");
            return;
        }

        // validate and convert the departure time
        int departureTimeInt = getValidTime(departureTime);
        if ( departureTimeInt == -1 ) {
            System.out.println("Error: invalid departure time.");
            return;
        }

        // check that arrival time is before or equal to departure time
        if ( arrivalTimeInt > departureTimeInt ) {
            System.out.println("Error: arrival time cannot be later than departure time.");
            return;
        }

        // calculate entry time as minutes
        int arrivalMinutes = militaryTimeToMinutes(arrivalTimeInt);
        // calculate departure time as minutes
        int departureMinutes = militaryTimeToMinutes(departureTimeInt);
        // calculate total length of time parked in minutes
        int totalMinutesParked = departureMinutes - arrivalMinutes;
        // calculate the number of 15 minute intervals that will be charged
        int intervals = totalMinutesParked / 15;
        if ( totalMinutesParked % 15 != 0 ) {
            intervals++;
        }

        double amountCharged; // the total fee paid by the user
        // determine if it is a weekend or a weekday and compute the fee accordingly
        if ( day.equalsIgnoreCase("sat") || day.equalsIgnoreCase("sun") ) {
            amountCharged = calculateParkingFee(intervals, WEEKEND_RATE, WEEKEND_MAX_FEE);
            displayOutput(day, totalMinutesParked, WEEKEND_RATE, amountCharged);
        } else if ( day.equalsIgnoreCase("mon") || day.equalsIgnoreCase("tue") ||
                day.equalsIgnoreCase("wed") || day.equalsIgnoreCase("thu") || day.equalsIgnoreCase("fri") ) {
            amountCharged = calculateParkingFee(intervals, WEEKDAY_RATE, WEEKDAY_MAX_FEE);
            displayOutput(day, totalMinutesParked, WEEKDAY_RATE, amountCharged);
        } else { // user entered an invalid day
            System.out.println("Error: invalid day of week.");
            return;
        }

        System.out.println();
        System.out.println("krbrooks@mail.pima.edu");
    } // end of main

    // check that the user entered an integer
    public static boolean isValidInteger(String s) {
        // check for empty string or negative sign with nothing following it so they don't fall through
        // the following loop and get treated as valid integers
        if ( s.equals("") || s.equals("-") ) {
            return false;
        }

        for ( int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if ( Character.isDigit(c) ) {
                // the character is good - nothing to do - loop continues
            } else if ( c == '-' && i == 0) {
                // this is also fine - negative integer is still an integer - loop continues
            } else {
                return false; // anything else is invalid
            }
        } // end of loop
        return true;
    } // end of method isValidInteger

    // check that the time entered is a valid time
    public static boolean isValidTime(int time) {
        int hours = time / 100;
        int minutes = time % 100;
        return (hours >=0 && hours <= 23) && (minutes >= 0 && minutes <= 59); // returns true only if hours and minutes in valid range
    } // end of method isValidTime

    // get valid integer time from the string time entered by the user or -1 if they entered something invalid
    public static int getValidTime(String s) {
        if ( !isValidInteger(s) ) {
            return -1; // if false return sentinel value
        }
        int time = Integer.parseInt(s); // convert the String to an int
        if ( !isValidTime(time) ) {
            return -1; // if false return sentinel value
        }
        return time;
    } // end of method getValidTime

    // convert military time to minutes
    public static int militaryTimeToMinutes(int time) {
        return (time / 100) * 60 + time %100;
    } //end of method militaryTimeToMinutes

    // calculate the parking fee
    public static double calculateParkingFee(int intervals, double rate, double maxFee) {
        double fee = intervals * rate;
        return Math.min(fee, maxFee);
    } //end of method calculateParkingFee

    // print output for user
    public static void displayOutput(String day, int minutes, double rate, double charged) {
        // format the day for printing
        String capitalizedDay = day.substring(0,1).toUpperCase() + day.substring(1).toLowerCase();
        System.out.println();
        System.out.printf("Day of week: %s%n", capitalizedDay);
        System.out.printf("Parking duration in minutes: %d; rate: $%.2f%n", minutes, rate);
        System.out.printf("Amount charged: $%.2f%n", charged);
    } //end of method displayOutput

} // end of class
