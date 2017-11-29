package Model;

import java.util.*;
import java.io.*;
import java.lang.reflect.Array;
import View.View;
/**
 * Class: ObjectHolder
 * @author Team Hydra
 * @version 1.0
 * Course: ITEC 3860, Fall 2017
 * Written: 
 * 
 * This class holds almost all data related to the game.
 * 
 * Purpose: This class is responsible for making class to class interactions easy and possible
 */
public class ObjectHolder
{
	View view;

	ArrayList<Room> rooms = new ArrayList<Room>();
	File file;
	Scanner fileread;
	Player user;

	Room currentRoom;
	Room previousRoom;
	ReferenceIdentities library = new ReferenceIdentities();

	/**
     * Method: ObjectHolder()
     * Constructor
     * @param v View object
     * @return nothing
     */
	public ObjectHolder(View v) throws FileNotFoundException
	{
		view = v;
		file = new File("TextFiles/RoomsA.txt");
		fileread = new Scanner(file);
		int i = 0;
		
		while (fileread.hasNextLine())
		{
			try
			{
				rooms.add(new Room(fileread.nextLine()));
				rooms.get(i).setView(view);
				// rooms.get(i).display();
				i++;
			}
			catch (Exception E)
			{
				System.out.println("error " + i);
			}
		}
		
		fileread.close();
		library.setLibray(library);
		library.loaditems();
		library.loadEnemys();
		library.loadPuzzles();
	}

	/**
     * Method: initializeNew()
     * Loads room information
     * @param none
     * @return nothing
     */
	public void initializeNew()
	{
		// load new game
		currentRoom = rooms.get(0);
		try
		{
			File file = new File("TextFiles/RoomsBEnemy.txt");
			loadEnemys(file);
			file = new File("TextFiles/RoomsBItem.txt");
			loadItems(file);
			file = new File("TextFiles/RoomsBPuzzle.txt");
			loadPuzzles(file);
			file = new File("TextFiles/Intro.txt");
			BufferedReader buff = new BufferedReader(new FileReader(file));
			while(buff.ready())
			{
				view.print(buff.readLine());
			}
		}
		catch (Exception E)
		{
			view.print("RoomsB didn't load");
		}
		user = new Player(view);
		// after load
		try
		{
			currentRoom.display();
		}
		catch (Exception e)
		{
		}
	}
	
	/**
     * Method: initializeLoad()
     * Loads game
     * @param none
     * @return nothing
     */
	public void initializeLoad(String number)
	{
		// load new game
		currentRoom = rooms.get(0);
		try
		{
			File file = new File("TextFiles/Save" + number + "/RoomsBEnemy.txt");
			loadEnemys(file);
			file = new File("TextFiles/Save" + number + "/RoomsBItem.txt");
			loadItems(file);
			file = new File("TextFiles/Save" + number + "/RoomsBPuzzle.txt");
			loadPuzzles(file);
			user = new Player(view);
			file = new File("TextFiles/Save" + number + "/PlayerHealth.txt");
			loadPlayer(file);
			file = new File("TextFiles/Save" + number + "/Inventory.txt");
			loadInventory(file);
			file = new File("TextFiles/Save" + number + "/Equipped Items.txt");
			loadEquippedItems(file);
			user.updateStats();
			file = new File("TextFiles/Save" + number + "/CurrentRoom.txt");
			loadCurrentRoom(file);
		}
		catch (Exception E)
		{
			view.print("Didn't load properly: Save" + number);
		}
		
	}
	
	// Load Methods
	
	/**
     * Method: loadCurrentRoom()
     * Loads current room
     * @param CurrentRoom File object
     * @return nothing
     */
	public void loadCurrentRoom(File CurrentRoom)
	{
		// loads a file formatted with one number
		try
		{
			BufferedReader buff = new BufferedReader(new FileReader(CurrentRoom));
			setCurrentRoom(Integer.parseInt(buff.readLine()));
			buff.close();
		}
		
		catch(Exception E)
		{
			view.print("load error CurrentRoom");
		}
	}
	
	/**
     * Method: loadPlayer()
     * Loads player information
     * @param Player File object
     * @return nothing
     */
	public void loadPlayer(File Player)
	{
		// loads a file formatted with player health
		try
		{
			BufferedReader buff = new BufferedReader(new FileReader(Player));
			user.setMaxHealth(Integer.parseInt(buff.readLine()));
			user.setHealth(Integer.parseInt(buff.readLine()));
			user.setPoisoned(Boolean.parseBoolean(buff.readLine()));
			buff.close();
		}
		catch(Exception E)
		{
			view.print("load error PlayerHealth");
		}
	}
	
	/**
     * Method: loadInventory()
     * Loads inventory information
     * @param Inventory File object
     * @return nothing
     */
	public void loadInventory(File Inventory)
	{
		// loads a file formatted item Ids
		try
		{
			BufferedReader buff = new BufferedReader(new FileReader(Inventory));
			while(buff.ready())
			{
				user.pickUp(library.cloneItem(Integer.parseInt(buff.readLine())));
			}
			buff.close();
		}
		catch(Exception E)
		{
			view.print("load error CurrentRoom");
		}
	}
	
	/**
     * Method: loadEquippedItems()
     * Loads equipped items
     * @param Equipped File object
     * @return nothing
     */
	public void loadEquippedItems(File Equipped)
	{
		// loads a file formatted with item Ids
		try
		{
			BufferedReader buff = new BufferedReader(new FileReader(Equipped));
			while(buff.ready())
			{
				int itemId = Integer.parseInt(buff.readLine());
				for(int i = 0; i < user.getInventory().size(); i++)
				{
					if(itemId==user.getItem(i).getItemId())
					{
						user.equipNoPrint(i);
					}
				}
			}
			buff.close();
		}
		catch(Exception E)
		{
			view.print("load error CurrentRoom");
		}
	}
	
	/**
     * Method: loadEnemys()
     * Loads enemy
     * @param EnemyFile File object
     * @return nothing
     */
	public void loadEnemys(File EnemyFile)
	{
		// loads a file formatted like RoomsBEnemy.txt

		try
		{
			BufferedReader buff = new BufferedReader(new FileReader(EnemyFile));
			buff.readLine();
			String loadedString;
			int i = 0;
			while (buff.ready())
			{
				try
				{
					loadedString = buff.readLine();
					if (!loadedString.matches("."))
					{
						rooms.get(i).setEnemy(library.cloneEnemy(Integer.parseInt(loadedString)));
					}
					i++;
				}
				catch (Exception E)
				{
					System.out.println("Error");
				}
			}
			buff.close();
		}
		catch (Exception E)
		{
			System.out.println("load error enemy");
		}
	}

	/**
     * Method: loadItems()
     * Loads items
     * @param ItemFile File object
     * @return nothing
     */
	public void loadItems(File ItemFile)
	{
		// loads a file formated like RoomsBEnemy.txt

		try
		{
			BufferedReader buff = new BufferedReader(new FileReader(ItemFile));
			buff.readLine();
			String loadedString;
			int i = 0;
			while (buff.ready())
			{
				// int ItemId
				try
				{
					loadedString = buff.readLine();
					if (!loadedString.matches("."))
					{
						try
						{
							rooms.get(i).addItem(library.cloneItem(Integer.parseInt(loadedString)));
						}
						catch (Exception E)
						{
							String[] splitString = loadedString.split("><");
							for (int j = 0; j < splitString.length; j++)
							{
								rooms.get(i).addItem(library.cloneItem(Integer.parseInt(splitString[j])));
							}
						}
					}
					i++;
				}
				catch (Exception E)
				{
					System.out.println("Error");
				}
			}
			buff.close();
		}
		catch (Exception E)
		{
			System.out.println("load error item");
		}
	}

	/**
     * Method: loadPuzzles()
     * Loads puzzles
     * @param PuzzleFile File object
     * @return nothing
     */
	public void loadPuzzles(File PuzzleFile)
	{
		// loads a file formated like RoomsBPuzzle.txt

		try
		{
			BufferedReader buff = new BufferedReader(new FileReader(PuzzleFile));
			String loadedString;
			int i = 0;
			while (buff.ready())
			{
				// int ItemId

				try
				{
					loadedString = buff.readLine();
					if (!loadedString.matches("."))
					{

						try
						{
							rooms.get(i).setPuzzle(library.clonePuzzle(Integer.parseInt(loadedString)));
							if (rooms.get(i).getPuzzle() instanceof DoorPuzzle)
							{
								((DoorPuzzle) rooms.get(i).getPuzzle()).setLockedRoom(rooms);
							}
							else if (rooms.get(i).getPuzzle() instanceof PuzzleRiddle)
							{
								((PuzzleRiddle) rooms.get(i).getPuzzle()).setLockedRoom(rooms);
							}
							else if (rooms.get(i).getPuzzle() instanceof PuzzleNumber)
							{
								((PuzzleNumber) rooms.get(i).getPuzzle()).setLockedRoom(rooms);
							}
						}
						catch (Exception E)
						{

						}
					}
					i++;
				}
				catch (Exception E)
				{
					System.out.println("Error");
				}
			}
			buff.close();
		}
		catch (Exception E)
		{
			System.out.println("load error puzzle");
		}
	}
	
	// Save Methods
	
	/**
     * Method: saveItems()
     * Saves items
     * @param number String value representing item
     * @return nothing
     */
	public void saveItems(String number) 
	{
		try 
		{
			PrintWriter writer = new PrintWriter("TextFiles/Save" + number + "/RoomsBItem.txt");
			writer.println();
			
			for(int i = 0;i < rooms.size(); i++)
			{
				if(rooms.get(i).getItems().size()==0)
				{
					writer.println(".");
				}
				else
				{
					String itemString = "";
					for(int j = 0; j < rooms.get(i).getItems().size();j++)
					{
						itemString = itemString + rooms.get(i).getItems().get(j).getItemId();
						
						if(rooms.get(i).getItems().size()!=j)
						{
							itemString = itemString + "><";
						}
					}
					writer.println(itemString);
				}
			}
			
			writer.close();
		}
		catch (Exception e) 
		{
			view.print("Item Save fail");
		}
	}
	
	/**
     * Method: saveEnemys()
     * Saves enemies
     * @param number String value representing enemy
     * @return nothing
     */
	public void saveEnemys(String number)
	{
		try 
		{
			PrintWriter writer = new PrintWriter(
					"TextFiles/Save" + number + "/RoomsBEnemy.txt");
			writer.println();
			for(int i = 0;i < rooms.size(); i++)
			{
				if(rooms.get(i).getEnemy()==null)
				{
					writer.println(".");
				}
				else
				{
					if(rooms.get(i).getEnemy().getEnemyId()<10)
					{
						writer.println("0" + rooms.get(i).getEnemy().getEnemyId());
					}
					else
					{
						writer.println(rooms.get(i).getEnemy().getEnemyId());
					}
				}
			}
			
			writer.close();
		} 
		catch (Exception e) 
		{
			view.print("Enemys Save fail");
		}
	}
	
	/**
     * Method: saveCurrentLocation()
     * Saves current location
     * @param number String value representing enemy
     * @return nothing
     */
	public void saveCurrentLocation(String number)
	{
		try 
		{
			PrintWriter writer = new PrintWriter(
					"TextFiles/Save" + number + "/CurrentRoom.txt");
			writer.print(currentRoom.getRoomId());
			writer.close();
		} catch (Exception e) 
		{
			view.print("CurrentLocation Save fail");
		}
	}
	
	/**
     * Method: savePlayerHealth()
     * Saves player health
     * @param number String value representing health
     * @return nothing
     */
	public void savePlayerHealth(String number)
	{
		try 
		{
			PrintWriter writer = new PrintWriter(
					"TextFiles/Save" + number + "/PlayerHealth.txt");
			writer.println(user.getMaxHealth());
			writer.println(user.getHealth());
			writer.print(user.isPoisoned());
			writer.close();
		} 
		catch (Exception e) 
		{
			view.print("Player Health Save fail");
		}
	}
	
	/**
     * Method: saveInventory()
     * Saves inventory
     * @param number String value representing inventory
     * @return nothing
     */
	public void saveInventory(String number)
	{
		try 
		{
			PrintWriter writer = new PrintWriter(
					"TextFiles/Save" + number + "/Inventory.txt");
			for(int i = 0; i < user.getInventory().size(); i++)
			{
				writer.println(user.getInventory().get(i).getItemId());
			}
			writer.close();
		} 
		catch (Exception e) 
		{
			view.print("Inventory Save fail");
		}
	}
	
	/**
     * Method: saveEquippedItems()
     * Saves equipped items
     * @param number String value representing equipped item
     * @return nothing
     */
	public void saveEquippedItems(String number)
	{
		try 
		{
			PrintWriter writer = new PrintWriter(
					"TextFiles/Save" + number + "/Equipped Items.txt");
			for(int i = 0; i < user.getEquippedItems().size(); i++)
			{
				writer.println(user.getEquippedItems().get(i).getItemId());
			}
			writer.close();
		}
		catch (Exception e) 
		{
			view.print("Equipped Items Save fail");
		}
	}
	
	/**
     * Method: savePuzzles()
     * Saves puzzles
     * @param number String value representing puzzle
     * @return nothing
     */
	public void savePuzzles(String number) 
	{
		try 
		{
			PrintWriter writer = new PrintWriter(
					"TextFiles/Save" + number + "/RoomsBPuzzle.txt");
			
			for(int i = 0;i < rooms.size(); i++)
			{
				if(rooms.get(i).getPuzzle()==null)
				{
					writer.println(".");
				}
				else
				{
					if(rooms.get(i).getPuzzle().getPuzzleID()<10)
					{
						writer.println("0" + rooms.get(i).getPuzzle().getPuzzleID());
					}
					else
					{
						writer.println(rooms.get(i).getPuzzle().getPuzzleID());
					}
				}
			}
			
			writer.close();
		} 
		catch (Exception e) 
		{
			view.print("Puzzle Save fail");
		}
	}

	/**
     * Method: navigate()
     * Allows for navigation
     * @param direction chat value representing direction
     * @return nothing
     */
	public void navigate(char direction)
	{
		int i = currentRoom.getDirections().length;
		while (i > 0)
		{
			i--;
			if (direction == currentRoom.getDirection(i))
			{
				if (rooms.get(currentRoom.getExit(i) - 1).isLocked())
				{
					view.print("locked");
				}
				else if (currentRoom.getEnemy() != null)
				{
					if (previousRoom.getRoomId() == currentRoom.getExit(i))
					{
						setCurrentRoom(currentRoom.getExit(i));
					}
					else
					{
						view.print("Exit Obstructed by enemy");
					}
				}
				else
				{
					setCurrentRoom(currentRoom.getExit(i));
				}
			}
		}
	}

	/**
     * Method: setCurrentRoom()
     * Setter for current room
     * @param i int value representing current room
     * @return nothing
     */
	public void setCurrentRoom(int i)
	{
		previousRoom = currentRoom;
		currentRoom = rooms.get(i - 1);
		if(currentRoom.getPuzzle()!=null)
		{
			if(currentRoom.getPuzzle() instanceof PuzzleDebuff) 
			{
				((PuzzleDebuff)currentRoom.getPuzzle()).initialize(user);
			}
			else
			{
				currentRoom.getPuzzle().initialize();
			}
		}
		if (currentRoom.getRoomId() == 31)
		{
			view.print("\r\n" + 
					"	 ╔═╗╔═╗╔╗╔╔═╗╦═╗╔═╗╔╦╗╦ ╦╦  ╔═╗╔╦╗╦╔═╗╔╗╔╔═╗\r\n" + 
					"	 ║  ║ ║║║║║ ╦╠╦╝╠═╣ ║ ║ ║║  ╠═╣ ║ ║║ ║║║║╚═╗\r\n" + 
					"	 ╚═╝╚═╝╝╚╝╚═╝╩╚═╩ ╩ ╩ ╚═╝╩═╝╩ ╩ ╩ ╩╚═╝╝╚╝╚═╝");
			view.print("	+-------------------------------------------+");
			view.print("	|    No foe was a match for your strength   |");
			view.print("	| You have completed the tower and escaped. |");
			view.print("	+-------------------------------------------+");
			view.line();
			view.print("	           Back to the main menu...");
			view.line();
			int exit = 1/0;
		}
		
		try
		{
			currentRoom.display();
		}
		
		catch(Exception E)
		{	
		}
	}

	/**
     * Method: getCurrentRoom()
     * Getter for current room
     * @param none
     * @return currentRoom
     */
	public Room getCurrentRoom()
	{
		return currentRoom;
	}
	
	/**
     * Method: getRoom()
     * Getter for room
     * @param none
     * @return rooms.get(i-1)
     */
	public Room getRoom(int i)
	{
		return rooms.get(i-1);
	}

	/**
     * Method: getRoom()
     * Getter for player
     * @param none
     * @return user
     */
	public Player getUser()
	{
		return user;
	}

	/**
     * Method: getView()
     * Getter for view
     * @param none
     * @return user
     */
	public View getView()
	{
		return view;
	}
}
