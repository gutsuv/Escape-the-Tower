import java.util.ArrayList;

public class PuzzleRiddle extends Puzzle{
	String answer1;
	String answer2;
	int roomId;
	Room lockedRoom;
	
	public PuzzleRiddle(String loadedString) {
		//loaded from file
		//int puzzleId String name, int roomId String puzzleDesc,
		//String hint, String answer1, String answer2
		try 
		{
			String[] splitString = loadedString.split("-_");
			puzzleId = Integer.parseInt(splitString[0]);
			puzzleName = splitString[1];
			roomId = Integer.parseInt(splitString[2]);
			puzzleDesc = splitString[3];
			hint = splitString[4];
			answer1 = splitString[5];
			answer2 = splitString[6];
		}catch(Exception E)
		{
			System.out.println("Text Spencer Williams to fix this. I might have messed up a TextFile."
					+ "I can fix it in like 30 minutes. Include PuzzleRiddle in the text message");
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
		setRoom(rooms.get(roomId-1));
	}
	
	@Override
	public void initialize() 
	{
		lockedRoom.setLocked(true);
	}
	
	@Override
	public void attemptSolve(String answer) 
	{
		if(answer.matches(answer1)||answer.matches(answer2)) 
		{
			solved=true;
			view.print("solved");
		}
	}

	@Override
	public void attemptSolve(int itemId) 
	{
		//no effect
	}
}
