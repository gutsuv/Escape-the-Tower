package Classes;

public class Player extends Character
{
	private String playerName;

	public Player() 
	{
		playerName = "";
	}

	public Player(int characterId, int health, int damage, int defense, int acc, boolean alive, String playerName) 
	{
		super(characterId, health, damage, defense, acc, alive);
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