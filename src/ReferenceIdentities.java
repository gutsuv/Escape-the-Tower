import java.io.*;
import java.util.*;

/**
 * Class: ReferenceIdentities
 * @author Team Hydra
 * @version 1.0
 * Course: ITEC 3860, Fall 2017
 * Written: 
 * 
 * This class – now describe what the class does 
 * 
 * Purpose: – Describe the purpose of this class
 */

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

	/**
     * Method: cloneItem()
     * Clones item
     * @param i int value
     * @return getItem(i).clone()
     */
	public Item cloneItem(int i) throws Exception
	{
		return (Item) getItem(i).clone();
	}

	/**
     * Method: getItem()
     * Searches for an item based off of item Id
     * @param i int value
     * @return Item
     */
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

	/**
     * Method: cloneEnemy()
     * Clones enemy
     * @param i int value
     * @return Enemy
     */
	public Enemy cloneEnemy(int i) throws Exception
	{
		return (Enemy) getEnemy(i).clone();
	}

	/**
     * Method: getEnemy()
     * Searches for an enemy based off of enemy Id
     * @param i int value
     * @return Enemy
     */
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

	/**
     * Method: clonePuzzle()
     * Clones puzzle
     * @param i int value
     * @return Puzzle
     */
	public Puzzle clonePuzzle(int i) throws Exception
	{
		return (Puzzle) getPuzzle(i).clone();
	}

	/**
     * Method: getPuzzle()
     * Searches for an puzzle based off of puzzle Id
     * @param i int value
     * @return Puzzle
     */
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

	/**
     * Method: loaditems()
     * Loads items
     * @param nothing
     * @return none
     */
	public void loaditems() throws FileNotFoundException
	{
		loadGearItems();
		loadConsumables();
		loadPuzzleItems();
	}

	/**
     * Method: loadEnemys()
     * Loads enemies
     * @param nothing
     * @return none
     */
	public void loadEnemys() throws FileNotFoundException
	{
		loadEnemyTable();
	}

	/**
     * Method: loadPuzzles()
     * Loads puzzles
     * @param nothing
     * @return none
     */
	public void loadPuzzles() throws FileNotFoundException
	{
		loadDoorPuzzles();
		loadObjectPuzzles();
		loadWordPuzzles();
		loadNumberPuzzles();
		loadPuzzleRiddle();
		loadPuzzleDebuff();
	}

	/**
     * Method: loadGearItems()
     * Loads gear
     * @param nothing
     * @return none
     */
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

	/**
     * Method: loadConsumables()
     * Loads consumables
     * @param nothing
     * @return none
     */
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

	/**
     * Method: loadPuzzleItems()
     * Loads puzzle items
     * @param nothing
     * @return none
     */
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

	/**
     * Method: loadEnemyTable()
     * Loads enemies
     * @param nothing
     * @return none
     */
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

	/**
     * Method: loadDoorPuzzles()
     * Loads puzzles
     * @param nothing
     * @return none
     */
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

	/**
     * Method: loadObjectPuzzles()
     * Loads object puzzle
     * @param nothing
     * @return none
     */
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

	/**
     * Method: loadWordPuzzles()
     * Loads word puzzle
     * @param nothing
     * @return none
     */
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

	/**
     * Method: loadNumberPuzzles()
     * Loads number puzzle
     * @param nothing
     * @return none
     */
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

	/**
     * Method: loadPuzzleRiddle()
     * Loads riddle puzzle
     * @param nothing
     * @return none
     */
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

	/**
     * Method: loadPuzzleDebuff()
     * Loads puzzle debuff
     * @param nothing
     * @return none
     */
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

	/**
     * Method: setLibray()
     * Sets library
     * @param library ReferenceIdentities object
     * @return none
     */
	public void setLibray(ReferenceIdentities library)
	{
		this.library = library;
	}
}
