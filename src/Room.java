import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;

public class Room
{
	protected int roomId;
	protected String roomDescription;
	int[] doors;
	char[] direction;
	String[] doorDescription;
	protected int puzzles;
	protected int enemies;
	protected int items;
	protected boolean locked;
	//I'm not using these but they could be used later
	protected String fileName;
	protected String line;
	//
	
	public Room() 
	{
	 roomId = 0;
	 roomDescription = null;
	 doors = null;
	 doorDescription = null;
	 //fileName = null;
	 line = null;
	}
	public Room(String loadedString)
	{
		// loaded from file
		//int roomId, String roomDescription, int exitRoomId, char direction, String doorDescription
		try {
			String[] splitString = loadedString.split("-_");
			roomId = Integer.parseInt(splitString[2]);
			roomDescription = splitString[1];
			//exits
			String[] tempString1 = splitString[2].split("/");
			String[] tempString2 = splitString[3].split("/");
			int i = Array.getLength(tempString1);
			doors = new int[i];
			direction = new char[i];
			while(i>0) {
				i--;
				doors[i] = Integer.parseInt(tempString1[i]);
				direction[i] = tempString2[i].charAt(0);;
			}
			doorDescription = splitString[4].split("/");
		}catch(Exception E)
		{
			System.out.println("Text Spencer Williams to fix this. I might have messed up a TextFile."
					+ "I can fix it in like 30 minutes. Include RoomsA in the text message");
		}
	}

	public Room(int roomId, boolean isLocked, String roomDescription, String doorDescription[], String fileName, String line)
	{
		this.roomId = roomId;
		this.roomDescription = roomDescription;
		this.doorDescription = doorDescription;
		//this.fileName = fileName;
		this.line = line;
	}
	public void reader(String fileName, String line){
		try{
			FileReader fileReader = new FileReader("RoomsA.txt");
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			
//			while(bufferedReader.readLine() != null){
//				line = bufferedReader.readLine();
//				System.out.println(line);
//			}
//			bufferedReader.close();
		}
		catch(FileNotFoundException ex){
//			System.out.println("Unable to open file '" + fileName + "'");
		}
		catch(IOException ex){
	//		ex.printStackTrace();
		}
	}

	public double getRoomId()
	{
		return roomId;
	}

	public void setRoomId(int roomId)
	{
	//	fileName = "RoomsB.txt";
	//	this.line = line;
	//	reader(fileName, line);
		this.roomId = roomId;
	}

	public String getRoomDescription()
	{
		return roomDescription;
	}

	public void setRoomDescription(String roomDescription)
	{
	//	fileName = "RoomsA.txt";
	//	this.line = line;
	//	reader(fileName, line);
		this.roomDescription = roomDescription;
	}

	public int[] getDoors()
	{
		return doors;
	}

	public void setDoors(int[] doors)
	{
		this.doors = doors;
	}

	public String[] getDoorDescription()
	{
		return doorDescription;
	}

	public void setDoorDescription(String[] doorDescription)
	{
		this.doorDescription = doorDescription;
	}
	
	public int getItems()
	{
		return items;
	}

	public void setItems(int items)
	{
		this.items = items;
	}

	public int getPuzzles()
	{
		return puzzles;
	}

	public void setPuzzles(int puzzles)
	{
		this.puzzles = puzzles;
	}
	
	public int getEnemies()
	{
		return enemies;
	}

	public void setEnemies(int enemies)
	{
		this.enemies = enemies;
	}
	
	public int getDoor(int i)
	{
		return doors[i];
	}
	
	public void setDoor1(int i, int door1)
	{
		doors[i] = door1;
	}
	
	public boolean isLocked()
	{
		return locked;
	}

	public void setLocked(boolean locked)
	{
		this.locked = locked;
	}
	
	public void lockedRoom() 
	{
		if(locked == true)
		{
		//	view.println("The door is locked!");
		//	view.println("It requires a key.");
		}
		else
		{
		//	view.println("Entering room.");
		}
	}
	
	public void examineRoom(int roomId) 
	{
		//view.println("Enemies: " + enemies + " Puzzles: " + puzzles + " Items: " + items);
	}
	
	public void showPaths(int door1, int door4, int door2, int door3)
	{
		//view.println("Rooms avalible: " + door1 + " door1 room " + door4 + " door4 room " + door2 + " door2 room " + door3 + " door3 room");
		//view.println("Enter which room?  Door1 Door2 Door3 Door4");
	}
	
	public void enterRoom()
	{
		
	}
	
	public void exitRoom()
	{
		
	}
	
	@Override
	public String toString()
	{
		return getRoomDescription();
	}
}