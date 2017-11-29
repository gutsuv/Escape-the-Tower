package Model;


/**
 * Class: PuzzleItem
 * @author Team Hydra
 * @version 1.0
 * Course: ITEC 3860, Fall 2017
 * Written: November 25
 * 
 * This class stores and holds the functionality of item based puzzles in the game.
 * 
 * Purpose: To contain the methods and attributes needed to create item based puzzles.
 */
public class PuzzleItem extends Item
{
	protected int puzzleId;

	/**
     * Method: PuzzleItem()
     * PuzzleItem constructor
     * @param loadedString String representing the string inputs to be parsed
     * @return nothing
     */
	public PuzzleItem(String loadedString)
	{
		// loaded from file

		// int ID, String name, int puzzleId, String description
		try
		{
			String[] splitString = loadedString.split("-_");
			itemId = Integer.parseInt(splitString[0]);
			itemName = splitString[1];
			puzzleId = Integer.parseInt(splitString[2]);
			itemDescShort = splitString[3];
			itemDescLong = splitString[3];
			// Other Item classes have two descriptions. Double casting it makes some sense
		}
		
		catch (Exception E)
		{
			System.out.println("Error");
		}
	}

	/**
     * Method: getPuzzleId()
     * Returns puzzle ID
     * @param none
     * @return puzzleId int value representing puzzle ID
     */
	public int getPuzzleId()
	{
		return puzzleId;
	}

	/**
     * Method: use()
     * 
     * @param none
     * @return nothing
     */
	@Override
	public void use()
	{
	}

	/**
     * Method: drop()
     * 
     * @param none
     * @return nothing
     */
	@Override
	public void drop()
	{
	}

	/**
     * Method: examine()
     * 
     * @param none
     * @return nothing
     */
	@Override
	public void examine()
	{
		view.print(itemDescShort);
	}

	/**
     * Method: getDisplay()
     * Displays item usage options
     * @param none
     * @return String value representing item usage options
     */
	@Override
	public String getDisplay()
	{
		return itemName + "-> [use], drop, examine:";
	}

	/**
     * Method: displayCommands()
     * Displays commands for items
     * @param none
     * @return nothing
     */
	@Override
	public void displayCommands()
	{
		view.line(125);
		view.print(itemName);
		
		if(itemId == 102)
		{
			view.print("use");
		}
		
		view.print("drop:");
		view.print("examine:");
		view.print("exit:");
	}
}
