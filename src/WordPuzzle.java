
public class WordPuzzle extends Puzzle
{
	String answer;
	Item item;
	public WordPuzzle(String loadedString, ReferenceIdentities library) 
	{
		//loaded from file
		//int puzzleId String name, int itemId, 
		//String answer, String puzzleDesc, String hint
		
		try 
		{
			String[] splitString = loadedString.split("-_");
			puzzleId = Integer.parseInt(splitString[0]);
			puzzleName = splitString[1];
			item = library.cloneItem(Integer.parseInt(splitString[2]));
			answer = splitString[3];
			puzzleDesc = splitString[4];
			hint = splitString[5];
		}
		catch(Exception E)
		{
			System.out.println("Text Spencer Williams to fix this. I might have messed up a TextFile."
					+ "I can fix it in like 30 minutes. Include WordPuzzle in the text message");
		}
	}
	public Item getItem() 
	{
		return item;
	}

	@Override
	public void initialize() {}

	@Override
	public void attemptSolve(String answer) 
	{
		if(this.answer.matches(answer)) 
		{
			solved = true;
			view.line(125);
			view.print("Puzzle solved");
			view.print("Item available");
		}
		else 
		{
			view.line(125);
			view.print("incorrect solution");
		}
	}

	@Override
	public void attemptSolve(int itemId) 
	{
		//no effect
	}
	
	@Override
	public void display() 
	{
		view.line(125);
		view.print(puzzleName);
		view.printString(puzzleDesc,125);
		view.printString("Input solution to puzzle or type 'exit' or type 'hint'",125);
	}
}
