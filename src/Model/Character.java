package Model;

/**
 * Class: Character
 * @author Team Hydra
 * @version 1.0
 * Course: ITEC 3150
 * Written: January 22, 2017
 * 
 * This class stores and initializes the player's personal statistics
 * 
 * Purpose: Contains the attributes of the player's health, attack, defense, accuracy, and whether the player is alive
 */
public abstract class Character
{
	protected int health;
	protected int maxHealth;
	protected int defense;
	protected int acc;
	protected boolean alive = true;

	public abstract int dealDamage();

	/**
     * Method: receiveDamage(int damage)
     * Displays the action of a the player receiving damage
     * @param damage
     * @return nothing
     */
	
	public void receiveDamage(int damage)
	{
		health = health - damage;
		if (health > maxHealth)
		{
			health = maxHealth;
		}
		// if statement is for healing items doing negative damage

		if (health <= 0)
		{
			alive = false;
		}
	}


	/**
     * Method: getHealth()
     * Retrieves the player's current health
     * @param none
     * @return health 
     */	
	public int getHealth()
	{
		return health;
	}

	/**
     * Method: getMaxHealth()
     * Retrieves the player's maximum health
     * @param none
     * @return maxHealth 
     */	
	public int getMaxHealth()
	{
		return maxHealth;
	}
	/**
     * Method: getDefense()
     * Retrieves the player's current defense stat
     * @param none
     * @return defense 
     */	
	public int getDefense()
	{
		return defense;
	}
	/**
     * Method: isAlive()
     * Retrieves weather the player is alive or dead
     * @param none
     * @return alive 
     */	
	public boolean isAlive()
	{
		return alive;
	}
	/**
     * Method: setAlive()
     * Instantiates whether the player is dead or alive
     * @param alive
     * @return nothing
     */	
	public void setAlive(boolean alive)
	{
		this.alive = alive;
	}

	@Override
	public String toString()
	{
		return "";
	}
}