/*
** Program	: Transaction.java
**
** Purpose	: To declare the properties and define the methods of the Transaction class which can represent 
**		  financial entities like loan payment, checks and deposits.
**
** F. D'Angelo
**/


public class Transaction
{
	private int transactionID ;

	private int transactionDate ;

	private double amount ;

	private char type ;

	public Transaction()
    	{
			setTransactionID( 0 );
			setTransactionDate( 0 );
        	setTransactionAmount(0.0);
       		setTransactionType(' ');
    	}

	public Transaction(int transactionID, int transactionDate, double amount , char type)
    	{
			setTransactionID( transactionID );
			setTransactionDate( transactionDate );
        	setTransactionAmount(amount);
       		setTransactionType( type );
    	}

	public void setTransactionID( int transactionID ) { this.transactionID = transactionID ; }

	public int getTransactionID()
	{
    		return transactionID ;
	}

	public void setTransactionDate( int transactionDate )
	{
    		this.transactionDate = transactionDate ;
	}

	public int getTransactionDate()
	{
    		return transactionDate ;
	}

	public void setTransactionAmount( double amount)
	{
    		this.amount = amount ;
	}

	public double getTransactionAmount()
	{
    		return amount ;
	}

	public void setTransactionType(char type)
	{
    		this.type = type ;
	}

	public char getTransactionType()
	{
    		return type ;
	}

	public String  toString()
	{
		StringBuffer strBuf = new StringBuffer();

		strBuf.append("\nTransaction ID     : " );
		strBuf.append(transactionID);
		strBuf.append("\nTransaction Date   : ");
		strBuf.append(transactionDate);
		strBuf.append("\nTransaction amount : ");
		strBuf.append(amount);
		strBuf.append("\nTransaction type   : ");
		strBuf.append(type);
		strBuf.append( "\n") ;
 
		return strBuf.toString() ;
	}
}


