
public class PuzzleItem extends Item{
	protected int puzzleId;
	
	public PuzzleItem(String loadedString)
	{
		//loaded from file
		
		//int ID, String name, int puzzleId, String description
		try 
		{
			String[] splitString = loadedString.split("-_");
			itemId = Integer.parseInt(splitString[0]);
			itemName = splitString[1];
			puzzleId = Integer.parseInt(splitString[2]);
			itemDescShort = splitString[3];
			itemDescLong = splitString[3];
			//Other Item classes have two descriptions. Double casting it makes some sense 
			
		}catch(Exception E)
		{
			System.out.println("Text Spencer Williams to fix this. I might have messed up a TextFile."
					+ "I can fix it in like 30 minutes. Include Gear in the text message");
		}
	}
	public int getPuzzleId() {return puzzleId;}
}
