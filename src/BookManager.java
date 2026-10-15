// BookManager.java
// Kristin Brooks
// 10/14/26
// Demonstrates writing, reading, and modifying data in a Java RandomAccessFile.

import java.io.EOFException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;

public class BookManager {
    public static void main(String[] args) {
        final String BOOK_FILE = "BookFile.dat";

        RandomAccessFile bookFile = null;

        ArrayList<Book> bookList = new ArrayList<Book>();

        // create the bookFile
        try {
            bookFile = new RandomAccessFile(BOOK_FILE, "rw");
        } catch (IOException e) {
            System.out.println("An IOException occurred while attempting to allocate the BookFile.");
        }

        // add Books to the ArrayList
        Book book = new Book(9780593819463L,
                             "The Irresistible Urge to Fall For Your Enemy",
                             2025,
                             20.00);
        bookList.add(book);

        book = new Book(9780425276235L,
                        "The Peripheral",
                        2014,
                        17.00);
        bookList.add(book);

        book = new Book(9780759557918L,
                        "Far From the Light of Heaven",
                        2021,
                        17.99);
        bookList.add(book);

        book = new Book(9781785657078L,
                        "The Book of Hidden Things",
                        2018,
                        15.95);
        bookList.add(book);

        book = new Book(9780593436721L,
                        "Vampires of El Norte",
                        2023,
                        28.00);
        bookList.add(book);

        // write the Book objects to the file
        try {
            assert bookFile != null;
            bookFile.seek(0);
            for (Book bookObj : bookList) {
                writeBook(bookFile, bookObj);
            }
        } catch (IOException e){
            System.out.println("An IOException occurred while attempting to write to " + BOOK_FILE + ".");
        } catch (Exception e) {
            System.out.println("A generic Exception occurred while attempting to write to " + BOOK_FILE + ".");
        }

        // display the booklist
        System.out.println("The original Book List:");
        System.out.println();
        try {
            Book inputBook = new Book();
            bookFile.seek(0);
            while (true) {
                readBook(bookFile, inputBook);
                System.out.println(inputBook.toString());
            }
        } catch (EOFException e) {
            System.out.println("Reached EOF on " + BOOK_FILE + " : " + e.toString() + ".") ;
        } catch (IOException e) {
            System.out.println("Probably reached EOF on " + BOOK_FILE + " : " + e.getMessage() + ".") ;
        } catch (Exception e) {
            System.out.println("An exception occurred reading " + BOOK_FILE + " : " + e.getMessage() + ".") ;
        }

        // update the title of one book, write it to the file, then read it from the file and display the updated entry
        long bookNumberToRetrieve1 = 5;
        Book testBook1 = new Book();

        try {
            readBook(bookFile, testBook1, bookNumberToRetrieve1);
            testBook1.setTitle("Vampires of the North");
            writeBook(bookFile, testBook1, bookNumberToRetrieve1);
            readBook(bookFile, testBook1, bookNumberToRetrieve1);
            System.out.println("\nUpdated title:\n" + testBook1.toString());
        } catch (EOFException e) {
            System.out.println("Reached EOF on " + BOOK_FILE + " : " + e.toString() + ".") ;
        } catch (IOException e) {
            System.out.println("Probably reached EOF on " + BOOK_FILE + ": " + e.getMessage() + ".") ;
        }  catch (Exception e) {
            System.out.println("An exception occurred reading " + BOOK_FILE + ": " + e.getMessage() + ".") ;
        }

        // update the price of one book, write it to the file, then read it from the file and display the updated entry
        long bookNumberToRetrieve2 = 3;
        Book testBook2 = new Book();

        try {
            readBook(bookFile, testBook2, bookNumberToRetrieve2);
            testBook2.setPrice(18.95);
            writeBook(bookFile, testBook2, bookNumberToRetrieve2);
            readBook(bookFile, testBook2, bookNumberToRetrieve2);
            System.out.println("\nUpdated price:\n" + testBook2.toString());
        } catch (EOFException e) {
            System.out.println("Reached EOF on " + BOOK_FILE + " : " + e.toString() + ".") ;
        } catch (IOException e) {
            System.out.println("Probably reached EOF on " + BOOK_FILE + ": " + e.getMessage() + ".") ;
        }  catch (Exception e) {
            System.out.println("An exception occurred reading " + BOOK_FILE + ": " + e.getMessage() + ".") ;
        }

        // display the updated list
        System.out.println("The updated Book List:");
        System.out.println();
        try {
            Book inputBook = new Book();
            bookFile.seek(0);
            while (true) {
                readBook(bookFile, inputBook);
                System.out.println(inputBook.toString());
            }
        } catch (EOFException e) {
            System.out.println("Reached EOF on " + BOOK_FILE + " : " + e.toString() + ".") ;
        } catch (IOException e) {
            System.out.println("Probably reached EOF on " + BOOK_FILE + " : " + e.getMessage() + ".") ;
        } catch (Exception e) {
            System.out.println("An exception occurred reading " + BOOK_FILE + " : " + e.getMessage() + ".") ;
        }


        try {
            bookFile.close();
        } catch (IOException e) {
            System.out.println("An IOException occurred while attempting to close " + BOOK_FILE + ": " + e.getMessage() + ".");
        } catch (Exception e) {
            System.out.println("A generic exception occurred while attempting to close " + BOOK_FILE + ": " + e.getMessage() + ".");
        }


        System.out.println();
        System.out.println("krbrooks@mail.pima.edu");
    }

    // for overwriting a whole file
    public static void writeBook(RandomAccessFile bookFile, Book aBook) throws IOException, EOFException, Exception {
        bookFile.writeLong(aBook.getISBN());
        bookFile.writeChars(aBook.getTitle());
        bookFile.writeInt(aBook.getYearPublished());
        bookFile.writeDouble(aBook.getPrice());
    }

    // for overwriting a book at a specific location
    public static void writeBook(RandomAccessFile bookFile, Book aBook, long keyValue) throws IOException, EOFException, Exception {
        long byteToBeginWriting = aBook.getRecordLength() * (keyValue - 1);
        bookFile.seek(byteToBeginWriting);
        writeBook(bookFile, aBook);
    }

    // reads the next book in the file
    public static void readBook(RandomAccessFile bookFile, Book aBook) throws IOException, EOFException, Exception {
        aBook.setISBN(bookFile.readLong());
        StringBuffer sb = new StringBuffer();
        for (int i =0; i < aBook.getTitleLength(); i++) {
            sb.append(bookFile.readChar());
        }
        aBook.setTitle(sb.toString());
        aBook.setYearPublished(bookFile.readInt());
        aBook.setPrice(bookFile.readDouble());
    }

    // reads a book in a specific location
    public static void readBook(RandomAccessFile bookFile, Book aBook, long keyValue) throws IOException, EOFException, Exception {
        long byteToBeginReading = aBook.getRecordLength() * (keyValue - 1);
        bookFile.seek(byteToBeginReading);
        readBook(bookFile, aBook);
    }

}
