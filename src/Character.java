
public abstract class Character
{
	protected int health;
	protected int maxHealth;
	protected int defense;
	protected int acc;
	protected boolean alive = true;

	public abstract int dealDamage();

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

	public int getHealth()
	{
		return health;
	}

	public int getMaxHealth()
	{
		return maxHealth;
	}

	public int getDefense()
	{
		return defense;
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