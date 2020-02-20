package dundee.ducklake;

import java.io.*;
import java.util.Scanner;

public class Main {

    public static final String fileName1 = "a_example.txt";
    public static final String fileName2 = "b_read_on.txt";
    public static final String fileName3 = "c_incunabula.txt";
    public static final String fileName4 = "d_tough_choices.txt";
    public static final String fileName5 = "e_so_many_books.txt";
    public static final String fileName6 = "f_libraries_of_the_world.txt";

    int numBook;

    int numLib;

    int days;

    int[] books;

    Library[] libraries;

    public static void main(String[] args) {
        Main main = new Main();
        main.loadTextFile(fileName1);

    }

    public void loadTextFile(String fileName) {
        String file = "";
        Scanner scanner = null;

        // Try to read every line of the file
        try {
            scanner = new Scanner(new FileReader(fileName));
            numBook = scanner.nextInt();
            numLib = scanner.nextInt();
            days = scanner.nextInt();
            books = new int[numBook];
//            scanner.nextLine();
            for (int i = 0; i < numBook; i++) {
                books[i] = scanner.nextInt();
            }
            libraries = new Library[numLib];
            for (int i = 0; i < numLib; i++) {
//                scanner.nextLine();
                libraries[i] = new Library(scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
                int[] books = new int[libraries[i].numBooks];
//                scanner.nextLine();
                for (int j = 0; j < libraries[i].numBooks; j++) {
                    books[j] = scanner.nextInt();
                }
                libraries[i].books = books;
            }
        }

        // Catch errors
        catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Close reader
        finally {
            if (scanner != null) {
                scanner.close();
            }
        }
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
