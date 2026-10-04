// CheckingAccount.java
// Kristin Brooks
// 10/3/26
// A concrete class derived from Account.

public class CheckingAccount extends Account {
    // constructor
    public CheckingAccount(int customerID, int accountNumber, char accountType, double balance) {
        super(customerID, accountNumber, accountType, balance);
    } // end of constructor

    @Override
    public void processTransaction(Transaction transaction) {
        transactionList.addLast(transaction);
        char type = transaction.getTransactionType();
        double amount = transaction.getTransactionAmount();
        if ( type == CHECK ) {
            setBalance(balance - amount);
        } else if ( type == DEPOSIT ) {
            setBalance(balance + amount);
        }
    } // end of method processTransaction

    @Override
    public String toString() {
        return super.toString();
    } // end of toString
} // end of class CheckingAccount
