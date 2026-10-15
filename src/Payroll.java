// Payroll.java
// Kristin Brooks
// 10/12/26
// Reads in employee payroll data from a text file, processes it, and outputs it in a table.


import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Payroll {

    // constants
    private static final String INPUT_FILE = "payroll.dat";
    private static final double REGULAR_HOURS = 40;
    private static final double OVERTIME_MULTIPLIER = 1.5;

    private static class PayInfo {
        // a helper class to allow us to return both regular pay and overtime from a single method

        // properties
        private final double regularPay;
        private final double overtimePay;

        // constructor
        public PayInfo(double regularPay, double overtimePay) {
            this.regularPay = regularPay;
            this.overtimePay = overtimePay;
        } // end of constructor

        // getters
        public double getRegularPay() {
            return regularPay;
        }

        public double getOvertimePay() {
            return overtimePay;
        }

        public double getTotalPay() {
            return regularPay + overtimePay;
        }
    } // end of class PayInfo

    private static PayInfo calculatePay(double hoursWorked, double hourlyRate) {
        double regularPay;
        double overtimePay;
        double overtimeHours;
        double overtimeRate;
        if (hoursWorked <= REGULAR_HOURS) {
            regularPay = hourlyRate * hoursWorked;
            overtimePay = 0.00;
        } else {
            regularPay = REGULAR_HOURS * hourlyRate;
            overtimeHours = hoursWorked - REGULAR_HOURS;
            overtimeRate = hourlyRate * OVERTIME_MULTIPLIER;
            overtimePay = overtimeHours * overtimeRate;
        }
        return new PayInfo(regularPay, overtimePay);
    } // end of method calculatePay

    private static void displayHeader() {
        System.out.println("                                     Hours    Rate   Regular  Overtime Total");
        System.out.println("Emp ID     Last Name    First Name  Worked   Hourly     Pay      Pay     Pay");
    } // end of method displayHeader

    private static void displayTableEntry(int empID, String lastName, String firstName, double hoursWorked, double hourlyRate, PayInfo payInfo) {
        System.out.printf("%-8d %10s, %12s %8.2f %8.2f %8.2f %8.2f %8.2f%n", empID, lastName, firstName,
                hoursWorked, hourlyRate, payInfo.getRegularPay(), payInfo.getOvertimePay(), payInfo.getTotalPay());
    } // end of method displayTableEntry

    public static void main(String[] args) {
        Scanner input = null;
        try {
            // create the scanner and File
            input = new Scanner(new File(INPUT_FILE));
            // display header
            displayHeader();
            // read in the data
            while (input.hasNext()) {
                int empID = input.nextInt();
                String lastName = input.next();
                String firstName = input.next();
                double hoursWorked = input.nextDouble();
                double hourlyRate = input.nextDouble();
                PayInfo payInfo = calculatePay(hoursWorked, hourlyRate);
                displayTableEntry(empID, lastName, firstName, hoursWorked, hourlyRate, payInfo);
            }
            input.close();
        } catch (FileNotFoundException e) {
            System.out.println("File " + INPUT_FILE + " not found");
            System.exit(-1);
        } catch (InputMismatchException e) {
            System.out.println("Error: expected a number in the payroll file. Check hours, rate, and ID values");
            input.close();
            System.exit(-1);
        }

        System.out.println();
        System.out.println("krbrooks@mail.pima.edu");
    } // end of method main
} // end of class Payroll
