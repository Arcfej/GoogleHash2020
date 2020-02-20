package dundee.ducklake;

public class Scan {

    public int libraryID;
    public Book[] books;

    public Scan(int libraryID, Book[] books) {
        this.libraryID = libraryID;
        this.books = books;
    }
}
