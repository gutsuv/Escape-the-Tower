package Model;

import java.util.ArrayList;

/**
 * Class: PuzzleRiddle
 * @author Team Hydra
 * @version 1.0
 * Course: ITEC 3860, Fall 2017
 * Written: November 24
 * 
 * This class stores and holds the functionality of riddle puzzles in the game.
 * 
 * Purpose: To contain the methods and attributes needed to create riddle puzzles.
 */
public class PuzzleRiddle extends Puzzle
{
	String answer1;
	String answer2;
	int roomId;
	Room lockedRoom;

	/**
     * Method: PuzzleRiddle()
     * PuzzleRiddle constructor
     * @param loadedString String representing the string inputs to be parsed
     * @return nothing
     */
	public PuzzleRiddle(String loadedString)
	{
		// loaded from file
		// int puzzleId String name, int roomId String puzzleDesc,
		// String hint, String answer1, String answer2
		try
		{
			String[] splitString = loadedString.split("-_");
			puzzleId = Integer.parseInt(splitString[0]);
			puzzleName = splitString[1];
			roomId = Integer.parseInt(splitString[2]);
			puzzleDesc = splitString[3];
			hint = splitString[4];
			answer1 = splitString[5];
			answer2 = splitString[6];
		}
		catch (Exception E)
		{
			System.out.println("Error");
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
     * Method: setRoom()
     * Sets room lock
     * @param room Room Object
     * @return nothing
     */
	public void setRoom(Room room)
	{
		lockedRoom = room;
	}

	/**
     * Method: setLockedRoom()
     * Sets room lock into ArrayList
     * @param room Room ArrayList
     * @return nothing
     */
	public void setLockedRoom(ArrayList<Room> rooms)
	{
		setRoom(rooms.get(roomId - 1));
	}

	/**
     * Method: initialize()
     * Locks Room
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
     * Initiates puzzle actions
     * @param answer String value representing player answer
     * @return nothing
     */
	@Override
	public void attemptSolve(String answer)
	{
		if (answer.equalsIgnoreCase(answer1) || answer.equalsIgnoreCase(answer2))
		{
			view.line(125);
			view.print("Puzzle solved: Exit is no longer obstructed");
			lockedRoom.setLocked(false);
			solved = true;
		}
		
		else
		{
			view.line(125);
			view.print("incorrect answer");
		}
	}

	/**
     * Method: attemptSolve()
     * 
     * @param itemId int value representing item ID
     * @return nothing
     */
	@Override
	public void attemptSolve(int itemId)
	{
	}

	/**
     * Method: display()
     * Displays puzzle options
     * @param none
     * @return nothing
     */
	@Override
	public void display()
	{
		view.line(125);
		view.print(puzzleName);
		view.printString(puzzleDesc);
		view.print("Hint: ");
		view.print("Attempt to answer puzzle:");
		view.print("Exit:");
	}
}
