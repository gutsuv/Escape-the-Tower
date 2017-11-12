// Subclass
package Model;

public class Enemy extends Character
{	
	private String enemyDesc;
	
	public Enemy() 
	{
		super(2, 0, 0, 0, false);
		this.enemyDesc = "";
	}

	public Enemy(int characterId, int health, int damage, int defense, boolean alive)
	{
		super(characterId, health, damage, defense, alive);
		this.enemyDesc = enemyDesc;
	}

	public String getEnemyDesc()
	{
		return enemyDesc;
	}

	public void setEnemyDesc(String enemyDesc)
	{
		this.enemyDesc = enemyDesc;
	}
}