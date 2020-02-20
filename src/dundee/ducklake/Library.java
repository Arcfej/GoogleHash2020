package dundee.ducklake;

public class Library {

    public int numBooks;

    public int[] books;

    public int signupDays;

    public int booksPerDay;

    public Library(int numBooks, int signupDays, int booksPerDay) {
        this.numBooks = numBooks;
        this.signupDays = signupDays;
        this.booksPerDay = booksPerDay;
    }
}
