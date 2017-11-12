import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Room
{
	protected double roomId;
	protected String roomDescription;
	String[] doors;
	protected String doorDescription;
	protected String fileName;
	protected String line;

	public Room() 
	{
	 roomId = 0;
	 roomDescription = null;
	 doors = null;
	 doorDescription = null;
	 fileName = null;
	 line = null;
	}

	public Room(double roomId, boolean isLocked, String roomDescription, String doorDescription, String fileName, String line)
	{
		this.roomId = roomId;
		this.roomDescription = roomDescription;
		this.doorDescription = doorDescription;
		this.fileName = fileName;
		this.line = line;
	}
	public void reader(String fileName, String line){
		try{
			FileReader fileReader = new FileReader(fileName);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			
			while(bufferedReader.readLine() != null){
				line = bufferedReader.readLine();
				System.out.println(line);
			}
			bufferedReader.close();
		}
		catch(FileNotFoundException ex){
			System.out.println("Unable to open file '" + fileName + "'");
		}
		catch(IOException ex){
			ex.printStackTrace();
		}
	}

	public double getRoomId()
	{
		
		return roomId;
	}

	public void setRoomId(double roomId)
	{
		fileName = "RoomsB.txt";
		this.line = line;
		reader(fileName, line);
		this.roomId = roomId;
	}

	public String getRoomDescription()
	{
		
		return roomDescription;
	}

	public void setRoomDescription(String roomDescription)
	{
		fileName = "RoomsA.txt";
		this.line = line;
		reader(fileName, line);
		this.roomDescription = roomDescription;
	}

	public String[] getDoors()
	{
		return doors;
	}

	public void setDoors(String[] doors)
	{
		this.doors = doors;
	}

	public String getDoorDescription()
	{
		return doorDescription;
	}

	public void setDoorDescription(String doorDescription)
	{
		this.doorDescription = doorDescription;
	}
	
	public void enterRoom()
	{
		
	}
	
	public void exitRoom()
	{
		
	}
}