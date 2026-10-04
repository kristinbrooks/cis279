// Mortgage.java
// Kristin Brooks
// 10/3/26
// A concrete class derived from Account.

public class Mortgage extends Account {
    // properties
    private double interestRate;
    private int term;
    private double monthlyInterestRate;
    private int termInMonths;
    private double periodicPayment;
    private double currentMonthInterest;
    private double balanceRepaid;

    // constructor
    public Mortgage(int customerID, int accountNumber, char accountType, double interestRate,
                    double balance, int term) {
        super(customerID, accountNumber, accountType, balance);
        this.interestRate = interestRate;
        this.term = term;
        this.monthlyInterestRate = interestRate / 12;
        this.termInMonths = term * 12;
        calcPeriodicPayment();
    }

    public double getInterestRate() {
        return interestRate;
    }

    public int getTerm() {
        return term;
    }

    public double getMonthlyInterestRate() {
        return monthlyInterestRate;
    }

    public int getTermInMonths() {
        return termInMonths;
    }

    public double getPeriodicPayment() {
        return periodicPayment;
    }

    public double getCurrentMonthInterest() {
        return currentMonthInterest;
    }

    public void setCurrentMonthInterest(double currentMonthInterest) {
        this.currentMonthInterest = currentMonthInterest;
    }

    public double getBalanceRepaid() {
        return balanceRepaid;
    }

    public void setBalanceRepaid(double balanceRepaid) {
        this.balanceRepaid = balanceRepaid;
    }

    @Override
    public void processTransaction( Transaction transactionObject) {
        transactionList.addLast( transactionObject); // Add a transaction to the list.
        // Calculate interest the amount repaid and change the account balance.

        if ( transactionObject.getTransactionType() == PAYMENT) {
            setCurrentMonthInterest( balance * monthlyInterestRate );
            setBalanceRepaid(periodicPayment - currentMonthInterest) ; setBalance( balance - balanceRepaid );
        }
        // To simplify this, we avoided dealing with an invalid transaction type.
    } //end of processTransaction

    public void calcPeriodicPayment () {
        double annuityFactor = (( 1 - ( 1 / Math.pow((1 + monthlyInterestRate ), termInMonths))) / monthlyInterestRate);
        periodicPayment = balance / annuityFactor;
    } // end of calcPeriodicPayment

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();

        output.append(super.toString());
        output.append("Interest rate   : " );
        output.append(UtilityMethods.round(getInterestRate() * 100, 3));
        output.append("%");
        output.append("\nTerm            : ");
        output.append(getTerm());
        output.append("\nPeriodic payment: ");
        output.append(UtilityMethods.round(getPeriodicPayment(), 2));
        output.append("\n");
        return output.toString();
    }
} // end of class Mortgage
