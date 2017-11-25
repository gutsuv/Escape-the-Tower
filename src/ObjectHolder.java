import java.util.*;
import java.io.*;
import java.lang.reflect.Array;

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
		}
		catch (Exception E)
		{
			view.print("RoomsB didn't load:" + number);
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

	public void loadEnemys(File EnemyFile)
	{
		// loads a file formated like RoomsBEnemy.txt

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
					System.out.println("Text Spencer Williams to fix this. I might have messed up a TextFile."
							+ "I can fix it in like 30 minutes. Include RoomsBenemy or Load in the text message");
				}
			}
			buff.close();
		}
		catch (Exception E)
		{
			System.out.println("load error enemy");
		}
	}

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
					System.out.println("Text Spencer Williams to fix this. I might have messed up a TextFile."
							+ "I	 can fix it in like 30 minutes. Include RoomBItem or Load in the text message");
				}
			}
			buff.close();
		}
		catch (Exception E)
		{
			System.out.println("load error item");
		}
	}

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
					System.out.println("Text Spencer Williams to fix this. I might have messed up a TextFile."
							+ "I	 can fix it in like 30 minutes. Include RoomBPuzzle or Load in the text message");
				}
			}
			buff.close();
		}
		catch (Exception E)
		{
			System.out.println("load error puzzle");
		}
	}
	
	public void saveItems(String number) {
		try 
		{
			PrintWriter print = new PrintWriter("TextFiles/Save" + number + "/RoomsBEnemy.txt");
			
		} catch (FileNotFoundException e) 
		{
			view.print("Items Save fail");
		}
	}

	public void navigate(char direction) throws Exception
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

	public void setCurrentRoom(int i) throws Exception
	{
		previousRoom = currentRoom;
		currentRoom = rooms.get(i - 1);
		if(currentRoom.getPuzzle()!=null)
		{
			currentRoom.getPuzzle().initialize();
		}
		if (currentRoom.getRoomId() == 31)
		{
			view.print("You won");
			System.exit(0);
		}
		currentRoom.display();
	}

	public Room getCurrentRoom()
	{
		return currentRoom;
	}
	
	public Room getRoom(int i)
	{
		return rooms.get(i-1);
	}

	public Player getUser()
	{
		return user;
	}

	public View getView()
	{
		return view;
	}
}
