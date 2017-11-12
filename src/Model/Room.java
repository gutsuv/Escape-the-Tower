// Used for designing room object.

package Model;
import java.util.LinkedList;
import View.Console;

public class Room
{
	private Console view;
	
	protected double roomId;
	protected String roomDesc;
	protected int items; 
	protected int puzzles;
	protected int enemies; 
	protected double north;
	protected Room northName;
	protected double south;
	protected double east;
	protected double west;
	public static LinkedList<Room> rooms = new LinkedList<Room>();
	protected boolean locked;

	public Room()
	{
	}

	public Room(double roomId, String roomDesc, int enemies, int puzzles, double north, double west, int items, double south, double east, boolean locked)
	{
		this.roomId = roomId;
		this.roomDesc = roomDesc;
		this.items = items;
		this.locked = locked;
		this.enemies = enemies;
		this.puzzles = puzzles;
		this.north = north;
		this.west = west;
		this.south = south;
		this.east = east;
		Room.rooms.add(this);
	}
	
	public double getRoomId()
	{
		return roomId;
	}

	public void setRoomId(double roomId)
	{
		this.roomId = roomId;
	}

	public String getRoomDesc()
	{
		return roomDesc;
	}

	public void setRoomDesc(String roomDesc)
	{
		this.roomDesc = roomDesc;
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

	public Room getNorthName()
	{
		return northName;
	}

	public void setNorthName(Room northName)
	{
		this.northName = northName;
	}

	public double getSouth()
	{
		return south;
	}

	public void setSouth(double south)
	{
		this.south = south;
	}

	public double getEast()
	{
		return east;
	}

	public void setEast(double east)
	{
		this.east = east;
	}

	public double getWest()
	{
		return west;
	}

	public void setWest(double west)
	{
		this.west = west;
	}

	public static LinkedList<Room> getRooms()
	{
		return rooms;
	}

	public static void setRooms(LinkedList<Room> rooms)
	{
		Room.rooms = rooms;
	}

	public boolean getLocked()
	{
		return locked;
	}

	public void setLocked(boolean locked)
	{
		this.locked = locked;
	}

	public double getNorth()
	{
		return north;
	}
	
	public void setNorth(double position) 
	{
		if (position == 1)
		{
			this.north = 2;
		}
		else if (position == 3)
		{
			this.north = 4;
		}
		else if (position == 5)
		{
			this.north = 6;
		}
		else if (position == 7)
		{
			this.north = 8;
		}
		else if (position == 9)
		{
			this.north = 10;
		}
		else if (position == 11)
		{
			this.north = 12;
		}
	}

	public void examineRoom(double roomId) 
	{
		view.println("The room contains:\tEnemies: " + enemies + " Puzzles: " + puzzles + " Items: " + items);
	}

	public void showPaths(int north, int west, int south, int east)
	{
		view.println("Rooms avalible: " + north + " north room " + west + " west room " + south + " south room " + east + " east");
		view.println("Enter which room?  North East South West");
	}

	public void lockedRoom() 
	{
		if(locked == true)
		{
			view.println("The door is locked!");
			view.println("It requires a key.");
		}
		else
		{
			view.println("Entering room.");
		}
	}

	@Override
	public String toString()
	{
		return "Room [view=" + view + ", roomId=" + roomId + ", roomDesc=" + roomDesc + ", items=" + items
				+ ", puzzles=" + puzzles + ", enemies=" + enemies + ", north=" + north + ", northName=" + northName
				+ ", south=" + south + ", east=" + east + ", west=" + west + ", locked=" + locked + "]";
	}
}
