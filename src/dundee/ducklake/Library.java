package dundee.ducklake;

public class Library {

    public int numBooks;

    public Book[] books;

    public int signupDays;

    public int booksPerDay;

    public Library(Book[] books, int numBooks, int signupDays, int booksPerDay) {
        this.books = books;
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
    
    public void arrangeBooksByScore()
    {
    	for(int i=0; i<numberOfBooks-1; i++)
    	{
    		int maxScore = books[i].getScore();
    		int index=i;
    		for(int j=i; j<numberOfBooks; j++)
    		{
    			if(books[j].getScore()>books[i].getScore())
    			{
    				maxScore=books[j].getScore();
    				index=j;
    			}
    		}
    		Book temp = books[i];
    		books[i].changeIDandScore(books[index].getID(), books[index].getScore());
    		books[index].changeIDandScore(temp.getID(), temp.getScore());
    	}
    }
}
