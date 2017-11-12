// Subclass
package Model;

import View.Console;

public class Player extends Character
{
	private Console view;

	private String playerName;
	private double position;
	private double door1Room;
	private double door2Room;
	private double door3Room;
	private double door4Room;
	private String puzzle;

	public Player() 
	{
		super(1, 100, 150, 0, false);
		this.playerName = "";
		this.position = 1;
	}

	public Player(String playerName, double position, double door1Room, double door2Room, double door3Room, double door4Room, int monsterScore, int puzzleScore, int gameScore)
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

	public double getPlayerPosition()
	{
		return position;
	}

	public void setPlayerPosition(double position)
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

	public double getDoor1Room()
	{
		return door1Room;
	}

	public void setDoor1Room(double position) 
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

	public double getDoor2Room()
	{
		return door2Room;
	}

	public void setDoor2Room(double position)
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

	public double getDoor3Room() 
	{
		return door3Room;
	}


	public void setDoor3Room(double position)
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

	public double getDoor4Room() 
	{
		return door4Room;
	}

	public void setDoor4Room(double position) 
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