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

    public void removeBookFromList(int bookID)
    {
    	for(int i=0; i<numBooks; i++)
    	{
    		if(books[i]==bookID)
    		{
    			for(int j=i; j<numBooks-1; j++)
    			{
    				books[j]=books[j+1];
    			}
    			numBooks--;
    		}
    	}
    }

    public void dayPassed()
    {
    	signupDays--;
    }
}
