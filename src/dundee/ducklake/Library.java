package dundee.ducklake;

public class Library {

    public int[] books;
    
    public int numberOfBooks;
    
    public int signupDays;

    public int booksPerDay;

    public Library(int[] books, int numberOfBooks, int signupDays, int booksPerDay) {
        this.books = books;
        this.numberOfBooks=numberOfBooks;
        this.signupDays = signupDays;
        this.booksPerDay = booksPerDay;
    }
    
    public void removeBookFromList(int bookID)
    {
    	for(int i=0; i<numberOfBooks; i++)
    	{
    		if(books[i]==bookID)
    		{
    			for(int j=i; j<numberOfBooks-1; j++)
    			{
    				books[j]=books[j+1];
    			}
    			numberOfBooks--;
    		}
    	}
    }
    
    public void dayPassed()
    {
    	signupDays--;
    }
}
