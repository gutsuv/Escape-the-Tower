// Subclass


public class Consumable extends Item
{
	
	protected int healthEffect;
	protected int maxHealthEffect;
	
	public Consumable(String loadedString)
	{
		//loaded from file
		//int itemID, String itemName, int healthEffect
		//int maxHealthEffect, String itemDescShort, String itemDescLong

		try 
		{
			String[] splitString = loadedString.split("-_");
			itemId = Integer.parseInt(splitString[0]);
			itemName = splitString[1];
			healthEffect = Integer.parseInt(splitString[2]);
			maxHealthEffect = Integer.parseInt(splitString[3]);
			itemDescShort = splitString[4];
			itemDescLong= splitString[5];
			
		}catch(Exception E)
		{
			System.out.println("Text Spencer Williams to fix this. I might have messed up a TextFile."
					+ "I can fix it in like 30 minutes. Include Consumable in the text message");
		}
		
	}
	
	public int getHealthEffect()
	{
		return healthEffect;
	}

	public int getMaxHealthEffect()
	{
		return maxHealthEffect;
	}
}