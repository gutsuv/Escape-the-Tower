package Controller;

import java.util.ArrayList;
import java.util.Scanner;

import Model.*;
import View.Console;
public class Controller
{
	protected Console view;
	protected Model model;
	protected Scanner input = new Scanner(System.in);
	Player player = new Player();
	ConsumableContent consumable = new ConsumableContent();
	GearContent gear = new GearContent();
	EnemyContent enemy = new EnemyContent();
	PuzzleContent puzzle = new PuzzleContent();
	RoomContent room = new RoomContent();
	
	public Controller(Model model, Console view)
	{
		this.model = model;
		this.view = view;
	}
	
	
	public String printAndPrompt1(String q1, String q2)
	{
		view.println(q1);
		view.println(q2);
		return input.nextLine();
	}
	
	public boolean printAndPrompt2(String input)
	{
		while(true)
		{
			String userInput = printAndPrompt1(input, "Yes or No\n");
			if (userInput.equalsIgnoreCase("yes"))
			{
				return true;
			}
			else if (userInput.equalsIgnoreCase("no"))
			{
				return false;
			}
		}
	}
	
	protected String name;

	protected void newGame()
	{
		name = printAndPrompt1("Enter Name", " ");
		view.println("Hello " + name + "\n");

		view.println("Entrance Floor 6, Room 1\n");
		boolean start = printAndPrompt2("Start?\n");

		while (!start)
		{
			view.println("Intro");
			start = printAndPrompt2("________");
		}

		player = new Player();
		player.setCharacterId(1);
		player.setDamage(5);
		player.setHealth(100);
		player.setPlayerName(name);
		player.setPlayerPosition(11);

		room.getRoom(player.getPlayerPosition());


		view.println(MiscellaneousContent.displayDefaultMenu());
		displayRoomContent();
	}
	
	protected void mainMenu()
	{
		boolean mainMenu = true;

		while (mainMenu)
		{
			 
			String userInput = input.nextLine();

			if (userInput.equalsIgnoreCase("new game"))
			{
				mainMenu = false; 
				newGame();
			} 
			else if (userInput.equalsIgnoreCase("load game"))
			{
				mainMenu = false;
				//loadGame();
			} 
			else if (userInput.equalsIgnoreCase("help"))
			{
				mainMenu = false;
				displayHelpMenu();
			} 
			else if (userInput.equalsIgnoreCase("exit"))
			{
				mainMenu = false;
				exit();
			} 
			else
			{
				view.println("Invalid Input");
			}
		}
	}
	
	protected ArrayList<Item> inventory = new ArrayList<Item>();
	
	protected void displayRoomContent()
	{

		boolean roomText = true;

		while (roomText)
		{
			String userInput = input.nextLine();

			if (userInput.equalsIgnoreCase("examine"))
			{
				roomText = false;
				room.examineRoom(player.getPlayerPosition());
				view.println(MiscellaneousContent.displayDefaultMenu());
				displayRoomContent();

			} 
			else if (userInput.equalsIgnoreCase("move"))
			{

				roomText = false;
				move(player.getPlayerPosition());

			} 
			else if (userInput.equalsIgnoreCase("help"))
			{

				roomText = false;
				//help();

			} 
			else if (userInput.equalsIgnoreCase("pick up"))
			{

				roomText = false;
				//addItem(player.getPlayerPosition());

			}
			else if (userInput.equalsIgnoreCase("engage enemy"))
			{

				roomText = false;
				//engageEnemy(player.getPlayerPosition());

			} 
			else if (userInput.equalsIgnoreCase("puzzle"))
			{
				roomText = false;
				//displayPuzzle(player.getPlayerPosition());

			} 
			else if (userInput.equalsIgnoreCase("view inventory"))
			{
				
				roomText = false;
				view.print("Inventory Contents");

				for (int i = 0; i < inventory.size(); i++)
				{
					view.println(inventory.get(i).getItemName());
				}


				view.println(MiscellaneousContent.displayDefaultMenu());
				displayRoomContent();
			}
			else if (userInput.equalsIgnoreCase("exit"))
			{
				roomText = false;
				boolean endGame = printAndPrompt2("End game?");

				if (endGame)
				{
					exit();
				}
				else
				{
					view.println("Continue");
					view.println(MiscellaneousContent.displayDefaultMenu());
					displayRoomContent();
				}
			} 
			else
			{
				view.println("Invalid Command");
			}
		}
	}
	

	private void move(double position)
	{

		player.setDoor1Room((player.getPlayerPosition()));
		player.setDoor2Room(player.getPlayerPosition());
		player.setDoor3Room(player.getPlayerPosition());
		player.setDoor4Room(player.getPlayerPosition());

		int door1 = 0; 
		int door2 = 0; 
		int door3 = 0; 
		int door4 = 0;

		if (player.getDoor1Room() != 0)
		{
			door1 = 1;
		}
		if (player.getDoor2Room() != 0)
		{
			door2 = 1;
		}
		if (player.getDoor3Room() != 0)
		{
			door3 = 1;
		}
		if (player.getDoor4Room() != 0)
		{
			door4 = 1;
		}

		if (player.getDoor1Room() == player.getPlayerPosition())
		{
			door1 = 0;
		}
		if (player.getDoor2Room() == player.getPlayerPosition())
		{
			door2 = 0;
		}
		if (player.getDoor3Room() == player.getPlayerPosition())
		{
			door3 = 0;
		}
		if (player.getDoor4Room() == player.getPlayerPosition())
		{
			door4 = 0;
		}

		room.accessible(door1, door4, door3, door2, player.getPlayerPosition());

		view.print("What room to enter?");
		String userInput = input.nextLine();

		boolean direction = true;
		while (direction)
		{
			boolean locked = false;
			if ((userInput.equalsIgnoreCase("door1") && player.getDoor1Room() != player.getPlayerPosition()))
			{
				player.setPlayerPosition(player.getDoor1Room());
				direction = false;
			} 
			else if ((userInput.equalsIgnoreCase("door4") && player.getDoor4Room() != player.getPlayerPosition()))
			{
				if ((player.getPlayerPosition() == 21 && locked != true))
				{
					view.println("Door is locked");
					move(player.getPlayerPosition());
				} 
				else
				{	
					player.setPlayerPosition(player.getDoor4Room());
				}
				direction = false;
			} 
			else if ((userInput.equalsIgnoreCase("door3") && player.getDoor3Room() != player.getPlayerPosition()))
			{
				if ((player.getPlayerPosition() == 11 && locked != true) || (player.getPlayerPosition() == 31 && locked != true))
				{
					view.println("Door is locked");
					move(player.getPlayerPosition());
					
				} 
				else 
				{	
					player.setPlayerPosition(player.getDoor3Room()); 
				}
				
				direction = false;
			}
			else if ((userInput.equalsIgnoreCase("door2") && player.getDoor2Room() != player.getPlayerPosition()))
			{
				if ((player.getPlayerPosition() == 41 && locked != true))
				{
					view.println("Door is locked");
					move(player.getPlayerPosition());
				} 
				else 
				{	
					player.setPlayerPosition(player.getDoor2Room());
				}
				
				direction = false;
			} 
			else
			{
				view.println(userInput + "Can't go that way");
				room.accessible(door1, door4, door3, door2, player.getPlayerPosition());
				view.print("What room to enter?");
				userInput = input.nextLine();
			}
		}
		room.getRoom(player.getPlayerPosition());
		view.println(MiscellaneousContent.displayDefaultMenu());
		displayRoomContent();
	}
	
	protected void exit()
	{
		view.println("Ending");
		System.exit(1);
	}
	
	protected void displayHelpMenu()
	{
		view.println(MiscellaneousContent.help());
		boolean help = true;

		while (help)
		{
			view.println("Return with back");
			String userInput = input.nextLine();
			if (userInput.equalsIgnoreCase("back"))
			{
				help = false;
				view.println(MiscellaneousContent.displayDefaultMenu());
				mainMenu();
			}
		}
	}
}
