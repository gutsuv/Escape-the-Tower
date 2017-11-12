package Classes;

public class Character 
{
	protected int characterId;
	protected int health;
	protected int damage;
	protected int defense;
	protected boolean alive;

	public Character() 
	{
		this.characterId = 0;
		this.health = 0;
		this.damage = 0;
		this.defense = 0;		
		this.alive = false;
	}

	public Character(int characterId, int health, int damage, int defense, boolean alive) 
	{
		this.characterId = characterId;
		this.health = health;
		this.damage = damage;
		this.defense = defense;
		this.alive = false;
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

	public boolean getAlive() 
	{
		return alive;
	}
	
	public void setAlive(boolean alive) 
	{
		this.alive = alive;
	}
	
	public void attack()
	{
		
	}
	}