// Subclass
package Model;

public class Enemy extends Character
{	
	private String enemyDesc;
	
	public Enemy() 
	{
		super(2, 0, 0, 0, 0, false);
		enemyDesc = "";
	}

	public Enemy(int characterId, int health, int damage, int defense, int acc, boolean alive, String enemyDesc)
	{
		super(characterId, health, damage, defense, acc, alive);
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