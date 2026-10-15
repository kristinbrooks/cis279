/*
*	Program		: StockItemManager
*	
*	Purpose		: To demonstrate witing, reading and modifying data in a Java RandomAccessFile.
*
*	Developer	: F DAngelo
*/

import java.io.RandomAccessFile; 

import java.util.ArrayList ;

import java.io.IOException;

import java.io.EOFException;


public class StockItemManager 
{
	public static void main(String[] args)
	{
		final String STOCK_ITEM_FILE = "C:\\data\\StockFile.dat";

		final byte ACTIVE_RECORD_STATUS  = 1 ;
		
		final byte DELETED_RECORD_STATUS = 0 ;
		
		RandomAccessFile stockFile = null ;
		
		ArrayList <StockItem> stockList = new ArrayList <StockItem>() ;
		
		try
		{
			stockFile = new RandomAccessFile(STOCK_ITEM_FILE, "rw");
		}
		
		catch (IOException e)
		{
			System.out.println("n IOException occurred while attempting to allocate the StockFile.") ;
		}
		
		StockItem item = new StockItem(ACTIVE_RECORD_STATUS, 
										1, 
										"budget widget", 
										10.00, 
										50) ;
		stockList.add(item);

		
		item = new StockItem(ACTIVE_RECORD_STATUS, 
										2, 
										"economy widget", 
										15.00, 
										100) ;
		stockList.add(item);

		
		item = new StockItem(ACTIVE_RECORD_STATUS, 
										3, 
										"basic widget", 
										20.00, 
										100) ;
		stockList.add(item);

		
		item = new StockItem(ACTIVE_RECORD_STATUS, 
										4, 
										"widget", 
										25.00, 
										100) ;
		stockList.add(item);

		
		item = new StockItem(ACTIVE_RECORD_STATUS, 
										5, 
										"commercial widget", 
										35.00, 
										80) ;
		stockList.add(item);

		
		item = new StockItem(ACTIVE_RECORD_STATUS, 
										6, 
										"industrial widget", 
										50.00, 
										60) ;
		stockList.add(item);
		
		System.out.println("\nWrite the StockItem objects from the vector to the file.\n");

		try
		{
			stockFile.seek(0); // Be sure that the file pointer points to the first byte in the file.

			for (StockItem itemObj : stockList) // for each StockItem object in our ArrayList of StockItem objects
			{
				writeData( stockFile, itemObj);
			}
		}
		
		catch (IOException e)
		{
			System.out.println("An IOException occurred while attempting to write data to " + STOCK_ITEM_FILE + ".") ;
		}
		
		catch (Exception e)
		{
			System.out.println("A generic Exception occurred while attempting to write data to " + STOCK_ITEM_FILE + ".") ;
		}
		

		// Use the first version of readData to read each object from the file.

		System.out.println("\nIterate through file and display values for each item:\n");

		try
		{
			StockItem inputItem = new StockItem() ; // Just to have a generic StockItem object into which we read data.

			stockFile.seek(0); // Be sure that the file pointer points to the first byte in the file.

			while ( true ) // Yes, this looks like an violation of normal iteration control, but Java gives us no choice.
			{
				readData( stockFile, inputItem );

				System.out.println(inputItem.toString());
			}
		}

		catch ( EOFException e)
		{
			System.out.println("Reached EOF on " + STOCK_ITEM_FILE + " : " + e.toString() + ".") ;
		}

		catch ( IOException e)
		{
			System.out.println("Probably reached EOF on " + STOCK_ITEM_FILE + " : " + e.getMessage() + ".") ;
		}

		catch ( Exception e)
		{
			System.out.println("An exception occurred reading " + STOCK_ITEM_FILE + " : " + e.getMessage() + ".") ;
		}

		// Read one specific item from the file using its itemNumber as a key value to locate it.
		// Then update its cost, write it back to the file and re-read it to prove its cost was changed.

		long itemNumberToRetrieve = 3 ; // Hardcoding for convenience.

		StockItem testItem = new StockItem() ; // Just to have a StockItem object into which we read data and use for updating.

		try
		{
			readData( stockFile, testItem, itemNumberToRetrieve ); // Read data from the file for itemNumber 3.

			System.out.println("\nShould show original cost:\n" + testItem.toString()); // Display original data.
		
			testItem.setCost(22.00) ; // Modify its cost; it was previously 20.00.

			writeData( stockFile, testItem, itemNumberToRetrieve ); // Re-write this item over its original position with its new price.

			readData( stockFile, testItem, itemNumberToRetrieve );  // Re-read this item to prove that its price was successfully modified.

			System.out.println("\nShould show new cost:\n" + testItem.toString());

		}

		catch ( EOFException e)
		{
			System.out.println("Reached EOF on " + STOCK_ITEM_FILE + " : " + e.toString() + ".") ;
		}

		catch ( IOException e)
		{
			System.out.println("Probably reached EOF on " + STOCK_ITEM_FILE + " : " + e.getMessage() + ".") ;
		}

		catch ( Exception e)
		{
			System.out.println("An exception occurred reading " + STOCK_ITEM_FILE + " : " + e.getMessage() + ".") ;
		}

		// Update a specific item from the file using its itemNumber as a key value to locate it.


		try
		{
			stockFile.close() ;
		}
		
		catch (IOException e)
		{
			System.out.println("An IOException occurred while attempting to close " + STOCK_ITEM_FILE + " : " + e.getMessage() + ".") ;
		}
		
		catch (Exception e)
		{
			System.out.println("A generic Exception occurred while attempting to close " + STOCK_ITEM_FILE + " : " + e.getMessage() + ".") ;
		}
		
	}

	// This version of readData reads the next record in a file. 
	public static void readData( RandomAccessFile stockFile, StockItem item) throws IOException, EOFException, Exception
	{ 
		// You must read in the order you wrote it.

		item.setRecordStatus( stockFile.readInt() );
		
		item.setItemNumber(stockFile.readLong()) ;

		StringBuffer sb = new StringBuffer(); // If you re-use this StringBuffer for other String fields, be sure to set its length to 0.
		
		// Access the characters for the description.
		for (int i = 0 ; i < item.getDescriptionLength(); i++)
		{
			sb.append(stockFile.readChar());
		}
		
		item.setDescription(sb.toString()) ;
		
		item.setCost( stockFile.readDouble() ) ;
		
		item.setQuantityOnHand( stockFile.readInt() ) ;
	}

	// This version of readData reads a specific record in a file as identified in this case by its itemNumber. 
	public static void readData( RandomAccessFile stockFile, StockItem item, long keyValue) throws IOException, EOFException, Exception
	{ 
		// You must read in the order you wrote it.

		long byteToBeginReading = item.getRecordLength() * (keyValue - 1); // Calculate the byte at which to begin reading. Why - 1?

		stockFile.seek(byteToBeginReading); // Set the file pointer to this byte.

		item.setRecordStatus( stockFile.readInt() );
		
		item.setItemNumber(stockFile.readLong()) ;
		
		StringBuffer sb = new StringBuffer(); // If you re-use this StringBuffer for other String fields, be sure to set its length to 0.
		
		// Access the characters for the description.
		for (int i = 0 ; i < item.getDescriptionLength(); i++)
		{
			sb.append(stockFile.readChar());
		}
		
		item.setDescription(sb.toString()) ;
		
		item.setCost( stockFile.readDouble() ) ;
		
		item.setQuantityOnHand( stockFile.readInt() ) ;
	}

	// This version of writeData does not write to a specific location. Use it when overwriting an entire file.
	public static void writeData( RandomAccessFile stockFile, StockItem anItem) throws IOException, EOFException, Exception
	{ 
		stockFile.writeInt(anItem.getRecordStatus());
		stockFile.writeLong(anItem.getItemNumber());
		stockFile.writeChars(anItem.getDescription());
		stockFile.writeDouble(anItem.getCost());
		stockFile.writeInt(anItem.getQuantityOnHand());
	}

	// This version of writeData overwrites a specific record whose keyValue is used to calculate the record's location.
	public static void writeData( RandomAccessFile stockFile, StockItem anItem, long keyValue) throws IOException, EOFException, Exception
	{ 
		long byteToBeginWriting = anItem.getRecordLength() * (keyValue - 1); // Calculate the byte at which to begin reading. Why - 1?

		stockFile.seek(byteToBeginWriting); // Set the file pointer to this byte.

		stockFile.writeInt(anItem.getRecordStatus());
		stockFile.writeLong(anItem.getItemNumber());
		stockFile.writeChars(anItem.getDescription());
		stockFile.writeDouble(anItem.getCost());
		stockFile.writeInt(anItem.getQuantityOnHand());
	}
}
