package dundee.ducklake;

import java.io.*;
import java.util.*;

public class Main {

    public static final String fileName1 = "a_example.txt";
    public static final String fileName2 = "b_read_on.txt";
    public static final String fileName3 = "c_incunabula.txt";
    public static final String fileName4 = "d_tough_choices.txt";
    public static final String fileName5 = "e_so_many_books.txt";
    public static final String fileName6 = "f_libraries_of_the_world.txt";

    public static final String outputA = "a_output.txt";
    public static final String outputB = "b_output.txt";
    public static final String outputC = "c_output.txt";
    public static final String outputD = "d_output.txt";
    public static final String outputE = "e_output.txt";
    public static final String outputF = "f_output.txt";

    int numBook;

    int numLib;

    int maxDays;

    int[] scores;

    Library[] libraries;

    public static void main(String[] args) {
        Main main = new Main();
        main.loadTextFile(fileName1);
        for (Library library : main.libraries) {
            library.sortBooksByScore();
            library.calculateScore(main.maxDays);
        }
        main.sortLibraries();

        List<Scan> scans = main.calculateOutput();
        main.writeToFile(outputA, scans);

        main.loadTextFile(fileName2);
        for (Library library : main.libraries) {
            library.sortBooksByScore();
            library.calculateScore(main.maxDays);
        }
        main.sortLibraries();

        scans = main.calculateOutput();
        main.writeToFile(outputB, scans);

        main.loadTextFile(fileName3);
        for (Library library : main.libraries) {
            library.sortBooksByScore();
            library.calculateScore(main.maxDays);
        }
        main.sortLibraries();

        scans = main.calculateOutput();
        main.writeToFile(outputC, scans);

        main.loadTextFile(fileName4);
        for (Library library : main.libraries) {
            library.sortBooksByScore();
            library.calculateScore(main.maxDays);
        }
        main.sortLibraries();

        scans = main.calculateOutput();
        main.writeToFile(outputD, scans);

        main.loadTextFile(fileName5);
        for (Library library : main.libraries) {
            library.sortBooksByScore();
            library.calculateScore(main.maxDays);
        }
        main.sortLibraries();

        scans = main.calculateOutput();
        main.writeToFile(outputE, scans);

        main.loadTextFile(fileName6);
        for (Library library : main.libraries) {
            library.sortBooksByScore();
            library.calculateScore(main.maxDays);
        }
        main.sortLibraries();

        scans = main.calculateOutput();
        main.writeToFile(outputF, scans);
    }

    public void loadTextFile(String fileName) {
        String file = "";
        Scanner scanner = null;

        // Try to read every line of the file
        try {
            scanner = new Scanner(new FileReader(fileName));
            numBook = scanner.nextInt();
            numLib = scanner.nextInt();
            maxDays = scanner.nextInt();
            scores = new int[numBook];
            for (int i = 0; i < numBook; i++) {
                scores[i] = scanner.nextInt();
            }
            libraries = new Library[numLib];
            for (int i = 0; i < numLib; i++) {
                libraries[i] = new Library(i, scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
                Book[] books = new Book[libraries[i].numBooks];
                for (int j = 0; j < libraries[i].numBooks; j++) {
                    int id = scanner.nextInt();
                    books[j] = new Book(id, scores[id]);
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

    private void sortLibraries() {
        Arrays.sort(libraries, Collections.reverseOrder(Comparator.comparingDouble(library -> library.score)));
    }

    private List<Scan> calculateOutput() {
        int average = 0;
        for (int score : scores) {
            average += score;
        }
        average /= scores.length;

        Set<Book> submitted = new HashSet<>(numBook);

        List<Scan> scans = new ArrayList<>();

        int remain = maxDays;
        int libIndex = 0;
        int bookIndex = 0;
        Library library = libraries[libIndex];
        remain -= library.signupDays;

        List<Book> books = new ArrayList<>();
        while (remain > 0) {
            Book book = library.books[0];
            for (int i = 0; i < library.booksPerDay; i++) {
                try {
                    boolean scanned = true;
                    while (scanned) {
                        book = library.books[bookIndex++];
                        scanned = submitted.contains(book);
                    }
                    books.add(book);
                    submitted.add(book);
                } catch (IndexOutOfBoundsException e) {
                    break;
                }
            }
            remain--;
            if (bookIndex >= library.numBooks) {
                scans.add(new Scan(library.id, books));
                books = new ArrayList<>();
                libIndex++;
                if (libIndex == libraries.length) {
                    break;
                }
                library = libraries[libIndex];
                remain -= library.signupDays;
                bookIndex = 0;
            }
        }
        if (books.size() != 0) {
            scans.add(new Scan(library.id, books));
        }
        return scans;
    }

    private void writeToFile(String fileName, List<Scan> scans) {

        // Try open or create a new file for writing
        try (PrintWriter writer = new PrintWriter(new FileOutputStream(fileName))) {
            writer.println(scans.size());
            for (Scan scan : scans) {
                writer.println(scan.libraryID + " " + scan.books.size());
                for (Book book : scan.books) {
                    writer.print(book.ID + " ");
                }
                writer.println();
            }
        } catch (FileNotFoundException | SecurityException e) {
            System.out.println("Access denied: " + e.getMessage());
        }
    }

}
