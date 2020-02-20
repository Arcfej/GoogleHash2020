package dundee.ducklake;

import java.util.List;

public class Scan {

    public int libraryID;
    public List<Book> books;

    public Scan(int libraryID, List<Book> books) {
        this.libraryID = libraryID;
        this.books = books;
    }
}
