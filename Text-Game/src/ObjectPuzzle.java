
public class ObjectPuzzle extends Puzzle{
	int itemId;
	
	public ObjectPuzzle(String loadedString) {
		//loaded from file
		//int puzzleId String name, int itemId, String puzzleDesc, String hint
		try 
		{
			String[] splitString = loadedString.split("-_");
			puzzleId = Integer.parseInt(splitString[0]);
			puzzleName = splitString[1];
			itemId = Integer.parseInt(splitString[2]);
			puzzleDesc = splitString[3];
			hint = splitString[4];

		}catch(Exception E)
		{
			System.out.println("Text Spencer Williams to fix this. I might have messed up a TextFile."
					+ "I can fix it in like 30 minutes. Include DoorPuzzle in the text message");
		}
	}

	@Override
	public void initialize() {}

	@Override
	public void attemptSolve(String answer) 
	{
		//no effect
	}

	@Override
	public void attemptSolve(int itemId) 
	{
		if(this.itemId==itemId) 
		{
			solved=true;
		}
	}

}
