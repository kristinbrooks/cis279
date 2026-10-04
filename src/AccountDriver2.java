// AccountDriver2.java
// Kristin Brooks
// 10/3/26
// A driver class for the Account class and its derived Checking Account and Mortgage classes.

import java.util.LinkedList;

public class AccountDriver2 {

    public static void main(String[] args) {
        // Here we declare and instantiate an empty LinkedList of the base class.
        LinkedList<Account> accountList = new LinkedList<Account>();

        // Mortgage = new Mortgage( customerID, accountNumber, accountType, interestRate, balance, term);
        Mortgage mortgage1 = new Mortgage( 1000, 10000, 'M',0.06875, 95000, 15);
        Mortgage mortgage2 = new Mortgage(2000, 20000, 'M', 0.06875, 210000, 30);

        // Transaction(int transactionID, int transactionDate, double amount , char type)
        mortgage1.processTransaction( new Transaction(5001, 20150515, UtilityMethods.round(mortgage1.getPeriodicPayment(), 2), Account.PAYMENT));
        mortgage1.processTransaction( new Transaction(5002, 20150615, UtilityMethods.round(mortgage1.getPeriodicPayment(), 2), Account.PAYMENT));
        mortgage1.processTransaction( new Transaction(5003, 20150715, UtilityMethods.round(mortgage1.getPeriodicPayment(), 2), Account.PAYMENT));
        mortgage1.processTransaction( new Transaction(5004, 20150815, UtilityMethods.round(mortgage1.getPeriodicPayment(), 2), Account.PAYMENT));

        mortgage2.processTransaction( new Transaction(6001, 20260704, UtilityMethods.round(mortgage2.getPeriodicPayment(), 2), Account.PAYMENT ));
        mortgage2.processTransaction( new Transaction(6002, 20260804, UtilityMethods.round(mortgage2.getPeriodicPayment(), 2), Account.PAYMENT ));
        mortgage2.processTransaction( new Transaction(6003, 20260904, UtilityMethods.round(mortgage2.getPeriodicPayment(), 2), Account.PAYMENT ));
        mortgage2.processTransaction( new Transaction(6004, 20261004, UtilityMethods.round(mortgage2.getPeriodicPayment(), 2), Account.PAYMENT ));

        // add mortgages to the list of accounts
        accountList.addLast(mortgage1);
        accountList.addLast(mortgage2);

        // CheckingAccount = new CheckingAccount( customerID, accountNumber, accountType, balance)
        CheckingAccount checking1 = new CheckingAccount(3000, 30000, 'C', 5674.26);
        CheckingAccount checking2 = new CheckingAccount(4000, 40000, 'C', 8572.61);

        checking1.processTransaction( new Transaction(7001, 20260923, 123.45, Account.CHECK));
        checking1.processTransaction( new Transaction(7002, 20260926, 67.89, Account.CHECK));
        checking1.processTransaction( new Transaction(7003, 20261001, 1098.35, Account.DEPOSIT));
        checking1.processTransaction( new Transaction(7004, 20261004, 464.38, Account.CHECK));

        checking2.processTransaction( new Transaction(8001, 20260912, 237.53, Account.DEPOSIT));
        checking2.processTransaction( new Transaction(8002, 20260920, 973.12, Account.CHECK));
        checking2.processTransaction( new Transaction(8003, 20260929, 58.24, Account.CHECK));
        checking2.processTransaction( new Transaction(8004, 20261002, 164.79, Account.DEPOSIT));

        // add checking accounts to list of accounts
        accountList.addLast(checking1);
        accountList.addLast(checking2);

        // loop through the list of accounts printing out all the account and transaction data
        for ( Account accountObj : accountList )
        {
            System.out.println(accountObj.toString() + "\n") ;
            System.out.println(accountObj.listTransactions()) ;
            System.out.println("\nThe current account balance is " + UtilityMethods.round(accountObj.getBalance(), 2) + ".\n\n");
        }

        System.out.println();
        System.out.println("krbrooks@mail.pima.edu");
    } // end of main
} // end of class AccountDriver2
