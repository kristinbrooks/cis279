// Customer.java
// Kristin Brooks
// 9/25/2026
// A class representing a credit card customer

public class Customer {

    // properties
    private int customerID;
    private String lastName;
    private String firstName;
    private int creditScore;

    // constructor
    public Customer(int customerID, String lastName, String firstName, int creditScore) {
        validateCreditScore(creditScore);
        this.customerID = customerID;
        this.lastName = lastName;
        this.firstName = firstName;
        this.creditScore = creditScore;
    } // end of constructor

    // getters and setters
    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public int getCreditScore() {
        return creditScore;
    }

    public void setCreditScore(int creditScore) {
        validateCreditScore(creditScore);
        this.creditScore = creditScore;
    }

    private static void validateCreditScore(int creditScore) {
        if ( creditScore < 300 || creditScore > 850 ) {
            throw new IllegalArgumentException("Credit Score must be between 300 and 850.");
        }
    } // end of method validateCreditScore

    @Override
    public String toString() {
        return "Customer{" +
                "customerID=" + customerID +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", creditScore=" + creditScore +
                '}';
    } // end of method toString
}  // end of class Customer
