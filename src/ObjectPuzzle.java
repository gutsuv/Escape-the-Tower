import java.util.ArrayList;

public class ObjectPuzzle extends Puzzle
{
	int itemId;

	public ObjectPuzzle(String loadedString)
	{
		// loaded from file
		// int puzzleId String name, int itemId, String puzzleDesc, String hint
		try
		{
			String[] splitString = loadedString.split("-_");
			puzzleId = Integer.parseInt(splitString[0]);
			puzzleName = splitString[1];
			itemId = Integer.parseInt(splitString[2]);
			puzzleDesc = splitString[3];
			hint = splitString[4];

		}
		catch (Exception E)
		{
			System.out.println("Text Spencer Williams to fix this. I might have messed up a TextFile."
					+ "I can fix it in like 30 minutes. Include DoorPuzzle in the text message");
		}
	}

	@Override
	public void initialize()
	{
		
	}

	@Override
	public void attemptSolve(String answer)
	{
		// no effect
	}

	@Override
	public void attemptSolve(int itemId)
	{
		if (this.itemId == itemId)
		{
			view.line(125);
			view.print("Puzzle passed");
			solved = true;
			// the only puzzle of this type is fire
		}
		else
		{
			view.line(125);
			view.print("Item doesn't solve puzzle");
		}

	}

	@Override
	public void display()
	{
		view.line(125);
		view.print(puzzleName);
		view.printString(puzzleDesc);
	}

	public void display(ArrayList<Item> items)
	{
		view.line(125);
		view.print(puzzleName);
		view.printString(puzzleDesc);
		view.print("---secect item---");
		for (int i = 0; i < items.size(); i++)
		{
			view.print(i + ": " + items.get(i));
		}
		view.print("hint:");
		view.print("exit:");
	}
}
