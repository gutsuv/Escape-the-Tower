public class Room
{
	protected double roomId;
	protected String roomDescription;
	String[] doors;
	protected String doorDescription;

	public Room() 
	{
	}

	public Room(double roomId, boolean isLocked, String roomDescription, String doorDescription)
	{
		this.roomId = roomId;
		this.roomDescription = roomDescription;
		this.doorDescription = doorDescription;
	}

	public double getRoomId()
	{
		return roomId;
	}

	public void setRoomId(double roomId)
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