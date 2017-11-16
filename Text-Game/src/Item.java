
public class Item implements Cloneable{
	protected int itemId;
	protected String itemName;
	protected String itemDescLong;
	protected String itemDescShort;

	public int getItemId()
	{
		return itemId;
	}

	public String getItemName() 
	{
		return itemName;
	}

	public String getItemDesc()
	{
		return itemDescLong;
	}
	
	public String getItemDescShort()
	{
		return itemDescShort;
	}

	@Override
	public String toString()
	{
		return "Item [itemId, "+ itemName + ": " +itemDescShort+"]";
	}
}