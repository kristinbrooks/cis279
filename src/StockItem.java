/*
StockItem.java

This class represents a stock item, for instance an item of merchandise sold by a store. It has data attributes such as sku (Stock Keeping Unit), description, cost and quantity on hand that relate to a item of merchandise.

F. D'Angelo

*/

public class StockItem 
{
	static final int ACTIVE_RECORD_STATUS  = 1 ;
	static final int DELETED_RECORD_STATUS = 0 ;
	
	final int DESCRIPTION_LENGTH = 15 ;
	final int SKU_LENGTH = 8 ;
	
	private int    recordStatus ;
	private long   itemNumber ;
	private String description ;
	private double cost ;
	private int    quantityOnHand ;
	
	static public int    recordLength = 0 ;
	
	public void setRecordLength()
	{
		// Integer, Long and Double sizes are in bits therefore we must divide by 8 to obtain bytes.
		// Java uses wide characters which contain two bytes therefore we must multiply
		// DESCRIPTION_LENGTH by 2.
		recordLength = (Integer.SIZE / 8 ) + (Long.SIZE / 8 )+ (DESCRIPTION_LENGTH * 2) + 
						(Double.SIZE / 8) + (Integer.SIZE / 8);
	}
	
	public int getRecordLength()
	{
		return recordLength ;
	}
	
	public StockItem ()
	{
		setRecordStatus(ACTIVE_RECORD_STATUS) ;
		
		setItemNumber( 0 ) ;
		
		setDescription( "" ) ;
		
		setCost( 0.0 ) ;
		
		setQuantityOnHand( 0 ) ;
		
		setRecordLength() ;
	}
	
	public StockItem (int recordStatus, long itemNumber, String description, double cost, int quantityOnHand)
	{
		setRecordStatus( recordStatus) ;
		
		setItemNumber( itemNumber ) ;
		
		setDescription( description ) ;
		
		setCost( cost ) ;
		
		setQuantityOnHand( quantityOnHand ) ;
		
		setRecordLength() ;
	}
	
	public StockItem (int recordStatus, long itemNumber, String description, double cost )
	{
		setRecordStatus( recordStatus) ;
		
		setItemNumber( itemNumber ) ;
		
		setDescription( description ) ;
		
		setCost( cost ) ;

		setRecordLength() ;
	}
	
	public void setRecordStatus (int recordStatus)
	{
		this.recordStatus = recordStatus ;
	}

	public int getRecordStatus ()
	{
		return this.recordStatus ;
	}
	
	public void setItemNumber (long itemNumber)
	{
		
		this.itemNumber = itemNumber ;
	}
	
	public long getItemNumber ()
	{
		return this.itemNumber ;
	}
	
	public void setDescription (String description)
	{
		StringBuffer descriptionSB = new StringBuffer( description ) ;
		
		if (descriptionSB.length() != DESCRIPTION_LENGTH) 
			descriptionSB = setCorrectLength( descriptionSB, DESCRIPTION_LENGTH) ;
		
		this.description = descriptionSB.toString() ;
	}
	
	public String getDescription ()
	{
		return this.description ;
	}
	
	public void setCost (double cost)
	{
		this.cost = cost ;
	}
	
	public double getCost ()
	{
		return this.cost ;
	}
	
	public void setQuantityOnHand (int quantityOnHand)
	{
		this.quantityOnHand = quantityOnHand ;
	}

	public int getQuantityOnHand ()
	{
		return this.quantityOnHand ;
	}
	
	public StringBuffer setCorrectLength( StringBuffer sb, int correctLength)
	{
		if (sb.length() > correctLength) sb.setLength(correctLength) ;
		
		if (sb.length() < correctLength) 
		{
			while (sb.length() < correctLength)
				sb.append(' ');						// right pad the length with spaces.
		}
		
		return sb ;
	}
	
	public int getDescriptionLength()
	{
		return DESCRIPTION_LENGTH ;
	}
	
	public int getSKULength()
	{
		return SKU_LENGTH ;
	}
	
	public String toString()
	{
		return "Record status   : " + Integer.toString(this.getRecordStatus())    + "\n" +
	               "Item number     : " + Long.toString(this.getItemNumber())         + "\n" +
		       "Description     : " + this.getDescription()                       + "\n" +
	               "Cost            : " + Double.toString(this.getCost() )            + "\n" +
		       "Quantity on-hand: " + Integer.toString(this.getQuantityOnHand() ) + "\n" ;
	}
	
}
