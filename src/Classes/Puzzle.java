package Classes;

public class Puzzle
{
	private int puzzleId;
	private String puzzleDescription;
	private boolean solved;
	private String solution;
	
	public Puzzle(){
		puzzleId = 0;
		puzzleDescription = "";
		solved = false;
		solution = "";
	}
	
	public Puzzle(int puzzleId, String puzzleDescription, boolean solved, String solution) 
	{
		this.puzzleId = puzzleId;
		this.puzzleDescription = puzzleDescription;
		this.solved = solved;
		this.solution = solution;
	}

	public int getPuzzleId()
	{
		return puzzleId;
	}

	public void setPuzzleId(int puzzleId)
	{
		this.puzzleId = puzzleId;
	}

	public String getPuzzleDescription()
	{
		return puzzleDescription;
	}

	public void setPuzzleDescription(String puzzleDescription)
	{
		this.puzzleDescription = puzzleDescription;
	}

	public boolean isSolved()
	{
		return solved;
	}

	public void setSolved(boolean solved)
	{
		this.solved = solved;
	}

	public String getSolution()
	{
		return solution;
	}

	public void setSolution(String solution)
	{
		this.solution = solution;
	}

	public void solve(String answer) 
	{
		if (answer.equalsIgnoreCase(solution))
		{
			//view.println("Correct");
		}
		else 
		{
			//view.println("Incorrect");
		}
	}
	
	public void getHint() 
	{
		//view.println("");
	}

	public void exitPuzzle() 
	{
		//view.println("");
	}

	@Override
	public String toString() 
	{
		return "Puzzle ID: " + puzzleId + "; Puzzle Description: " + puzzleDescription + "; solved:" + solved;
	}	
}