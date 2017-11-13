package Classes;

public class Enemy extends Character
{
	private String enemyDescription;
	
	public Enemy()
	{
		enemyDescription = "";
	}

	public Enemy(int characterId, int health, int damage, int defense, int acc, boolean alive, String enemyDescription) 
	{
		super(characterId, health, damage, defense, acc, alive);
		this.enemyDescription = enemyDescription;
	}

	public String getEnemyDescription()
	{
		return enemyDescription;
	}

	public void setEnemyDescription(String enemyDescription) 
	{
		this.enemyDescription = enemyDescription;
	}

	@Override
	public String toString() 
	{
		return enemyDescription;
	}
}