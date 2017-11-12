package Model;

public class PuzzleContent 
{
	String puzzleDesc;

	Puzzle puzzle0;
	Puzzle puzzle1;
	Puzzle puzzle2;
	Puzzle puzzle3;
	Puzzle puzzle4;
	Puzzle puzzle5;
	Puzzle puzzle6;
	Puzzle puzzle7;
	Puzzle puzzle8;

	public String puzzleDesc0 = "Puzzle: Example puzzle  ";
	public String puzzleAnswer0 = "puzzle";
	
	public String puzzleDesc1 = "Puzzle: Example puzzle  ";
	public String puzzleAnswer1 = "puzzle";
	
	public String puzzleDesc2 = "Puzzle: Example puzzle  ";
	public String puzzleAnswer2 = "puzzle";
	
	public String puzzleDesc3 = "Puzzle: Example puzzle  ";
	public String puzzleAnswer3 = "puzzle";
	
	public String puzzleDesc4 = "Puzzle: Example puzzle  ";
	public String puzzleAnswer4 = "puzzle";
	
	public String puzzleDesc5 = "Puzzle: Example puzzle  ";
	public String puzzleAnswer5 = "puzzle";
	
	public String puzzleDesc6 = "Puzzle: Example puzzle  ";
	public String puzzleAnswer6 = "puzzle";
	
	public String puzzleDesc7 = "Puzzle: Example puzzle  ";
	public String puzzleAnswer7 = "puzzle";
	
	public String puzzleDesc8 = "Puzzle: Example puzzle  ";
	public String puzzleAnswer8 = "puzzle";


	public String getPuzzleDesc() 
	{
		return puzzleDesc;
	}

	public void setPuzzleDesc(int puzzle) 
	{
		switch (puzzle) 
		{
		case 0: puzzleDesc = puzzleDesc0; 
		break;
		case 1: puzzleDesc = puzzleDesc1; 
		break;
		case 2: puzzleDesc = puzzleDesc2;
		break;
		case 3: puzzleDesc = puzzleDesc3; 
		break;
		case 4: puzzleDesc = puzzleDesc4; 
		break;
		case 5: puzzleDesc = puzzleDesc5; 
		break;
		case 6: puzzleDesc = puzzleDesc6; 
		break;
		case 7: puzzleDesc = puzzleDesc7; 
		break;
		case 8: puzzleDesc = puzzleDesc8; 
		break;

		default: puzzleDesc = "No more puzzles."; 
		break;
		}
	}
}