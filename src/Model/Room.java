// Used for designing room object.

package Model;
import java.util.ArrayList;
import View.Console;

public class Room
{
	private Console view;
	
	protected int roomId;
	protected String roomDesc;
	protected int items; 
	protected int puzzles;
	protected int enemies; 
	protected double door1;
	protected double door2;
	protected double door3;
	protected double door4;
	public static ArrayList<Room> rooms = new ArrayList<Room>();
	protected boolean locked;

	public Room()
	{
	}

	public Room(int roomId, String roomDesc, int enemies, int puzzles, double door1, double door4, int items, double door2, double door3, boolean locked)
	{
		this.roomId = roomId;
		this.roomDesc = roomDesc;
		this.items = items;
		this.locked = locked;
		this.enemies = enemies;
		this.puzzles = puzzles;
		this.door1 = door1;
		this.door4 = door4;
		this.door2 = door2;
		this.door3 = door3;
		Room.rooms.add(this);
	}
	
	public int getRoomId()
	{
		return roomId;
	}

	public void setRoomId(int roomId)
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

	public double getDoor1()
	{
		return door1;
	}

	public void setDoor1(double door1)
	{
		this.door1 = door1;
	}

	public double getDoor2()
	{
		return door2;
	}

	public void setDoor2(double door2)
	{
		this.door2 = door2;
	}

	public double getDoor3()
	{
		return door3;
	}

	public void setDoor3(double door3)
	{
		this.door3 = door3;
	}

	public double getDoor4()
	{
		return door4;
	}

	public void setDoor4(double door4)
	{
		this.door4 = door4;
	}

	public boolean isLocked()
	{
		return locked;
	}

	public void setLocked(boolean locked)
	{
		this.locked = locked;
	}

	public void setDoor(double position) 
	{
		if (position == 1)
		{
			this.door1 = 2;
		}
		else if (position == 3)
		{
			this.door1 = 4;
		}
		else if (position == 5)
		{
			this.door1 = 6;
		}
		else if (position == 7)
		{
			this.door1 = 8;
		}
		else if (position == 9)
		{
			this.door1 = 10;
		}
		else if (position == 11)
		{
			this.door1 = 12;
		}
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

	public void examineRoom(double roomId) 
	{
		view.println("Enemies: " + enemies + " Puzzles: " + puzzles + " Items: " + items);
	}

	public void showPaths(int door1, int door4, int door2, int door3)
	{
		view.println("Rooms avalible: " + door1 + " door1 room " + door4 + " door4 room " + door2 + " door2 room " + door3 + " door3 room");
		view.println("Enter which room?  Door1 Door2 Door3 Door4");
	}

	@Override
	public String toString()
	{
		return getRoomDesc();
	}
}
