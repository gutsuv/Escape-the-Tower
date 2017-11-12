public class Player extends Character
{
	private String playerName;

	public Player() 
	{
		super(
				// Things
				);	
		this.playerName = "";
	}

	public Player(int characterId, int health, int damage, int defense, boolean alive, String playerName) 
	{
		super(characterId, health, damage, defense, alive);
		this.playerName = playerName;
	}

	public String getPlayerName() 
	{
		return playerName;
	}

	public void setPlayerName(String playerName) 
	{
		this.playerName = playerName;
	}
	
	public void engage()
	{
		
	}
	
	public void retreat()
	{
		
	}
}