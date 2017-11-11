package Controller;

import Model.*;
import View.Console;
import java.util.*;

public class Controller
{	
	protected Console view;
	protected Model model;
	
	protected String name;
	protected Player player;
	protected String puzzleInput;
	protected ArrayList<Item> inventory = new ArrayList<Item>();
	
	protected Scanner input = new Scanner(System.in);

	public Controller(Model model, Console view)
	{
		this.model = model;
		this.view = view;
	}

	ConsumableContent consumable = new ConsumableContent();
	GearContent gear = new GearContent();
	EnemyContent enemy = new EnemyContent();
	PuzzleContent puzzle = new PuzzleContent();
	RoomContent room = new RoomContent();

	String[] consumableName = consumable.getConsumableName();
	String[] consumableDesc = consumable.getConsumableDesc();
	String[] gearName = gear.getGearName();
	String[] gearDesc = gear.getGearDesc();
	String[] enemyName = enemy.getEnemyName();
	String[] enemyDesc = enemy.getEnemyDescs();

	Consumable con1 = new Consumable(1, consumableName[0], consumableDesc[0], 1,0);
	Consumable con2 = new Consumable(2, consumableName[1], consumableDesc[1], 2,0);
	Consumable con3 = new Consumable(3, consumableName[2], consumableDesc[2], 3, 0);
	Gear g11 = new Gear(1, gearName[0], gearDesc[0], 1, 0, 0, "");
	Gear g21 = new Gear(2, gearName[1], gearDesc[1], 2, 0, 0, "");
	Gear g31 = new Gear(3, gearName[2], gearDesc[2], 3, 0, 0, "");
	Gear key11 = new Gear(4, gearName[4], gearDesc[4], 5, 0, 0, ""); 
	Gear key21 = new Gear(5, gearName[5], gearDesc[5], 6, 0, 0, ""); 
	Gear key31 = new Gear(6, gearName[6], gearDesc[6], 7, 0, 0, ""); 

	Item[] items = {con1, con2, con3, g11, g21, g31, key11, key21, key31};

	//Enemy e1 = new Enemy(1, 45, 75, false, 1, enemyName[0], enemyDesc[0]);
	//Enemy e2 = new Enemy(2, 15, 100, false, 2, enemyName[1], enemyDesc[1]);
	//Enemy e3 = new Enemy(3, 25, 30, false, 3, enemyName[2], enemyDesc[2]);
	//Enemy[] enemy = {e1, e2, e3};

	HashMap<Double, Integer> enemyMap = new HashMap<Double, Integer>();
	HashMap<Double, Integer> gearMap = new HashMap<Double, Integer>();
	HashMap<Double, Integer> itemMap = new HashMap<Double, Integer>();
	
	protected void mainMenu()
	{
		boolean mainMenu = true;

		while (mainMenu)
		{
			 
			String userInput = input.nextLine();

			if (userInput.equalsIgnoreCase("start") || userInput.equalsIgnoreCase("new") || userInput.equalsIgnoreCase("new game") || userInput.equalsIgnoreCase("start a new game"))
			{
				mainMenu = false; 
				newGame();

			} 
			else if (userInput.equalsIgnoreCase("help") || userInput.equalsIgnoreCase("help menu"))
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
	
	protected void newGame()
	{
		name = prompt("Enter Name ", "Name");
		view.println("Hello " + name);

		view.println("Entrance");
		boolean begin = twoOptionPrompt("Start");

		while (!begin)
		{
			view.println("______");
			begin = twoOptionPrompt("________");
		}

		player = new Player();
		player.setCharacterId(1);
		player.setDamage(2);
		player.setHealth(23);
		player.setPlayerName(name);
		player.setPlayerPosition(1);

		room.getRoom(player.getPlayerPosition());


		view.println(MiscellaneousContent.displayDefaultMenu());
		displayRoomContent();
	}

	protected void displayRoomContent()
	{

		boolean roomText = true;

		while (roomText)
		{
			String userInput = input.nextLine();

			if (userInput.equalsIgnoreCase("examine") || userInput.equalsIgnoreCase("examine room"))
			{
				roomText = false;
				room.examineRoom(player.getPlayerPosition());
				view.println(MiscellaneousContent.displayDefaultMenu());
				displayRoomContent();

			} 
			else if (userInput.equalsIgnoreCase("change room") || userInput.equalsIgnoreCase("move"))
			{

				roomText = false;
				move(player.getPlayerPosition());

			} 
			else if (userInput.equalsIgnoreCase("help") || userInput.equalsIgnoreCase("help menu"))
			{

				roomText = false;
				//help();

			} 
			else if (userInput.equalsIgnoreCase("pick up") || userInput.equalsIgnoreCase("pick up item") || userInput.equalsIgnoreCase("item"))
			{

				roomText = false;
				addItem(player.getPlayerPosition());

			}
			else if (userInput.equalsIgnoreCase("combat") || userInput.equalsIgnoreCase("Engage Enemy"))
			{

				roomText = false;
				engageEnemy(player.getPlayerPosition());

			} 
			else if (userInput.equalsIgnoreCase("puzzle") || userInput.equalsIgnoreCase("view puzzle"))
			{
				roomText = false;
				displayPuzzle(player.getPlayerPosition());

			} 
			else if (userInput.equalsIgnoreCase("inventory") || userInput.equalsIgnoreCase("view inventory"))
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
				boolean endGame = twoOptionPrompt("End game?");

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

	boolean occupied1 = false;
	boolean occupied2 = false;
	boolean occupied3 = false;
	boolean occupied4 = false;
	boolean occupied5 = false;
	boolean occupied6 = false;

	private void addItem(double roomID)
	{
		gearMap.put(1.0, 1);
		gearMap.put(2.0, 0);
		gearMap.put(3.0, 2);


		if ((player.getPlayerPosition() == 1.0 && occupied1 == true)
				|| (player.getPlayerPosition() == 2.0 && occupied1 == true)
				|| (player.getPlayerPosition() == 3.0 && occupied1 == true))
		{
			view.println("No Item");
			view.println(MiscellaneousContent.displayDefaultMenu());
			displayRoomContent();
		}
		if (gearMap.containsKey(player.getPlayerPosition()))
		{
			if (player.getPlayerPosition() == 1.0 && occupied1 != true)
			{
				addItem();
				occupied1 = true;
			}
			if (player.getPlayerPosition() == 2.0 && occupied1 != true)
			{
				addItem();
				occupied1 = true;
			}
			if (player.getPlayerPosition() == 3.0 && occupied1 != true)
			{
				addItem();
				occupied1 = true;
			}
			if (player.getPlayerPosition() == 4.0 && occupied1 != true)
			{
				addItem();
				occupied1 = true;
			}
			if (player.getPlayerPosition() == 5.0 && occupied1 != true)
			{
				addItem();
				occupied1 = true;
			}
			view.println(MiscellaneousContent.displayDefaultMenu());
			displayRoomContent();
		}
		
		else if (!gearMap.containsKey(player.getPlayerPosition()) || !itemMap.containsKey(player.getPlayerPosition()))
		{
			view.println("No Item");
			view.println(MiscellaneousContent.displayDefaultMenu());
			displayRoomContent();
		}
	}


	public void addItem()
	{
		view.println(items[itemMap.get(player.getPlayerPosition())].getItemName() + " added to inventory");
		inventory.add(items[itemMap.get(player.getPlayerPosition())]);
	}

	private void engageEnemy(double roomID)
	{
		enemyMap.put(15.0, 0);
		enemyMap.put(34.0, 5);
		enemyMap.put(7.0, 1);

		if (roomID == 1 || roomID == 2 || roomID == 3)
		{

			view.println("No Enemy");
			view.println(MiscellaneousContent.displayDefaultMenu());
			displayRoomContent();

		} 
		else
		{
			//view.println(enemy[enemyMap.get(player.getPlayerPosition())].getEnemyDescription());
			combatOptions();
		}
	}

	private void combatOptions()
	{

		view.println(MiscellaneousContent.displayCombatMenu());
		 
		String userInput = input.nextLine();

		switch (userInput.toLowerCase())
		{
		case "attack":
			view.println(MiscellaneousContent.displayCombatMenu());
			attack();
			break;
			
		case "dodge":
			//dodge();
			break;

		case "run":
			retreat();
			break;

		default:
		{
			while (!(userInput.equalsIgnoreCase("attack") || userInput.equalsIgnoreCase("dodge") || userInput.equalsIgnoreCase("run")))
			{
				view.println("Invalid input");
				combatOptions();
			}
			break;
		}

		}
		view.println(MiscellaneousContent.displayCombatMenu());
		userInput = input.nextLine();
		combatOptions();
	}

	private void attack()
	{
		String userInput = input.nextLine();

		switch (userInput.toLowerCase())
		{
		
			case "attack":
				//useWeapon();
				break;
	
			default:
			{
	
				while (!userInput.equalsIgnoreCase("attack"))
				{
					view.println("Invalid Input");
					view.println(MiscellaneousContent.displayCombatMenu());
					attack();
				}
				break;
			}
		}
	}

	/*private void useWeapon()
	{
		//gearMap.put("weapon1", 0);
		//gearMap.put("weapon2", 1);
		//gearMap.put("weapon3", 2);s
		try
		{
			if (inventory.isEmpty())
			{
				view.println("No Weapon");
				// combatOptions();
				view.println(MiscellaneousContent.displayCombatMenu());
				attack();
			} 
			else
			{
				view.print("Select Weapon");
				for (int i = 0; i < inventory.size(); i++)
				{
					view.print("[" + inventory.get(i).getItemName() + "]");
				}
				 
				String userInput = input.nextLine();
				userInput = userInput.toLowerCase();

				if (userInput.equalsIgnoreCase("weapon1") || userInput.equalsIgnoreCase("weapon2") || userInput.equalsIgnoreCase("weapon3") || userInput.equalsIgnoreCase("weapon4") || userInput.equalsIgnoreCase("weapon5"))
				{
					view.println("You Attack " + enemy[enemyMap.get(player.getPlayerPosition())].getEnemyName());
					enemy[enemyMap.get(player.getPlayerPosition())].setHealth(enemy[enemyMap.get(player.getPlayerPosition())].getHealth() - weapon[gearMap.get(userInput)].getDamage());

					if (enemy[enemyMap.get(player.getPlayerPosition())].getHealth() > 0)
					{
						view.println("Your Health: " + player.getHealth());
						view.println(enemy[enemyMap.get(player.getPlayerPosition())].getEnemyName() + "'s HP: " + enemy[enemyMap.get(player.getPlayerPosition())].getHealth());
						view.println(enemy[enemyMap.get(player.getPlayerPosition())].getEnemyName() + " attacks");
						player.setHealth(player.getHealth() - enemy[enemyMap.get(player.getPlayerPosition())].getDamage());

						if (player.getHealth() > 0)
						{
							view.println("Your Health: " + player.getHealth());
							view.println(enemy[enemyMap.get(player.getPlayerPosition())].getEnemyName() + "'s HP: " + enemy[enemyMap.get(player.getPlayerPosition())].getHealth());
							combatOptions();
						} 
						else
						{
							int floor;
							view.println(enemy[enemyMap.get(player.getPlayerPosition())].getEnemyName() + " knocks you out");

							if (player.getPlayerPosition() < 2.0)
							{
								floor = 1;
								player.setPlayerPosition(1);
								view.println("Floor 1");
							} 
							else if (player.getPlayerPosition() < 3.0)
							{
								floor = 2;
								player.setPlayerPosition(2);
								view.println("Floor 2");
							} 
							else if (player.getPlayerPosition() < 4.0)
							{
								floor = 3;
								player.setPlayerPosition(3);
								view.println("Floor 3");
							} 
							else
							{
								floor = 4;
								player.setPlayerPosition(4);
								view.println("Floor 4");
							}
							player.setHealth(100);

							view.println(MiscellaneousContent.displayDefaultMenu());
							displayRoomContent();
						}

					} 
					else
					{
						int floor;
						int roomNum;
						view.println(enemy[enemyMap.get(player.getPlayerPosition())].getEnemyName() + " eliminates you");
						view.println("You eliminated "+ enemy[enemyMap.get(player.getPlayerPosition())].getEnemyName());
						if (player.getPlayerPosition() == 1.0)
						{
							view.println("Pick up enemy item");
							itemMap.put(1.101, 12);
							addItem();
						}
						if (player.getPlayerPosition() == 2.0)
						{
							view.println("Pick up enemy item");
							itemMap.put(1.101, 13);
							addItem();
						}
						if (player.getPlayerPosition() == 3.0)
						{
							view.println("Pick up enemy item");
							itemMap.put(1.101, 14);
							addItem();
						}
						if (player.getPlayerPosition() == 4.0)
						{
							view.println("Pick up enemy item");
							itemMap.put(1.101, 15);
							addItem();
						}

						if (player.getPlayerPosition() < 2.0)
						{
							floor = 1;
						}
						else if (player.getPlayerPosition() < 3.0)
						{
							floor = 2;
						}
						else if (player.getPlayerPosition() < 4.0)
						{
							floor = 3;
						}
						else
						{
							floor = 4;
						}

						if (player.getPlayerPosition() == 1.0 || player.getPlayerPosition() == 2.0 || player.getPlayerPosition() == 3.0)
						{
							roomNum = 10;
						}
						else
						{
							roomNum = (int) ((player.getPlayerPosition() * 10) % 10);
						}

						view.println("Floor: " + floor + " Room: " + roomNum);

						view.println(MiscellaneousContent.displayDefaultMenu());
						displayRoomContent();
					}
				}
				else
				{
					view.println("Invalid");
					useWeapon();
				}
			}
		} 
		catch (InterruptedException ie)
		{
			ie.printStackTrace();
		}

	}*/


	/*private void dodge()
	{
		try
		{
			view.println("Dodge Successful");
			view.println("Your Health: " + player.getHealth());
			view.println(enemy[enemyMap.get(player.getPlayerPosition())].getEnemyName() + "'s HP: " + enemy[enemyMap.get(player.getPlayerPosition())].getHealth());
			combatOptions();
		} 
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
	}*/

	private void retreat()
	{
		int floor;
		int roomNum;

		if (player.getPlayerPosition() < 2.0)
		{
			floor = 1;
		}
		else if (player.getPlayerPosition() < 3.0)
		{
			floor = 2;
		}
		else if (player.getPlayerPosition() < 4.0)
		{
			floor = 3;
		}
		else
			floor = 4;

		if (player.getPlayerPosition() == 1.0 || player.getPlayerPosition() == 2.0 || player.getPlayerPosition() == 3.0)
		{
			roomNum = 10;
		}
		else
		{
			roomNum = (int) ((player.getPlayerPosition() * 10) % 10);
		}

		view.println("You escape combat");

		view.println("Floor: " + floor + " Room: " + roomNum);

		view.println(MiscellaneousContent.displayDefaultMenu());
		displayRoomContent();
	}

	boolean itemPresent = false;
	boolean locked = false;
	
	boolean solved1 = false;
	boolean solved2 = false;
	boolean solved3 = false;
	boolean solved4 = false;
	boolean solved5 = false;

	private void displayPuzzle(double position)
	{
		HashMap<Double, Integer> puzzleMap = new HashMap<Double, Integer>();
		puzzleMap.put(1.0, 10);
		puzzleMap.put(2.0, 11);
		puzzleMap.put(3.0, 12);
		puzzleMap.put(4.0, 6);
		puzzleMap.put(5.0, 1);
		puzzleMap.put(6.0, 2);


		if (player.getPlayerPosition() == 1.0 && solved1 == false)
		{
			puzzle.setPuzzleDesc((puzzleMap.get(player.getPlayerPosition())));
			view.println(puzzle.getPuzzleDesc());
			puzzleInput = input.nextLine();
			checkPuzzleInput(puzzleInput);
		}

		else if (player.getPlayerPosition() == 2.0 && solved1 == false)
		{
			puzzle.setPuzzleDesc(puzzleMap.get(player.getPlayerPosition()));
			view.println(puzzle.getPuzzleDesc());
			puzzleInput = input.nextLine();
			checkPuzzleInput(puzzleInput);
		}

		else if (player.getPlayerPosition() == 3.0 && solved1 == false)
		{
			puzzle.setPuzzleDesc(puzzleMap.get(player.getPlayerPosition()));
			view.println(puzzle.getPuzzleDesc());
			puzzleInput = input.nextLine();
			checkPuzzleInput(puzzleInput);
		}

		else if (player.getPlayerPosition() == 4.0 && solved1 == false)
		{
			puzzle.setPuzzleDesc(puzzleMap.get(player.getPlayerPosition()));
			view.println(puzzle.getPuzzleDesc());
			puzzleInput = input.nextLine();
			checkPuzzleInput(puzzleInput);
		}

		else if (player.getPlayerPosition() == 5.0 && solved1 == false)
		{
			puzzle.setPuzzleDesc(puzzleMap.get(player.getPlayerPosition()));
			view.println(puzzle.getPuzzleDesc());
			puzzleInput = input.nextLine();
			checkPuzzleInput(puzzleInput);
		}

		else if (player.getPlayerPosition() == 6.0 && solved1 == false)
		{
			puzzle.setPuzzleDesc(puzzleMap.get(player.getPlayerPosition()));
			view.println(puzzle.getPuzzleDesc());
			puzzleInput = input.nextLine();
			checkPuzzleInput(puzzleInput);
		}

		else if (player.getPlayerPosition() == 7.0 && solved1 == false)
		{
			puzzle.setPuzzleDesc(puzzleMap.get(player.getPlayerPosition()));
			view.println(puzzle.getPuzzleDesc());
			puzzleInput = input.nextLine();
			checkPuzzleInput(puzzleInput);
		}
		else
		{
			view.println("\n\n\t\t[There is no puzzles to be solved!]");
			view.println(MiscellaneousContent.displayDefaultMenu());
			displayRoomContent();
		}
	}

	private void checkPuzzleInput(String puzzleInput)
	{
		if (puzzleInput.equalsIgnoreCase(puzzle.puzzleAnswer1))
		{
			solved1 = true;
			view.println(MiscellaneousContent.displayDefaultMenu());
			displayRoomContent();
		}

		if (puzzleInput.equalsIgnoreCase(puzzle.puzzleAnswer1))
		{
			solved1 = true;
			view.println(MiscellaneousContent.displayDefaultMenu());
			displayRoomContent();
		}

		if (puzzleInput.equalsIgnoreCase(puzzle.puzzleAnswer1))
		{
			solved1 = true;
			view.println(MiscellaneousContent.displayDefaultMenu());
			displayRoomContent();
		}

		if (puzzleInput.equalsIgnoreCase(puzzle.puzzleAnswer1))
		{
			solved1 = true;
			view.println(MiscellaneousContent.displayDefaultMenu());
			displayRoomContent();
		}

		if (puzzleInput.equalsIgnoreCase(puzzle.puzzleAnswer1))
		{
			solved1 = true;
			view.println(MiscellaneousContent.displayDefaultMenu());
			displayRoomContent();
		}

		if (puzzleInput.equalsIgnoreCase(puzzle.puzzleAnswer1))
		{
			solved1 = true;
			view.println(MiscellaneousContent.displayDefaultMenu());
			displayRoomContent();
		}

		if (puzzleInput.equalsIgnoreCase(puzzle.puzzleAnswer1))
		{
			solved1 = true;
			view.println(MiscellaneousContent.displayDefaultMenu());
			displayRoomContent();
		}

		else
		{
			if (!puzzleInput.equalsIgnoreCase("exit"))
			{
				view.println(MiscellaneousContent.invalidPuzzleInput());
				displayPuzzle(player.getPlayerPosition());
				puzzleInput = input.nextLine();
			}
			if (puzzleInput.equalsIgnoreCase("exit"))
			{
				view.println(MiscellaneousContent.displayDefaultMenu());
				displayRoomContent();
			}
		}
	}

	private void move(double position)
	{

		player.setNorthRoom(player.getPlayerPosition());
		player.setEastRoom(player.getPlayerPosition());
		player.setSouthRoom(player.getPlayerPosition());
		player.setWestRoom(player.getPlayerPosition());

		int north = 0; 
		int east = 0; 
		int south = 0; 
		int west = 0;

		if (player.getNorthRoom() != 0)
		{
			north = 1;
		}
		if (player.getEastRoom() != 0)
		{
			east = 1;
		}
		if (player.getSouthRoom() != 0)
		{
			south = 1;
		}
		if (player.getWestRoom() != 0)
		{
			west = 1;
		}

		if (player.getNorthRoom() == player.getPlayerPosition())
		{
			north = 0;
		}
		if (player.getWestRoom() == player.getPlayerPosition())
		{
			west = 0;
		}
		if (player.getSouthRoom() == player.getPlayerPosition())
		{
			south = 0;
		}
		if (player.getEastRoom() == player.getPlayerPosition())
		{
			east = 0;
		}

		room.accessible(north, west, south, east, player.getPlayerPosition());

		view.print("What room to enter?");
		String userInput = input.nextLine();

		boolean direction = true;
		while (direction)
		{
			if ((userInput.equalsIgnoreCase("north") && player.getNorthRoom() != player.getPlayerPosition()))
			{
				player.setPlayerPosition(player.getNorthRoom());
				direction = false;
			} 
			else if ((userInput.equalsIgnoreCase("west") && player.getWestRoom() != player.getPlayerPosition()))
			{
				if ((player.getPlayerPosition() == 2.0 && locked != true))
				{
					view.println("Door is locked");
					move(player.getPlayerPosition());
				} 
				else
				{	
					player.setPlayerPosition(player.getWestRoom());
				}
				direction = false;
			} 
			else if ((userInput.equalsIgnoreCase("south") && player.getSouthRoom() != player.getPlayerPosition()))
			{
				if ((player.getPlayerPosition() == 1.0 && locked != true) || (player.getPlayerPosition() == 3.0 && locked != true))
				{
					view.println("Door is locked");
					move(player.getPlayerPosition());
					
				} 
				else 
				{	
					player.setPlayerPosition(player.getSouthRoom()); 
				}
				
				direction = false;
			}
			else if ((userInput.equalsIgnoreCase("east") && player.getEastRoom() != player.getPlayerPosition()))
			{
				if ((player.getPlayerPosition() == 4.0 && locked != true))
				{
					view.println("Door is locked");
					move(player.getPlayerPosition());
				} 
				else 
				{	
					player.setPlayerPosition(player.getEastRoom());
				}
				
				direction = false;
			} 
			else
			{
				view.println(userInput + "Can't go that way");
				room.accessible(north, west, south, east, player.getPlayerPosition());
				view.print("What room to enter?");
				userInput = input.nextLine();
			}
		}
		room.getRoom(player.getPlayerPosition());
		view.println(MiscellaneousContent.displayDefaultMenu());
		displayRoomContent();
	}

	protected void accessFloor()
	{
		boolean back = true;
		while (back)
		{
			String userInput = input.nextLine();
			if (userInput.equalsIgnoreCase("access"))
			{
				back = false;
				view.print("Input password");
				//checkPassword();
			}
			else if (userInput.equalsIgnoreCase("back"))
			{
				back = false;
				view.println("back");
				if (player.getPlayerPosition() > 1.0 && player.getPlayerPosition() < 2.0)
				{
					view.println("");
				}
				else if (player.getPlayerPosition() > 2.0 && player.getPlayerPosition() < 3.0)
				{
					view.println("");
				}
				else if (player.getPlayerPosition() > 3.0 && player.getPlayerPosition() < 4.0)
				{
					view.println("");
				}
				view.println(MiscellaneousContent.displayDefaultMenu());
				displayRoomContent();
			} 
			else
				view.println("");
		}
	}
	
	protected void exit()
	{
		view.println("Ending");
		System.exit(1);
	}


	public String prompt(String question, String prompt)
	{
		view.println(question);
		view.print(prompt);
		return input.nextLine();
	}


	public boolean twoOptionPrompt(String prompt)
	{
		while (true)
		{
			String userInput = prompt(prompt, "Yes or No");
			if (userInput.equalsIgnoreCase("yes") || userInput.equalsIgnoreCase("y"))
			{
				return true;
			}
			else if (userInput.equalsIgnoreCase("no") || userInput.equalsIgnoreCase("n"))
			{
				return false;
			}
			view.println("Yes or No");
		}
	}
}
