import java.io.*;
import java.util.*;

public class ReferenceIdentities
{
	ReferenceIdentities library;
	ArrayList<Item> items = new ArrayList<Item>();
	ArrayList<Enemy> enemys = new ArrayList<Enemy>();
	ArrayList<Puzzle> puzzles = new ArrayList<Puzzle>();
	File file;
	Scanner fileread;
	View itemView = new View();
	View enemyView = new View();
	View puzzleView = new View();
	// redundant views are for if classes are changed to accomadate unforseen
	// changes in requirements
	// the unforeseen requirements probably do not include view

	public Item cloneItem(int i) throws Exception
	{
		return (Item) getItem(i).clone();
	}

	// this method clones an item
	public Item getItem(int i) throws Exception
	{
		for (int j = 0; j < items.size(); j++)
		{
			if (items.get(j).getItemId() == i)
			{
				return items.get(j);
			}
		}
		return null;
	}
	// the method searches for an item based off of item Id

	public Enemy cloneEnemy(int i) throws Exception
	{
		return (Enemy) getEnemy(i).clone();
	}

	// this method clones an enemy
	public Enemy getEnemy(int i) throws Exception
	{
		for (int j = 0; j < items.size(); j++)
		{
			if (enemys.get(j).getEnemyId() == i)
			{
				return enemys.get(j);
			}
		}
		return null;
	}
	// the method searches for an enemy based off of enemy Id

	public Puzzle clonePuzzle(int i) throws Exception
	{
		return (Puzzle) getPuzzle(i).clone();
	}

	// this method clones an item
	public Puzzle getPuzzle(int i) throws Exception
	{
		for (int j = 0; j < puzzles.size(); j++)
		{
			if (puzzles.get(j).getPuzzleID() == i)
			{
				return puzzles.get(j);
			}
		}
		return null;
	}
	// the method searches for an puzzle based off of puzzle Id

	public void loaditems() throws FileNotFoundException
	{
		loadGearItems();
		loadConsumables();
		loadPuzzleItems();
	}

	public void loadEnemys() throws FileNotFoundException
	{
		loadEnemyTable();
	}

	public void loadPuzzles() throws FileNotFoundException
	{
		loadDoorPuzzles();
		loadObjectPuzzles();
		loadWordPuzzles();
		loadNumberPuzzles();
		loadPuzzleRiddle();
		loadPuzzleDebuff();
	}

	// item load methods
	private void loadGearItems() throws FileNotFoundException
	{
		file = new File("TextFiles/Gear.txt");

		try
		{
			BufferedReader buff = new BufferedReader(new FileReader(file));
			buff.readLine();
			while (buff.ready())
			{
				items.add(new Gear(buff.readLine()));
				items.get(items.size() - 1).setView(itemView);
			}
			buff.close();
		}
		catch (Exception E)
		{
			System.out.println("error");
		}
	}

	private void loadConsumables() throws FileNotFoundException
	{
		file = new File("TextFiles/Consumable.txt");

		try
		{
			BufferedReader buff = new BufferedReader(new FileReader(file));
			buff.readLine();
			while (buff.ready())
			{
				items.add(new Consumable(buff.readLine()));
				items.get(items.size() - 1).setView(itemView);
			}
			buff.close();
		}
		catch (Exception E)
		{
			System.out.println("error");
		}
	}

	private void loadPuzzleItems() throws FileNotFoundException
	{
		file = new File("TextFiles/PuzzleItem.txt");

		try
		{
			BufferedReader buff = new BufferedReader(new FileReader(file));
			buff.readLine();
			while (buff.ready())
			{
				items.add(new PuzzleItem(buff.readLine()));
				items.get(items.size() - 1).setView(itemView);
			}
			buff.close();
		}
		catch (Exception E)
		{
			System.out.println("error");
		}
	}

	// enemy load methods
	private void loadEnemyTable() throws FileNotFoundException
	{
		file = new File("TextFiles/EnemyTable.txt");

		try
		{
			BufferedReader buff = new BufferedReader(new FileReader(file));
			buff.readLine();
			while (buff.ready())
			{
				enemys.add(new Enemy(buff.readLine(), library));
				enemys.get(enemys.size() - 1).setView(enemyView);
			}
			buff.close();
		}
		catch (Exception E)
		{
			System.out.println("error");
		}
	}

	// Puzzle load methods
	private void loadDoorPuzzles() throws FileNotFoundException
	{
		file = new File("TextFiles/PuzzleDoor.txt");

		try
		{
			BufferedReader buff = new BufferedReader(new FileReader(file));
			buff.readLine();
			while (buff.ready())
			{
				puzzles.add(new DoorPuzzle(buff.readLine()));
				puzzles.get(puzzles.size() - 1).setView(puzzleView);
				// System.out.println(puzzles.get(puzzles.size()-1));
			}
			buff.close();
		}
		catch (Exception E)
		{
			System.out.println("error");
		}
	}

	private void loadObjectPuzzles() throws FileNotFoundException
	{
		file = new File("TextFiles/ObjectPuzzle.txt");

		try
		{
			BufferedReader buff = new BufferedReader(new FileReader(file));
			buff.readLine();
			while (buff.ready())
			{
				puzzles.add(new ObjectPuzzle(buff.readLine()));
				puzzles.get(puzzles.size() - 1).setView(puzzleView);
				// System.out.println(puzzles.get(puzzles.size()-1));
			}
			buff.close();
		}
		catch (Exception E)
		{
			System.out.println("error");
		}
	}

	private void loadWordPuzzles() throws FileNotFoundException
	{
		file = new File("TextFiles/WordPuzzle.txt");

		try
		{
			BufferedReader buff = new BufferedReader(new FileReader(file));
			buff.readLine();
			while (buff.ready())
			{
				puzzles.add(new WordPuzzle(buff.readLine(), library));
				puzzles.get(puzzles.size() - 1).setView(puzzleView);
				// System.out.println(puzzles.get(puzzles.size()-1));
			}
			buff.close();
		}
		catch (Exception E)
		{
			System.out.println("error");
		}
	}

	private void loadNumberPuzzles() throws FileNotFoundException
	{
		file = new File("TextFiles/PuzzleNumber.txt");

		try
		{
			BufferedReader buff = new BufferedReader(new FileReader(file));
			buff.readLine();
			while (buff.ready())
			{
				puzzles.add(new PuzzleNumber(buff.readLine()));
				puzzles.get(puzzles.size() - 1).setView(puzzleView);
				// System.out.println(puzzles.get(puzzles.size()-1));
			}
			buff.close();
		}
		catch (Exception E)
		{
			System.out.println("error");
		}
	}

	private void loadPuzzleRiddle() throws FileNotFoundException
	{
		file = new File("TextFiles/PuzzleRiddle.txt");

		try
		{
			BufferedReader buff = new BufferedReader(new FileReader(file));
			buff.readLine();
			while (buff.ready())
			{
				puzzles.add(new PuzzleRiddle(buff.readLine()));
				puzzles.get(puzzles.size() - 1).setView(puzzleView);
				// System.out.println(puzzles.get(puzzles.size()-1));
			}
			buff.close();
		}
		catch (Exception E)
		{
			System.out.println("error");
		}
	}

	private void loadPuzzleDebuff() throws FileNotFoundException
	{
		file = new File("TextFiles/PuzzleDebuff.txt");

		try
		{
			BufferedReader buff = new BufferedReader(new FileReader(file));
			buff.readLine();
			while (buff.ready())
			{
				puzzles.add(new PuzzleDebuff(buff.readLine()));
				puzzles.get(puzzles.size() - 1).setView(puzzleView);
				// System.out.println(puzzles.get(puzzles.size()-1));
			}
			buff.close();
		}
		catch (Exception E)
		{
			System.out.println("error");
		}
	}

	// this exists for self reference
	public void setLibray(ReferenceIdentities library)
	{
		this.library = library;
	}
}