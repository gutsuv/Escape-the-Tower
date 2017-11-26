package Controller;

import java.util.ArrayList;

import Model.Artifact;
import Model.Floor;
import Model.Player;

public class Controller
{

	ArrayList<Floor> floors;
	int inRoom = 1;
	int onFloor = 6;

	public int getOnFloor()
	{
		return onFloor;
	}

	public void setOnFloor(int onFloor)
	{
		this.onFloor = onFloor;
	}

	public int getInRoom()
	{
		return inRoom;
	}

	public void setInRoom(int inRoom)
	{
		this.inRoom = inRoom;
	}

	public Floor getFloor(int i)
	{
		for (Floor f : floors)
		{
			if (f.getId() == i)
			{
				return f;
			}
		}
		return null;
	}

	Player player = new Player();

	public String inventaryList()
	{
		String toRet = "";
		for (Artifact a : player.inventary)
		{
			toRet = toRet + "\n" + a.getName();
		}
		if (toRet.isEmpty())
		{
			return "There are no items in inventory";
		}
		return toRet;
	}

	public boolean use(String item)
	{
		for (Artifact a : player.inventary)
		{
			if (a.getName().equals(item))
			{
				// Use ti
				return true;
			}
		}
		return false;
	}

	public boolean drop(String item)
	{
		for (Artifact a : player.inventary)
		{
			if (a.getName().equals(item))
			{

				return true;
			}
		}
		return false;
	}

	public boolean pickup(Artifact item)
	{
		player.inventary.add(item);

		return true;
	}

	private Controller()
	{
		floors = new ArrayList<>();
		floors.add(new Floor(1));
		floors.add(new Floor(2));
		floors.add(new Floor(3));
		floors.add(new Floor(4));
		floors.add(new Floor(5));
		floors.add(new Floor(6));
		player.setAttackPoints(5);
		player.setHealthPoints(150);

		player.setDefencePoints(50);
		player.setMonsterScore(0);
		player.setGameScore(0);
	}

	public Player getPlayer()
	{
		return player;
	}

	public void setPlayerName(String name)
	{
		player.setPlayerName(name);
	}

	public void setPlayerGender(String gender)
	{
		player.setGender(gender);
	}

	private static Controller controller;

	public static Controller eInstance()
	{
		if (controller == null)
		{
			controller = new Controller();
		}
		return controller;
	}

}
