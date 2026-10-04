// Account.java
// Kristin Brooks
// 10/3/26
// An abstract base class, which declares all common attributes and defines all common methods for its derived classes.

import java.util.LinkedList;

public abstract class Account {
    // properties
    private int customerID;
    private int accountNumber;
    private char accountType;
    protected double balance;
    protected LinkedList<Transaction> transactionList = new LinkedList<Transaction>();
    public static final char PAYMENT = 'P';
    public static final char CHECK = 'C';
    public static final char DEPOSIT = 'D';

    // constructor
    public Account(int customerID, int accountNumber, char accountType, double balance) {
        this.customerID = customerID;
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.balance = balance;
    } // end of constructor

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public char getAccountType() {
        return accountType;
    }

    public void setAccountType(char accountType) {
        this.accountType = accountType;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public abstract void processTransaction(Transaction transaction);

    public String listTransactions() {
        StringBuilder str = new StringBuilder();
        for (Transaction transaction : transactionList) {
            str.append(transaction.toString());
        }
        return str.toString();
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();

        output.append("Account data:");
        output.append("\n");
        output.append("\nAccount number  : " );
        output.append(getAccountNumber());
        output.append("\nCustomer ID     : ");
        output.append(getCustomerID());
        output.append("\nAccount type    : ");
        output.append(getAccountType());
        output.append("\nBalance         : ");
        output.append(UtilityMethods.round(getBalance(), 2));
        output.append("\n");

        return output.toString() ;

    }
} // end of class Account
