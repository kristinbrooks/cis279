// CreditCardAccount.java
// Kristin Brooks
// 9/25/2026
// A class representing a credit card account

public class CreditCardAccount {

    // constant
    private static final double PENALTY_RATE = 0.05;

    // properties
    private int accountNumber;
    private double beginningBalance;
    private double endingBalance;
    private double creditLimit;
    private double interestRate;
    private Customer customer;

    // constructor
    public CreditCardAccount(int accountNumber, double beginningBalance, double endingBalance, double creditLimit,
                             double interestRate, int customerID, String lastName, String firstName, int creditScore) {
        this.accountNumber = accountNumber;
        this.beginningBalance = beginningBalance;
        this.endingBalance = endingBalance;
        this.creditLimit = creditLimit;
        this.interestRate = interestRate;
        this.customer = new Customer(customerID, lastName, firstName, creditScore);
    }

    // getters and setters
    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBeginningBalance() {
        return beginningBalance;
    }

    public void setBeginningBalance(double beginningBalance) {
        this.beginningBalance = beginningBalance;
    }

    public double getEndingBalance() {
        return endingBalance;
    }

    public void setEndingBalance(double endingBalance) {
        this.endingBalance = endingBalance;
    }

    public double getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(double creditLimit) {
        this.creditLimit = creditLimit;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public int getCustomerID() {
        return customer.getCustomerID();
    }

    public void setCustomerID(int customerID) {
        this.customer.setCustomerID(customerID);
    }

    public String getCustomerLastName() {
        return customer.getLastName();
    }

    public void setCustomerLastName(String lastName) {
        this.customer.setLastName(lastName);
    }

    public String getCustomerFirstName() {
        return customer.getFirstName();
    }

    public void setCustomerFirstName(String firstName) {
        this.customer.setFirstName(firstName);
    }

    public int getCustomerCreditScore() {
        return customer.getCreditScore();
    }

    public void setCustomerCreditScore(int creditScore) {
        this.customer.setCreditScore(creditScore);
    }

    // methods
    public double calculateAverageBalance() {
        return (this.beginningBalance + this.endingBalance) / 2;
    } // end of method calculateAverageBalance

    public String determineAccountStatus() {
        if ( this.endingBalance <= this.creditLimit ) {
            return "OK";
        } else {
            return "OVER";
        }
    } // end of method determineAccountStatus

    public double calculatePenalty() {
        if ( determineAccountStatus().equals("OK") ) {
            return 0.00;
        } else {
            return this.endingBalance * PENALTY_RATE;
        }
    } // end of method calculatePenalty

    public static void displayHeader() {
        System.out.printf("%-12s %-12s %-15s %-15s %-10s %-15s %-15s %-12s %-12s %-15s %-12s%n",
                "Acct Num", "Cust ID", "Last Name", "First Name", "Score",
                "Credit Limit", "End Balance", "Status", "Penalty", "Avg Balance", "Rate");
    } // end of method displayHeader

    public void displayAccount() {
        System.out.printf("%-12d %-12d %-15s %-15s %-10d %-15.2f %-15.2f %-12s %-12.2f %-15.2f %-12s%n",
                this.accountNumber, getCustomerID(), getCustomerLastName(), getCustomerFirstName(),
                getCustomerCreditScore(), this.creditLimit, this.endingBalance, determineAccountStatus(),
                calculatePenalty(), calculateAverageBalance(), Math.round(this.interestRate * 100) + "%");
    } // end of method displayAccount

    @Override
    public String toString() {
        return "CreditCardAccount{" +
                "accountNumber=" + accountNumber +
                ", beginningBalance=" + beginningBalance +
                ", endingBalance=" + endingBalance +
                ", creditLimit=" + creditLimit +
                ", interestRate=" + interestRate +
                ", customer=" + customer +
                '}';
    } // end of method toString
} // end of class CreditCardAccount



