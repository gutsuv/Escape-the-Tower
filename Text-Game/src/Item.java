
public class Item implements Cloneable, Comparable<Item>{
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
	
	protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
	
	@Override
	public String toString()
	{
		return "Item [" + itemId +", "+itemName + ", " +itemDescShort+"]";
	}

	@Override
	public int compareTo(Item o) {
		if(itemId>o.getItemId()) {return 1;}
		else if(itemId<o.getItemId()){return -1;}
		else {return 0;}
	}
}