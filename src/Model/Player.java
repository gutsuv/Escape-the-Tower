// Subclass
package Model;

import View.Console;

public class Player extends Character
{
	private Console view;

	protected String playerName;
	protected int position;
	protected int exit1Room;
	protected int exit2Room;
	protected int exit3Room;
	protected int exit4Room;
	protected int exit5Room;
	protected String puzzle;

	public Player() 
	{
		super(1, 100, 150, 0, 100, true);
		playerName = "";
		position = 30;
		exit1Room = 0;
		exit2Room = 0;
		exit3Room = 0;
		exit4Room = 0;
		exit5Room = 0;
		puzzle = "";
		
	}

	public Player(String playerName, int position, int exit1Room, int exit2Room, int exit3Room, int exit4Room, int exit5Room, int monsterScore, int puzzleScore, int gameScore)
	{
		this.playerName = playerName;
		this.position = position;
		this.exit1Room = exit1Room;
		this.exit2Room = exit2Room;
		this.exit3Room = exit3Room;
		this.exit4Room = exit4Room;
		this.exit5Room = exit5Room;
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

	public int getExit1Room()
	{
		return exit1Room;
	}

	public void setExit1Room(int position) 
	{
		if (position == 1) 
		{
			this.exit1Room = 2;
		}
		else if (position == 3) 
		{
			this.exit1Room = 4;
		}
		else if (position == 5)
		{
			this.exit1Room = 6;
		}
		else 
		{
			this.exit1Room = position;
		}
	}

	public int getExit2Room()
	{
		return exit2Room;
	}

	public void setExit2Room(int position)
	{
		if (position == 1) 
		{
			this.exit2Room = 3;
		}
		else if (position == 3) 
		{
			this.exit2Room = 5;
		}
		else if (position == 5)
		{
			this.exit2Room = 7;
		}
		else 
		{
			this.exit2Room = position;
		}
	}

	public int getExit3Room() 
	{
		return exit3Room;
	}


	public void setExit3Room(int position)
	{
		if (position == 1) 
		{
			this.exit3Room = 3;
		}
		else if (position == 3) 
		{
			this.exit3Room = 5;
		}
		else if (position == 5)
		{
			this.exit3Room = 7;
		}
		else 
		{
			this.exit3Room = position;
		}
	}

	public int getExit4Room() 
	{
		return exit4Room;
	}

	public void setExit4Room(int position) 
	{
		if (position == 1) 
		{
			this.exit4Room = 3;
		}
		else if (position == 3) 
		{
			this.exit4Room = 5;
		}
		else if (position == 5)
		{
			this.exit4Room = 7;
		}
		else 
		{
			this.exit4Room = position;
		}
	}
	
	public int getExit5Room() 
	{
		return exit5Room;
	}

	public void setExit5Room(int position) 
	{
		if (position == 1) 
		{
			this.exit5Room = 3;
		}
		else if (position == 3) 
		{
			this.exit5Room = 5;
		}
		else if (position == 5)
		{
			this.exit5Room = 7;
		}
		else 
		{
			this.exit5Room = position;
		}
	}

	public String getPuzzle()
	{
		return puzzle;
	}
}