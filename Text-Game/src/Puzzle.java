
public abstract class Puzzle implements Cloneable
{
	protected int puzzleId;
	protected String puzzleName;
	protected String puzzleDesc;
	protected String hint;
	protected View view;
	protected boolean solved=false;
	
	public int getPuzzleID() 
	{
		return puzzleId;
	}

	public String getHint() 
	{
		return hint;
	}
	
	public void printHint()
	{
		view.line(125);
		view.printString(hint,125);
	}
	
	public String getPuzzleDescription() 
	{
		return puzzleDesc;
	}
	
	public void printPuzzleDescription()
	{
		view.printString(puzzleDesc,125);
	}
	
	public void setView(View view)
	{
		this.view = view;
	}
	
	public boolean isSolved() 
	{
		return solved;
	}
	
	public void Solve(boolean solved) 
	{
		solved=true;
	}
	
	public String getName()
	{
		return puzzleName;
	}
	
	public abstract void initialize(); 
	public abstract void attemptSolve(String answer);
	public abstract void attemptSolve(int itemId);
	public abstract void display();
	//I'm aware of redundancy but I did it this way for a reason
	@Override
	public String toString()
	{
		return puzzleName + ", " + puzzleDesc;
	}
	@Override
	protected Object clone() throws CloneNotSupportedException {
        return super.clone();}
}