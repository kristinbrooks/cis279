// Book.java
// Kristin Brooks
// 10/13/26
// a class for creating a book object

public class Book {
    final int TITLE_LENGTH = 50;

    private long ISBN;
    private String title;
    private int yearPublished;
    private double price;

    static private int recordLength;

    // constructors
    public Book() {
        setISBN(0);
        setTitle("");
        setYearPublished(0);
        setPrice(0.0);
        setRecordLength();
    }

    public Book(long ISBN, String title, int yearPublished, double price) {
        setISBN(ISBN);
        setTitle(title);
        setYearPublished(yearPublished);
        setPrice(price);
        setRecordLength();
    }

    // getters and setters
    public int getTitleLength() {
        return TITLE_LENGTH;
    }

    public long getISBN() {
        return ISBN;
    }

    public void setISBN(long ISBN) {
        this.ISBN = ISBN;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        StringBuffer titleSB = new StringBuffer(title);
        if (titleSB.length() != TITLE_LENGTH) {
            titleSB = setCorrectLength(titleSB, TITLE_LENGTH);
        }
        this.title = titleSB.toString();
    }

    public int getYearPublished() {
        return yearPublished;
    }

    public void setYearPublished(int yearPublished) {
        this.yearPublished = yearPublished;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getRecordLength() {
        return recordLength;
    }

    public void setRecordLength() {
        recordLength = (Long.SIZE / 8) + (TITLE_LENGTH * 2) + (Integer.SIZE / 8) + (Double.SIZE / 8);
    }

    public StringBuffer setCorrectLength(StringBuffer sb, int correctLength) {
        if (sb.length() > correctLength) {
            sb.setLength(correctLength);
        }
        if (sb.length() < correctLength) {
            while (sb.length() < correctLength) {
                sb.append(' ');
            }
        }
        return sb;
    }

    @Override
    public String toString() {
        return  "ISBN          : " + ISBN + "\n" +
                "title         : " + title + "\n" +
                "Year Published: " + yearPublished + "\n" +
                "price         : " + String.format("%.2f", price) + "\n";
    }
}
