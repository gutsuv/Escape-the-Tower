package Model;

import java.util.ArrayList;

/**
 * Class: PuzzleNumber
 * @author Team Hydra
 * @version 1.0
 * Course: ITEC 3860, Fall 2017
 * Written: November 25
 * 
 * This class stores and holds the functionality of number based puzzles in the game.
 * 
 * Purpose: To contain the methods and attributes needed to create number based puzzles.
 */
public class PuzzleNumber extends Puzzle
{
	int answer;
	int roomId;
	Room lockedRoom;
	int damage = 5;

	/**
     * Method: PuzzleNumber()
     * PuzzleNumber constructor
     * @param loadedString String representing the string inputs to be parsed
     * @return nothing
     */
	public PuzzleNumber(String loadedString)
	{
		// loaded from file
		// int puzzleId String name, int roomId
		// String puzzleDesc, String hint
		try
		{
			String[] splitString = loadedString.split("-_");
			puzzleId = Integer.parseInt(splitString[0]);
			puzzleName = splitString[1];
			answer = (int) (Math.random() * 100) + 1;
			roomId = Integer.parseInt(splitString[2]);
			puzzleDesc = splitString[3];
			hint = splitString[4];

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
     * Method: getDamage()
     * Returns damage
     * @param none
     * @return damage int value representing damage
     */
	public int getDamage()
	{
		return damage;
	}

	/**
     * Method: initialize()
     * Displays puzzle intro
     * @param none
     * @return nothing
     */
	@Override
	public void initialize()
	{
		lockedRoom.setLocked(true);
		view.line(125);
		view.printString("You walk inside cell to inspect the seemingly empty room."
				+ " Immediately, a prisoner slams the door shut and challenges you to"
				+ " guess the number on his mind.",125);
	}

	/**
     * Method: attemptSolve()
     * Initiates puzzle actions
     * @param stringAnswer String value representing player answer
     * @return nothing
     */
	@Override
	public void attemptSolve(String stringAnswer)
	{
		
		int guess = Integer.parseInt(stringAnswer);
		
		if (guess > answer)
		{
			view.print("wrong answer: too high");
		}
		
		else if (guess < answer)
		{
			view.print("wrong answer: too low");
		}
		
		else
		{
			solved = true;
			lockedRoom.setLocked(false);
			view.print("puzzle solved");
			
			if(puzzleId == 5)
			{
				view.print("Answer to puzzle 01 is 'A horseshoe nail'(copy paste)");
			}
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
		view.print("guess a number:");
		view.print("hint:");
		view.print("exit:");
	}
}
