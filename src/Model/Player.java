// Subclass
package Model;

import View.Console;

public class Player extends Character
{
	private Console view;

	private String playerName;
	private double position;
	private double northRoom;
	private double eastRoom;
	private double southRoom;
	private double westRoom;
	private String puzzle;


	public Player() 
	{
		super(1, 15, 150, 0, false);
		this.playerName = "";
		this.position = 1;
	}

	public Player(String playerName, double position, double northRoom, double eastRoom, double southRoom, double westRoom, int monsterScore, int puzzleScore, int gameScore)
	{
		this.playerName = playerName;
		this.position = position;
		this.northRoom = northRoom;
		this.eastRoom = eastRoom;
		this.southRoom = southRoom;
		this.westRoom = westRoom;
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

	public double getNorthRoom()
	{
		return northRoom;
	}

	public void setNorthRoom(double position) 
	{
		if (position == 1) 
		{
			this.northRoom = 2;
		}
		else if (position == 3) 
		{
			this.northRoom = 4;
		}
		else if (position == 5)
		{
			this.northRoom = 6;
		}
		else 
		{
			this.northRoom = position;
		}
	}

	public double getEastRoom()
	{
		return eastRoom;
	}

	public void setEastRoom(double position)
	{
		if (position == 1) 
		{
			this.eastRoom = 3;
		}
		else if (position == 3) 
		{
			this.eastRoom = 5;
		}
		else if (position == 5)
		{
			this.eastRoom = 7;
		}
		else 
		{
			this.eastRoom = position;
		}
	}

	public double getSouthRoom() 
	{
		return southRoom;
	}


	public void setSouthRoom(double position)
	{
		if (position == 1) 
		{
			this.southRoom = 3;
		}
		else if (position == 3) 
		{
			this.southRoom = 5;
		}
		else if (position == 5)
		{
			this.southRoom = 7;
		}
		else 
		{
			this.southRoom = position;
		}
	}

	public double getWestRoom() 
	{
		return westRoom;
	}

	public void setWestRoom(double position) 
	{
		if (position == 1) 
		{
			this.southRoom = 3;
		}
		else if (position == 3) 
		{
			this.southRoom = 5;
		}
		else if (position == 5)
		{
			this.southRoom = 7;
		}
		else 
		{
			this.southRoom = position;
		}
	}

	public String getPuzzle()
	{
		return puzzle;
	}
}