package Model;

import View.View;
/**
 * Class: Item
 * @author Team Hydra
 * @version 1.0
 * Course: ITEC 3860, Fall 2017
 * Written: November 20
 * 
 * This class stores and holds the functionality of items in the game.
 * 
 * Purpose: To contain the methods and attributes needed to create items.
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
     * Uses item
     * @param none
     * @return nothing
     */
	public abstract void use();

	/**
     * Method: drop()
     * Drops item
     * @param none
     * @return nothing
     */
	public abstract void drop();

	/**
     * Method: examine()
     * Examines item
     * @param none
     * @return nothing
     */
	public abstract void examine();

	/**
     * Method: getDisplay()
     * gets Display
     * @param none
     * @return nothing
     */
	public abstract String getDisplay();

	/**
     * Method: displayCommands()
     * Displays commands
     * @param none
     * @return nothing
     */
	public abstract void displayCommands();

	/**
     * Method: clone()
     * Clones object
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