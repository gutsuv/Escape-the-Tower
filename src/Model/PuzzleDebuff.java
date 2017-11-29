package Model;

import java.util.ArrayList;

/**
 * Class: PuzzleDebuff
 * @author Team Hydra
 * @version 1.0
 * Course: ITEC 3860, Fall 2017
 * Written: November 24
 * 
 * This class stores and holds the functionality of debuff puzzles in the game.
 * 
 * Purpose: To contain the methods and attributes needed to create debuff puzzles.
 */
public class PuzzleDebuff extends Puzzle
{
	private int itemId;
	private boolean active = true;
	
	/**
     * Method: PuzzleDebuff()
     * PuzzleDebuff constructor
     * @param loadedString String representing the string inputs to be parsed
     * @return nothing
     */
	public PuzzleDebuff(String loadedString)
	{
		// loaded from file
		// int puzzleId String name, int roomId String puzzleDesc,
		// String hint, String answer1, String answer2
		try
		{
			String[] splitString = loadedString.split("-_");
			puzzleId = Integer.parseInt(splitString[0]);
			puzzleName = splitString[1];
			//debuff = Integer.parseInt(splitString[2]);
			itemId = Integer.parseInt(splitString[3]);
			puzzleDesc = splitString[4];
			hint = splitString[5];
		}
		catch (Exception E)
		{
			System.out.println("Error");
		}
	}
	
	/**
     * Method: isActive()
     * Returns active status
     * @param none
     * @return active boolean value representing active status
     */
	public boolean isActive()
	{
		return active;
	}
	
	/**
     * Method: initialize()
     * 
     * @param none
     * @return nothing
     */
	@Override
	public void initialize()
	{
	}

   /** Method: initialize()
    * Poisons the player
    * @param Player as the player invoking triggering poison
    * @return nothing
    */
	public void initialize(Player user)
	{
		user.setPoisoned(true);
		user.updateStats();
		printPoison();
	}
	
	/**
     * Method: attemptSolve()
     * Sets solved to true
     * @param answer String value representing answer
     * @return nothing
     */
	@Override
	public void attemptSolve(String answer)
	{
		solved = true;
	}
	
	/**
     * Method: printPoison()
     * Displays poison action
     * @param none
     * @return nothing
     */
	public void printPoison()
	{
		view.line(125);
		view.printString("You drink the vial and begin to fall sick."
				+ " It was poison! Where’s the antidote?",125);
		active = true;
	}

	/**
     * Method: attemptSolve()
     * 
     * @param none
     * @return nothing
     */
	@Override
	public void attemptSolve(int itemId)
	{
	}

	/**
     * Method: display()
     * Displays puzzle information
     * @param none
     * @return nothing
     */
	@Override
	public void display()
	{
		view.line(125);
		view.print(puzzleName);
		view.printString(puzzleDesc);
		view.print("Hint:");
		view.print("Exit:");
	}
}
