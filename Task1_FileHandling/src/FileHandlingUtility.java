/*
 * CodTech Internship - Task 1
 * File Handling Utility
 * This program demonstrates:
 * 1. Writing to a file
 * 2. Reading from a file
 * 3. Modifying (appending) file content
 */

import java.io.*;

public class FileHandlingUtility {

    // Method to write data to a file
    public static void writeFile(String filename) {
        try {
            FileWriter writer = new FileWriter(filename);
            writer.write("Hello, this is CodTech Internship Task 1.\n");
            writer.write("This program demonstrates file handling in Java.\n");
            writer.close();
            System.out.println("Data written successfully.\n");
        } catch (IOException e) {
            System.out.println("Error writing file: " + e.getMessage());
        }
    }

    // Method to read data from a file
    public static void readFile(String filename) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            String line;

            System.out.println("Reading file content:");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            reader.close();
            System.out.println();
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    // Method to modify file (append mode)
    public static void modifyFile(String filename) {
        try {
            FileWriter writer = new FileWriter(filename, true); // true = append mode
            writer.write("This line was added later as modification.\n");
            writer.close();
            System.out.println("File modified successfully.\n");
        } catch (IOException e) {
            System.out.println("Error modifying file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {

        String filename = "sample.txt";

        // Step 1: Write to file
        writeFile(filename);

        // Step 2: Read file
        readFile(filename);

        // Step 3: Modify file
        modifyFile(filename);

        // Step 4: Read again to show changes
        readFile(filename);
    }
}
