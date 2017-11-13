package Classes;

import java.lang.reflect.Array;

public class Room
{
	protected int roomId;
	protected String roomDescription;
	int[] exits;
	char[] direction;
	String[] exitDescription;

	public Room() 
	{
		roomId = 0;
		roomDescription = "";
		exits = null;
		direction = null;
		exitDescription = null;
	}
	public Room(int roomId, boolean isLocked, String roomDescription, int[] exits, char[] direction, String[] exitDescription)
	{
		this.roomId = roomId;
		this.roomDescription = roomDescription;
		this.exits = exits;
		this.direction = direction;
		this.exitDescription = exitDescription;
		//this.exitDescription = doorDescription;
		//multiple exits. Doesn't make sense to have door as one description.
	}
	
	public Room(String loadedString)
 	{
		// loaded from file
		//int roomId, String roomDescription, int exitRoomId, char direction, String doorDescription
		try {
			String[] splitString = loadedString.split("|");
			roomId = Integer.parseInt(splitString[0]);
			roomDescription = splitString[1];
			//exits
			String[] tempString1 = splitString[2].split("/");
			String[] tempString2 = splitString[3].split("/");
			int i = Array.getLength(tempString1);
			exits = new int[i];
			direction = new char[i];
			while(i>0) {
				i--;
				exits[i] = Integer.parseInt(tempString1[i]);
				direction[i] = tempString2[i].charAt(0);;
			}
			exitDescription = splitString[4].split("/");
		}catch(Exception E)
		{
			System.out.println("Text Spencer Williams to fix this. I might have messed up a TextFile."
					+ "I can fix it in like 30 minutes. Include RoomsA in the text message");
		}	
	}


	public double getRoomId()
	{
		return roomId;
	}

	public void setRoomId(int roomId)
	{
		this.roomId = roomId;
	}

	public String getRoomDescription()
	{
		return roomDescription;
	}

	public void setRoomDescription(String roomDescription)
	{
		this.roomDescription = roomDescription;
	}

	public int[] getExits()
	{
		return exits;
	}

	public void setDirection(char[] direction)
	{
		this.direction = direction;
	}
	public char[] getDirection()
	{
		return direction;
	}

	public void setExits(int[] exits)
	{
		this.exits = exits;
	}

	public String[] getDoorDescription()
	{
		return exitDescription;
	}

	public void setDoorDescription(String[] doorDescription)
	{
		this.exitDescription = doorDescription;
	}
	
	public void enterRoom()
	{
		
	}
	
	public void exitRoom()
	{
		
	}
}