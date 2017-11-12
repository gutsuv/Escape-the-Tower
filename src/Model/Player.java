// Subclass
package Model;

import View.Console;

public class Player extends Character
{
	private Console view;

	private String playerName;
	private int position;
	private int door1Room;
	private int door2Room;
	private int door3Room;
	private int door4Room;
	private String puzzle;

	public Player() 
	{
		super(1, 100, 150, 0, false);
		this.playerName = "";
		this.position = 1;
	}

	public Player(String playerName, int position, int door1Room, int door2Room, int door3Room, int door4Room, int monsterScore, int puzzleScore, int gameScore)
	{
		this.playerName = playerName;
		this.position = position;
		this.door1Room = door1Room;
		this.door2Room = door2Room;
		this.door3Room = door3Room;
		this.door4Room = door4Room;
	}

	public String getPlayerName() 
	{
		return playerName;
	}

	public void setPlayerName(String playerName)
	{
		this.playerName = playerName;
	}

	public int getPlayerPosition()
	{
		return position;
	}

	public void setPlayerPosition(int position)
	{
		this.position = position;
	}

	public boolean isAlive() 
	{
		return alive;
	}

	public void setAlive(boolean alive) 
	{
		this.alive = alive;
	}

	public void retreat()
	{
		view.println("Retreating");
		System.exit(0);
	}

	public int getDoor1Room()
	{
		return door1Room;
	}

	public void setDoor1Room(int position) 
	{
		if (position == 1) 
		{
			this.door1Room = 2;
		}
		else if (position == 3) 
		{
			this.door1Room = 4;
		}
		else if (position == 5)
		{
			this.door1Room = 6;
		}
		else 
		{
			this.door1Room = position;
		}
	}

	public int getDoor2Room()
	{
		return door2Room;
	}

	public void setDoor2Room(int position)
	{
		if (position == 1) 
		{
			this.door2Room = 3;
		}
		else if (position == 3) 
		{
			this.door2Room = 5;
		}
		else if (position == 5)
		{
			this.door2Room = 7;
		}
		else 
		{
			this.door2Room = position;
		}
	}

	public int getDoor3Room() 
	{
		return door3Room;
	}


	public void setDoor3Room(int position)
	{
		if (position == 1) 
		{
			this.door3Room = 3;
		}
		else if (position == 3) 
		{
			this.door3Room = 5;
		}
		else if (position == 5)
		{
			this.door3Room = 7;
		}
		else 
		{
			this.door3Room = position;
		}
	}

	public int getDoor4Room() 
	{
		return door4Room;
	}

	public void setDoor4Room(int position) 
	{
		if (position == 1) 
		{
			this.door3Room = 3;
		}
		else if (position == 3) 
		{
			this.door3Room = 5;
		}
		else if (position == 5)
		{
			this.door3Room = 7;
		}
		else 
		{
			this.door3Room = position;
		}
	}

	public String getPuzzle()
	{
		return puzzle;
	}
}