public class Enemy extends Character
{
	private String enemyDescription;
	
	public Enemy()
	{
		super(// Things
				);
		this.enemyDescription = "";
	}

	public Enemy(int characterId, int health, int damage, int defense, boolean alive, String enemyDescription) 
	{
		//super(characterId, health, damage, defense, alive);
		// ^^^ I got an error here ^^^
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