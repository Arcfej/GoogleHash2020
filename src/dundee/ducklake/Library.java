package dundee.ducklake;

public class Library {

	public int id;

    public int numBooks;

    public Book[] books;

    public int signupDays;

    public int booksPerDay;

    public double score;

    public Library(int id, int numBooks, int signupDays, int booksPerDay) {
		this.id = id;
        this.numBooks = numBooks;
        this.signupDays = signupDays;
        this.booksPerDay = booksPerDay;
    }

    public void removeBookFromList(int bookID)
    {
    	for(int i=0; i<numBooks; i++)
    	{
    		if(books[i].getID() == bookID)
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
    
    public void sortBooksByScore()
    {
    	for(int i=0; i < numBooks-1; i++)
    	{
    		int maxScore = books[i].getScore();
    		int index = i;
    		for(int j=i+1; j<numBooks; j++)
    		{
    			if(maxScore < books[j].getScore())
    			{
    				maxScore  = books[j].getScore();
    				index=j;
    			}
    		}
    		Book temp = books[i];
    		books[i].changeIDandScore(books[index].getID(), books[index].getScore());
    		books[index].changeIDandScore(temp.getID(), temp.getScore());
    	}
    }

    public void calculateScore(int allDays) {
    	double average = 0;
		for (Book book : books) {
			average += book.score;
		}
		average /= books.length;

		int remainingDays = allDays - signupDays;
		if (remainingDays > 0) {
			score = remainingDays * average;
		} else {
			score = remainingDays;
		}
	}
}
