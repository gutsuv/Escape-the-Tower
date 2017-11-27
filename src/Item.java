import javafx.scene.control.Button;

/**
 * Class: Item
 * @author Team Hydra
 * @version 1.0
 * Course: ITEC 3860, Fall 2017
 * Written: 
 * 
 * This class – now describe what the class does 
 * 
 * Purpose: – Describe the purpose of this class
 */
public abstract class Item implements Cloneable, Comparable<Item>
{
	protected int itemId;
	protected String itemName;
	protected String itemDescLong;
	protected String itemDescShort;
	protected View view;

	/**
     * Method: getItemId()
     * Getter for item ID
     * @param none
     * @return itemId int value representing item ID
     */
	public int getItemId()
	{
		return itemId;
	}

	/**
     * Method: getItemName()
     * Getter for item name
     * @param none
     * @return itemName String value representing item name
     */
	public String getItemName()
	{
		return itemName;
	}

	/**
     * Method: getItemDesc()
     * Getter for long item description
     * @param none
     * @return itemDescLong String value representing long item description
     */
	public String getItemDesc()
	{
		return itemDescLong;
	}

	/**
     * Method: getItemDescShort()
     * Getter for short item description
     * @param none
     * @return itemDescShort String value representing short item description
     */
	public String getItemDescShort()
	{
		return itemDescShort;
	}

	/**
     * Method: setView()
     * Setter for view
     * @param view View object
     * @return nothing
     */
	public void setView(View view)
	{
		this.view = view;
	}

	/**
     * Method: use()
     * [What the method does]
     * @param none
     * @return nothing
     */
	public abstract void use();

	/**
     * Method: drop()
     * [What the method does]
     * @param none
     * @return nothing
     */
	public abstract void drop();

	/**
     * Method: examine()
     * [What the method does]
     * @param none
     * @return nothing
     */
	public abstract void examine();

	/**
     * Method: getDisplay()
     * [What the method does]
     * @param none
     * @return nothing
     */
	public abstract String getDisplay();

	/**
     * Method: displayCommands()
     * [What the method does]
     * @param none
     * @return nothing
     */
	public abstract void displayCommands();

	/**
     * Method: clone()
     * [What the method does]
     * @param none
     * @return clone
     */
	protected Object clone() throws CloneNotSupportedException
	{
		return super.clone();
	}

	/**
     * Method: toString()
     * Displays item information
     * @param none
     * @return String showing item
     */
	@Override
	public String toString()
	{
		return "Item [" + itemName + ", " + itemDescShort + "]";
	}

	/**
     * Method: compareTo()
     * Compares items
     * @param none
     * @return int value
     */
	@Override
	public int compareTo(Item o)
	{
		if (itemId > o.getItemId())
		{
			return 1;
		}
		else if (itemId < o.getItemId())
		{
			return -1;
		}
		else
		{
			return 0;
		}
	}
}