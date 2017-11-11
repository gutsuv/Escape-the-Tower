package Model;

public class MiscellaneousContent
{
	public static String displayIntro()
	{
		return  "Welcome";
	}

	public static String displayMainMenu()
	{
		return  "New Game\n"
				+ "Load Game\n"
				+ "Save Game\n"
				+ "Exit";
	}

	public static String displayDefaultMenu()
	{
		return  "Examine Room\n"
				+ "Pick Up\n"
				+ "Engage Enemy\n"
				+ "View Puzzle\n"
				+ "View Inventory\n"
				+ "Help Menu\n"
				+ "Change Room\n"
				+ "Exit";
	}

	public static String move()
	{
		return  	"Password\n"
					+ "Down";
	}


	public static String help() 
	{
		return  "Help\n"
				+ "Menu Goes Here";
	}


	public static String invalidRoomInput()
	{
		return  "[]";
	}


	public static String invalidPuzzleInput() 
	{
		return  "Incorrect\n"
				+ "Exit Option Goes Here";
	}

	public static String invalidEnemyInput() 
	{
		return  "[]";
	}


	public static String displayCombatMenu() 
	{	
		return  "Combat\n"
				+ "Attack\n"
				+ "Defense\n"
				+ "Retreat";
	}

	public static String displayAttackCommand() 
	{
		return  "Combat\n"
				+ "Weapon\n";
	}

	public static String openInventory()
	{
		return  "Inventory\n"
				+ "Select\n";
	}
	
	public static String takeItem() 
	{ 
		return  "Item\n"
				+ "Yes or No?\n";
	}
}