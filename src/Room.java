
// Used for designing room object.

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Class: Room
 * @author Team Hydra
 * @version 1.0
 * Course: ITEC 3860, Fall 2017
 * Written: 
 * 
 * This class – now describe what the class does 
 * 
 * Purpose: – Describe the purpose of this class
 */
public class Room
{
	View view;
	protected int roomId;
	protected String roomDesc;
	// protected int puzzles;

	protected int[] exitIDs;
	protected char[] directions;
	protected String[] doorDescriptions;

	protected boolean locked;
	protected Enemy enemy;
	protected ArrayList<Item> items = new ArrayList<Item>();
	protected Puzzle puzzle;

	/**
     * Method: Room()
     * Room constructor
     * @param loadedString String representing the string inputs to be parsed
     * @return nothing
     */
	public Room(String loadedString)
	{
		// loaded from file
		// int roomId, String roomDescription, int exitRoomId, char direction, String
		// doorDescription
		locked = false;
		try
		{
			String[] splitString = loadedString.split("-_");
			roomId = Integer.parseInt(splitString[0]);
			roomDesc = splitString[1];
			// exits
			String[] tempString1 = splitString[2].split("><");
			String[] tempString2 = splitString[3].split("><");
			int i = Array.getLength(tempString1);
			exitIDs = new int[i];
			directions = new char[i];
			while (i > 0)
			{
				i--;
				exitIDs[i] = Integer.parseInt(tempString1[i]);
				directions[i] = tempString2[i].charAt(0);
				;
			}
			doorDescriptions = splitString[4].split("><");
		}
		catch (Exception E)
		{
			System.out.println("Text Spencer Williams to fix this. I might have messed up a TextFile."
					+ "I can fix it in like 30 minutes. Include RoomsA in the text message");
		}
	}

	/**
     * Method: getRoomId()
     * Returns room ID
     * @param none
     * @return roomId int value representing the room id
     */
	public int getRoomId()
	{
		return roomId;
	}

	/**
     * Method: getRoomDesc()
     * Returns room description
     * @param none
     * @return roomDesc String value representing the room description
     */
	public String getRoomDesc()
	{
		return roomDesc;
	}

	/**
     * Method: getExits()
     * Returns exit IDs
     * @param none
     * @return exitIDs int array representing exit IDs
     */
	public int[] getExits()
	{
		return exitIDs;
	}

	/**
     * Method: getExit()
     * Returns exit ID
     * @param none
     * @return exitIDs int value representing exit ID
     */
	public int getExit(int i)
	{
		return exitIDs[i];
	}

	/**
     * Method: getExitDescriptions()
     * Returns doorDescriptions
     * @param none
     * @return doorDescriptions String value representing door description
     */
	public String[] getExitDescriptions()
	{
		return doorDescriptions;
	}

	/**
     * Method: getExitDescriptions()
     * Returns doorDescription
     * @param i int value
     * @return doorDescriptions String value representing door description
     */
	public String getExitDescription(int i)
	{
		return doorDescriptions[i];
	}

	/**
     * Method: getDirections()
     * Returns directions
     * @param none
     * @return directions char value representing direction
     */
	public char[] getDirections()
	{
		return directions;
	}

	/**
     * Method: getDirection()
     * Returns direction
     * @param i int value
     * @return directions char value representing direction
     */
	public char getDirection(int i)
	{
		try
		{
			return directions[i];
		}
		catch (Exception E)
		{
			return ' ';
		}
	}

	/**
     * Method: isLocked()
     * Returns locked
     * @param none
     * @return locked boolean value representing locked
     */
	public boolean isLocked()
	{
		return locked;
	}

	/**
     * Method: setLocked()
     * Sets lock
     * @param locked boolean
     * @return nothing
     */
	public void setLocked(boolean locked)
	{
		this.locked = locked;
	}

	/**
     * Method: getEnemy()
     * returns enemy
     * @param none
     * @return enemy Enemy object
     */
	public Enemy getEnemy()
	{
		return enemy;
	}

	/**
     * Method: setEnemy()
     * Sets enemy
     * @param enemy Enemy object
     * @return nothing
     */
	public void setEnemy(Enemy enemy)
	{
		this.enemy = enemy;
	}

	/**
     * Method: getPuzzle()
     * Returns puzzle
     * @param none
     * @return puzzle
     */
	public Puzzle getPuzzle()
	{
		return puzzle;
	}

	/**
     * Method: getPuzzle()
     * Sets puzzle
     * @param puzzle
     * @return nothing
     */
	public void setPuzzle(Puzzle puzzle)
	{
		this.puzzle = puzzle;
	}

	/**
     * Method: getItems()
     * Returns items
     * @param none
     * @return nothing
     */
	public ArrayList<Item> getItems()
	{
		return items;
	}

	/**
     * Method: addItem()
     * Returns items
     * @param item
     * @return nothing
     */
	public void addItem(Item item)
	{
		items.add(item);
	}

	/**
     * Method: removeItem()
     * Returns items
     * @param i
     * @return nothing
     */
	public void removeItem(int i)
	{
		items.remove(i);
	}

	/**
     * Method: pickUp()
     * Returns items
     * @param i
     * @return item
     */
	public Item pickUp(int i)
	{
		Item item = items.get(i);
		items.remove(i);
		return item;
	}


	/**
     * Method: enemyDeathEffects()
     * enemyDeathEffects
     * @param none
     * @return nothing
     */
	public void enemyDeathEffects()
	{
		view.print("enemy has died");
		for (int i = 0; i < enemy.getItems().size(); i++)
		{
			addItem(enemy.getItems().get(i));
		}
		enemy = null;
		try
		{
			display();
		}
		catch (Exception e)
		{

		}
	}

	/**
     * Method: setView()
     * Sets view
     * @param v
     * @return nothing
     */
	public void setView(View v)
	{
		view = v;
	}

	public void examineRoom()
	{
	}

	/**
     * Method: showPaths()
     * Displays path
     * @param none
     * @return nothing
     */
	public void showPaths()
	{
		int i = directions.length;
		while (i > 0)
		{
			i--;
			System.out.println(directions[i] + " " + doorDescriptions[i]);
		}
	}

	/**
     * Method: display()
     * Displays room
     * @param none
     * @return nothing
     */
	public void display() throws Exception
	{
		view.line(125);
		view.printString(getRoomDesc(), 125);
		if (enemy != null)
		{
			view.printString(enemy.toString(), 125);
		}
		if (puzzle != null)
		{
			view.printString(puzzle.toString(), 125);
		}
		view.printStrO(items, 125);
		view.line();
		view.print("=======[Commands]========");
		view.print("stats:");
		view.print("help:");
		view.print("menu:");
		view.print("inventory:");
		if (items.size() > 0)
		{
			view.print("pick up:");
		}
		if (enemy != null)
		{
			view.print("combat:");
		}
		if (puzzle != null)
		{
			view.print("puzzle:");
		}
		view.print("=====[Move Commands]=====");
		try
		{
			for (int i = 0; i < directions[i]; i++)
			{
				view.printString(directions[i], doorDescriptions[i], 125);
			}
		}
		catch (Exception E)
		{

		}
	}
	
	/**
     * Method: helpMessage()
     * Displays help message
     * @param none
     * @return nothing
     */
	public void helpMessage() throws Exception
	{
		view.print("=====[Help Menu]=====");
		view.print("Enter 'help' for help");
	}
	
	/**
     * Method: toString()
     * Displays room desc
     * @param none
     * @return getRoomDesc
     */
	@Override
	public String toString()
	{
		return getRoomDesc();
	}
}
