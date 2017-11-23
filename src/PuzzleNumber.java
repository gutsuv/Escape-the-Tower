import java.util.ArrayList;

public class PuzzleNumber extends Puzzle{
	int answer;
	int roomId;
	Room lockedRoom;
	int damage = 5;
	
	public PuzzleNumber(String loadedString) {
		//loaded from file
		//int puzzleId String name, int roomId
		//String puzzleDesc, String hint
		try 
		{
			String[] splitString = loadedString.split("-_");
			puzzleId = Integer.parseInt(splitString[0]);
			puzzleName = splitString[1];
			answer = (int)(Math.random()*100)+1;
			roomId = Integer.parseInt(splitString[2]);
			puzzleDesc = splitString[3];
			hint = splitString[4];

		}catch(Exception E)
		{
			System.out.println("Text Spencer Williams to fix this. I might have messed up a TextFile."
					+ "I can fix it in like 30 minutes. Include PuzzleNumber in the text message");
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
	
	public int getDamage()
	{
		return damage;
	}
	
	@Override
	public void initialize() 
	{
		lockedRoom.setLocked(true);
	}
	
	@Override
	public void attemptSolve(String stringAnswer) 
	{
		initialize();
		int guess = Integer.parseInt(stringAnswer);
		if(guess>answer) {view.print("wrong anser: too high");}
		else if(guess<answer) {view.print("wrong answer: too low");}
		else{solved=true;lockedRoom.setLocked(false);}
	}
	
	@Override
	public void attemptSolve(int itemId) 
	{
		//no effect
	}
	
	@Override
	public void display() {
		view.line(125);
		view.print(puzzleName);
		view.printString(puzzleDesc);
		view.print("guess a number:");
		view.print("hint:");
		view.print("exit:");
	}
}
