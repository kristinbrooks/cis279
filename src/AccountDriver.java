/*
** Program	: MainDriver.java
**
** Purpose	: To declare and instantiate objects of various derived clases of a common base class. 
**
**			In this example, the derived classes -- CheckingAccount and Mortgagge -- inherit 
**			the attributes and methods of the abstract base Account class, 
**			then add their own specialized attributes and methods for handling situations specific
**			them. They also have their own overridden versions of the process Transaction and 
**			toString methods. 
**
**			Note that we've declared the base class, Account, as abstract because it makes no sense
**			to create an object of this class since it is too general or abstract when we actually
**			deal with more specific entities like checking accounts and mortgages.
**
**
**
** Developer	: F. D'Angelo
**/

import java.util.LinkedList;


public class AccountDriver
{
	public static void main(String[] args)
	{
		final char PAYMENT_TYPE = 'P' ;
		final char CHECK_TYPE   = 'C' ;
		final char DEPOSIT_TYPE = 'D' ;

		// Here we declare and instantiate an empty LinkedList of the base class.

		LinkedList<Account> accountList = new LinkedList<Account>();

		// Mortgage = new Mortgage( customerID, accountNumber, accountType, interestRate, balance, term);

		Mortgage mortgage = new Mortgage( 1000, 10000, 'M',0.06875, 95000, 15);

		// Transaction(int transactionID, int transactionDate, double amount , char type)

		mortgage.processTransaction( new Transaction(5001, 20150515, 847.26, 'P'));

		mortgage.processTransaction( new Transaction(5002, 20150615, 847.26, PAYMENT_TYPE));

		mortgage.processTransaction( new Transaction(5003, 20150715, 847.26, PAYMENT_TYPE));

		mortgage.processTransaction( new Transaction(5004, 20150815, 847.26, PAYMENT_TYPE));

		mortgage.processTransaction( new Transaction(5005, 20150915, 847.26, PAYMENT_TYPE));

		accountList.addLast( mortgage ) ;

		for ( Account accountObj : accountList )
		{
			System.out.println(accountObj.toString() + "\n") ;

			System.out.println(accountObj.listTransactions()) ;

			System.out.println("\nThe current account balance is " + accountObj.getBalance() + ".\n\n");
		}
	}
}
