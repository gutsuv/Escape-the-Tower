// Room objects

package Model;

import View.Console;

public class RoomContent 
{
	Console view = new Console();
	
	// Grid layout of rooms
	protected double[][] FloorOne = 
	{
			{1, 2, 3, 0},
			{0, 4, 0, 0},
			{0, 5, 6, 0},
			{7, 8, 0, 9},
			{10, 11, 0, 0},
	};

	protected double[] FloorOneRooms = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};

	public double[][] getFloorOne() 
	{
		return FloorOne;
	}

	public double[] getFloorOneRooms() 
	{
		return FloorOneRooms;
	}

	double roomId1 = 1;
	double roomId2 = 2;
	double roomId3 = 3;
	double roomId4 = 4;
	double roomId5 = 5;
	double roomId6 = 6;
	double roomId7 = 7;
	double roomId8 = 8;
	double roomId9 = 9;
	double roomId10 = 10;
	double roomId11 = 11;


	boolean roomLocked1 = false;
	boolean roomLocked2 = false;
	boolean roomLocked3 = false;
	boolean roomLocked4 = false;
	boolean roomLocked5 = false;
	boolean roomLocked6 = false;
	boolean roomLocked7 = false;
	boolean roomLocked8 = false;
	boolean roomLocked9 = false;
	boolean roomLocked10 = false;
	boolean roomLocked11 = false;

	int roomEnemy1 = 0;
	int roomEnemy2 = 0;
	int roomEnemy3 = 1;
	int roomEnemy4 = 0;
	int roomEnemy5 = 0;
	int roomEnemy6 = 1;
	int roomEnemy7 = 0;
	int roomEnemy8 = 0;
	int roomEnemy9 = 1;
	int roomEnemy10 = 0;
	int roomEnemy11 = 0;
	
	int roomPuzzle1 = 0;
	int roomPuzzle2 = 0;
	int roomPuzzle3 = 1;
	int roomPuzzle4 = 0;
	int roomPuzzle5 = 0;
	int roomPuzzle6 = 1;
	int roomPuzzle7 = 0;
	int roomPuzzle8 = 0;
	int roomPuzzle9 = 1;
	int roomPuzzle10 = 0;
	int roomPuzzle11 = 0;
	
	int roomItem1 = 0;
	int roomItem2 = 0;
	int roomItem3 = 1;
	int roomItem4 = 0;
	int roomItem5 = 0;
	int roomItem6 = 1;
	int roomItem7 = 0;
	int roomItem8 = 0;
	int roomItem9 = 1;
	int roomItem10 = 0;
	int roomItem11 = 0;

	String roomDesc1 = "Room Name, Floor 1: Room 1 \nRoom Description";
	String roomDesc2 = "Room Name, Floor 1: Room 2 \nRoom Description";
	String roomDesc3 = "Room Name, Floor 1: Room 3 \nRoom Description";
	String roomDesc4 = "Room Name, Floor 1: Room 4 \nRoom Description";
	String roomDesc5 = "Room Name, Floor 1: Room 5 \nRoom Description";
	String roomDesc6 = "Room Name, Floor 1: Room 6 \nRoom Description";
	String roomDesc7 = "Room Name, Floor 1: Room 7 \nRoom Description";
	String roomDesc8 = "Room Name, Floor 1: Room 8 \nRoom Description";
	String roomDesc9 = "Room Name, Floor 1: Room 9 \nRoom Description";
	String roomDesc10 = "Room Name, Floor 1: Room 10 \nRoom Description";
	String roomDesc11 = "Room Name, Floor 1: Room 11 \nRoom Description";

	double  room1North = 1, 
			room1East = 2,
			room1South = 3,
			room1West = 4,
			
		    room2North = 1,
			room2East = 2,
			room2South = 3,
			room2West = 4,
			
			room3North = 1, 
			room3East = 2,
			room3South = 3,
			room3West = 4,
			
			room4North = 1, 
			room4East = 2,
			room4South = 3,
			room4West = 4,
			
			room5North = 1, 
			room5East = 2,
			room5South = 3,
			room5West = 4,
			
			room6North = 1, 
			room6East = 2,
			room6South = 3,
			room6West = 4,
			
			room7North = 1, 
			room7East = 2,
			room7South = 3,
			room7West = 4,
			
			room8North = 1, 
			room8East = 2,
			room8South = 3,
			room8West = 4,
			
			room9North = 1, 
			room9East = 2,
			room9South = 3,
			room9West = 4,
					
			room10North = 1, 
			room10East = 2,
			room10South = 3,
			room10West = 4,
			
			room11North = 1, 
			room11East = 2,
			room11South = 3,
			room11West = 4;


	Room room1 = new Room(roomId1, roomDesc1, roomEnemy1, roomPuzzle1, room1North, room1West, roomItem1, room1South, room1East, roomLocked1);
	Room room2 = new Room(roomId2, roomDesc2, roomEnemy2, roomPuzzle2, room2North, room2West, roomItem2, room2South, room2East, roomLocked2);
	Room room3 = new Room(roomId3, roomDesc3, roomEnemy3, roomPuzzle3, room3North, room3West, roomItem3, room3South, room3East, roomLocked3);
	Room room4 = new Room(roomId4, roomDesc4, roomEnemy4, roomPuzzle4, room4North, room4West, roomItem4, room4South, room4East, roomLocked4);

	
	public void getRoom(double roomID)
	{
		switch (String.valueOf(roomID)) 
		{
			case "1": view.println(room1.toString()); 
			break;
			case "2": view.println(room2.toString()); 
			break;
			case "3": view.println(room3.toString());
			break;
			case "4": view.println(room4.toString()); 
			break;
		}
	}

	public void examineRoom(double id) 
	{
		if (id == 1) 
		{ 
			view.println("\n" + room1.getEnemies() +  " enemies, " + room1.getPuzzles() + " puzzles" + ", and " + room1.getItems() + " items\n");
		}
		
		if (id == 2) 
		{ 
			view.println("\n" + room2.getEnemies() +  " enemies, " + room2.getPuzzles() + " puzzles" + ", and " + room2.getItems() + " items\n");
		}

		if (id == 3) 
		{ 
			view.println("\n" + room3.getEnemies() +  " enemies, " + room3.getPuzzles() + " puzzles" + ", and " + room3.getItems() + " items\n");
		}

		if (id == 4) 
		{ 
			view.println("\n" + room4.getEnemies() +  " enemies, " + room4.getPuzzles() + " puzzles" + ", and " + room4.getItems() + " items\n");
		}
	}

	String directions = "";


	public void accessible(int north, int south, int east, int west, double position)
	{
		String northOption, westOption, southOption, eastOption, up, left, right;

		if (north != 0) 
		{
			northOption = "North: ";
		}
		else 
		{
			northOption = "";
		}

		if (east != 0)
		{
			eastOption = "East: ";
		}
		else 
		{
			eastOption = "";
		}

		if (south != 0)
		{
			southOption = "South: ";
		}
		else 
		{
			southOption = "";
		}

		if (west != 0)
		{
			westOption = "West: ";
		}
		else 
		{
			westOption = "";
		}
	
		if (position == 1 || position == 2 || position == 3)
		{
			up = "Up: ";
		}
		else 
		{
			up = "";
		}
		
		if (position == 4)
		{
			left = "Left: ";
		}
		else
		{
			left = "";
		}
		if (position == 4)
		{
			right ="Right: ";
		}
		else
		{
			right = "";
		}

		//directions = "\nExits avalible: " + northOption + westOption + southOption + eastOption + up + left + right; 

		view.println("\nExits avalible: " + northOption + westOption + southOption + eastOption + up + left + right);
	}

	public void obtainItem(int item)
	{
		if(item != 0)
		{
			view.println(MiscellaneousContent.takeItem());
		}
	}

	public void engageEnemy(int enemy) 
	{
		if(enemy != 0)
		{
			view.println("Engaging enemy");
		}
	}

	public void doPuzzle(int puzzle) 
	{ 
		if(puzzle != 0)
		{
			view.println("Puzzle present");
		}
	}
}