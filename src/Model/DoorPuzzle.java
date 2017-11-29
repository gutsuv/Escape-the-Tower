package Model;

import java.util.ArrayList;

/**
 * Class: DoorPuzzle
 * @author Team Hydra
 * @version 1.0
 * Course: ITEC 3860, Fall 2017
 * Written: November 23
 * 
 * This class stores the functionality of puzzles with locked doors.
 * 
 * Purpose: The purpose is to store attributes that relate to locked door puzzles.
 */
public class DoorPuzzle extends Puzzle
{
	int itemId;
	int roomId;
	Room lockedRoom;

	/**
     * Method: DoorPuzzle()
     * Class constructor that initializes variables and reads from file
     * @param loadedString
     * @return nothing
     */
	public DoorPuzzle(String loadedString)
	{
		// loaded from file
		// int puzzleId String name, int itemId, int roomId
		// String puzzleDesc, String hint
		try
		{
			String[] splitString = loadedString.split("-_");
			puzzleId = Integer.parseInt(splitString[0]);
			puzzleName = splitString[1];
			itemId = Integer.parseInt(splitString[2]);
			roomId = Integer.parseInt(splitString[3]);
			puzzleDesc = splitString[4];
			hint = splitString[5];

		} 
		catch (Exception E)
		{
			System.out.println("Errors");
		}
	}

	/**
     * Method: getRoomId()
     * Retrieves room ID
     * @param none
     * @return roomID
     */
	public int getRoomId()
	{
		return roomId;
	}

	/**
     * Method: setRoom()
     * Instantiates whether room is locked
     * @param room
     * @return nothing
     */
	public void setRoom(Room room)
	{
		lockedRoom = room;
	}

	/**
     * Method: setLockedRoom()
     * Sets whether a room is locked
     * @param Arraylisr<Room> rooms
     * @return nothing
     */
	public void setLockedRoom(ArrayList<Room> rooms)
	{
		setRoom(rooms.get(roomId - 1));
	}

	/**
     * Method: initialize()
     * Initializes whether a room is locked
     * @param none
     * @return nothing
     */
	@Override
	public void initialize()
	{
		lockedRoom.setLocked(true);
	}

	/**
     * Method: attemptSolve()
     * user can attempt to solve puzzle
     * @param answer
     * @return nothing
     */
	@Override
	public void attemptSolve(String answer)
	{
		// no effect
	}

	/**
     * Method: attemptSolve()
     * user can attempt to solve puzzle
     * @param itemId 
     * @return nothing
     */
	@Override
	public void attemptSolve(int itemId)
	{
		if (this.itemId == itemId)
		{
			view.line(125);
			view.print("Puzzle solved: The exit is no longer obstructed");
			lockedRoom.setLocked(false);
			solved = true;
		} else
		{
			view.line(125);
			view.print("puzzle not solved by item");
		}
	}

	/**
     * Method: display()
     * Displays locked door puzzle description
     * @param none
     * @return nothing
     */
	@Override
	public void display()
	{
		view.line(125);
		view.print(puzzleName);
		view.printString(puzzleDesc);
	}

	/**
     * Method: display()
     * Displays locked door puzzle prompt
     * @param items
     * @return nothing
     */
	public void display(ArrayList<Item> items)
	{
		view.line(125);
		view.print(puzzleName);
		view.printString(puzzleDesc);
		view.print("---[Select Item]---");
		for (int i = 0; i < items.size(); i++)
		{
			view.print(i + ": " + items.get(i));
		}
		view.print("Hint:");
		view.print("Exit:");
	}
}
