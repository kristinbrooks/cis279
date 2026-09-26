// ClassComposition.java
// Kristin Brooks
// 9/25/2026
// A driver class for the CreditCardAccount and Customer classes that reads in account information from a file and then
// prints it all out in a table.

import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;

public class ClassComposition {

    // file path for the customer account information
    private static final String INPUT_FILE = "HW5_Accounts.txt";

    public static void main(String[] args) {

        // create the BufferedReader and FileReader
        try (BufferedReader reader = new BufferedReader(new FileReader(INPUT_FILE))) {
            // print the table header
            CreditCardAccount.displayHeader();

            String line; // the first line in each record

            // read in the account info
            while ((line = reader.readLine()) != null) {
                if (line.trim().isEmpty()) {
                    continue; // skip any blank lines between or after records
                }
                String[] accountInfo = new String[9];
                accountInfo[0] = line;
                for (int i = 1; i < 9; i++) {
                    accountInfo[i] = reader.readLine();
                }
                // check for null entries at end of file
                boolean incomplete = false;
                for (int i = 0; i < 9; i++) {
                    if (accountInfo[i] == null) {
                        incomplete = true;
                        break;
                    }
                }
                if (incomplete) {
                    System.out.println("Incomplete record at end of file.");
                    break;
                }

                try {
                    // parse the data
                    int accountNumber = Integer.parseInt(accountInfo[0].trim());
                    double beginningBalance = Double.parseDouble(accountInfo[1].trim());
                    double endingBalance = Double.parseDouble(accountInfo[2].trim());
                    double creditLimit = Double.parseDouble(accountInfo[3].trim());
                    double interestRate = Double.parseDouble(accountInfo[4].trim());
                    int customerID = Integer.parseInt(accountInfo[5].trim());
                    String lastName = accountInfo[6].trim();
                    String firstName = accountInfo[7].trim();
                    int creditScore = Integer.parseInt(accountInfo[8].trim());

                    // create a CreditCardAccount
                    CreditCardAccount account = new CreditCardAccount(accountNumber, beginningBalance, endingBalance,
                            creditLimit, interestRate, customerID, lastName, firstName, creditScore);

                    // print out the account info to the table
                    account.displayAccount();
                } catch (IllegalArgumentException e) {
                    System.out.println("Skipped record for account " + accountInfo[0].trim() + ": " + e.getMessage());
                }
            }

        } catch (IOException e) {
            System.out.println("An error occurred while reading the file: " + e.getMessage());
        }

        System.out.println();
        System.out.println("krbrooks@mail.pima.edu");
    } // end of method main
} // end of class ClassComposition
