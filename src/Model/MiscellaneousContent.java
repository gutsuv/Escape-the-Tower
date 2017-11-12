package Model;

public class MiscellaneousContent
{
	public static String displayIntro()
	{
		return  "Welcome\n";
	}

	public static String displayMainMenu()
	{
		return  "New Game\n"
				+ "Load Game\n"
				+ "Save Game\n"
				+ "Exit\n";
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
				+ "Exit\n";
	}

	public static String move()
	{
		return  	"Password\n"
					+ "Down\n";
	}


	public static String help() 
	{
		return  "Help\n"
				+ "Menu Goes Here\n";
	}


	public static String invalidRoomInput()
	{
		return  "[]";
	}


	public static String invalidPuzzleInput() 
	{
		return  "Incorrect\n"
				+ "Exit Option Goes Here\n";
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
				+ "Retreat\n";
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