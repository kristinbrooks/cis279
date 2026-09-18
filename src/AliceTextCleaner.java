// AliceTextCleaner.java
// Kristin Brooks
// removes extraneous blank lines from Alice in Wonderland and changes all instances of Alice to ALICE

import java.io.IOException;
import java.util.Scanner;
import java.io.FileReader;
import java.io.FileWriter;

public class AliceTextCleaner {
    // the filepath for Alice in Wonderland
    private static final String inputFile = "/Users/ktown/workspace/cis279/Alice_in_Wonderland_(padded).txt";

    public static void main(String[] args) throws IOException {
        // create the Scanner and FileReader
        Scanner scanner = new Scanner(new FileReader(inputFile));
        // create the FileWriter
        FileWriter writer = new FileWriter("Alice_in_Wonderland.txt");

        // loop through the file line by line and write the non-blank lines to the new file
        while (scanner.hasNextLine()) { // check if file has a next line
            String line = scanner.nextLine(); // read in the next line
            if ( !line.isBlank()) { // check if the line is blank
                line = line.replace("Alice", "ALICE"); // make all instances of Alice uppercase
                writer.write(line + "\n"); // write non-blank lines
            }
        }
        scanner.close();
        writer.close();

    System.out.println("krbrooks@mail.pima.edu");
    } //end of main

} // end of class AliceTextCleaner
