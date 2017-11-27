/**
 * Class: Character
 * @author Team Hydra
 * @version 1.0
 * Course: ITEC 3860, Fall 2017
 * Written: 
 * 
 * This class – now describe what the class does 
 * 
 * Purpose: – Describe the purpose of this class
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
     * Method: receiveDamage()
     * [What the method does]
     * @param damage int value representing...
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
     * [What the method does]
     * @param none
     * @return health int value representing...
     */
	public int getHealth()
	{
		return health;
	}

	/**
     * Method: getMaxHealth()
     * [What the method does]
     * @param none
     * @return maxHealth int value representing...
     */
	public int getMaxHealth()
	{
		return maxHealth;
	}

	/**
     * Method: getDefense()
     * [What the method does]
     * @param none
     * @return defense int value representing...
     */
	public int getDefense()
	{
		return defense;
	}

	/**
     * Method: isAlive()
     * [What the method does]
     * @param none
     * @return defense boolean value representing...
     */
	public boolean isAlive()
	{
		return alive;
	}

	/**
     * Method: setAlive()
     * [What the method does]
     * @param alive boolean value representing...
     * @return nothing
     */
	public void setAlive(boolean alive)
	{
		this.alive = alive;
	}

	/**
     * Method: toString()
     * [What the method does]
     * @param none
     * @return nothing
     */
	@Override
	public String toString()
	{
		return "";
	}
}