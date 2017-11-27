import javafx.scene.control.Button;

/**
 * Class: Gear
 * @author Team Hydra
 * @version 1.0
 * Course: ITEC 3860, Fall 2017
 * Written: 
 * 
 * This class – now describe what the class does 
 * 
 * Purpose: – Describe the purpose of this class
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
     * [What the method does]
     * @param loadedString String value representing...
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
			System.out.println("Text Spencer Williams to fix this. I might have messed up a TextFile."
					+ "I can fix it in like 30 minutes. Include Gear in the text message");
		}

	}
	
	/**
     * Method: setEquipped()
     * [What the method does]
     * @param equip boolean value representing...
     * @return nothing
     */
	public void setEquipped(boolean equip)
	{
		equipped = equip;
	}
	
	/**
     * Method: getDefense()
     * [What the method does]
     * @param none
     * @return defense int value representing defense
     */
	public int getDefense()
	{
		return defense;
	}

	/**
     * Method: getAttackMin()
     * [What the method does]
     * @param none
     * @return attackMin int value representing minimum attack
     */
	public int getAttackMin()
	{
		return attackMin;
	}

	/**
     * Method: getAttackMin()
     * [What the method does]
     * @param none
     * @return attackMax int value representing maximum attack
     */
	public int getAttackMax()
	{
		return attackMax;
	}

	/**
     * Method: getAcc()
     * [What the method does]
     * @param none
     * @return acc int value representing accuracy
     */
	public int getAcc()
	{
		return acc;
	}

	/**
     * Method: getItemslot()
     * [What the method does]
     * @param none
     * @return itemslot chat value representing item slot
     */
	public char getItemslot()
	{
		return itemslot;
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

	/**
     * Method: examine()
     * [What the method does]
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
     * [What the method does]
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
     * [What the method does]
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
     * [What the method does]
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