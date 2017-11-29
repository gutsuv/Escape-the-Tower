package Model;

import java.util.*;
import View.View;
/**
 * Class: Enemy
 * @author Team Hydra
 * @version 1.0
 * Course: ITEC 3860, Fall 2017
 * Written: 
 * 
 * This class stores and holds the functionality of Enemies in the game 
 * 
 * Purpose: – Purpose is to store variables related to enemies
 */
public class Enemy extends Character implements Cloneable
{
	private String name;
	private String enemyDesc;
	private int enemyId;
	protected int damage;
	View view;
	protected ArrayList<Item> item = new ArrayList<Item>();

	/**
     * Method: Enemy()
     * Enemy constructor
     * @param String loadedString string loaded from file
     * @param ReferenceIdentities library object
     * @return nothing
     */
	public Enemy(String loadedString, ReferenceIdentities library)
	{
		// loaded from file
		// int enemyId, String name, int health, int damage, int defense,
		// int acc, Item itemId, String enemyDescription
		try
		{
			String[] splitString = loadedString.split("-_");
			enemyId = Integer.parseInt(splitString[0]);
			name = splitString[1];
			health = Integer.parseInt(splitString[2]);
			maxHealth = health;
			damage = Integer.parseInt(splitString[3]);
			defense = Integer.parseInt(splitString[4]);
			acc = Integer.parseInt(splitString[5]);
			if (splitString[6].equalsIgnoreCase(""))
			{
				// No if statement?
			} 
			else
			{
				String[] ints = splitString[6].split("><");
				int i = ints.length;
				while (i > 0)
				{
					i--;
					item.add(library.cloneItem(Integer.parseInt(ints[i])));
				}
			}
			enemyDesc = splitString[7];

		} 
		catch (Exception E)
		{
			System.out.println("Text Spencer Williams to fix this. I might have messed up a TextFile."
					+ "I can fix it in like 30 minutes. Include Gear in the text message");
		}

	}

	/**
     * Method: getEnemyDesc()
     * Retrieves enemy description
     * @param none
     * @return enemyDesc String value representing enemy description
     */
	public String getEnemyDesc()
	{
		return enemyDesc;
	}

	/**
     * Method: getEnemyId()
     * Retrieves enemy ID
     * @param none
     * @return enemyId String value representing enemy ID
     */
	public int getEnemyId()
	{
		return enemyId;
	}

	/**
     * Method: setView()
     * Instantiates view object
     * @param view View object representing View object
     * @return nothing
     */
	public void setView(View view)
	{
		this.view = view;
	}

	/**
     * Method: display()
     * Displays enemy prompt
     * @param none
     * @return nothing
     */
	public void display()
	{
		view.line(125);
		view.print(name);
		view.printString(enemyDesc, 125);
		view.line();
		view.print("Attack:");
		view.print("Inventory:");
		view.print("Exit:");
	}

	/**
     * Method: getItems()
     * Retrieves items Arraylist
     * @param none
     * @return item ArrayList representing a list of items from enemy
     */
	public ArrayList<Item> getItems()
	{
		return item;
	}

	/**
     * Method: toString()
     * [What the method does]
     * @param none
     * @return String value representing...
     */
	@Override
	public String toString()
	{
		return "Enemy [" + name + ", " + enemyDesc + "]";
	}

	/**
     * Method: clone()
     * Clones super class
     * @param none
     * @return cloned super Object
     */
	protected Object clone() throws CloneNotSupportedException
	{
		return super.clone();
	}

	/**
     * Method: dealDamage()
     * Performs action of enemies doing damage
     * @param none
     * @return int value representing damage dealt
     */
	@Override
	public int dealDamage()
	{
		if ((Math.random() * 10) < acc)
		{
			return damage;
		} 
		else
		{
			return 0;
		}
	}
}