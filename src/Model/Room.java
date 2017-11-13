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
	protected int exit1;
	protected int exit2;
	protected int exit3;
	protected int exit4;
	protected int exit5;
	public static ArrayList<Room> rooms = new ArrayList<Room>();
	protected boolean locked;

	public Room()
	{
	}

	public Room(int roomId, String roomDesc, int enemies, int puzzles, int exit1, int exit2, int exit3, int exit4, int exit5, int items, boolean locked)
	{
		this.roomId = roomId;
		this.roomDesc = roomDesc;
		this.items = items;
		this.locked = locked;
		this.enemies = enemies;
		this.puzzles = puzzles;
		this.exit1 = exit1;
		this.exit2 = exit2;
		this.exit3 = exit3;
		this.exit4 = exit4;
		this.exit5 = exit5;
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

	public int getExit1()
	{
		return exit1;
	}

	public void setExit1(int exit1)
	{
		this.exit1 = exit1;
	}

	public int getExit2()
	{
		return exit2;
	}

	public void setExit2(int exit2)
	{
		this.exit2 = exit2;
	}

	public int getExit3()
	{
		return exit3;
	}

	public void setExit3(int exit3)
	{
		this.exit3 = exit3;
	}

	public int getExit4()
	{
		return exit4;
	}

	public void setExit4(int exit4)
	{
		this.exit4 = exit4;
	}
	
	public int getExit5()
	{
		return exit5;
	}

	public void setExit5(int exit5)
	{
		this.exit5 = exit5;
	}

	public boolean isLocked()
	{
		return locked;
	}

	public void setLocked(boolean locked)
	{
		this.locked = locked;
	}

	public void setExit(int position) 
	{
		if (position == 1)
		{
			this.exit1 = 2;
		}
		else if (position == 3)
		{
			this.exit1 = 4;
		}
		else if (position == 5)
		{
			this.exit1 = 6;
		}
		else if (position == 7)
		{
			this.exit1 = 8;
		}
		else if (position == 9)
		{
			this.exit1 = 10;
		}
		else if (position == 11)
		{
			this.exit1 = 12;
		}
	}
	
	public void lockedRoom() 
	{
		if(locked == true)
		{
			view.println("The exit is locked!");
			view.println("It requires a key.");
		}
		else
		{
			view.println("Entering room.");
		}
	}

	public void examineRoom(int roomId) 
	{
		view.println("Enemies: " + enemies + " Puzzles: " + puzzles + " Items: " + items);
	}

	public void showPaths(int exit1, int exit4, int exit2, int exit3)
	{
		view.println("Rooms avalible: " + exit1 + " exit1 room " + exit4 + " exit4 room " + exit2 + " exit2 room " + exit3 + " exit3 room");
		view.println("Enter which room?  Exit1 Exit2 Exit3 Exit4");
	}

	@Override
	public String toString()
	{
		return getRoomDesc();
	}
}
