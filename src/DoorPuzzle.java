import java.util.ArrayList;

public class DoorPuzzle extends Puzzle
{
	int itemId;
	int roomId;
	Room lockedRoom;

	public DoorPuzzle(String loadedString)
	{
		// loaded from file
		// int puzzleId String name, int itemId, int roomId
		// String puzzleDesc, String hint
		try
		{
			String[] splitString = loadedString.split("-_");
			puzzleId = Integer.parseInt(splitString[0]);
			puzzleName = splitString[1];
			itemId = Integer.parseInt(splitString[2]);
			roomId = Integer.parseInt(splitString[3]);
			puzzleDesc = splitString[4];
			hint = splitString[5];

		} catch (Exception E)
		{
			System.out.println("Text Spencer Williams to fix this. I might have messed up a TextFile."
					+ "I can fix it in like 30 minutes. Include DoorPuzzle in the text message");
		}
	}

	public int getRoomId()
	{
		return roomId;
	}

	public void setRoom(Room room)
	{
		lockedRoom = room;
	}

	public void setLockedRoom(ArrayList<Room> rooms)
	{
		setRoom(rooms.get(roomId - 1));
	}

	@Override
	public void initialize()
	{
		lockedRoom.setLocked(true);
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
			view.print("Puzzle solved: The exit is no longer obstructed");
			lockedRoom.setLocked(false);
			solved = true;
		} else
		{
			view.line(125);
			view.print("puzzle not solved by item");
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
