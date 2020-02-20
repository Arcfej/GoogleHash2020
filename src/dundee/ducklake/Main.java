package dundee.ducklake;

import java.io.*;
import java.util.Scanner;

public class Main {

    int numBook;

    int numLib;

    int days;

    int[] books;



    public static void main(String[] args) {
        System.out.println("Hello DuckLake!");
    }

    private String loadTextFile(String fileName) {
        String file = "";
        BufferedReader bufferedReader = null;

        // Try to read every line of the file
        try {
            bufferedReader = new BufferedReader(new FileReader(fileName));
            while (bufferedReader.ready()) {
                file = file.concat(bufferedReader.readLine()).concat("\n");
            }
        }

        // Catch errors
        catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error during reading the file: " + e.getMessage());
            file = null;
        }

        // Close reader
        finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    System.out.println("Error closing file: " + e.getMessage());
                }
            }
        }

        return file;
    }

    /**
     * Ask for lines from the user and save them in a txt file.
     *
     * @param in the input stream through the user type in their texts.
     */
    private void writeToFile(Scanner in) {
        final String USER_INPUT_FILE_PATH = "input.txt";

        // Try open or create a new file for writing
        try (PrintWriter writer = new PrintWriter(new FileOutputStream(USER_INPUT_FILE_PATH))) {
            // Prompt the user to write line by line until they enter an empty line
            System.out.println("Please input the lines of the file. In case of an empty line the file will be saved.");
            while (true) {
                String line = in.nextLine();
                if (line.isEmpty()) break;
                writer.println(line);
            }
        } catch (FileNotFoundException | SecurityException e) {
            System.out.println("Access denied: " + e.getMessage());
        }
    }

}
