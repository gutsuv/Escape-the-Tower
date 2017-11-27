/**
 * Class: Consumable
 * @author Team Hydra
 * @version 1.0
 * Course: ITEC 3860, Fall 2017
 * Written: 
 * 
 * This class – now describe what the class does 
 * 
 * Purpose: – Describe the purpose of this class
 */

public class Consumable extends Item
{
	protected int healthEffect;
	protected int maxHealthEffect;

	/**
     * Method: Consumable()
     * [What the method does]
     * @param loadedString String value representing...
     * @return nothing
     */
	public Consumable(String loadedString)
	{
		// loaded from file
		// int itemID, String itemName, int healthEffect
		// int maxHealthEffect, String itemDescShort, String itemDescLong

		try
		{
			String[] splitString = loadedString.split("-_");
			itemId = Integer.parseInt(splitString[0]);
			itemName = splitString[1];
			healthEffect = Integer.parseInt(splitString[2]);
			maxHealthEffect = Integer.parseInt(splitString[3]);
			itemDescShort = splitString[4];
			itemDescLong = splitString[5];

		} 
		catch (Exception E)
		{
			System.out.println("Text Spencer Williams to fix this. I might have messed up a TextFile."
					+ "I can fix it in like 30 minutes. Include Consumable in the text message");
		}

	}

	/**
     * Method: getHealthEffect()
     * [What the method does]
     * @param none
     * @return healthEffect int value representing...
     */
	public int getHealthEffect()
	{
		return healthEffect;
	}

	/**
     * Method: getMaxHealthEffect()
     * [What the method does]
     * @param none
     * @return -maxHealthEffect int value representing...
     */
	public int getMaxHealthEffect()
	{
		return -maxHealthEffect;
	}

	/**
     * Method: use()
     * [What the method does]
     * @param none
     * @return nothing
     */
	@Override
	public void use()
	{
	}

	// code moved because I can't make an object delete itself without using outside
	// method
	/**
     * Method: drop()
     * [What the method does]
     * @param none
     * @return nothing
     */
	@Override
	public void drop()
	{
	}
	// code moved because I can't make an object delete itself without using outside
	// method
	
	/**
     * Method: examine()
     * [What the method does]
     * @param none
     * @return nothing
     */
	@Override
	public void examine()
	{
		view.printString((healthEffect + ": " + itemDescLong), 125);
	}

	/**
     * Method: getDisplay()
     * [What the method does]
     * @param none
     * @return nothing
     */
	@Override
	public String getDisplay()
	{
		return itemName + "-> use, drop, examine:";
	}

	/**
     * Method: displayCommands()
     * [What the method does]
     * @param none
     * @return nothing
     */
	@Override
	public void displayCommands()
	{
		view.line(125);
		view.print(itemName);
		view.print("use:");
		view.print("drop:");
		view.print("examine:");
		view.print("exit:");
	}
}