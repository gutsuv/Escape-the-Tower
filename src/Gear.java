import javafx.scene.control.Button;

public class Gear extends Item
{
	protected int defense;
	protected int attackMin;
	protected int attackMax;
	protected int acc;
	protected char itemslot;

	public Gear(String loadedString)
	{
		// loaded from file
		// int itemId, String itemName, char slot, int defense,
		// int attackMin, int attackMax,int acc,
		// String itemDescShort, String itemDescLong
		try
		{
			String[] splitString = loadedString.split("-_");
			itemId = Integer.parseInt(splitString[0]);
			itemName = splitString[1];
			itemslot = splitString[2].charAt(0);
			defense = Integer.parseInt(splitString[3]);
			attackMin = Integer.parseInt(splitString[4]);
			attackMax = Integer.parseInt(splitString[5]);
			acc = Integer.parseInt(splitString[6]);
			itemDescShort = splitString[7];
			itemDescLong = splitString[8];

		} 
		catch (Exception E)
		{
			System.out.println("Text Spencer Williams to fix this. I might have messed up a TextFile."
					+ "I can fix it in like 30 minutes. Include Gear in the text message");
		}

	}

	public int getDefense()
	{
		return defense;
	}

	public int getAttackMin()
	{
		return attackMin;
	}

	public int getAttackMax()
	{
		return attackMax;
	}

	public int getAcc()
	{
		return acc;
	}

	public char getItemslot()
	{
		return itemslot;
	}

	@Override
	public void use()
	{
	}

	// code moved because I can't make an object delete itself without using outside
	// method
	@Override
	public void drop()
	{
	}
	// code moved because I can't make an object delete itself without using outside
	// method

	@Override
	public void examine()
	{
		if (itemslot == 'w')
		{
			view.print(itemName + ", MinDamage: " + attackMin + ", MaxDamage: " + attackMax + ", Accuracy: " + acc
					+ ", " + itemDescLong);
		} 
		else
		{
			view.print(itemName + ", " + itemDescLong);
		}
	}

	@Override
	public String getDisplay()
	{
		return itemName + "-> equip, drop, examine:";
	}

	@Override
	public void displayCommands()
	{
		view.line(125);
		view.print(itemName);
		view.print("equip:");
		view.print("drop:");
		view.print("examine:");
		view.print("exit:");
	}
}