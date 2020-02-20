package dundee.ducklake;

public class Book {

	int ID;
	int score;
	
	public Book(int ID, int score)
	{
		this.ID = ID;
		this.score = score;
	}
	
	public int getID()
	{
		return ID;
	}
	public int getScore()
	{
		return score;
	}
	public void changeIDandScore(int newID, int newScore)
	{
		ID=newID;
		score=newScore;
	}
}
