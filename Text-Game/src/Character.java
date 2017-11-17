
public class Character 
{
	protected int health;
	protected int damage;
	protected int defense;
	protected int acc;
	protected boolean alive;

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
		return "";
	}
}