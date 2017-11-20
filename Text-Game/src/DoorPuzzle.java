
public class DoorPuzzle extends Puzzle{
	
	int itemId;
	int roomId;
	Room lockedRoom;
	
	public DoorPuzzle(String loadedString) {
		//loaded from file
		//int puzzleId String name, int itemId, int roomId
		//String puzzleDesc, String hint
		try 
		{
			String[] splitString = loadedString.split("-_");
			itemId = Integer.parseInt(splitString[0]);
			puzzleName = splitString[1];
			itemId = Integer.parseInt(splitString[2]);
			roomId = Integer.parseInt(splitString[3]);
			puzzleDesc = splitString[4];
			hint = splitString[5];

		}catch(Exception E)
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
	
	@Override
	public void initialize() 
	{
		lockedRoom.setLocked(true);
	}
	
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
			lockedRoom.setLocked(false);
			solved=true;
		}
	}
	
}
