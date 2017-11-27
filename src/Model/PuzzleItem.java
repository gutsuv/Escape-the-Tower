package Model;


/**
 * Class: PuzzleItem
 * @author Team Hydra
 * @version 1.0
 * Course: ITEC 3860, Fall 2017
 * Written: 
 * 
 * This class – now describe what the class does 
 * 
 * Purpose: – Describe the purpose of this class
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
			System.out.println("Text Spencer Williams to fix this. I might have messed up a TextFile."
					+ "I can fix it in like 30 minutes. Include Gear in the text message");
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
