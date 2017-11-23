// Superclass

package Model;

import View.Console;

public class Character 
{
	protected Console view;

	protected int characterId;
	protected int health;
	protected int damage;
	protected int defense;
	protected int acc;
	protected boolean alive;
	
	public Character()
	{
		this.characterId = 0;
		this.health = 0;
		this.damage = 0;
		this.defense = 0;
		this.acc = 0;
		this.alive = true;
	}

	public Character(int characterId, int health, int damage, int defense, int acc, boolean alive)
	{
		this.characterId = characterId;
		this.health = health;
		this.damage = damage;
		this.defense = defense;
		this.acc = acc;
		this.alive = alive;
	}

	public int getCharacterId()
	{
		return characterId;
	}


	public void setCharacterId(int characterId)
	{
		this.characterId = characterId;
	}


	public int getHealth()
	{
		return health;
	}


	public void setHealth(int health)
	{
		this.health = health;
	}


	public int getDamage()
	{
		return damage;
	}


	public void setDamage(int damage)
	{
		this.damage = damage;
	}


	public int getDefense()
	{
		return defense;
	}


	public void setDefense(int defense)
	{
		this.defense = defense;
	}


	public boolean isAlive()
	{
		return alive;
	}


	public void setAlive(boolean alive)
	{
		this.alive = alive;
	}


	@Override
	public String toString()
	{
		return "Character [view=" + view + ", characterId=" + characterId + ", health=" + health + ", damage=" + damage
				+ ", defense=" + defense + ", alive=" + alive + "]";
	}
}