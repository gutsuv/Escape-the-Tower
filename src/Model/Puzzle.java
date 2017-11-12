package Model;

import View.Console;

public class Puzzle
{
	private Console view;

	private int puzzleId;
	private String puzzleDesc;
	private String answer;
	private boolean solved;
	
	public Puzzle(int puzzleId, String puzzleDesc, boolean solved, String answer)
	{
		this.puzzleId = puzzleId;
		this.puzzleDesc = puzzleDesc;
		this.solved = solved;
		this.answer = answer;
	}

	public int getPuzzleID() 
	{
		return puzzleId;
	}

	public String getPuzzleDescription() 
	{
		return puzzleDesc;
	}

	public boolean solved() 
	{
		return solved;
	}
	
	public void setSolved(boolean solved) 
	{
		this.solved = solved;
	}

	public void solve(String answer)
	{
		if (answer.equalsIgnoreCase(answer))
		{
			view.println("Correct");
		}
		else 
		{
			view.println("Incorrect");
		}
	}

	public void exitPuzzle() 
	{
		view.println("Puzzle exited.");
	}

	@Override
	public String toString()
	{
		return "Puzzle [puzzleId=" + puzzleId + ", puzzleDesc=" + puzzleDesc + ", answer=" + answer + ", solved="
				+ solved + ", view=" + view + "]";
	}
}