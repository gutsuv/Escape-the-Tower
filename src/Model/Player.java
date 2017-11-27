package Model;

import java.util.*;
import View.View;
/**
 * Class: Player
 * @author Team Hydra
 * @version 1.0
 * Course: ITEC 3860, Fall 2017
 * Written: 
 * 
 * This class – now describe what the class does 
 * 
 * Purpose: – Describe the purpose of this class
 */
public class Player extends Character
{
	View view;
	private int maxAttack;
	private int minAttack;
	private ArrayList<Item> inventory = new ArrayList<Item>();
	private ArrayList<Gear> equippedItems = new ArrayList<Gear>();
	private boolean poisoned = false;
	
	/**
     * Method: Player()
     * Player constructor
     * @param view View object
     * @return nothing
     */
	public Player(View view)
	{
		health = 100;
		maxHealth = 100;
		minAttack = 0;
		defense = 0;
		acc = 100;
		alive = true;
		this.view = view;
	}

	/**
     * Method: Player()
     * Player constructor
     * @param health int value representing player health
     * @param minAttack int value representing player min attack
     * @param defense int value representing player defense
     * @param acc int value representing player accuracy
     * @param alive boolean value representing player alive status
     * @param view View object
     * @return nothing
     */
	public Player(int health, int minAttack, int defense, int acc, boolean alive, View view)
	{
		this.health = health;
		this.minAttack = minAttack;
		this.defense = defense;
		this.acc = acc;
		this.alive = alive;
		this.view = view;
	}
	
	/**
     * Method: displayStats()
     * Displays player stats
     * @param none
     * @return nothing
     */
	public void displayStats()
	{
		view.line(125);
		view.print("Health: " + health + "/" + maxHealth);
		view.print("Max Attack: " + maxAttack);
		view.print("Min Attack: " + minAttack);
		view.print("Defense: " + defense);
		view.print("Accuracy: " + acc + "/100");
	}

	/**
     * Method: updateStats()
     * Updates player stats
     * @param none
     * @return nothing
     */
	public void updateStats()
	{
		maxAttack = 0;
		minAttack = 0;
		defense = 0;
		acc = 100;
		
		for (int i = 0; i < equippedItems.size(); i++)
		{
			maxAttack = maxAttack + equippedItems.get(i).getAttackMax();
			minAttack = minAttack + equippedItems.get(i).getAttackMin();
			defense = defense + equippedItems.get(i).getDefense();
			acc = acc - equippedItems.get(i).getAcc();
		}
		
		if(poisoned)
		{
			minAttack = (minAttack*3)/4;
			maxAttack = (maxAttack*3)/4;
			defense = (defense*3)/4;
			acc = (acc*3)/4;
		}
		displayEquippedItems();
		displayStats();
	}

	/**
     * Method: dealDamage()
     * Updates player stats
     * @param none
     * @return int value representing damage
     */
	@Override
	public int dealDamage()
	{
		if ((Math.random() * 100) < acc)
		{
			return (int) (minAttack + (Math.random() * (1 + maxAttack - minAttack)));
		}
		else
		{
			return 0;
		}
	}

	/**
     * Method: updateMaxHealth()
     * Updates player max health
     * @param i int value representing update value
     * @return nothing
     */
	public void updateMaxHealth(int i)
	{
		maxHealth = maxHealth + i;
	}
	
	/**
     * Method: setMaxHealth()
     * Sets player max health
     * @param i int value representing max health
     * @return nothing
     */
	public void setMaxHealth(int i)
	{
		maxHealth = i;
	}
	
	/**
     * Method: setMaxHealth()
     * Sets player max health
     * @param i int value representing max health
     * @return nothing
     */
	public void setHealth(int i)
	{
		health = i;
	}
	
	/**
     * Method: setPoisoned()
     * Sets player poison
     * @param poison boolean value representing poison status
     * @return nothing
     */
	public void setPoisoned(boolean poison)
	{
		poisoned = poison;
	}
	
	/**
     * Method: isPoisoned()
     * Getter for poisoned
     * @param none
     * @return poisoned
     */
	public boolean isPoisoned()
	{
		return poisoned;
	}

	// Inventory Exists on player so methods for item based things exist here to
	// interact with player items.
	/**
     * Method: getInventory()
     * Getter for inventory
     * @param none
     * @return inventory
     */
	public ArrayList<Item> getInventory()
	{
		return inventory;
	}
	
	/**
     * Method: getEquippedItems()
     * Getter for equipped items
     * @param none
     * @return equippedItems
     */
	public ArrayList<Gear> getEquippedItems()
	{
		return equippedItems;
	}

	/**
     * Method: getItem()
     * Getter for item
     * @param none
     * @return inventory.get(i)
     */
	public Item getItem(int i)
	{
		return inventory.get(i);
	}
	
	/**
     * Method: removeItem()
     * Removes item from inventory
     * @param i int value representing item
     * @return nothing
     */
	public void removeItem(int i)
	{
		inventory.remove(i);
	}

	/**
     * Method: pickUp()
     * Adds item to inventory
     * @param item Item object
     * @return nothing
     */
	public void pickUp(Item item)
	{
		inventory.add(item);
	}

	/**
     * Method: drop()
     * Drops item
     * @param i int value representing item
     * @return nothing
     */
	public void drop(int i)
	{
		for (int j = 0; j < equippedItems.size(); j++)
		{
			if (inventory.get(i) == equippedItems.get(j))
			{
				unequip(j);
			}
		}
		inventory.remove(i);
	}

	/**
     * Method: equip()
     * Equips item
     * @param i int value representing item
     * @return nothing
     */
	public void equip(int i) throws Exception
	{
		equip(inventory.get(i));
	}

	/**
     * Method: equip()
     * Equips item
     * @param item Item object representing item
     * @return nothing
     */
	public void equip(Item item) throws Exception
	{
		for (int i = 0; i < equippedItems.size(); i++)
		{
			if (((Gear) item).getItemslot() == equippedItems.get(i).getItemslot())
			{
				if (equippedItems.get(i).getItemslot() != 'e')
				{
					unequip(i);
				}
			}
		}
		for (int i = 0; i < equippedItems.size(); i++)
		{
			if (equippedItems.get(i).getItemId() == item.getItemId())
			{
				unequip(i);
			}
		}
		((Gear) item).setEquipped(true);
		equippedItems.add((Gear) item);
		updateStats();
	}

	/**
     * Method: unequip()
     * Unequips item
     * @param i int value representing item
     * @return nothing
     */
	public void unequip(int i)
	{
		equippedItems.get(i).setEquipped(false);
		equippedItems.remove(i);
	}

	/**
     * Method: displayInventory()
     * Displays inventory
     * @param none
     * @return nothing
     */
	public void displayInventory()
	{
		view.line(125);
		view.print("Items");
		for (int i = 0; i < inventory.size(); i++)
		{
			view.print(i + ": " + inventory.get(i).getDisplay());
		}
		view.print("exit: ");
	}

	/**
     * Method: displayEquippedItems()
     * Displays equipped items
     * @param none
     * @return nothing
     */
	public void displayEquippedItems()
	{
		view.line(125);
		view.print(equippedItems);
	}
}