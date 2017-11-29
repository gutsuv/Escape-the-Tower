package Model;


/**
 * Class: Gear
 * @author Team Hydra
 * @version 1.0
 * Course: ITEC 3860, Fall 2017
 * Written: November 22
 * 
 * This class holds the functionality of items classified as gear or equipment
 * 
 * Purpose: The purpose is store the attributes of the weapons and armor found in the game
 */
public class Gear extends Item
{
	protected int defense;
	protected int attackMin;
	protected int attackMax;
	protected int acc;
	protected char itemslot;
	protected boolean equipped = false;
	
	/**
     * Method: Gear()
     * Gear Constructor
     * @param loadedString String value representing the information from text file
     * @return nothing
     */
	public Gear(String loadedString)
	{
		// loaded from file
		// int itemId, String itemName, char slot, int defense,
		// int attackMin, int attackMax,int acc,
		// String itemDescShort, String itemDescLong
		try
		{
			String[] splitString = loadedString.split("-_");
			itemId = Integer.parseInt(splitString[0]);
			itemName = splitString[1];
			itemslot = splitString[2].charAt(0);
			defense = Integer.parseInt(splitString[3]);
			attackMin = Integer.parseInt(splitString[4]);
			attackMax = Integer.parseInt(splitString[5]);
			acc = Integer.parseInt(splitString[6]);
			itemDescShort = splitString[7];
			itemDescLong = splitString[8];

		} 
		catch (Exception E)
		{
			System.out.println("Error");
		}
	}
	
	/**
     * Method: setEquipped()
     * Signifies whether an item is been equipped
     * @param equip boolean value representing whether an item is equipped
     * @return nothing
     */
	public void setEquipped(boolean equip)
	{
		equipped = equip;
	}
	
	/**
     * Method: getDefense()
     * Retrieves defense attribute
     * @param none
     * @return defense int value representing defense attribute
     */
	public int getDefense()
	{
		return defense;
	}

	/**
     * Method: getAttackMin()
     * Retrieves minimum attack attribute of item
     * @param none
     * @return attackMin int value representing minimum attack of item
     */
	public int getAttackMin()
	{
		return attackMin;
	}

	/**
     * Method: getAttackMax()
     * Retrieves maximum attack attribute of item
     * @param none
     * @return attackMax int value representing maximum attack of item
     */
	public int getAttackMax()
	{
		return attackMax;
	}

	/**
     * Method: getAcc()
     * Retrieves accuracy attribute of item
     * @param none
     * @return acc int value representing accuracy of item
     */
	public int getAcc()
	{
		return acc;
	}

	/**
     * Method: getItemslot()
     * Retrieves item slot number
     * @param none
     * @return itemslot chat value representing item slot
     */
	public char getItemslot()
	{
		return itemslot;
	}

	/**
     * Method: use()
     * Performs action of using item
     * @param none
     * @return nothing
     */
	@Override
	public void use()
	{
	}

	/**
     * Method: drop()
     * Performs action of dropping item
     * @param none
     * @return nothing
     */
	@Override
	public void drop()
	{
	}

	/**
     * Method: examine()
     * Prints item description
     * @param none
     * @return nothing
     */
	@Override
	public void examine()
	{
		if (itemslot == 'w')
		{
			view.printString(itemName + ", MinDamage " + attackMin + ", MaxDamage " + attackMax + ", Accuracy " + acc
					+ ", " + itemDescLong,125);
		} 
		else
		{
			view.printString(itemName + ", Armor " + defense + ", " + itemDescLong,125);
		}
	}

	/**
     * Method: getDisplay()
     * Displays gear prompt
     * @param none
     * @return String value representing a display for gear
     */
	@Override
	public String getDisplay()
	{
		if(equipped)
		{
			return "[Equipped]" + itemName + "-> equip, drop, examine:";
		}
		return "[Gear]" + itemName + "-> equip, drop, examine:";
	}
	
	/**
     * Method: toString()
     * Converts everything to string
     * @param none
     * @return String value representing a display for gear
     */
	@Override
	public String toString()
	{
		if(equipped)
		{
			return "[Equipped] Gear [" + itemName + ", " + itemDescShort + "]";
		}
		return "Gear [" + itemName + ", " + itemDescShort + "]";
	}
	
	/**
     * Method: displayCommands()
     * Displays command for gear
     * @param none
     * @return nothing
     */
	@Override
	public void displayCommands()
	{
		view.line(125);
		view.print(itemName);
		
		if(equipped)
		{
			view.print("[equipped]");
		}
		
		if(itemslot=='w') 
		{
			view.print("Max Damage " + attackMax + 
					", Min Damage " + attackMin +
					", Accuracy, " + (100-acc));
		}
		
		else 
		{
			view.print("Armor " + defense);
		}
		
		if(equipped == false)
		{
			view.print("equip:");
		}
		
		view.print("drop:");
		view.print("examine:");
		view.print("exit:");
	}
}