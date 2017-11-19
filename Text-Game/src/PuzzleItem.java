
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

	@Override
	public void use() {}
	//code moved because I can't make an object delete itself without using outside method
	@Override
	public void drop() {}
	//code moved because I can't make an object delete itself without using outside method		
	
	@Override
	public void examine() {
		view.print(itemDescShort);
	}
	@Override
	public String getDisplay() 
	{
		return itemName + "-> use, drop, examine:";
	}
	@Override
	public void displayCommands() {
		view.line(125);
		view.print(itemName);
		view.print("use:");
		view.print("drop:");
		view.print("examine:");	
		view.print("exit:");
	}
}
